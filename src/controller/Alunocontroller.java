package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import br.edu.fateczl.lista.listaObj.Lista;
import model.Aluno;

public class Alunocontroller implements ActionListener {
private JTextField tfAlunora;
private JTextField tfAlunonome;
private JTextArea tabAluno;

	Lista l = new Lista();

public Alunocontroller(JTextField tfAlunora, JTextField tfAlunonome, JTextArea tabAluno) {
	
	this.tfAlunora = tfAlunora;
	this.tfAlunonome = tfAlunonome;
	this.tabAluno = tabAluno;
}

public Alunocontroller() {
	// TODO Auto-generated constructor stub
}

@Override
public void actionPerformed(ActionEvent e) {
	String cmd = e.getActionCommand();
	if(cmd.equals("Cadastrar")) {
		try {
			cadastro();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	if(cmd.equals("Buscar")) {
		try {
			buscar();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	if(cmd.equals("Excluir")) {
		excluir();
	}
	
}

private void excluir() {
	
}

private void buscar() throws IOException {
	Aluno al = new Aluno();
	al.ra =tfAlunora.getText().trim();
	al = buscaAluno(al);
	if(al.nome!=null) {
		tabAluno.setText("RA: "+ al.ra + " \t Nome : "+ al.nome);
	}else {
		tabAluno.setText("Aluno não encontrado ");
	}
	
	
}

public Aluno buscaAluno(Aluno al) throws IOException {
	String path = System.getProperty("user.home") + File.separator +"Sistema de Cadastro";
	File arq = new File(path,"Aluno.csv");
	if(arq.exists()&& arq.isFile()) {
		FileInputStream fis = new FileInputStream(arq);
		InputStreamReader isr =new InputStreamReader(fis);
		BufferedReader buffer =new BufferedReader(isr);
		String linha = buffer.readLine();
		while(linha!=null) {
			String [] vetlinha =linha.split(";");
			
			if(vetlinha[0].equals(al.ra)) {
				al.nome = vetlinha[1];
				break;
			}
			linha=buffer.readLine();
		}
		buffer.close();
		isr.close();
		fis.close();
	}
	return al;
}


private void cadastro() throws IOException {
	Aluno al = new Aluno();
	al.ra =tfAlunora.getText();
	al.nome = tfAlunonome.getText();
	
		cadastroAluno (al.toString());
		tfAlunora.setText(" ");
		tfAlunonome.setText("");
}

private void cadastroAluno(String csvAluno) throws IOException {
	String path = System.getProperty("user.home") + File.separator +"Sistema de Cadastro";
	File dir = new File (path);
	if(!dir.exists()) {
		dir.mkdir();
	}
	File arq = new File(path,"Aluno.csv");
	boolean existe =false;
	if(arq.exists()) {
		existe = true;
	}
	FileWriter fw = new FileWriter(arq, existe);
	PrintWriter pw = new PrintWriter(fw);
	pw.write(csvAluno +"\r\n");
	pw.flush();
	pw.close();
	fw.close();
	
	
	
}

}
