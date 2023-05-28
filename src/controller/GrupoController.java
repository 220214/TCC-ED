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
import model.Grupo;
import model.Professor;

public class GrupoController  implements ActionListener{
	private JTextField txGrupocod;
	private JTextField txGrupomatr;
	private JTextField txGrupoprof;
	private JTextField txGrupoare;
	private JTextField txGrupotema;
	private JTextField txGrupora1;
	private JTextField txGruponome1;
	private JTextArea tfGrupotab;
	

	public GrupoController(JTextField txGrupocod, JTextField txGrupomatr, JTextField txGrupoprof, JTextField txGrupoare,
			JTextField txGrupotema, JTextField txGrupora1, JTextField txGruponome1,JTextArea tfGrupotab) {
	
		this.txGrupocod = txGrupocod;
		this.txGrupomatr = txGrupomatr;
		this.txGrupoprof = txGrupoprof;
		this.txGrupoare = txGrupoare;
		this.txGrupotema = txGrupotema;
		this.txGrupora1 = txGrupora1;
		this.txGruponome1 = txGruponome1;
		this. tfGrupotab = tfGrupotab;
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
		if(cmd.equals("Buscar/grupo")) {
			try {
				buscargrupo();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(cmd.equals("Buscar/Professor")) {
			try {
				buscarprofessor();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if(cmd.equals("Buscar/Aluno")) {
			try {
				buscarAluno();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
	}


	private void buscarAluno() throws IOException {
		Aluno al = new Aluno();
		al.ra =txGrupora1.getText();
		al = buscaAluno(al);
		if(al.nome!=null) {
			txGruponome1.setText(al.nome);
		}else {
			tfGrupotab.setText("Aluno não encontrado ");
		}
	}

	private Aluno buscaAluno(Aluno al) throws IOException {
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


	private void buscarprofessor() throws IOException {
		Professor pf = new Professor ();
		pf.matricula = txGrupomatr.getText();
		pf =buscaProfessor(pf);
		if(pf.nome!=null) {
			txGrupoprof.setText(pf.nome); 
			txGrupoare.setText(pf.Area);
		}else {
			tfGrupotab.setText("Professor  não encontrado ");
			
		}
		
		
	}



	private Professor buscaProfessor(Professor pf) throws IOException {
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
	


	private void buscargrupo() throws Exception {
		Grupo gr = new Grupo();
		Lista aluno = new Lista();
		aluno= buscaAluno(gr.ra);
		
		gr.cod =txGrupocod.getText();
		gr = buscarGrupo(gr);
		if(gr.nome!=null) {
			tfGrupotab.setText("Grupo: "+ gr.cod+ "\t Professor : "+ gr.profnome + " Tema :"+ gr.tema);
			
		}else {
			tfGrupotab.setText("Grupo não encontrado ");
			
		}
		int tm =aluno.size();
		StringBuffer buffer = new StringBuffer();
		if(tm>0) {
			for(int i=0; i<tm;i++) {
				Grupo g = (Grupo) aluno.get(i);
				buffer.append("Aluno ;" + g.nome+"\r\n");
				
			}
			tfGrupotab.setText(buffer.toString());
		}
		
	}


	private Lista buscaAluno(String ra) throws IOException {
		Grupo pr = new Grupo();
		Lista aluno = new Lista();
		String path = System.getProperty("user.home") + File.separator +"Sistema de Cadastro";
		File arq = new File(path,"Grupo.csv");
		if(arq.exists()&& arq.isFile()) {
			FileInputStream fis = new FileInputStream(arq);
			InputStreamReader isr =new InputStreamReader(fis);
			BufferedReader buffer =new BufferedReader(isr);
			String linha = buffer.readLine();
			while(linha!=null) {
				String [] vetlinha =linha.split(";");
				
				if(vetlinha[5].equals(ra)){
					Grupo gr = new Grupo();
					gr.nome =vetlinha[5];
					
				aluno.addFirst(gr);
				}
				linha=buffer.readLine();
			}
			buffer.close();
			isr.close();
			fis.close();
	}
		return aluno;
	}
	


	private Grupo buscarGrupo(Grupo gr) throws IOException {
		String path = System.getProperty("user.home") + File.separator +"Sistema de Cadastro";
		File arq = new File(path,"Grupo.csv");
		if(arq.exists()&& arq.isFile()) {
			FileInputStream fis = new FileInputStream(arq);
			InputStreamReader isr =new InputStreamReader(fis);
			BufferedReader buffer =new BufferedReader(isr);
			String linha = buffer.readLine();
			while(linha!=null) {
				String [] vetlinha =linha.split(";");
				
				if(vetlinha[0].equals(gr.cod)){
					gr.profmatr = vetlinha[1];
					gr.profnome = vetlinha[2];
					gr.ra = vetlinha[4];
					gr.nome =vetlinha[5];
					gr.tema =vetlinha[3];
					
					break;
				}
				linha=buffer.readLine();
			}
			buffer.close();
			isr.close();
			fis.close();
	}
		return gr;
	}
	


	private void cadastro() throws IOException {
		Grupo gr = new Grupo();
		gr.cod = txGrupocod.getText();
		gr.profmatr = txGrupomatr.getText();
		gr.profnome = txGrupoprof.getText();
		gr.ra = txGrupora1.getText();
		gr.nome =txGruponome1.getText();
		gr.tema =txGrupotema.getText();
		gr.pfarea = txGrupoare.getText();
		CadastrarGrupo(gr.toString());
	
		
	}


	private void CadastrarGrupo(String csvgrupo) throws IOException {
		String path = System.getProperty("user.home") + File.separator +"Sistema de Cadastro";
		File dir = new File (path);
		if(!dir.exists()) {
			dir.mkdir();
		}
		File arq = new File(path,"Grupo.csv");
		boolean existe =false;
		if(arq.exists()) {
			existe = true;
		}
		FileWriter fw = new FileWriter(arq, existe);
		PrintWriter pw = new PrintWriter(fw);
		pw.write(csvgrupo +"\r\n");
		pw.flush();
		pw.close();
		fw.close();
		
	}

}
