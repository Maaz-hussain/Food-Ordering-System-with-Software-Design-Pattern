
package Factory;
public class FoodFactory { 
    public Factory.Food getFood(String foodType) {
        if (foodType == null) {
            return null;
        }
        if (foodType.equalsIgnoreCase("itemCategory")) {
            return new ItemCategoryClass();
        } else if (foodType.equalsIgnoreCase("item")) {
            return new ItemClass();
        } else if (foodType.equalsIgnoreCase("staff")) {
            return new StaffClass();
        } 
        return null;
    }
}
