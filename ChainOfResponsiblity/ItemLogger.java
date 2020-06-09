package ChainOfResponsiblity;

import com.mysql.jdbc.Statement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ItemLogger extends AbstractLogger {

    public ItemLogger(int level) {
        this.level = level;
    }

    @Override
    protected void Add(Object obj) {
        Mediator.ItemMediator itemb = (Mediator.ItemMediator) obj;
        try {
            String query = "INSERT INTO tb_food_item (`name`,`price`,`food_category_id`) VALUES( '"
                    + itemb.getName() + "'," + itemb.getPrice() + "," + itemb.getFood_categ_id() + ")";
            Statement st = null;
            st = (Statement) connection.Connect.con.createStatement();
            if (st.executeUpdate(query) == 1) {
                System.out.println("Inserted Food Item");
            } else {

            }
        } catch (SQLException ex) {
            System.out.println("Data Is Not Inserted..");
            if (ex.getErrorCode() == 1062) {

            } else {
                Logger.getLogger(StaffLogger.class.getName()).log(Level.SEVERE, null, ex + " error code " + String.valueOf(ex.getErrorCode()));
            }
        }
    }

    
}
