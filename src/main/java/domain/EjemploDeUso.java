package domain;

import domain.model.*;
import domain.services.ServicioMLApi;

import java.io.IOException;
import java.util.Scanner;

public class EjemploDeUso {

    public static void main(String[] args) throws IOException {
        ServicioMLApi servicioMLApi = ServicioMLApi.instancia();
        System.out.println("Listado de paises:");
        ListadoDePaises listadoDePaises = servicioMLApi.listadoDePaises();
        for(Pais unPais:listadoDePaises.paises) {
            System.out.println(unPais.id + " - " + unPais.name + " - " + unPais.currency_id);
        }

            System.out.println("Elegir id de Pais para obtener sus provincias: ");
            Scanner entradaEscaner = new Scanner(System.in);
            String idPaisElegido = entradaEscaner.nextLine();
            Pais pais = servicioMLApi.pais(idPaisElegido);
            for(Provincia unaProvincia: pais.states){
                System.out.println(unaProvincia.name + " - id: "+ unaProvincia.id);
            }

            System.out.println("Elegir id de Provincia para obtener sus ciudades: ");
            Scanner entradaEscaner1 = new Scanner(System.in);
            String idProvinciaElegida = entradaEscaner1.nextLine();
            Provincia provincia = servicioMLApi.provincia(idProvinciaElegida);

            for(Ciudad unaCiudad: provincia.cities){
                System.out.println(unaCiudad.name);
            }


          //  Scanner entradaEscaner1 = new Scanner(System.in);
          //  System.out.println("Elegir id de provincia para obtener sus ciudades: ");
//
          //  for(Ciudad unaCiudad: )

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
