package cl.eme.appdogs.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import cl.eme.appdogs.R;
import cl.eme.appdogs.databinding.FragmentFavoritesBinding;
import cl.eme.appdogs.model.Favorite;
import cl.eme.appdogs.model.Repository;
import cl.eme.appdogs.presenter.FavoritesPresenter;
import cl.eme.appdogs.presenter.IFavoritesPresenterView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FavoritesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FavoritesFragment extends Fragment implements IFavoritesPresenterView {
    private static final String TAG ="Infolog";

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private FavoritesAdapter adapter;
    private FavoritesPresenter presenter;
    private RecyclerView recyclerView;
    private FragmentFavoritesBinding binding;

    public FavoritesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FavoritesList.
     */
    // TODO: Rename and change types and number of parameters
    public static FavoritesFragment newInstance(String param1, String param2) {
        FavoritesFragment fragment = new FavoritesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding= FragmentFavoritesBinding.inflate(inflater, container, false);
        View thisView = binding.getRoot();
        Log.d(TAG, "onCreateView: Construyendo el Adapter de Favorites");
        adapter = new FavoritesAdapter(new ArrayList<>());
        Log.d(TAG, "onCreateView: Construyendo el Presenter de Favorites");
       presenter= new FavoritesPresenter(this, new Repository());
        recyclerView = binding.rvFavorites;
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),1));
        Log.d(TAG, "onCreateView: vinculando Favorites Fragment con Adapter");
        recyclerView.setAdapter(adapter);
        // Inflate the layout for this fragment
        return thisView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding=null;
    }


    @Override
    public void showFavorites(List<Favorite> listFavorites) {
        Log.d(TAG, "showFavorites: en Fragmento: la lista tiene"+ listFavorites.size()+ " elementos");
        adapter.updateFavorites(listFavorites);
    }
}