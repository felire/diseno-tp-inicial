package tp.macowins;

public abstract class Prenda {
	static private int valorFijo;
	protected int precioBase;
	protected boolean importada;
	
	public static int getValorFijo() {
		return valorFijo;
	}

	public static void setValorFijo(int valorFijo) {
		Prenda.valorFijo = valorFijo;
	}
	public int getPrecioBase() {
		return precioBase;
	}

	public void setPrecioBase(int precioBase) {
		this.precioBase = precioBase;
	}
	public boolean isImportada() {
		return importada;
	}

	public void setImportada(boolean importada) {
		this.importada = importada;
	}
	
	public double precioFinal(){
		return (this.valorFijo + this.precioBase)*this.importada();
	}
	
	public double importada(){
		if(this.importada){
			return 1.3;
		}
		else{
			return 1;
		}
	}
	
}