package domain;

import domain.model.*;
import domain.services.ServicioMLApi;

import java.io.IOException;

public class EjemploDeUso {

    public static void main(String[] args) throws IOException {
        ServicioMLApi servicioMLApi = ServicioMLApi.instancia();
        System.out.println("Listado de paises:");
        ListadoDePaises listadoDePaises = servicioMLApi.listadoDePaises();
        for(Pais unPais:listadoDePaises.paises){
            System.out.println(unPais.id + " - " + unPais.name + " - "+ unPais.currency_id);
            }
        }

        /*
        Scanner entradaEscaner = new Scanner(System.in);
        String idProvinciaElegida = entradaEscaner.nextLine();
        Optional<Provincia> posibleProvincia = listadoDeProvinciasArgentinas.provinciaDeId(Integer.parseInt(idProvinciaElegida));
        if(posibleProvincia.isPresent()){
            Provincia provinciaSeleccionada = posibleProvincia.get();
            ListadoDeMunicipios municipiosDeLaProvincia = servicioMLApi.listadoDeMunicipiosDeProvincia(provinciaSeleccionada);
            System.out.println("Los municipios de la provincia "+ provinciaSeleccionada.nombre +" son:");
            for(Ciudad unMunicipio: municipiosDeLaProvincia.municipios){
                System.out.println(unMunicipio.nombre);
            }
        }
        else{
            System.out.println("No existe la provincia seleccionada");
        }

         */
}
