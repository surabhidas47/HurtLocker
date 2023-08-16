import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Groceries {

    private String name;
    private Double price;
    private String type;
    private String expiration;


    public Groceries(String name, Double price, String type, String expiration) {





        this.name = name;
        this.price = price;
        this.type = type;
        this.expiration = expiration;
    }






    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }
}
