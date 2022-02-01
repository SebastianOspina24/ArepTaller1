package edu.escuelaing.Categorias.temperatura;

public class Kelvin implements Temperatura {


    @Override
    public double getCelsius(double value) {
        return value - 273.15;
    }

    @Override
    public double getFahrenheit(double value) {
        return (getCelsius(value)*(9/5))+32;
    }

    @Override
    public double getKelvin(double value) {
        return value;
    }
    
}
