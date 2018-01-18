import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class CadastroAluno extends JFrame {
	
	private JLabel codigo, nome, email, cidade, bairro, curso, knew, foto;
	private JTextField campoCodigo, campoNome, campoEmail, campoBairro;
	private JRadioButton yes, no;
	private ButtonGroup grupo;
	private JComboBox listaDasCidades, listaDosCursos;
	private JButton botaoConcluir, botaoConsulta, botaoLimpar; 
	
	
	public CadastroAluno() {
		iniciarComponentes();
		definirEventos();
	}		
	
	public void iniciarComponentes() {
		setTitle("Cadastro de Aluno");
		setBounds(100, 100, 450, 350);
		
		this.getContentPane().setLayout(null);
		
		JLabel information = new JLabel ("Insira suas informações abaixo para se inscrever!");
		information.setBounds(50, 20, 350, 20);
		
		codigo = new JLabel("Código");
		codigo.setBounds(10, 50, 100, 20);
				
		nome = new JLabel("Nome");
		nome.setBounds(10, 80, 100, 20);
		
		email = new JLabel("Email");
		email.setBounds(10, 110, 100, 20);
		
		cidade = new JLabel("Cidade");
		cidade.setBounds(10, 140, 100, 20);
		
		bairro = new JLabel("Bairro");
		bairro.setBounds(10, 170, 100, 20);
		
		curso = new JLabel("Curso");
		curso.setBounds(10, 200, 100, 20);		
		
		knew = new JLabel("Tem conhecimento em lógica?");
		knew.setBounds(10, 230, 220, 20);
		
		foto = new JLabel("Foto");
		foto.setBounds(350, 220, 80, 20);
		
		campoCodigo = new JTextField();
		campoCodigo.setBounds(100, 50, 70, 20);
		
		campoNome = new JTextField();
		campoNome.setBounds(100, 80, 170, 20);
		
		campoEmail = new JTextField();
		campoEmail.setBounds(100, 110, 170, 20);
		
		/*ArrayList <String> listaCidade = new ArrayList<>();
		listaCidade.add("Fortaleza");
		listaCidade.add("Aquiraz");
		listaCidade.add("Maracanaú");
		listaCidade.add("Caucaia");
		listaCidade.add("Maranguape");
		listaCidade.add("Eusébio");
		Collections.sort(listaCidade);
		@SuppressWarnings("unchecked")
		listaDasCidades = new JComboBox(new Vector<String>(listaCidade));
		listaDasCidades.setBounds(100, 140, 120, 20);
		listaDasCidades.setSelectedItem(null);*/
		
		String [] listaCidade = {"Aquiraz", "Caucaia", "Eusébio", "Fortaleza", "Maracanaú", "Maranguape"};
		listaDasCidades = new JComboBox(listaCidade);
		listaDasCidades.setBounds(100, 140, 120, 20);
		listaDasCidades.setSelectedItem(null);
		
		campoBairro = new JTextField();
		campoBairro.setBounds(100, 170, 170, 20);
		
		String [] listaCursos = {"C#", "Java", "PHP", "Python", "Ruby"};
		listaDosCursos = new JComboBox(listaCursos);
		//listaDosCursos.setSelectedIndex(1);
		listaDosCursos.setSelectedItem(null);
		listaDosCursos.setBounds(100, 200, 80, 20);	
		
		yes = new JRadioButton("Sim");
		yes.setBounds(60, 250, 70, 20);
		no = new JRadioButton("Não");
		no.setBounds(150, 250, 70, 20);
		
		grupo = new ButtonGroup();
		grupo.add(yes);
		grupo.add(no);					
			
		
		/*JFileChooser photo = new JFileChooser();
		int resultado = photo.showDialog(this, "Selecionar Imagem");
		if(resultado == JFileChooser.APPROVE_OPTION) {
			ImageIcon imagePhoto = new ImageIcon(photo.getSelectedFile().getAbsolutePath());
			JPanel painelFoto = new JPanel();
			painelFoto.setBounds(300, 70, 120, 145);
			this.getContentPane().add(painelFoto);
		}*/		
		
		JPanel painelFoto = new JPanel();
		painelFoto.setBounds(300, 70, 120, 145);
		this.getContentPane().add(painelFoto);
		painelFoto.setBackground(Color.DARK_GRAY);		
		
		botaoConcluir = new JButton("Concluir");
		botaoConcluir.setBounds(50, 280, 100, 20);
		
		botaoConsulta = new JButton("Consulta");
		botaoConsulta.setBounds(170, 280, 100, 20);
		
		botaoLimpar = new JButton("Limpar");
		botaoLimpar.setBounds(290, 280, 100, 20);
		
		JMenuItem itemMenuArquivo = new JMenuItem("Sair");
		JMenu menuArquivo = new JMenu("Arquivo");
		menuArquivo.add(itemMenuArquivo);
		
		JMenuItem itemMenuEditar = new JMenuItem("Limpar");
		JMenu menuEditar = new JMenu("Editar");
		menuEditar.add(itemMenuEditar);
		
		JMenu menuAjuda = new JMenu("Ajuda");
		
		JMenuBar menuBarra = new JMenuBar();
		
		menuBarra.add(menuArquivo);
		menuBarra.add(menuEditar);
		menuBarra.add(menuAjuda);
		
		this.getContentPane().add(information);
		this.getContentPane().add(codigo);
		this.getContentPane().add(nome);
		this.getContentPane().add(email);
		this.getContentPane().add(cidade);
		this.getContentPane().add(bairro);
		this.getContentPane().add(foto);
		this.getContentPane().add(curso);
		this.getContentPane().add(knew);
		
		this.getContentPane().add(campoCodigo);
		this.getContentPane().add(campoNome);
		this.getContentPane().add(campoEmail);
		this.getContentPane().add(campoBairro);
		this.getContentPane().add(listaDasCidades);
		this.getContentPane().add(listaDosCursos);
		this.getContentPane().add(yes);
		this.getContentPane().add(no);
		
		this.getContentPane().add(botaoConcluir);
		this.getContentPane().add(botaoConsulta);
		this.getContentPane().add(botaoLimpar);
		this.getContentPane().add(menuBarra);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		
	}	
	public void definirEventos(){
		// Evento do Botão Limpar.
				botaoLimpar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						// Limpa todos os Campos.
						campoCodigo.setText("");
						campoNome.setText("");
						campoEmail.setText("");
						listaDasCidades.setSelectedItem(null);
						campoBairro.setText("");
						listaDosCursos.setSelectedItem(null);
						grupo.clearSelection();
					}
		});
				botaoConcluir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						if (campoCodigo.getText().equals("")) {
							
							JOptionPane.showMessageDialog(null,
									"O Código não pode está vazio!");							
							campoCodigo.requestFocus();
		 
						} else if (campoNome.getText().equals("")) {							
							JOptionPane.showMessageDialog(null,
									"O Nome não pode está vazio!");							
							campoNome.requestFocus();
		 
						} else if (campoEmail.getText().equals("")) {							
							JOptionPane.showMessageDialog(null, "O email não pode está vazio!");
		 
							campoEmail.requestFocus();
		 
						} else {
						
							try {									 
								File arquivo = new File(campoCodigo.getText()
										+ ".txt");
								if(arquivo.exists()){
									JOptionPane.showMessageDialog(null, "Arquivo já exisente!",
											"Alerta", JOptionPane.ERROR_MESSAGE);
									campoCodigo.requestFocus();
								}else{
									PrintWriter out = new PrintWriter(campoCodigo.getText()
											+ ".txt");
									out.println(campoCodigo.getText());
									out.println(campoNome.getText());
									out.println(campoEmail.getText());
									out.println(listaDasCidades.getSelectedItem());
									out.println(campoBairro.getText());
									out.println(listaDosCursos.getSelectedItem());
									if(yes.isSelected()) {
										out.println(yes.getText());
									}if(no.isSelected()) {
									out.println(no.getText());
									}								
									
									out.close();		 
									
									JOptionPane.showMessageDialog(null,
											"Arquivo Gravado com Sucesso!");
									
									campoCodigo.setText("");
									campoNome.setText("");
									campoEmail.setText("");
									listaDasCidades.setSelectedItem(null);
									campoBairro.setText("");
									listaDosCursos.setSelectedItem(null);
									grupo.clearSelection();
								}
			 
								} catch (IOException Erro) {
									JOptionPane.showMessageDialog(null,
											"Erro ao Gravar no Arquivo" + Erro);
								}									
						}
					}
				});
				botaoConsulta.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						try {
							
							String arquivo = JOptionPane.showInputDialog(null,
									"Infome o Código a abrir:");
		 
							BufferedReader br = new BufferedReader(new FileReader(
									arquivo + ".txt"));		 
							
							campoCodigo.setText(br.readLine());
							campoNome.setText(br.readLine());
							campoEmail.setText(br.readLine());
							listaDasCidades.setSelectedItem(br.readLine());
							campoBairro.setText(br.readLine());
							listaDosCursos.setSelectedItem(br.readLine());
							String texto = br.readLine(); 							
							if(texto.equals(yes.getText())){
								yes.setSelected(true);
							}else if(texto.equals(no.getText())) {
								no.setSelected(true);
							}
		 
						} catch (IOException Erro) {
		 
						}
					}
				});
	}

	public static void main(String[] args) {
		CadastroAluno cadastro = new CadastroAluno();
		cadastro.setVisible(true);

	}

}