package cl.eme.appdogs.presenter;

import android.util.Log;

import java.util.List;

import cl.eme.appdogs.model.IRepositoryPresenter;
import cl.eme.appdogs.model.Repository;

public class PicturesPresenter implements IRepositoryPresenter {

    private static final String TAG = "InfoLog";

    private IBreedPresenterView viewPicture;
        private Repository repository;
        private String breed;

         public PicturesPresenter(IBreedPresenterView viewBreed, Repository repository, String pBreed) {
             this.viewPicture = viewBreed;
             this.repository = repository;
             this.breed = pBreed;
             Log.d(TAG, "PicturePresenter: seteando el presentador del repositorio");
             repository.setPicturesPresenter(this);
             Log.d(TAG, "PicturePresenter: llamando al metodo loadBreedList");
             repository.loadBreedPictures(breed);
             repository.getFavorites();
         }


    @Override
    public void showBreed(List<String> breeds) {
        Log.d(TAG, "showBreed: llama a showBreed en PicturesPresenter"+ breeds);
        viewPicture.showBreed(breeds);
    }

    public void addFavorite(String pPicture, String pBreed){
             if (!repository.isFavorite(pPicture)){
                 repository.loadNewFavorite(pPicture,pBreed);
                 viewPicture.showToast_Success();
             }
             else {
                 viewPicture.showToast_Failure();
             }
    }
}


