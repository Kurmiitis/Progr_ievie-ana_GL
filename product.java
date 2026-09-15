
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


public int get_count(){
    return count;
}

public void set_count(int count){
    if(count>=0){
        this.count=count;
    }else{
        System.out.println("!!ERROR: Product count cannot be negative!!");
    }
}


public void restock(int added_count){
    if(added_count>=0){
        this.count=count;
    }else{
        System.out.println("!!Error: Added stock cannot be negative!!");
    }
}


public String get_info(){
    return "Product ID: " + get_prod_id() +
    ", Name: " + get_name() +
    ", Price: " + get_price() +
    ", Quantity: " + get_count();
}


public static class Perishable extends product{
    private String exp_date;

    public Perishable(String product_id, String name, double price, int count, String exp_date){
        super(product_id, name, price, count);
        this.exp_date=exp_date;
    }

    public String get_exp_date() {//exp date getter
        return exp_date;
    }

    public void set_exp_date(String exp_date) {//exp date setter
        this.exp_date = exp_date;
    }

    public String get_prod_info() {//perishable product info
        return (super.get_prod_info() + ", Expiry Date: " + get_exp_date());
    }
}