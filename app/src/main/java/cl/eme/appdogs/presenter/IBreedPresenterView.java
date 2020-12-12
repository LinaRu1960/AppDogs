package cl.eme.appdogs.presenter;

import java.util.List;

public interface IBreedPresenterView {
    void showBreed (List<String>breeds);
    void showToast_Failure();
    void showToast_Succes();

}
