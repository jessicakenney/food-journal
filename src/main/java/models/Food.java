package models;

import java.util.ArrayList;

/**
 * Created by Guest on 8/10/17.
 */
public class Food {
    private String name;
    private Double servings;
    private static ArrayList<Food> instances = new ArrayList<>();
    private int id;


    public Food (String name, Double servings){
        this.name = name;
        this.servings = servings;
        instances.add(this);
        this.id = instances.size();
    }

    public Double getCalories() {
        Double temp = 98.00;
        System.out.println(servings);
        return 98.00 * servings;
    }

    public static ArrayList<Food> getAllFoods(){
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
    public int getFoodId (){
        return id;
    }
    public static Food getFoodbyId (int id) {
        return instances.get(id -1);
    }
    public void update(Double servings){
        this.servings = servings;
    }

}

