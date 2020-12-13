package cl.eme.appdogs.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import cl.eme.appdogs.databinding.ItemListPicturesBinding;

public class PicturesAdapter extends RecyclerView.Adapter<PicturesAdapter.PicturesAdapterVH> {

    private List<String> listOfPictures;
    private OnItemLongClickListener listener;
    private ItemListPicturesBinding binding;

    public PicturesAdapter(List<String> listOfPictures) {
        this.listOfPictures = listOfPictures;
    }

    public PicturesAdapter(List<String> listOfPictures, OnItemLongClickListener listener) {
        this.listOfPictures = listOfPictures;
        this.listener = listener;
    }

    @NonNull
    @Override
    public PicturesAdapter.PicturesAdapterVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemListPicturesBinding.inflate(LayoutInflater.from(parent.getContext()),parent, false);
        View view = binding.getRoot();
        return new PicturesAdapterVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PicturesAdapter.PicturesAdapterVH holder, int position) {
        String picture = listOfPictures.get(position);
        holder.bind(picture);

    }

    @Override
    public int getItemCount() {
        return listOfPictures.size();
    }

    public void updatePictures(List<String> picture){
        listOfPictures.clear();
        listOfPictures.addAll(picture);
        notifyDataSetChanged();
    }

    public List<String > getListOfPictures() {
        return listOfPictures;
    }

    public class PicturesAdapterVH extends RecyclerView.ViewHolder implements View.OnLongClickListener{
        private ImageView imgPictures;
        private Context context;

        public PicturesAdapterVH(@NonNull View itemView) {
            super(itemView);
            imgPictures= binding.imgBreed;
            context = itemView.getContext();
            itemView.setOnLongClickListener(this);
        }

        @Override
        public boolean onLongClick(View v) {
            int position = getAdapterPosition();
            listener.onLongClick(position);
            return true;
        }

        public void bind(String picture){
            Glide.with(context)
                    .load(picture)
                    .override(500,500)
                    .into(imgPictures);

        }
    }

}
