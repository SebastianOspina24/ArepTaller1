package edu.escuelaing.Categorias.temperatura;



public class Celsius implements Temperatura{

    private double celsius;
    private double fahrenheit;

    /**
     * Constructor de Celsius y calcula todas las temperaturas que esten en la interfaz implementada
     * @param value
     */
    public Celsius(double value){
        celsius = getCelsius(value);
        fahrenheit = getFahrenheit(value);
    }

    @Override
    public   double getCelsius(double value) {
        return value;
    }

    @Override
    public  double getFahrenheit(double value) {
        return (value*9/5)+32;
    }
}
