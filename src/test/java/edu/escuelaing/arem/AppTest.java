package edu.escuelaing.arem;

import static org.junit.Assert.assertEquals;
import org.junit.*;

import edu.escuelaing.Categorias.temperatura.Celsius;
import edu.escuelaing.Categorias.temperatura.Fahrenheit;
import edu.escuelaing.Categorias.temperatura.Temperatura;

/**
 * Unit test for simple App.
 */
public class AppTest {

    Temperatura tem;

    @Test
    /**
     * Se verifica que la resolucion de Celsius a Fahrenheit sea correcta, y todas deben pasar
     */
    public void CaseCelsiusFahrenheit(){
        tem = new Celsius(0);
        assertEquals(tem.getFahrenheit(0.0),32.0,1);
        assertEquals(tem.getFahrenheit(31),87.8,1);
        assertEquals(tem.getFahrenheit(55),131,1);
        assertEquals(tem.getFahrenheit(100),212,1);
        assertEquals(tem.getFahrenheit(78),172.4,1);
        assertEquals(tem.getFahrenheit(35.9),96.62,1);
        assertEquals(tem.getFahrenheit(-987),-1744.6,1);
    }


    @Test
    /**
     * Se verifica que la resolucion de Celsius a Celsius sea correcta, y todas deben pasar
     */
    public void CaseCelsiusCelsius(){
        tem = new Celsius(0);
        assertEquals(tem.getCelsius(0.0),0.0,1);
        assertEquals(tem.getCelsius(31),31,1);
        assertEquals(tem.getCelsius(55),55,1);
        assertEquals(tem.getCelsius(100),100,1);
        assertEquals(tem.getCelsius(78),78,1);
        assertEquals(tem.getCelsius(35.9),35.9,1);
        assertEquals(tem.getCelsius(-987),-987,1);

    }


    @Test
     /**
     * Se verifica que la resolucion de Fahrenheit a Celsius  sea correcta, y todas deben pasar
     */
    public void CaseFahrenheitCelsius(){
        
        tem = new Fahrenheit(0);
        assertEquals(0.0,tem.getCelsius(32.0),1);
        assertEquals(31,tem.getCelsius(87.8),1);
        assertEquals(55,tem.getCelsius(131),1);
        assertEquals(100,tem.getCelsius(212),1);
        assertEquals(78,tem.getCelsius(172.4),1);
        assertEquals(35.9,tem.getCelsius(96.62),1);
        assertEquals(-987,tem.getCelsius(-1744.6),1);
    }


    @Test
     /**
     * Se verifica que la resolucion de Fahrenheit a Fahrenheit  sea correcta, y todas deben pasar
     */
    public void CaseFahrenheitFahrenheit(){
        
        tem = new Fahrenheit(0);
        assertEquals(tem.getFahrenheit(0.0),0.0,1);
        assertEquals(tem.getFahrenheit(31),31,1);
        assertEquals(tem.getFahrenheit(55),55,1);
        assertEquals(tem.getFahrenheit(100),100,1);
        assertEquals(tem.getFahrenheit(78),78,1);
        assertEquals(tem.getFahrenheit(35.9),35.9,1);
        assertEquals(tem.getFahrenheit(-987),-987,1);
    }

}
