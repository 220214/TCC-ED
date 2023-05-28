package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Alunocontroller;
import controller.GrupoController;
import controller.ProfessorController;

import javax.swing.JLayeredPane;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

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
		
		JButton btnAlunoExcluir = new JButton("Excluir");
		btnAlunoExcluir.setForeground(new Color(255, 0, 0));
		btnAlunoExcluir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAlunoExcluir.setBounds(489, 357, 100, 23);
		TabAluno.add(btnAlunoExcluir);
		
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
		
		JButton btnProfessorExcluir = new JButton("Excluir");
		btnProfessorExcluir.setForeground(new Color(255, 0, 0));
		btnProfessorExcluir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnProfessorExcluir.setBounds(487, 357, 89, 23);
		TabProfessor.add(btnProfessorExcluir);
		
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
	
	Alunocontroller alc = new Alunocontroller(tfAlunora, tfAlunonome, taAlunolista);
	btnAlunocadastrar.addActionListener(alc);
	btnAlunobuscar.addActionListener(alc);	
	btnAlunoExcluir.addActionListener(alc);
	
	ProfessorController pc = new ProfessorController(texProfessornome, textProfessorarea, texProfessorMatricula, taProfessorlista);
	
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
	
	tfGrupotablista = new JTextArea();
	tfGrupotablista.setFont(new Font("Tahoma", Font.PLAIN, 14));
	tfGrupotablista.setBounds(10, 189, 578, 126);
	tabGrupo.add(tfGrupotablista);
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
	GrupoController gc= new GrupoController( tfcodigo, tfgrupomatricula,tfpGrupoprofnome,tfgrupoaareprof,txGrupotema, tfGrupora1, texGruponome1, tfGrupotablista);
	
	JButton btngrupobuscarprof = new JButton("Buscar/Professor");
	btngrupobuscarprof.setFont(new Font("Tahoma", Font.PLAIN, 14));
	btngrupobuscarprof.setBounds(244, 46, 136, 23);
	tabGrupo.add(btngrupobuscarprof);
	btnBuscarGrupo.addActionListener(gc);
	btngrupobuscarprof.addActionListener(gc);
	btnGrupoBuscarAluno.addActionListener(gc);
	btnSalvarGrupo.addActionListener(gc);

	btnProfessorcadastro.addActionListener(pc);
	btnProfessorBuscar.addActionListener(pc);
	btnProfessorExcluir.addActionListener(pc);
	

	
	}
}
