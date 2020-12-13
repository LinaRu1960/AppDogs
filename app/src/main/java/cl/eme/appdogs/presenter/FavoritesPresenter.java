package cl.eme.appdogs.presenter;

import android.util.Log;

import java.util.List;

import cl.eme.appdogs.model.Favorite;
import cl.eme.appdogs.model.Repository;

public class FavoritesPresenter {
    private static final String TAG = "Infolog";
    private IFavoritesPresenterView favoriteView;
    private Repository repository;

    public FavoritesPresenter(IFavoritesPresenterView favoriteView, Repository repository) {
        this.favoriteView = favoriteView;
        this.repository = repository;
        repository.setFavoritesPresenter(this);
        repository.downloadAllFavorites();
    }

    public void showFavorites(List<Favorite> listFavorites) {
        Log.d(TAG, "showFavorites: en Presenter" + listFavorites.toString());
        favoriteView.showFavorites(listFavorites);
        Log.d(TAG, "showFavorites: en Presenter. La Lista tiene "+ listFavorites.size()+ "elementos");
    }
}
