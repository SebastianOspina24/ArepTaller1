package  edu.escuelaing.arep;

import static spark.Spark.*;

import edu.escuelaing.Categorias.temperatura.Celsius;
import edu.escuelaing.Categorias.temperatura.Temperatura;



public class SparkWebApp {

    public static void main(String[] args) {
        port(getPort());
        get("/hello", (req, res) -> "Hello Heroku");
        path("/Temperatura",()->{
            final Temperatura tempe = new Celsius();
            path("/Celsius",()->{
                get("/Fahrenhaeit/:value", (req, res) -> {
                    return " "+tempe.getFahrenheit(Integer.valueOf(req.params(":value")));
                });
                get("/Celsius/:value", (req, res) -> {
                    return "Hello Heroku " + req.params(":value");
                });
            });
            path("/Fahrenhaeit",()->{
                get("/Fahrenhaeit/:value", (req, res) -> {
                    return "Hello Heroku " + req.params(":value");
                });
                get("/Celsius/:value", (req, res) -> {
                    return "Hello Heroku " + req.params(":value");
                });
            });
        });       
    }
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
        //returns default port if heroku-port isn't set (i.e. on localhost)
    }
}