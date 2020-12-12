package cl.eme.appdogs.presenter;

import java.util.List;

import cl.eme.appdogs.model.Favorites;

public interface IFavoritesPresenterView {

    void showFavorites(List<Favorites> listFavorites);

    void showBreed(List<String> breeds);
}
