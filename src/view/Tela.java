package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Agendacontroller;
import controller.Alunocontroller;
import controller.GrupoController;
import controller.ProfessorController;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class Tela extends JFrame {

	private static final long serialVersionUID = -8533024649811972087L;
	private JPanel contentPane;
	private JTextField tfAlunora;
	private JTextField tfAlunonome;
	private JTextField texProfessornome;
	private JTextField textProfessorarea;
	private JTextField tfcodigo;
	private JTextField tfpGrupoprofnome;
	private JTextField tfgrupoaareprof;
	private JTextField tfGrupora1;
	private JTextField txGrupotema;
	private JTextArea tfGrupotablista;
	private JTextField texProfessorMatricula;
	private JTextField tfgrupomatricula;
	private JTextField texGruponome1;
	private JTextField texAgendaCodGrupo;
	private JTextField textAgendaData;
	private JTextField textAgendaOrientação;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Tela() {
		setTitle("Fatec - TCC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 604, 419);
		contentPane.add(tabbedPane);
		
		JPanel TabAluno = new JPanel();
		TabAluno.setForeground(new Color(51, 204, 255));
		tabbedPane.addTab("Aluno", null, TabAluno, "Cadastro de Aluno");
		TabAluno.setLayout(null);
		
		JLabel lblAlunora = new JLabel("RA:");
		lblAlunora.setToolTipText("Registro do Aluno");
		lblAlunora.setForeground(new Color(0, 0, 0));
		lblAlunora.setFont(new Font("Arial", Font.PLAIN, 14));
		lblAlunora.setBounds(28, 45, 49, 40);
		TabAluno.add(lblAlunora);
		
		JLabel lblAlunonome = new JLabel("Nome:");
		lblAlunonome.setFont(new Font("Arial", Font.PLAIN, 14));
		lblAlunonome.setBounds(28, 96, 49, 40);
		TabAluno.add(lblAlunonome);
		
		tfAlunora = new JTextField();
		tfAlunora.setFont(new Font("Arial", Font.PLAIN, 14));
		tfAlunora.setBounds(87, 51, 187, 29);
		TabAluno.add(tfAlunora);
		tfAlunora.setColumns(10);
		
		tfAlunonome = new JTextField();
		tfAlunonome.setFont(new Font("Arial", Font.PLAIN, 14));
		tfAlunonome.setBounds(87, 102, 295, 29);
		TabAluno.add(tfAlunonome);
		tfAlunonome.setColumns(10);
		
		JButton btnAlunocadastrar = new JButton("Cadastrar");
		btnAlunocadastrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAlunocadastrar.setBounds(453, 50, 100, 29);
		TabAluno.add(btnAlunocadastrar);
		
		JButton btnAlunobuscar = new JButton("Buscar");
		btnAlunobuscar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAlunobuscar.setBounds(453, 103, 100, 29);
		TabAluno.add(btnAlunobuscar);
		
		JScrollPane tabelaAluno = new JScrollPane();
		tabelaAluno.setBounds(10, 153, 579, 97);
		TabAluno.add(tabelaAluno);
		
		JTextArea taAlunolista = new JTextArea();
		tabelaAluno.setViewportView(taAlunolista);
		taAlunolista.setFont(new Font("Monospaced", Font.PLAIN, 13));
		
		JPanel TabProfessor = new JPanel();
		tabbedPane.addTab("Professor", null, TabProfessor, "Cadastro de Professor");
		TabProfessor.setLayout(null);
		
		JLabel lblProfessornome = new JLabel("Nome:");
		lblProfessornome.setToolTipText("Nome do Professor");
		lblProfessornome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProfessornome.setBounds(10, 67, 46, 29);
		TabProfessor.add(lblProfessornome);
		
		JLabel lblProfessorarea = new JLabel("Área de Pesquisa:");
		lblProfessorarea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProfessorarea.setBounds(10, 107, 113, 29);
		TabProfessor.add(lblProfessorarea);
		
		texProfessornome = new JTextField();
		texProfessornome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		texProfessornome.setBounds(66, 67, 331, 29);
		TabProfessor.add(texProfessornome);
		texProfessornome.setColumns(10);
		
		textProfessorarea = new JTextField();
		textProfessorarea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textProfessorarea.setBounds(124, 107, 273, 29);
		TabProfessor.add(textProfessorarea);
		textProfessorarea.setColumns(10);
		
		JButton btnProfessorcadastro = new JButton("Salvar");
		btnProfessorcadastro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnProfessorcadastro.setBounds(469, 67, 107, 29);
		TabProfessor.add(btnProfessorcadastro);
		
		JButton btnProfessorBuscar = new JButton("Buscar");
		btnProfessorBuscar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnProfessorBuscar.setBounds(469, 112, 107, 29);
		TabProfessor.add(btnProfessorBuscar);
		
		JScrollPane tabProfessor = new JScrollPane();
		tabProfessor.setBounds(10, 164, 579, 154);
		TabProfessor.add(tabProfessor);
		
		JTextArea taProfessorlista = new JTextArea();
		tabProfessor.setViewportView(taProfessorlista);
		JLabel lblNewLabel = new JLabel("Matricula:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setToolTipText("Matricula do Professor");
		lblNewLabel.setBounds(10, 30, 68, 26);
		TabProfessor.add(lblNewLabel);
		
		texProfessorMatricula = new JTextField();
		texProfessorMatricula.setFont(new Font("Tahoma", Font.PLAIN, 14));
		texProfessorMatricula.setBounds(88, 30, 96, 25);
		TabProfessor.add(texProfessorMatricula);
		texProfessorMatricula.setColumns(10);
	
	
	
	JPanel tabGrupo = new JPanel();
	tabbedPane.addTab("Grupo", null, tabGrupo, "Cadastro do Grupo");
	tabGrupo.setLayout(null);
	
	JLabel lblGrupocodigo = new JLabel("Código Grupo:");
	lblGrupocodigo.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblGrupocodigo.setToolTipText("Sequência do Grupo");
	lblGrupocodigo.setBounds(10, 11, 96, 24);
	tabGrupo.add(lblGrupocodigo);
	
	JLabel lbProfessornome = new JLabel("Professor:");
	lbProfessornome.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lbProfessornome.setBounds(10, 78, 104, 24);
	tabGrupo.add(lbProfessornome);
	
	JLabel lblprofessorarea = new JLabel("Área de pesquisa:");
	lblprofessorarea.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblprofessorarea.setBounds(310, 78, 112, 24);
	tabGrupo.add(lblprofessorarea);
	
	JLabel lbprofessortema = new JLabel("Tema :");
	lbprofessortema.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lbprofessortema.setBounds(10, 108, 52, 23);
	tabGrupo.add(lbprofessortema);
	
	tfcodigo = new JTextField();
	tfcodigo.setFont(new Font("Tahoma", Font.PLAIN, 14));
	tfcodigo.setBounds(114, 12, 120, 24);
	tabGrupo.add(tfcodigo);
	tfcodigo.setColumns(10);
	
	tfpGrupoprofnome = new JTextField();
	tfpGrupoprofnome.setFont(new Font("Tahoma", Font.PLAIN, 14));
	tfpGrupoprofnome.setBounds(96, 79, 204, 24);
	tabGrupo.add(tfpGrupoprofnome);
	tfpGrupoprofnome.setColumns(10);
	
	tfgrupoaareprof = new JTextField();
	tfgrupoaareprof.setBounds(439, 80, 149, 24);
	tabGrupo.add(tfgrupoaareprof);
	tfgrupoaareprof.setColumns(10);
	
	tfGrupora1 = new JTextField();
	tfGrupora1.setFont(new Font("Tahoma", Font.PLAIN, 14));
	tfGrupora1.setBounds(96, 150, 204, 26);
	tabGrupo.add(tfGrupora1);
	tfGrupora1.setColumns(10);
	
	txGrupotema = new JTextField();
	txGrupotema.setBounds(96, 113, 154, 26);
	tabGrupo.add(txGrupotema);
	txGrupotema.setColumns(10);
	
	JScrollPane scrollPane_2 = new JScrollPane();
	scrollPane_2.setBounds(10, 215, 578, 131);
	tabGrupo.add(scrollPane_2);
	
	tfGrupotablista = new JTextArea();
	scrollPane_2.setViewportView(tfGrupotablista);
	tfGrupotablista.setFont(new Font("Tahoma", Font.PLAIN, 14));
	tfGrupotablista.setColumns(10);
	
	
	JButton btnBuscarGrupo = new JButton("Buscar/grupo");
	btnBuscarGrupo.setToolTipText("BuscarGrupo");
	btnBuscarGrupo.setFont(new Font("Tahoma", Font.PLAIN, 14));
	btnBuscarGrupo.setBounds(244, 12, 136, 23);
	tabGrupo.add(btnBuscarGrupo);
	
	JButton btnSalvarGrupo = new JButton("Salvar");
	btnSalvarGrupo.setFont(new Font("Tahoma", Font.PLAIN, 14));
	btnSalvarGrupo.setBounds(485, 357, 89, 23);
	tabGrupo.add(btnSalvarGrupo);
	
	JLabel lblprofessorra_1 = new JLabel("RA Aluno1:");
	lblprofessorra_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblprofessorra_1.setBounds(10, 142, 84, 36);
	tabGrupo.add(lblprofessorra_1);
	
	JButton btnGrupoBuscarAluno = new JButton("Buscar/Aluno");
	btnGrupoBuscarAluno.setToolTipText("Informe RA");
	btnGrupoBuscarAluno.setFont(new Font("Tahoma", Font.PLAIN, 14));
	btnGrupoBuscarAluno.setBounds(309, 113, 149, 23);
	tabGrupo.add(btnGrupoBuscarAluno);
	
	JLabel lblNewmatricula = new JLabel("Matricula:");
	lblNewmatricula.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblNewmatricula.setToolTipText("Matricula do professor");
	lblNewmatricula.setBounds(10, 48, 84, 19);
	tabGrupo.add(lblNewmatricula);
	
	tfgrupomatricula = new JTextField();
	tfgrupomatricula.setBounds(96, 46, 96, 24);
	tabGrupo.add(tfgrupomatricula);
	tfgrupomatricula.setColumns(10);
	
	JLabel lblGruponome1 = new JLabel(" Aluno1:");
	lblGruponome1.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblGruponome1.setBounds(310, 144, 84, 36);
	tabGrupo.add(lblGruponome1);
	
	texGruponome1 = new JTextField();
	texGruponome1.setFont(new Font("Tahoma", Font.PLAIN, 14));
	texGruponome1.setColumns(10);
	texGruponome1.setBounds(384, 150, 204, 26);
	tabGrupo.add(texGruponome1);
	
	JButton btngrupobuscarprof = new JButton("Buscar/Professor");
	btngrupobuscarprof.setFont(new Font("Tahoma", Font.PLAIN, 14));
	btngrupobuscarprof.setBounds(244, 46, 136, 23);
	tabGrupo.add(btngrupobuscarprof);
	
	JButton btnGrupoLimpar = new JButton("Limpar/Tela");
	btnGrupoLimpar.setBounds(462, 11, 112, 23);
	tabGrupo.add(btnGrupoLimpar);
	
	JPanel Orientador = new JPanel();
	Orientador.setToolTipText("");
	tabbedPane.addTab("Agenda", null, Orientador, "Orientação e Agendamento de Encontros");
	Orientador.setLayout(null);
	
	JLabel lblNewLabel_1 = new JLabel("CodGrupo:");
	lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblNewLabel_1.setToolTipText("Codigo do Grupo");
	lblNewLabel_1.setBounds(10, 46, 78, 30);
	Orientador.add(lblNewLabel_1);
	
	texAgendaCodGrupo = new JTextField();
	texAgendaCodGrupo.setFont(new Font("Tahoma", Font.PLAIN, 14));
	texAgendaCodGrupo.setBounds(84, 48, 100, 30);
	Orientador.add(texAgendaCodGrupo);
	texAgendaCodGrupo.setColumns(10);
	
	JLabel lblNewLabel_2 = new JLabel("Data:");
	lblNewLabel_2.setToolTipText("Data da Orientação");
	lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblNewLabel_2.setBounds(10, 101, 78, 51);
	Orientador.add(lblNewLabel_2);
	
	textAgendaData = new JTextField();
	textAgendaData.setFont(new Font("Tahoma", Font.PLAIN, 14));
	textAgendaData.setBounds(84, 108, 100, 30);
	Orientador.add(textAgendaData);
	textAgendaData.setColumns(10);
	
	JLabel lblNewLabel_3 = new JLabel("Tema:");
	lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblNewLabel_3.setBounds(352, 51, 68, 20);
	Orientador.add(lblNewLabel_3);
	
	JLabel lblNewLabel_4 = new JLabel("Orientador:");
	lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblNewLabel_4.setBounds(318, 91, 88, 27);
	Orientador.add(lblNewLabel_4);
	
	JLabel lblNewLabel_5 = new JLabel("Integrantes :");
	lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblNewLabel_5.setBounds(310, 138, 88, 30);
	Orientador.add(lblNewLabel_5);
	
	JLabel lblNewLabel_6 = new JLabel("Orientação:");
	lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblNewLabel_6.setBounds(10, 163, 78, 30);
	Orientador.add(lblNewLabel_6);
	
	JTextArea textAgendaTema = new JTextArea();
	textAgendaTema.setFont(new Font("Monospaced", Font.PLAIN, 15));
	textAgendaTema.setBounds(401, 51, 168, 30);
	Orientador.add(textAgendaTema);
	
	JTextArea txtabAgendaOrientador = new JTextArea();
	txtabAgendaOrientador.setFont(new Font("Monospaced", Font.PLAIN, 15));
	txtabAgendaOrientador.setBounds(401, 94, 168, 24);
	Orientador.add(txtabAgendaOrientador);
	
	JScrollPane scrollPane_3 = new JScrollPane();
	scrollPane_3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	scrollPane_3.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	scrollPane_3.setBounds(401, 129, 168, 88);
	Orientador.add(scrollPane_3);
	
	JTextArea txtabAgendaIntregrantes = new JTextArea();
	scrollPane_3.setViewportView(txtabAgendaIntregrantes);
	txtabAgendaIntregrantes.setFont(new Font("Monospaced", Font.PLAIN, 15));
	
	JButton btnAgendaCadastrar = new JButton("Salvar");
	btnAgendaCadastrar.setToolTipText("Salvar Orientação");
	btnAgendaCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
	btnAgendaCadastrar.setBounds(480, 357, 89, 23);
	Orientador.add(btnAgendaCadastrar);
	
	JButton btnAgendaBuscar = new JButton("Buscar");
	btnAgendaBuscar.setToolTipText("Buscar Grupo");
	btnAgendaBuscar.setFont(new Font("Tahoma", Font.PLAIN, 14));
	btnAgendaBuscar.setBounds(84, 359, 89, 23);
	Orientador.add(btnAgendaBuscar);
	
	JScrollPane scrollPane_1 = new JScrollPane();
	scrollPane_1.setBounds(84, 170, 147, 47);
	Orientador.add(scrollPane_1);
	
	textAgendaOrientação = new JTextField();
	scrollPane_1.setViewportView(textAgendaOrientação);
	textAgendaOrientação.setColumns(10);
	
	JButton btnAgendaLimpar = new JButton("Limpar Tela");
	btnAgendaLimpar.setFont(new Font("Tahoma", Font.PLAIN, 14));
	btnAgendaLimpar.setBounds(272, 355, 110, 25);
	Orientador.add(btnAgendaLimpar);
	
	JButton btnAgendaLista = new JButton("Lista Orientação");
	btnAgendaLista.setBounds(241, 194, 122, 23);
	Orientador.add(btnAgendaLista);
	
	
	
	ProfessorController pc = new ProfessorController(texProfessornome, textProfessorarea, texProfessorMatricula, taProfessorlista);
	GrupoController gc= new GrupoController(tfcodigo, tfgrupomatricula,tfpGrupoprofnome,tfgrupoaareprof,txGrupotema, tfGrupora1, texGruponome1, tfGrupotablista);
	Alunocontroller alc = new Alunocontroller(tfAlunora, tfAlunonome, taAlunolista);
	
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(12, 247, 562, 84);
	Orientador.add(scrollPane);
	
	JTextArea txtabBuscarOrientação = new JTextArea();
	scrollPane.setViewportView(txtabBuscarOrientação);
	txtabBuscarOrientação.setToolTipText("");
	
	Agendacontroller ac = new Agendacontroller(texAgendaCodGrupo, textAgendaData, textAgendaOrientação, textAgendaTema, txtabAgendaOrientador, txtabAgendaIntregrantes,txtabBuscarOrientação);
	
	btnAlunocadastrar.addActionListener(alc);
	btnAlunobuscar.addActionListener(alc);
	
	btnBuscarGrupo.addActionListener(gc);
	btngrupobuscarprof.addActionListener(gc);
	btnGrupoBuscarAluno.addActionListener(gc);
	btnSalvarGrupo.addActionListener(gc);
	btnGrupoLimpar.addActionListener(gc);
	btnProfessorcadastro.addActionListener(pc);
	btnProfessorBuscar.addActionListener(pc);
	
	
	
	btnAgendaLimpar.addActionListener(ac);
	
	
	btnAgendaBuscar.addActionListener(ac);
	btnAgendaCadastrar.addActionListener(ac);
	
	}
}
