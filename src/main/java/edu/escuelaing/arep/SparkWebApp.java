package  edu.escuelaing.arep;

import static spark.Spark.*;
import spark.Filter;
import spark.Request;
import spark.Response;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

import edu.escuelaing.Categorias.temperatura.*;


public class SparkWebApp {

    public static void main(String[] args) {
        port(getPort());
        staticFileLocation("/html");
        init();
        after((Filter) (request, response) -> {
            response.header("Access-Control-Allow-Origin", "*");
            response.header("Access-Control-Allow-Methods", "GET");
        });
        path("/Temperatura",()->{
            get("/Celsius", (req, res)->{
                return getCelsius(Double.valueOf(req.queryParams("value")));
            });
            get("/Fahrenheit", (req, res)->{
                return getFahrenheit(Double.valueOf(req.queryParams("value")));
            });
        });  
    }

    private static JsonElement getCelsius(double valor) {
        return new Gson().toJsonTree(new Celsius(valor));
    }

    private static JsonElement getFahrenheit(double valor) {
        return new Gson().toJsonTree(new Fahrenheit(valor));
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
        //returns default port if heroku-port isn't set (i.e. on localhost)
    }


}