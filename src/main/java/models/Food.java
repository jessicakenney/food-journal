package models;

import java.util.ArrayList;

/**
 * Created by Guest on 8/10/17.
 */
public class Food {
    private String name;
    private Double servings;
    private static ArrayList<Food> instances = new ArrayList<>();


    public Food (String name, Double servings){
        this.name = name;
        this.servings = servings;
        instances.add(this);
    }

    public Double getCalories() {
        Double temp = 98.00;
        System.out.println(servings);
        return 98.00 * servings;
    }

    public static ArrayList<Food> getAll(){
        return instances;
    }
    public String getName(){
        return name;
    }
    public Double getServings(){
        return servings;
    }
    public static void clearAllFoods(){
        instances.clear();
    }

}

