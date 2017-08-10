import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import models.Food;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;



/**
 * Created by Guest on 8/10/17.
 */
public class App {

    public static void main(String[] args) {
        staticFileLocation("/public");

        // get: home page
        get ("/", (request, response)->{
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "layout.hbs");
        }, new HandlebarsTemplateEngine());

        //get: show new Food form
        get ("foods/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "food-form.hbs");
        }, new HandlebarsTemplateEngine());

        //post: update new Food when form is submitted
        post ( "foods/new", (request,response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String name = request.queryParams("foodSelector");
            Double servings = Double.parseDouble(request.queryParams("servings"));
            Food newFood = new Food(name, servings);
            model.put("newFood", newFood);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        //get: show all foods
        get ( "/foods", (request,response)-> {
            Map<String, Object> model = new HashMap<String, Object>();
            ArrayList<Food> foods = Food.getAllFoods();
            model.put("foods",foods);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        //get individual food details
        get( "/foods/:id", (request,response)-> {
            Map<String, Object> model = new HashMap<String, Object>();
            int id = Integer.parseInt(request.params("id"));
            Food detailFood = Food.getFoodbyId(id);
            model.put("food",detailFood);
            System.out.println("ID "+ id + "name "+detailFood.getName());
            return new ModelAndView(model, "foods-details.hbs");
        }, new HandlebarsTemplateEngine());

        //get: individual food update
        get("/foods/:id/update", (request, response) -> {
            System.out.println(request);
            System.out.println(response);

            Map<String,Object>model = new HashMap<String,Object>();
            int id = Integer.parseInt(request.params("id"));
            Food detailFood = Food.getFoodbyId(id);
            model.put("detailFood",detailFood);
            return new ModelAndView(model, "food-form.hbs");
        }, new HandlebarsTemplateEngine());

//        //post: update individual food
//        post("/foods/:id/update", (request, response) -> {
//            Map<String,Object>model = new HashMap<String,Object>();
//            Double newServings = Double.parseDouble(request.queryParams("servings"));
//            int id = Integer.parseInt(request.params("id"));
//            Food detailFood = Food.getFoodbyId(id);
//            detailFood.update(newServings);
//
//            return new ModelAndView(model, "success.hbs");
//        }, new HandlebarsTemplateEngine());






    }
}
