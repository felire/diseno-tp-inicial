package tp.macowins;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
	App aplicacion;
	Venta venta;
    Venta venta1;
    Venta venta2;
    Camisas camisa;
    Pantalones pantalon;
    Sacos saco;
	public void setUp(){
		Prenda.setValorFijo(50);
		this.aplicacion = new App();
		this.camisa = new Camisas(200,true);
		this.pantalon = new Pantalones(250,false);
		this.saco = new Sacos(300,true);
		venta = new Venta(camisa,2,new Fecha(2,6,2015));
		venta1 = new Venta(pantalon,3,new Fecha(2,6,2015));
		venta2 = new Venta(saco,1,new Fecha(3,6,2015));
		this.aplicacion.getVentasTotales().add(venta);
		this.aplicacion.getVentasTotales().add(venta1);
		this.aplicacion.getVentasTotales().add(venta2);
	}
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }
    public void testApp()
    {
    	this.assertEquals(1550,(int) this.aplicacion.calcularGanancia(new Fecha(2,6,2015)));
        
    }
}
