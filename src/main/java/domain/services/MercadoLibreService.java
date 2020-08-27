package domain.services;

import domain.model.ListadoDePaises;
import domain.model.Pais;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface MercadoLibreService {
    @GET("countries")
    Call<List<Pais>> paises();

    @GET("countries/id")
    Call<Pais> pais(@Path("id") String id);

    /*public interface RetrofitUsersService {
        @GET("/api/users/{id}")
        Call<ResponseUser> getUser(@Path("id") int userId);
    }
    */
}