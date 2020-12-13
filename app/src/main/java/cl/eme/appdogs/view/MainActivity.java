package cl.eme.appdogs.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cl.eme.appdogs.R;
import cl.eme.appdogs.databinding.ActivityMainBinding;
import cl.eme.appdogs.model.Repository;
import cl.eme.appdogs.presenter.BreedPresenter;
import cl.eme.appdogs.presenter.IBreedPresenterView;
import cl.eme.appdogs.presenter.IFavoritesPresenterView;
import cl.eme.appdogs.view.BreedAdapter;
import cl.eme.appdogs.view.FavoritesFragment;

/* TODO
Descripcion
* [X] 1. Muestre un listado de razas de perritos.
* [X] 2. Al seleccionar una raza de perritos, muestre un listado de fotos de perros de esa raza.
* [X] 3. Al darle un click largo sobre la imagen de un perro, puedas guardar esa foto especifica como favorita.
* [X] 4. Debe haber un listado de fotos con los perros favoritos. (opcional)

Requerimientos generales
[X] ● Utilizar un patrón de diseño MVP.
[X] ● Utilizar un sistema de control de versiones(Git). Como mínimo un commit por parte.

Requerimientos específicos
[X] ● API dog.ceo (Retrofit)
[X] ● Utilizar como EndPoints.
    [X] ○ breeds/list/ (Para el listado de razas).
    [X] ○ breed/{breed}/images/ (Para el listado de imágenes basándonos en una raza).
[X] ● Single Activity y las vistas en Fragmentos.
[X] ● Botón que muestre el listado de favoritos.
[X] ● Imagen favorita sea almacenada en FireStore.
[X] ● Utilizar librerías externas para mostrar las imágenes (Picasso, Glide).
[X] ● Utilizar Retrofit para la conexión a la API y Gson para el mapeo de datos.
[X] ● Debe utilizar Firebase(FireStore) para almacenar datos de favoritos.
[X] ● Para unir las vistas puedes utilizar el método que estime conveniente.( findViewById,butterknife, dataBinding )
[] ● Realizar test unitarios en el presentador.

TAREAS
Parte I - Modelo de la app
* [X] Crear Repositorio en GitHub
* [X] Añadir permisos de Internet en Manifest
* [X] Implementar Retrofit en build.gradle
* [X] Habilitar librerias (Picasso y Glide)
* [X] Activar ViewBinding
* [X] 1. Creación del modelo de la aplicación.
      [X] ● Crear los POJOS necesarios para recibir la información de la API.
            [X] Breed
            [X] BreedImage
      [X] ● Crear el POJOS necesario para subir la colección de favoritos a FireStore (raza, url, timeStamp) .
             [X] Favorite
* [X] 2. Crear item_list_XXX.xml que correspondan a cada elemento a mostrar.
        [X] item_list_breed.xml
        [X] item_list_listpictures.xml
        [X] item_list_favorites.xml
* [X] 3. Crear los Fragmentos necesarios:
      [X] ● Listado de razas.
      [X] ● Detalles.
      [X] ● Listado de favoritos (opcional).(FavoritesList)
* [X] 4. Mostrar en un fragmento el RecyclerView con el listado de razas.
* [X] 5. Mostrar en un fragmento el RecyclerView con el listado de fotos de la raza seleccionada.
* [X] 6. Crear los adapters que serán necesarios para transformar los distintos DataSet.

Parte II - Consumo y muestra de información
[X] 1. Crear el Cliente Retrofit y la interface necesaria para la conexión.
        [X] RetrofitClient
        [X] ApiDogs
[X] 2. Realizar la conexión a la API.
[X] 3. Crear el presentador que servirá para conectar la vista con el modelo. Se necesita más de un presentador.
[X] 4. Implementar los métodos en las vista correspondientes.
[X] 5. Instanciar los adapters donde sea necesario y pasar los dataSets que necesite cada uno de ellos.

Parte III - Guardar favoritos usando FireStore
[X] 1. Implementar la funcionalidad para que al hacer un click largo a una foto, este lleve los datos a FireStore
[X] 2. Mostrar el detalle de los favoritos en un Fragmento de detalles (Opcional)
 */


public class MainActivity extends AppCompatActivity implements IBreedPresenterView, OnItemClickListener {

    private static final String TAG = "MainActivity";
    private ActivityMainBinding binding;
    BreedPresenter presenter;
    private BreedAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        adapter = new BreedAdapter(new ArrayList<>(), this);
        presenter = new BreedPresenter(this,new Repository());
        Log.d(TAG, "onCreate: Se construye adaptador y RecyclerView");
        RecyclerView recyclerView = binding.rvBreedRecycler;
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setAdapter(adapter);
        Button viewFavorites= binding.btViewFavorites;
        viewFavorites.setOnClickListener(v -> getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_recyclerview, FavoritesFragment.newInstance("",""))
                .addToBackStack("Detail")
                .commit());

    }



    @Override
    public void showBreed(List<String> breed) {
        Log.d(TAG, "showBreed: Actualiza lista de razas en el adapter");
        adapter.updateBreeds(breed);

    }

    @Override
    public void showToast_Failure() {

    }

    @Override
    public void showToast_Success() {

    }

    public void onClick(int position) {
        Log.d(TAG, "onClick: haciendo click en el elemento de la lista"+adapter.getListOfBreed().get(position));
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_recyclerview,PicturesFragment.newInstance("",adapter.getListOfBreed().get(position))).addToBackStack("Detail").commit();

    }

}