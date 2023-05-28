package model;

public class Grupo {
	public String cod;
	public String tema;
	public String profmatr;
	public String pfarea;
	public String nome;
	public String ra;
	public String profnome;
@Override
	public String toString() {
		return cod + ";"  + profmatr +  ";" +profnome  +  ";" + pfarea + ";"+ tema+
				";" + nome+ ";" + ra+ ";";
	}

	
}
