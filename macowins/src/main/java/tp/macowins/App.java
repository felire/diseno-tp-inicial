package tp.macowins;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App 
{
	private ArrayList<Venta> ventasTotales;
	public App(){
		ventasTotales = new ArrayList<Venta>();
	}
    public ArrayList<Venta> getVentasTotales() {
		return ventasTotales;
	}
	public void setVentasTotales(ArrayList<Venta> ventasTotales) {
		this.ventasTotales = ventasTotales;
	}
	public double calcularGanancia(Fecha fecha){
		int i = 0;
		double acum = 0;
		this.ventasTotales = (ArrayList<Venta>) this.ventasTotales.stream().filter(venta1 -> venta1.mismaFecha(fecha)).collect(Collectors.toList());
		for(;i<this.ventasTotales.size();i++){
			acum += ventasTotales.get(i).ganancia();
		}
		return acum;
	}
	public static void main( String[] args )
    {
    	Prenda.setValorFijo(50);
        Sacos saco = new Sacos(100,true);
        Venta venta = new Venta(saco,5,new Fecha(14,5,2016));
        Venta venta1 = new Venta(saco,7,new Fecha(14,5,2016));
        Venta venta2 = new Venta(saco,8,new Fecha(14,5,2016));
        Fecha fecha = new Fecha(14,5,2016);
        App aplicacion = new App();
        aplicacion.getVentasTotales().add(venta);
        aplicacion.getVentasTotales().add(venta1); 
        aplicacion.getVentasTotales().add(venta2); 
        System.out.println(aplicacion.calcularGanancia(fecha));
    }
}
