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

import model.Professor;

public class ProfessorController implements ActionListener{
	private JTextField texProfessornome;
	private JTextField textProfessorarea;
	private JTextField texProfessorMatricula;
	private JTextArea tabProfessor;
	Lista lp = new Lista();
	public ProfessorController(JTextField texProfessornome, JTextField textProfessorarea,JTextField texProfessorMatricula,JTextArea tabProfessor) {
		this.texProfessornome = texProfessornome;
		this.textProfessorarea = textProfessorarea;
		this.texProfessorMatricula =texProfessorMatricula;
		this.tabProfessor = tabProfessor;
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	
		String cmd = e.getActionCommand();
		if(cmd.equals("Salvar")) {
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
		// TODO Auto-generated method stub
		
	}
	private void buscar() throws IOException  {
		Professor pf = new Professor ();
		pf.matricula = texProfessorMatricula.getText();
		pf =buscaProfessor(pf);
		if(pf.nome!=null) {
			tabProfessor.setText("Matricula: "+ pf.matricula + "\t Nome : "+ pf.nome + "\t Área de pesquisa: " + pf.Area);
		}else {
			tabProfessor.setText("Professor  não encontrado ");
			
		}
		
		
	}
	public Professor buscaProfessor(Professor pf) throws IOException {
		String path = System.getProperty("user.home") + File.separator +"Sistema de Cadastro";
		File arq = new File(path,"Professor.csv");
		if(arq.exists()&& arq.isFile()) {
			FileInputStream fis = new FileInputStream(arq);
			InputStreamReader isr =new InputStreamReader(fis);
			BufferedReader buffer =new BufferedReader(isr);
			String linha = buffer.readLine();
			while(linha!=null) {
				String [] vetlinha =linha.split(";");
				
				if(vetlinha[0].equals(pf.matricula)) {
					pf.nome = vetlinha[1];
					pf.Area=vetlinha [2];
					break;
				}
				linha=buffer.readLine();
			}
			buffer.close();
			isr.close();
			fis.close();
		}
		return pf;
	}
	private void CadastroProfessor(String csvProf) throws IOException {
		String path = System.getProperty("user.home") + File.separator +"Sistema de Cadastro";
		File dir = new File (path);
		if(!dir.exists()) {
			dir.mkdir();
		}
		File arq = new File(path,"Professor.csv");
		boolean existe =false;
		if(arq.exists()) {
			existe = true;
		}
		FileWriter fw = new FileWriter(arq, existe);
		PrintWriter pw = new PrintWriter(fw);
		pw.write(csvProf +"\r\n");
		pw.flush();
		pw.close();
		fw.close();
		
	}
	private void cadastro() throws IOException {
		Professor pf = new Professor ();
		pf.matricula = texProfessorMatricula.getText();
		pf.nome = texProfessornome.getText();
		pf.Area =textProfessorarea.getText();
		
		CadastroProfessor(pf.toString());
		texProfessornome.setText("");
		textProfessorarea.setText("");
		texProfessorMatricula.setText("");
	}
	
}


	