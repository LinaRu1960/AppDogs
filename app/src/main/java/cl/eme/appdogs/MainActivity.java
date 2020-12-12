package cl.eme.appdogs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import cl.eme.appdogs.databinding.ActivityMainBinding;
import cl.eme.appdogs.model.Repository;
import cl.eme.appdogs.presenter.BreedPresenter;
import cl.eme.appdogs.presenter.IBreedPresenterView;
import cl.eme.appdogs.view.BreedAdapter;
import cl.eme.appdogs.view.FavoritesFragment;

/* TODO
Descripcion
* [] 1. Muestre un listado de razas de perritos.
* [] 2. Al seleccionar una raza de perritos, muestre un listado de fotos de perros de esa raza.
* [] 3. Al darle un click largo sobre la imagen de un perro, puedas guardar esa foto especifica como favorita.
* [] 4. Debe haber un listado de fotos con los perros favoritos. (opcional)

Requerimientos generales
[] ● Utilizar un patrón de diseño MVP.
[] ● Utilizar un sistema de control de versiones(Git). Como mínimo un commit por parte.

Requerimientos específicos
[] ● API dog.ceo (Retrofit)
[] ● Utilizar como EndPoints.
    [X] ○ breeds/list/ (Para el listado de razas).
    [X] ○ breed/{breed}/images/ (Para el listado de imágenes basándonos en una raza).
[] ● Single Activity y las vistas en Fragmentos.
[] ● Botón que muestre el listado de favoritos.
[] ● Imagen favorita sea almacenada en FireStore.
[] ● Utilizar librerías externas para mostrar las imágenes (Picasso, Glide).
[] ● Utilizar Retrofit para la conexión a la API y Gson para el mapeo de datos.
[] ● Debe utilizar Firebase(FireStore) para almacenar datos de favoritos.
[] ● Para unir las vistas puedes utilizar el método que estime conveniente.( findViewById,butterknife, dataBinding )
[] ● Realizar test unitarios en el presentador.

TAREAS
Parte I - Modelo de la app
* [X] Crear Repositorio en GitHub
* [X] Añadir permisos de Internet en Manifest
* [X] Implementar Retrofit en build.gradle
* [X] Habilitar librerias (Picasso y Glide)
* [X] Activar DataBinding
* [] 1. Creación del modelo de la aplicación.
      [X] ● Crear los POJOS necesarios para recibir la información de la API.
            [X] Breed
            [X] BreedImage
      [X] ● Crear el POJOS necesario para subir la colección de favoritos a FireStore (raza, url, timeStamp) .
             [X] Favorites
* [] 2. Crear item_list_XXX.xml que correspondan a cada elemento a mostrar.
        [X] item_list_breed.xml
        [X] item_list_ListImage.xml
        [X] item_list_favorites.xml
* [X] 3. Crear los Fragmentos necesarios:
      [X] ● Listado de razas.(BreedList)
      [X] ● Detalles.(BreedDetail
      [X] ● Listado de favoritos (opcional).(FavoritesList)
* [X] 4. Mostrar en un fragmento el RecyclerView con el listado de razas.
* [X] 5. Mostrar en un fragmento el RecyclerView con el listado de fotos de la raza seleccionada.
* [] 6. Crear los adapters que serán necesarios para transformar los distintos DataSet.

Parte II - Consumo y muestra de información
[X] 1. Crear el Cliente Retrofit y la interface necesaria para la conexión.
        [X] RetrofitClient
        [X] ApiDogs
[X] 2. Realizar la conexión a la API.
[X] 3. Crear el presentador que servirá para conectar la vista con el modelo. Se necesita más de un presentador.
[X] 4. Implementar los métodos en las vista correspondientes.
[] 5. Instanciar los adapters donde sea necesario y pasar los dataSets que necesite cada uno de ellos.

Parte III - Guardar favoritos usando FireStore
[] 1. Implementar la funcionalidad para que al hacer un click largo a una foto, este lleve los datos a FireStore
[] 2. Mostrar el detalle de los favoritos en un Fragmento de detalles (Opcional)
 */


public class MainActivity extends AppCompatActivity implements IBreedPresenterView, AdapterView.OnItemClickListener {

    private static final String TAG = "Infolog";
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
        Log.d(TAG, "onCreate: Construyendo adaptador y RecyclerView");
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
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void showBreed(List<String> breeds) {
        Log.d(TAG, "showBreed: Actualizando lista de breeds en el adapter");
        adapterBreed.updateBreeds(breeds);

    }

    @Override
    public void showToast_Failure() {

    }

    @Override
    public void showToast_Succes() {

    }
}