import models.Food;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Guest on 8/10/17.
 */
public class FoodTest {
    //helper new object
    public Food getNewFood(){
        return new Food("almond butter", 2.00);
    }

    @Test
    public void newFood_instantiatesCorrectly() throws Exception{
        Food testFood = getNewFood();
        assertEquals(true, testFood instanceof Food);
    }

    @Test
    public void getCalories_returnsCaloriesForSingleFoodServing_Integer() throws Exception {
        Food testFood = new Food ("almond butter", 1.00);
        Double expected = 98.00;
        assertEquals(expected, testFood.getCalories());
    }

    @Test
    public void getCalories_returnsCaloriesForVariableServings_Integer() throws Exception {
        Food testFood = getNewFood();
        Double expected = 196.00;
        assertEquals(expected, testFood.getCalories());
    }
    @Test
    public void getAll_returnsAllInstancesofFood_ArrayList() throws Exception {
        Food.clearAllFoods();
        Food testFood = getNewFood();
        Food anotherTestFood = new Food ("blueberries", 10.00);
        assertEquals(2, Food.getAll().size());
        assertEquals("almond butter", testFood.getName());
        Double expected = 10.00;
        assertEquals(expected, anotherTestFood.getServings());
    }


}