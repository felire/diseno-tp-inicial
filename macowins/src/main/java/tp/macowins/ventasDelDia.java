package tp.macowins;

import java.util.ArrayList;

public class ventasDelDia
{
	public ArrayList<Venta> ventas= new ArrayList<Venta>();
	
	public void nuevaVenta(Prenda x,int y,String z)
	{
		Venta unaVenta= new Venta(x,y,z);
		ventas.add(unaVenta);
	}
	
	public double total()
	{
		double totalDia=0;
		int size= ventas.size();
		size--;
		Venta unaVenta;
		while(size>=0)
		{
			unaVenta=ventas.get(size);
			totalDia=totalDia+unaVenta.valor();
			size--;
		}
		
		return totalDia;
	}
}
