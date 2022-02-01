package edu.escuelaing.Categorias.temperatura;

public class Fahrenheit implements Temperatura{


    @Override
    public double getCelsius(double value) {
        return (value-32)*(5/9);
    }

    @Override
    public double getFahrenheit(double value) {
        return value;
    }

    @Override
    public double getKelvin(double value) {
        return getCelsius(value)+273.15;
    }
    
}
