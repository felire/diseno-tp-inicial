package tp.macowins;

public class Venta
{
	public String fecha;
	public Prenda producto;
	public int cantidad;
	
	public Venta(Prenda prod, int cant, String dia)
	{
		producto=prod;
		cantidad=cant;
		fecha=dia;
	}
	
	public double valor()
	{
		double precio=producto.precioFinal();
		return (precio*cantidad);
	}
}
