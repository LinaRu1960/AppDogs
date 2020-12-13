package cl.eme.appdogs.view;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import cl.eme.appdogs.databinding.ItemListFavoritesBinding;
import cl.eme.appdogs.model.Favorite;

public class FavoritesAdapter extends RecyclerView.Adapter<FavoritesAdapter.FavoritesAdapterVH> {

    private List<Favorite> favoriteList;
    private ItemListFavoritesBinding binding;
    private static final String TAG= "Infolog";
    public FavoritesAdapter(List<Favorite> favoriteList){
        this.favoriteList = favoriteList;
    }

    @NonNull
    @Override
    public FavoritesAdapterVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: la lista de favoritos tiene: " + favoriteList.size()+ "elementos");
        binding = ItemListFavoritesBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        View view = binding.getRoot();
        return new FavoritesAdapterVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoritesAdapterVH holder, int position) {
        Favorite favorite = favoriteList.get(position);
        Log.d(TAG, "onBindViewHolder position"+ position + "" + favorite.toString());
        holder.bind(favorite);

    }
    public void updateFavorites(List<Favorite> pFavoriteList){
        Log.d(TAG, "updateFavorites: en Adapter"+ favoriteList.toString());
        favoriteList.clear();
        favoriteList.addAll(pFavoriteList);
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: la lista de favoritos tiene: " + favoriteList.size()+ "elementos");

        return favoriteList.size();
    }

    public class FavoritesAdapterVH extends RecyclerView.ViewHolder{
        private ImageView imgFavorite;
        private TextView breedFavorite;
        private TextView timeStamp;
        private Context context;

        public FavoritesAdapterVH(@NonNull View itemView) {
            super(itemView);
            breedFavorite = binding.tvBreedFavorite;
            timeStamp = binding.tvTimeStamp;
            imgFavorite = binding.imgBreed;
            context = itemView.getContext();
        }

        public void bind(Favorite favorite) {
            Log.d(TAG, "bind favorito: "+ favorite);
            breedFavorite.setText(favorite.getBreed().toUpperCase());
            timeStamp.setText(favorite.getTimeStamp());
            Glide.with(context)
                    .load(favorite.getUrlImage())
                    .override(400,400)
                    .into(imgFavorite);
        }
    }
}
