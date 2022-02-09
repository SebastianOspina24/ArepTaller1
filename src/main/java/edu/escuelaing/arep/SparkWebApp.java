package  edu.escuelaing.arep;

import static spark.Spark.*;
import spark.Filter;


import com.google.gson.Gson;

import edu.escuelaing.Categorias.temperatura.*;


public class SparkWebApp {

    public static void main(String[] args) {
        staticFiles.location("/public");
        port(getPort());
        init();
        after((Filter) (request, response) -> {
            response.header("Access-Control-Allow-Origin", "*");
            response.header("Access-Control-Allow-Methods", "GET");
        });
        path("/Temperatura",() ->{
            get("/Celsius",(req, res)->{
                res.type("application/json");
                return getCelsius(Double.valueOf(req.queryParams("value")));
            });
            get("/Fahrenheit",(req, res)->{
                res.type("application/json");
                return getFahrenheit(Double.valueOf(req.queryParams("value")));
            });  
        });
    }

    private static String getCelsius(double valor) {
        return new Gson().toJson(new Celsius(valor));
    }

    private static String getFahrenheit(double valor) {
        return new Gson().toJson(new Fahrenheit(valor));
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
        //returns default port if heroku-port isn't set (i.e. on localhost)
    }


}
