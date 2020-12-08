package cl.eme.appdogs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

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
* [] 1. Creación del modelo de la aplicación.
      [] ● Crear los POJOS necesarios para recibir la información de la API.
      [] ● Crear el POJOS necesario para subir la colección de favoritos a FireStore (raza, url, timeStamp) .
      [] ○ Observación: Obtener el TimeStamp en formato String.
* [] 2. Crear item_list_XXX.xml que correspondan a cada elemento a mostrar.
* [] 3. Crear los Fragmentos necesarios:
      [] ● Listado de razas.
      [] ● Detalles.
      [] ● Listado de favoritos (opcional).
* [] 4. Mostrar en un fragmento el RecyclerView con el listado de razas.
* [] 5. Mostrar en un fragmento el RecyclerView con el listado de fotos de la raza seleccionada.
* [] 6. Crear los adapters que serán necesarios para transformar los distintos DataSet.

Parte II - Consumo y muestra de información
[] 1. Crear el Cliente Retrofit y la interface necesaria para la conexión.
[] 2. Realizar la conexión a la API.
[] 3. Crear el presentador que servirá para conectar la vista con el modelo. Se necesita más de un presentador.
[] 4. Implementar los métodos en las vista correspondientes.
[] 5. Instanciar los adapters donde sea necesario y pasar los dataSets que necesite cada uno de ellos.

Parte III - Guardar favoritos usando FireStore
[] 1. Implementar la funcionalidad para que al hacer un click largo a una foto, este lleve los datos a FireStore
[] 2. Mostrar el detalle de los favoritos en un Fragmento de detalles (Opcional)

 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}