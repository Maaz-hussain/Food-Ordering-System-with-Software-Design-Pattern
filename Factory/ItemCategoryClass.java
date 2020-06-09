package Factory;

import Mediator.ItemCategoryMediator;
import Singleton.SingletonClass;
import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ItemCategoryClass implements Food { 
    @Override
    public void show(Object obj) { 
        List<Mediator.ItemCategoryMediator> ubArray = new ArrayList<>();
        String query = "SELECT * FROM `tb_item_category` ";
        System.out.println("" + query);
        Statement st = null;
        ResultSet rs = null;
        Mediator.ItemCategoryMediator sbeans; 
        try {
            st = (Statement) connection.Connect.con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                sbeans = new Mediator.ItemCategoryMediator();
                sbeans.setCol_id(String.valueOf(rs.getInt("id")));
                sbeans.setCol_name(rs.getString("name").substring(0, 1).toUpperCase() + rs.getString("name").substring(1)); 
                ubArray.add(sbeans);
            }
            Controller.MainViewController.ItemsCateg_List.clear();
            ObservableList<Mediator.ItemCategoryMediator> data = FXCollections.observableArrayList(ubArray);
            Controller.MainViewController.ItemsCateg_List = data;
        } catch (SQLException ex) {
            Logger.getLogger(SingletonClass.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
} 