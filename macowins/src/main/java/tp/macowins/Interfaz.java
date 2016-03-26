package tp.macowins;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Interfaz extends JPanel implements ActionListener{
	private JComboBox<String> combo1;
	private JComboBox<String> combo2;
	private JComboBox<String> dia;
	private JComboBox<String> mes;
	private JComboBox<String> anio;
	private JComboBox<String> diaCalculo;
	private JComboBox<String> mesCalculo;
	private JComboBox<String> anioCalculo;
	private ButtonGroup grupo;
	private JRadioButton importado;
	private JRadioButton noImportado;
	private JButton boton1; 
	private JButton boton2;
	private JLabel texto;
	private App aplicacion;
	public Interfaz(App aplicacion){
		this.aplicacion = aplicacion;
		String [] lista = {"Camisas", "Pantalones", "Sacos"};
		String [] lista2 = {"1", "2", "3", "4", "5", "6", "7", "8", "9","10"};
		String [] lista3 = {"1", "2", "3", "4", "5", "6", "7", "8", "9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		String [] lista4 = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
		String [] lista5 = {"2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008","2009","2010","2011","2012","2013","2014","2015","2016"};
		texto = new JLabel();
		texto.setVisible(false);
		combo1 = new JComboBox<String>(lista);
		combo1.setVisible(true);
		combo2 = new JComboBox<String>(lista2);
		combo2.setVisible(true);
		dia = new JComboBox<String>(lista3);
		dia.setVisible(true);
		mes = new JComboBox<String>(lista4);
		mes.setVisible(true);
		anio = new JComboBox<String>(lista5);
		anio.setVisible(true);
		diaCalculo = new JComboBox<String>(lista3);
		diaCalculo.setVisible(true);
		mesCalculo = new JComboBox<String>(lista4);
		mesCalculo.setVisible(true);
		anioCalculo = new JComboBox<String>(lista5);
		anioCalculo.setVisible(true);
		boton1 = new JButton("Añadir Venta");
		boton1.setVisible(true);
		boton1.addActionListener(this);
		boton2 = new JButton("Calcular Ventas");
		boton2.setVisible(true);
		boton2.addActionListener(this);
		importado = new JRadioButton("Prenda Importada", true);
		noImportado = new JRadioButton("Prenda no Importada",false);
		grupo = new ButtonGroup();
		grupo.add(importado);
		grupo.add(noImportado);
		JLabel textoCalculo = new JLabel("Seleccione Fecha para el calculo: ");
		textoCalculo.setVisible(true);
		JLabel texto1 = new JLabel("Elija la Prenda Vendida: ");
		texto1.setVisible(true);
		JLabel texto2 = new JLabel("Elija la Cantidad Vendida: ");
		texto2.setVisible(true);
		JLabel textoDia = new JLabel("Dia: ");
		textoDia.setVisible(true);
		JLabel textoMes = new JLabel("Mes: ");
		textoMes.setVisible(true);
		JLabel textoAnio = new JLabel("Año: ");
		textoAnio.setVisible(true);
		this.add(texto1);
		this.add(combo1);
		this.add(texto2);
		this.add(combo2);
		this.add(importado);
		this.add(noImportado);	
		this.add(textoDia);
		this.add(dia);
		this.add(textoMes);
		this.add(mes);
		this.add(textoAnio);
		this.add(anio);
		this.add(boton1);
		this.add(textoCalculo);
		this.add(dia);
		this.add(diaCalculo);
		this.add(mes);
		this.add(mesCalculo);
		this.add(anio);
		this.add(anioCalculo);
		this.add(boton2);
		this.add(texto);
	}
	public int darFecha(String fecha){
		if(fecha.equals("Enero")) return 1;
		if(fecha.equals("Febrero")) return 2;
		if(fecha.equals("Marzo")) return 3;
		if(fecha.equals("Abril")) return 4;
		if(fecha.equals("Mayo")) return 5;
		if(fecha.equals("Junio")) return 6;
		if(fecha.equals("Julio")) return 7;
		if(fecha.equals("Agosto")) return 8;
		if(fecha.equals("Sebtiembre")) return 9;
		if(fecha.equals("Octubre")) return 10;
		if(fecha.equals("Noviembre")) return 11;
		if(fecha.equals("Diciembre")) return 12;
		return 0;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String seleccion;
		Venta venta;
		// Esto lo seteo porque sino java me tira error
		venta = new Venta(new Sacos(300, importado.isSelected()), Integer.parseInt((String)combo2.getSelectedItem()), new Fecha(Integer.parseInt((String)dia.getSelectedItem()), darFecha((String)mes.getSelectedItem()),Integer.parseInt((String)anio.getSelectedItem())));
		Object fuente = e.getSource();
		if(boton1 == fuente){
		seleccion = (String) combo1.getSelectedItem();
		if(seleccion.equals("Camisas")){
			venta = new Venta(new Camisas(200, importado.isSelected()), Integer.parseInt((String)combo2.getSelectedItem()), new Fecha(Integer.parseInt((String)dia.getSelectedItem()), darFecha((String)mes.getSelectedItem()),Integer.parseInt((String)anio.getSelectedItem())));
		}
		if(seleccion.equals("Pantalones")){
			venta = new Venta(new Pantalones(250, importado.isSelected()), Integer.parseInt((String)combo2.getSelectedItem()), new Fecha(Integer.parseInt((String)dia.getSelectedItem()), darFecha((String)mes.getSelectedItem()),Integer.parseInt((String)anio.getSelectedItem())));
		}
		if(seleccion.equals("Sacos")){
			venta = new Venta(new Sacos(300, importado.isSelected()), Integer.parseInt((String)combo2.getSelectedItem()), new Fecha(Integer.parseInt((String)dia.getSelectedItem()), darFecha((String)mes.getSelectedItem()),Integer.parseInt((String)anio.getSelectedItem())));
		}
		aplicacion.getVentasTotales().add(venta);
		}
		else{
			texto.setText("Su ganancia total en el dia elegido es: "+ String.valueOf(aplicacion.calcularGanancia(new Fecha(Integer.parseInt((String)diaCalculo.getSelectedItem()), darFecha((String)mesCalculo.getSelectedItem()),Integer.parseInt((String)anioCalculo.getSelectedItem())))));
			texto.setVisible(true);
		}
	}
}
