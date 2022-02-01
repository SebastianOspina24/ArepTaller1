package edu.escuelaing.Categorias.temperatura;


public interface Temperatura {


    /**
     * Recibe un valor el cual va a ser convertido a Celsius 
     * @param value Valor el cual se quiere convertir
     * @return valor obtenido tras la convesion
     */
    public  abstract double getCelsius(double value);

    /**
     * Recibe un valor el cual va a ser convertido a Fahrenheit 
     * @param value Valor el cual se quiere convertir
     * @return valor obtenido tras la convesion
     */
    public abstract double getFahrenheit(double value);

}
