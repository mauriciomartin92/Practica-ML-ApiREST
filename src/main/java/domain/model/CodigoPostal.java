package domain.model;

public class CodigoPostal {

    public String calle;
    public Integer altura;
    public String pais;
    public String provincia;
    public String ciudad;

    //metodo de clase
    public void set(String calle, Integer altura, String pais, String provincia, String ciudad){
        this.calle = calle;
        this.altura = altura;
        this.pais = pais;
        this.provincia = provincia;
        this.ciudad = ciudad;
    }

    public void imprimir() {
        System.out.println("Calle: "+ this.calle);
        System.out.println("Altura: "+ this.altura);
        System.out.println("Ciudad: "+ this.ciudad);
        System.out.println("Provincia: "+ this.provincia);
        System.out.println("Pais: "+ this.pais);
    }
    //se decide modelar asi porque cada clase tiene el listado de sus subestados
    // (por ejemplo el pais contiene lista de provincias) atributos que no son necesarios en clase cod postal
}
