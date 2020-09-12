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
        for (Pais unPais : listadoDePaises.paises) {
            System.out.println(unPais.id + " - " + unPais.name + " - " + unPais.currency_id);
        }

        System.out.println("Elegir id de Pais para obtener sus provincias: ");
        Scanner entradaEscaner = new Scanner(System.in);
        String idPaisElegido = entradaEscaner.nextLine();
        Pais pais = servicioMLApi.pais(idPaisElegido);

        for (Provincia unaProvincia : pais.states) {
            System.out.println(unaProvincia.name + " - id: " + unaProvincia.id);
        }
        System.out.println("Elegir id de Provincia para obtener sus ciudades: ");
        Scanner entradaEscaner1 = new Scanner(System.in);
        String idProvinciaElegida = entradaEscaner1.nextLine();
        Provincia provincia = servicioMLApi.provincia(idProvinciaElegida);
        for (Ciudad unaCiudad : provincia.cities) {
            System.out.println(unaCiudad.name);
        }

        //carga de datos
        //nuevo codigo postal de organizacion
        CodigoPostal codPostal = new CodigoPostal();
        System.out.println("Ingrese ciudad: ");
        Scanner entradaCiudad = new Scanner(System.in);
        String ciudad = entradaCiudad.nextLine();
        System.out.println("Ingrese calle: ");
        Scanner entradaCalle = new Scanner(System.in);
        String calle = entradaCalle.nextLine();
        System.out.println("Ingrese altura: ");
        Scanner entradaAltura = new Scanner(System.in);
        Integer altura = entradaAltura.nextInt();
        //set(String Calle, Integer Altura, String Pais, String Provincia, String Ciudad)
        codPostal.set(calle, altura, pais.name, provincia.name, ciudad);

        //moneda
        Moneda unaMoneda = servicioMLApi.moneda(pais.currency_id);
        Moneda moneda = new Moneda(unaMoneda.id, unaMoneda.symbol, unaMoneda.description);


        codPostal.imprimir();
    }

}
