package tp.macowins;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import javax.swing.JFrame;

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
		App aplicacion = new App();
		JFrame ventana = new JFrame("MacoWins");
		ventana.setExtendedState(JFrame.MAXIMIZED_BOTH);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Interfaz panel = new Interfaz(aplicacion);
		ventana.add(panel);
		ventana.setVisible(true);
    }
}
