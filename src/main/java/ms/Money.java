package ms;

public class Money {

    private String currency;
    private Double price;

    public Money(String currency, Double price) {
        super();
        this.currency = currency;
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public Double getPrice() {
        return price;
    }

}
