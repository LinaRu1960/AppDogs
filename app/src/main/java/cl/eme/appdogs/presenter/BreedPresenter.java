package cl.eme.appdogs.presenter;

import android.util.Log;

import java.util.List;

import cl.eme.appdogs.model.IRepositoryPresenter;
import cl.eme.appdogs.model.Repository;

public class BreedPresenter implements IRepositoryPresenter {
    private static final String TAG = "InfoLog";
    private IFavoritesPresenterView viewBreed;
    private Repository repository;

    public BreedPresenter(IFavoritesPresenterView viewBreed, Repository repository) {
        this.viewBreed = viewBreed;
        this.repository = repository;
        Log.d(TAG, "BreedPresenter: seteando el presentador del repositorio");
        repository.setBreedPresenter(this);
        Log.d(TAG, "BreedPresenter: llamando al metodo LoadBreedList");
        repository.loadBreedList();
        repository.getFavorites();
    }

    @Override
    public void showBreed(List<String> breeds) {
        Log.d(TAG, "showBreed: llamando a ShowBreed en Presenter" + breeds);
        viewBreed.showBreed(breeds);
    }
}
