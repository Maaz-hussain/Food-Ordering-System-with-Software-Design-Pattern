package Mediator;

import javafx.beans.property.SimpleStringProperty;

public class ItemMediator {
    String id,name,price,food_categ_id,food_categ_name;
    SimpleStringProperty col_id,col_name,col_price,col_food_categ_id,col_food_categ_name,col_item_qty,col_item_total;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getFood_categ_id() {
        return food_categ_id;
    }

    public void setFood_categ_id(String food_categ_id) {
        this.food_categ_id = food_categ_id;
    }

    public String getFood_categ_name() {
        return food_categ_name;
    }

    public void setFood_categ_name(String food_categ_name) {
        this.food_categ_name = food_categ_name;
    }

    public String getCol_id() {
        return col_id.get();
    }

    public void setCol_id(String col_id) {
        this.col_id = new SimpleStringProperty (col_id);
    }
                
    public String getCol_name() {
        return col_name.get();
    }

    public void setCol_name(String col_name) {
        this.col_name = new SimpleStringProperty(col_name);
    }

    public String getCol_price() {
        return col_price.get();
    }

    public void setCol_price(String col_price) {
        this.col_price = new SimpleStringProperty(col_price);
    }

    public String getCol_food_categ_id() {
        return col_food_categ_id.get();
    }

    public void setCol_food_categ_id(String col_food_categ_id) {
        this.col_food_categ_id =new SimpleStringProperty (col_food_categ_id);
    }

    public String getCol_food_categ_name() {
        return col_food_categ_name.get();
    }

    public void setCol_food_categ_name(String col_food_categ_name) {
        this.col_food_categ_name = new SimpleStringProperty(col_food_categ_name);
    }

    public String getCol_item_qty() {
        return col_item_qty.get();
    }

    public void setCol_item_qty(String col_item_qty) {
        this.col_item_qty =  new SimpleStringProperty(col_item_qty);
    }

    public String getCol_item_total() {
        return col_item_total.get();
    }

    public void setCol_item_total(String col_item_total) {
        this.col_item_total =  new SimpleStringProperty(col_item_total);
    }
    
    
    
    
}
