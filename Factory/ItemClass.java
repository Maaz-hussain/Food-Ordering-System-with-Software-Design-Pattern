 
package Factory;
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

public class ItemClass implements Food{
    @Override
    public void show(Object obj) { 
        List<Mediator.ItemMediator> iArray = new ArrayList<>();
        String query = "SELECT f.*,ic.`name` AS food_categ_name FROM `tb_food_item` f LEFT JOIN tb_item_category ic ON f.`food_category_id`=ic.id ";
        System.out.println("" + query);
        Statement st = null;
        ResultSet rs = null;
        Mediator.ItemMediator ibeans; 
        try {
            st = (Statement) connection.Connect.con.createStatement();
            rs = st.executeQuery(query);
            
            
            while (rs.next()) {
                ibeans = new Mediator.ItemMediator();
                ibeans.setCol_id(String.valueOf(rs.getInt("id")));
                ibeans.setCol_name(rs.getString("name").substring(0, 1).toUpperCase() + rs.getString("name").substring(1));
                ibeans.setCol_price(String.valueOf(rs.getInt("price")));
                //System.out.println(""+rs.getString("food_categ_name").substring(0, 1).toUpperCase() + rs.getString("food_categ_name").substring(1));
                ibeans.setCol_food_categ_name(rs.getString("food_categ_name").substring(0, 1).toUpperCase() + rs.getString("food_categ_name").substring(1));
                ibeans.setFood_categ_id(String.valueOf(rs.getInt("food_category_id"))); 
                iArray.add(ibeans);
            }
            Controller.MainViewController.Items_List.clear();
            ObservableList<Mediator.ItemMediator> data = FXCollections.observableArrayList(iArray);
            Controller.MainViewController.Items_List = data;
        } catch (SQLException ex) {
            Logger.getLogger(ItemClass.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}

  
