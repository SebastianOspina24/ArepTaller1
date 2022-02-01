package edu.escuelaing.Categorias.temperatura;

public class Fahrenheit implements Temperatura{

    private double celsius;
    private double fahrenhaeit;

    public Fahrenheit(double value){
        celsius = getCelsius(value);
        fahrenhaeit = getFahrenheit(value);
    }

    @Override
    public double getCelsius(double value) {
        return (value-32)*5/9;
    }

    @Override
    public double getFahrenheit(double value) {
        return value;
    }

}
