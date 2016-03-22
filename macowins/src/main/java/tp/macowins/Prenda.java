package tp.macowins;

public abstract class Prenda
{
	public static int valorFijo=3; //le tire 3 pa joder, dice que puede ser cualquier valor
	public int precioBase;
	public double tasaDeImportacion=1;
	
	public double precioFinal()
	{
		return ((valorFijo+this.precioBase)*this.tasaDeImportacion);
	}
	
	public void esImportado()
	{
		this.tasaDeImportacion=1.3;
	}
}