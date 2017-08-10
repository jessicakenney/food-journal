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
//        get ( "/foods", (request,response)-> {
//
//
//        }, new HandlebarsTemplateEngine());




    }
}
