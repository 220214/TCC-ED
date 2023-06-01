package model;

public class Professor {
	public String nome;
	public String Area;
	public String matricula;
	public String SubArea;
	
	@Override
	public String toString() {
		return matricula +";" + nome + ";"+ Area+";"+ SubArea;
	}
	
}
