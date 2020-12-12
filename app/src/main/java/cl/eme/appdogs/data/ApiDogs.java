package cl.eme.appdogs.data;

import cl.eme.appdogs.model.Breed;
import cl.eme.appdogs.model.BreedImage;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiDogs {
    @GET("breeds/list/all")
    Call<Breed> getAllBreeds();
    @GET("breed/{breed}/images/")
    Call <BreedImage> getImageBreeds(@Path("breed") String breed);
}
