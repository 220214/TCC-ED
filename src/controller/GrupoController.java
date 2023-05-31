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
		if(cmd.equals("Limpar/Tela")) {
			LimparTela();
		}
		
	}


	private void LimparTela() {
		txGrupocod.setText("");
		 txGrupomatr.setText("");
		txGrupoprof.setText("");
		txGrupoare.setText("");
		txGrupotema.setText("");
		txGrupora1.setText("");
		txGruponome1.setText("");
		tfGrupotab.setText("");
		            
	}


	private void buscargrupo() throws Exception {
	Lista p = new Lista();
	Grupo gr = new Grupo ();
	gr.cod = txGrupocod.getText();
	
	p = buscarGrupo(gr.cod);
	if(p!=null) {
	int tm = p.size();
	StringBuffer buffer = new StringBuffer();
	if(tm>0) {
	for(int i = 0 ; i< tm ;i++) {
		Grupo g = (Grupo)p.get(i);
		buffer.append("Cod " + g.cod+ "  Prof "+ g.profnome+ "  Tema: "+g.tema);
		buffer.append("\n\r");
		buffer.append(" RA: "+ g.ra+ "  Nome:  "+ g.nome);
		buffer.append("\n\r");
	}
	tfGrupotab.setText(buffer.toString());
	}
	
	}else {
	tfGrupotab.setText("Grupo não encontrado");
	}
	}


	private Lista buscarGrupo(String cod) throws IOException {
		Lista grupo = new Lista ();
		String path = System.getProperty("user.home") + File.separator +"Sistema de Cadastro";
		File arq = new File(path,"Grupo.csv");
		if(arq.exists()&& arq.isFile()) {
			FileInputStream fis = new FileInputStream(arq);
			InputStreamReader isr =new InputStreamReader(fis);
			BufferedReader buffer =new BufferedReader(isr);
			String linha = buffer.readLine();
			while(linha!=null) {
				String [] vetlinha =linha.split(";");
				if (vetlinha.length > 1) {
					if(vetlinha[0].equals(cod)){
						Grupo gr = new Grupo();
						gr.cod= vetlinha [0];
						gr.profmatr = vetlinha[1];
						gr.profnome = vetlinha[2];
						gr.pfarea = vetlinha[3];
						gr.tema =vetlinha[4];
						gr.nome =vetlinha[5];
						gr.ra = vetlinha[6];
						
						
						
						grupo.addFirst(gr);
					}
				}
				linha=buffer.readLine();
			}
			buffer.close();
			isr.close();
			fis.close();
	}
		return grupo;
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
