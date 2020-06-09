package Mediator;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;

public class ItemCategoryMediator {

    String id, name;
    SimpleStringProperty col_id, col_name;
    public ObservableList<Mediator.ItemMediator> ItemList;

    public void add(Mediator.ItemMediator e) {
        ItemList.add(e);
    }

    public void remove(Mediator.ItemMediator e) {
        ItemList.remove(e);
    }

    public ObservableList<Mediator.ItemMediator> getItemList() {
        return ItemList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCol_id() {
        return col_id.get();
    }

    public void setCol_id(String col_id) {
        this.col_id = new SimpleStringProperty(col_id);
    }

    public String getCol_name() {
        return col_name.get();
    }

    public void setCol_name(String col_name) {
        this.col_name = new SimpleStringProperty(col_name);
    }

}
