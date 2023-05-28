package model;

public class Agenda {
	public String cod;
	public String data;
	public String Orientação ;
	public String Orientador;
	public String tema;
	public String integrantes;
	@Override
	public String toString() {
		return  cod + ";"+  data + ";" + Orientação + "; " + Orientador
				+ ";" + tema + ";" + integrantes ;
	}
	
	
}
