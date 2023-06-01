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

import br.com.mary.pilhastring.Pilha;
import br.edu.fateczl.lista.listaObj.Lista;
import model.Agenda;
import model.Grupo;

public class Agendacontroller implements ActionListener{
	
	private JTextField texAgendaCodGrupo;
	private JTextField textAgendaData;
	private JTextField textAgendaOrientação;
	private JTextArea textAgendaTema;
	private JTextArea txtabAgendaOrientador;
	private JTextArea txtabAgendaIntregrantes;
	private JTextArea txtabBuscarOrientação;
	
	

	public Agendacontroller(JTextField texAgendaCodGrupo, JTextField textAgendaData, JTextField textAgendaOrientação,
			JTextArea textAgendaTema, JTextArea txtabAgendaOrientador, JTextArea txtabAgendaIntregrantes,JTextArea txtabBuscarOrientação) {
		this.texAgendaCodGrupo = texAgendaCodGrupo;
		this.textAgendaData = textAgendaData;
		this.textAgendaOrientação = textAgendaOrientação;
		this.textAgendaTema = textAgendaTema;
		this.txtabAgendaOrientador = txtabAgendaOrientador;
		this.txtabAgendaIntregrantes = txtabAgendaIntregrantes;
		this.txtabBuscarOrientação= txtabBuscarOrientação;
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
				Buscar();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(cmd.equals("Limpar Tela")) {
			Limpar();
		}
		if(cmd.equals("Lista Orientação")) {
			try {
				listaOri();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}



	private void listaOri() throws Exception {
		Lista l = new Lista();
		Agenda a = new Agenda();
		a.cod = texAgendaCodGrupo.getText();
		
		l= buscarLista(a.cod);
		int tm = l.size();
		StringBuffer buffer= new StringBuffer();
		if(tm>0) {
		for(int i=tm-1 ; i>=0;i--) {
			buffer.append(l.get(i));
			buffer.append("\n\r" );
			
		}
		txtabBuscarOrientação.setText(buffer.toString());
		
	}
	}






	private Lista buscarLista(String cod) throws Exception {
		Lista l = new Lista ();
		String path = System.getProperty("user.home") + File.separator +"Sistema de Cadastro";
		File arq = new File(path,"Agenda.csv");
		if(arq.exists()&& arq.isFile()) {
			FileInputStream fis = new FileInputStream(arq);
			InputStreamReader isr =new InputStreamReader(fis);
			BufferedReader buffer =new BufferedReader(isr);
			String linha = buffer.readLine();
			while(linha!=null) {
				String [] vetlinha =linha.split(";");
				
				if(vetlinha[0].equals(cod)){
					
					if(l.isEmpty()==true) {
					
					l.addFirst(vetlinha[2]);
					
					}else {
						l.addLast(vetlinha[2]);
					}
				}
				linha=buffer.readLine();
			}
			buffer.close();
			isr.close();
			fis.close();
	}
		return l;
	}
	






	private void Limpar() {
		textAgendaTema.setText("");
		txtabAgendaOrientador.setText("");
		txtabAgendaIntregrantes.setText(""); 
		texAgendaCodGrupo.setText("");
		txtabBuscarOrientação.setText("");
		textAgendaOrientação.setText(" ");
		textAgendaData.setText(" "); 
	}






	private void Buscar() throws Exception {
		String tema = null ;
		String or= null;
		Lista p= new Lista();
		Agenda a = new Agenda();
		a.cod = texAgendaCodGrupo.getText();
		p= buscargrupo(a.cod);
		int tm = p.size();
		StringBuffer buffer= new StringBuffer();
		if (tm >0) {
			for (int i=0; i<tm; i++) {
				Grupo g = (Grupo)p.get(i);
				buffer.append( g.nome );
				buffer.append("\n\r" );
				tema =g.tema;
				or = g.profnome;
			}
			textAgendaTema.setText(tema);
			txtabAgendaOrientador.setText(or);
			txtabAgendaIntregrantes.setText(buffer.toString()); 
			Pilha pi = new Pilha ();
			pi = buscarorentação(a.cod);
					txtabBuscarOrientação.setText(pi.exibir());
		}else {
			txtabBuscarOrientação.setText("Grupo não encontrado");
		}
		
			}




	private Pilha buscarorentação(String cod) throws Exception {
		Pilha Or = new Pilha();
		String path = System.getProperty("user.home") + File.separator +"Sistema de Cadastro";
		File arq = new File(path,"Agenda.csv");
		if(arq.exists()&& arq.isFile()) {
			FileInputStream fis = new FileInputStream(arq);
			InputStreamReader isr =new InputStreamReader(fis);
			BufferedReader buffer =new BufferedReader(isr);
			String linha = buffer.readLine();
			while(linha!=null) {
				String [] vetlinha =linha.split(";");
				
				if(vetlinha[0].equals(cod)){
					Agenda  a = new Agenda();
					a.cod= vetlinha [0];
					a.data = vetlinha[1];
					a.Orientação = vetlinha[2];
					a.tema= vetlinha[3];
					a.Orientador=vetlinha[4];
					a.integrantes=vetlinha[5];
					
					Or.push(a.Orientação);
					
					
				}
				linha=buffer.readLine();
			}
			buffer.close();
			isr.close();
			fis.close();
	}
	if(Or.size()==0) {
		Or.push("Vazia");
	}
		
		return Or;
	}






	private Lista buscargrupo(String cod) throws IOException {
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
				linha=buffer.readLine();
			}
			buffer.close();
			isr.close();
			fis.close();
	}
		return grupo;
	}
	







	private void cadastro() throws IOException {
		Agenda a = new Agenda();
		a.cod = texAgendaCodGrupo.getText();     
		a.data =textAgendaData.getText();        
		a.Orientação=textAgendaOrientação.getText();  
		a.tema = textAgendaTema.getText();         
		a.Orientador =txtabAgendaOrientador.getText();  
		a.integrantes =txtabAgendaIntregrantes.getText();
		CadastrarAgenda(a.toString());
		textAgendaTema.setText("");
		txtabAgendaOrientador.setText("");
		txtabAgendaIntregrantes.setText(""); 
		texAgendaCodGrupo.setText("");
		txtabBuscarOrientação.setText("");
		textAgendaOrientação.setText(" ");
		textAgendaData.setText(" "); 
	}



	private void CadastrarAgenda(String csvagenda) throws IOException {
		String path = System.getProperty("user.home") + File.separator +"Sistema de Cadastro";
		File dir = new File (path);
		if(!dir.exists()) {
			dir.mkdir();
		}
		File arq = new File(path,"Agenda.csv");
		boolean existe =false;
		if(arq.exists()) {
			existe = true;
		}
		FileWriter fw = new FileWriter(arq, existe);
		PrintWriter pw = new PrintWriter(fw);
		pw.write(csvagenda +"\r\n");
		pw.flush();
		pw.close();
		fw.close();
		
	}
		
}                      
                                                   

