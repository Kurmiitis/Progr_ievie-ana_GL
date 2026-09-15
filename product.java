
public class product{
    private String product_id;
    private String name;
    private double price;
    private int count;
}

public product(String product_id, String name, double price, in count){
    this.product_id=product_id;
    this.name=name;
    set_price(price);
    set_count(count);
}


public String get_prod_id(){
    return product_id;
}

public void set_prod_id(String product_id){
    this.product_id=product_id;
}


public String get_name(){
    return name;
}

public void set_name(String name){
    this.name=name;
}


public double get_price(){
    return price;
}

public void set_price(double price){
    if(price>=0){
        this.price=price;
    }else{
        System.out.println("!!ERROR: Product price cannot be negative!!");
    }
}