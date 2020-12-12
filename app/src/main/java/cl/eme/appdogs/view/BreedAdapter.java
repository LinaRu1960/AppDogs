package cl.eme.appdogs.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cl.eme.appdogs.R;
import cl.eme.appdogs.databinding.ItemListBreedBinding;

public class BreedAdapter extends RecyclerView.Adapter<BreedAdapter.BreedAdapterVH>{

    private List<String> breedsList;
    private OnItemClickListener listener;
    private ItemListBreedBinding binding;

    public BreedAdapter(List<String> breedsList, OnItemClickListener pListener) {
        this.breedsList = breedsList;
        this.listener = pListener;
    }

    public List<String> getBreedsList() {
        return breedsList;
    }


    @NonNull
    @Override
    public BreedAdapter.BreedAdapterVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemListBreedBinding.inflate(LayoutInflater.from(parent.getContext()),parent, false);
        View view =binding.getRoot();

        return new BreedAdapterVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BreedAdapter.BreedAdapterVH holder, int position) {
        String breed = breedsList.get(position);
        holder.bind(breed);
    }

    @Override
    public int getItemCount() {
        return breedsList.size();
    }
    
    public void updateBreeds(List<String>breeds){
        breedsList.clear();
        breedsList.addAll(breeds);
        notifyDataSetChanged();
    }
    public class BreedAdapterVH extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView tvBreed;

        public BreedAdapterVH(@NonNull View itemView) {
            super(itemView);
           tvBreed = binding.imgBreed;
            itemView.setOnClickListener(this);
        }
        
        public void bind(String breed){
            tvBreed.setText(breed.toUpperCase());
        }

        @Override
        public void onClick(View v) {
            int position=getAdapterPosition();
            listener.onClick(position);
        }
    }
}
