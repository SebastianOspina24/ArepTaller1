package edu.escuelaing.Categorias.temperatura;



public class Celsius implements Temperatura{


    @Override
    public   double getCelsius(double value) {
        return value;
    }

    @Override
    public  double getFahrenheit(double value) {
        return (value*9/5)+32;
    }
}
