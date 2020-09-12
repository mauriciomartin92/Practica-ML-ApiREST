package domain.model;

public class Moneda {
    public String id;

    public Moneda(String id, String symbol, String description) {
        this.id = id;
        this.symbol = symbol;
        this.description = description;
    }

    public String symbol;
    public String description;

}
