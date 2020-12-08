package cl.eme.appdogs.data;

import java.util.List;

import cl.eme.appdogs.model.Breeds;
import cl.eme.appdogs.model.ListImage;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiDogs {
    @GET("list/all")
    Call<List<Breeds>> getAllBreeds();
    @GET("breed/{breed}/images/")
    Call <ListImage> getImageBreeds();
}
