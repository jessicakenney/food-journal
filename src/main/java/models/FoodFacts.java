package models;

/**
 * Created by Guest on 8/10/17.
 */
public class FoodFacts {

        private Double servingSize;
        private Double calPerServing;
        private String foodGroup;

        public FoodFacts (Double servingSize, Double calPerServing,String foodGroup){
            this.servingSize = servingSize;
            this.calPerServing = calPerServing;
            this.foodGroup = foodGroup;
        }

    }

