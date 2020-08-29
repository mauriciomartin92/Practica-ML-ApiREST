package domain.services;

import domain.model.Pais;
import domain.model.Provincia;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface MercadoLibreService {
    @GET("countries")
    Call<List<Pais>> paises();

    @GET("countries/{id}")
    Call<Pais> pais(@Path("id") String id);

    @GET("states/{id}")
    Call<Provincia> provincia(@Path("id") String id);


    /*public interface RetrofitUsersService {
        @GET("/api/users/{id}")
        Call<ResponseUser> getUser(@Path("id") int userId);
    }
    */
}