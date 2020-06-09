package ChainOfResponsiblity;
import com.mysql.jdbc.Statement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ItemCategoryLogger   extends AbstractLogger{

  public ItemCategoryLogger(int level){
      this.level = level;
   }
    @Override
    protected void Add(Object obj) {
        Mediator.ItemCategoryMediator itemb = (Mediator.ItemCategoryMediator) obj;
        try {
            String query = "INSERT INTO tb_item_category (`name`) VALUES( '" + itemb.getName()+"')";
            Statement st = null;
            st = (Statement) connection.Connect.con.createStatement();
            if (st.executeUpdate(query) == 1) {
                System.out.println("Category inserted");
            } else {

            }
        } catch (SQLException ex) {
            System.out.println("Data Is Not Inserted");
            if (ex.getErrorCode() == 1062) {

            } else {
                Logger.getLogger(ItemCategoryLogger.class.getName()).log(Level.SEVERE, null, ex + " error code " + String.valueOf(ex.getErrorCode()));
            }
        }
    }

}
