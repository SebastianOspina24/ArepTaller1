package  edu.escuelaing.arep;

import static spark.Spark.*;

import com.google.gson.Gson;

import edu.escuelaing.Categorias.temperatura.*;


public class SparkWebApp {

    public static void main(String[] args) {
        port(getPort());
        get("/hello", (req, res) -> "Hello Heroku");
        path("/Temperatura",()->{
            get("/Celsius/:value", (req, res)->{
                return getCelsius(Double.valueOf(req.params(":value")));
            });
            get("/Fahrenheit/:value", (req, res)->{
                return getFahrenheit(Double.valueOf(req.params(":value")));
            });
        });       
    }

    private static Object getCelsius(double valor) {
        return new Gson().toJson(new Celsius(valor));
    }

    private static Object getFahrenheit(double valor) {
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