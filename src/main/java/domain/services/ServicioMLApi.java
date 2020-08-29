package domain.services;

import com.sun.org.apache.xpath.internal.operations.Mod;
import domain.model.ListadoDePaises;
import domain.model.Moneda;
import domain.model.Pais;
import domain.model.Provincia;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

public class ServicioMLApi {
    private static ServicioMLApi instancia = null;
    private static int maximaCantidadRegistrosDefault = 200;
    private Retrofit retrofit;

    private ServicioMLApi() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl("https://api.mercadolibre.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static ServicioMLApi instancia(){
        if(instancia== null){
            instancia = new ServicioMLApi();
        }
        return instancia;
    }

    public ListadoDePaises listadoDePaises() throws IOException {
        MercadoLibreService mercadoLibreService = this.retrofit.create(MercadoLibreService.class);
        Call<List<Pais>> requestListadoDePaises = mercadoLibreService.paises();
        /*es este punto se hace la request (el send) de forma asincronica en este caso*/
        Response<List<Pais>> responseListadoDePaises = requestListadoDePaises.execute();
        ListadoDePaises listadoDePaises = new ListadoDePaises();
        listadoDePaises.paises= responseListadoDePaises.body();
        return listadoDePaises;
    }

    public Pais pais(String id) throws IOException {
        MercadoLibreService mercadoLibreService = this.retrofit.create(MercadoLibreService.class);
        Call<Pais> requestDetalleDePais = mercadoLibreService.pais(id);

        Response<Pais> responseDetalleDePais = requestDetalleDePais.execute();
        return responseDetalleDePais.body();
    }

    public Provincia provincia(String id) throws IOException {
        MercadoLibreService mercadoLibreService = this.retrofit.create(MercadoLibreService.class);
        Call<Provincia> requestDetalleDeProvincia = mercadoLibreService.provincia(id);

        Response<Provincia> responseDetalleDeProvincia = requestDetalleDeProvincia.execute();
        return responseDetalleDeProvincia.body();
    }

    public Moneda moneda(String id) throws IOException{
        MercadoLibreService mercadoLibreService = this.retrofit.create(MercadoLibreService.class);
        Call<Moneda> requestMoneda = mercadoLibreService.moneda(id);

        Response<Moneda> responseMoneda = requestMoneda.execute();
        return responseMoneda.body();
    }


}