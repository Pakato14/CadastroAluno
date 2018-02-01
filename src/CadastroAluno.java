import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

import br.com.utd.conexao.ConnectionFactory;

public class CadastroAluno extends JFrame {
	
	private JLabel codigo, nome, email, cidade, bairro, curso, knew, foto;
	private JTextField campoCodigo, campoNome, campoEmail, campoBairro;
	private JRadioButton yes, no;
	private ButtonGroup grupo;
	private JComboBox listaDasCidades, listaDosCursos;
	private JButton botaoConcluir, botaoConsulta, botaoAlterar; 
	private JMenuItem itemMenuEditar, itemMenuEditar2;
	
	
	public CadastroAluno() {
		iniciarComponentes();
		definirEventos();
	}		
	
	public void iniciarComponentes() {
		setTitle("Cadastro de Aluno");
		setBounds(100, 100, 450, 370);
		setLocationRelativeTo(null);
		
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
		
		botaoAlterar = new JButton("Alterar");
		botaoAlterar.setBounds(290, 280, 100, 20);
		
		JMenuBar menuBarra = new JMenuBar();
		
		JMenu menuArquivo = new JMenu("Arquivo");
		JMenuItem itemMenuArquivo = new JMenuItem("Sair");		
		menuArquivo.add(itemMenuArquivo);
		
		JMenu menuEditar = new JMenu("Editar");
		itemMenuEditar = new JMenuItem("Limpar");		
		itemMenuEditar2 = new JMenuItem("Deletar");
		menuEditar.add(itemMenuEditar);
		menuEditar.add(itemMenuEditar2);
		
		JMenu menuAjuda = new JMenu("Ajuda");		
		
		menuBarra.add(menuArquivo);
		menuBarra.add(menuEditar);
		menuBarra.add(menuAjuda);
		
		setJMenuBar(menuBarra);
		
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
		this.getContentPane().add(botaoAlterar);
		//this.getContentPane().add(menuBarra);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		
	}	
	public String ultimoResg(String email) throws SQLException
	{ 
			
			Connection connection = new ConnectionFactory().getConnection();
			
			String sql = "SELECT * FROM `cadastroAluno` WHERE email =  '" + email + "'" ;
			
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			 
			while(rs.next()){
				return rs.getString("id");
				}
 			return rs.getString("id");
 		 
	}
	public void definirEventos(){
		//Tornando o campo código inativo
		campoCodigo.setEnabled(false);
		// Evento do Botão Limpar.
		itemMenuEditar.addActionListener(new ActionListener() {
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
						//conexão com o banco
						Connection connection = new ConnectionFactory().getConnection();
						
						if (campoNome.getText().equals("")) {							
							JOptionPane.showMessageDialog(null,
									"O Nome não pode está vazio!");							
							campoNome.requestFocus();
		 
						} else if (campoEmail.getText().equals("")) {							
							JOptionPane.showMessageDialog(null, "O email não pode está vazio!");
		 
							campoEmail.requestFocus();
		 
						} else if (listaDosCursos.getSelectedItem().equals("")) {
							
							JOptionPane.showMessageDialog(null, "Escolha o curso que deseja estudar!");
							 
							listaDosCursos.requestFocus();
						}else {
							String sql = "insert into cadastroAluno" +
						             "(nome,email,cidade,bairro,curso,knew)" +
						             " values (?,?,?,?,?,?)";						
							try {
								
								 // prepared statement para inserção
						         PreparedStatement stmt = connection.prepareStatement(sql);
						         
						         // seta os valores
						         stmt.setString(1,campoNome.getText());
						         stmt.setString(2,campoEmail.getText());
						         stmt.setString(3,(String) listaDasCidades.getSelectedItem());
						         stmt.setString(4,campoBairro.getText());
						         stmt.setString(5,(String) listaDosCursos.getSelectedItem());
						         if(yes.isSelected()) {
										stmt.setString(6, yes.getText());
									}if(no.isSelected()) {
										stmt.setString(6, no.getText());
									}
						         
						         // executa
						         stmt.execute();
						         stmt.close();
						         
						         String a = ultimoResg(campoEmail.getText());
						         
						         JOptionPane.showMessageDialog(null,
											"Arquivo Gravado com Sucesso!\nAluno(a) matriculado(a) com registro: "+a);
									
									campoCodigo.setText("");
									campoNome.setText("");
									campoEmail.setText("");
									listaDasCidades.setSelectedItem(null);
									campoBairro.setText("");
									listaDosCursos.setSelectedItem(null);
									grupo.clearSelection();				         
								
			 
								} catch (SQLException Erro) {
									JOptionPane.showMessageDialog(null,
											"Erro ao Gravar no Arquivo" + Erro);
								}									
						}
					}
				});
				botaoConsulta.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						//conexão com o banco
						Connection connection = new ConnectionFactory().getConnection();
						
						String id = JOptionPane.showInputDialog(null,
								"Infome o Código a abrir:");
						
						try {				 
							PreparedStatement stmt = connection.prepareStatement("select * from cadastroAluno where id = '"+id+"'");
					         ResultSet rs = stmt.executeQuery();
												
							 while (rs.next()) {
					             // criando o objeto Contato
					            int cod = rs.getInt("id");
					            campoCodigo.setText(String.valueOf(cod));
					            campoNome.setText(rs.getString("nome"));
					            campoEmail.setText(rs.getString("email"));
					            listaDasCidades.setSelectedItem(rs.getString("cidade"));
					            campoBairro.setText(rs.getString("bairro"));
					            listaDosCursos.setSelectedItem(rs.getString("curso"));
					            String texto = rs.getString("knew");
					            if(texto.equals(yes.getText())){
									yes.setSelected(true);
								}else if(texto.equals(no.getText())) {
									no.setSelected(true);
								}
					            					            
							 }
							 stmt.execute();
							 stmt.close();
							 rs.close();
							
		 
						} catch (SQLException Erro) {
		 
						}
					}
				});
				botaoAlterar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						//conexão com o banco
						Connection connection = new ConnectionFactory().getConnection();
						if (campoNome.getText().equals("")) {							
							JOptionPane.showMessageDialog(null,
									"O Nome não pode está vazio!");							
							campoNome.requestFocus();
		 
						} else if (campoEmail.getText().equals("")) {							
							JOptionPane.showMessageDialog(null, "O email não pode está vazio!");
		 
							campoEmail.requestFocus();
		 
						} else if (listaDosCursos.getSelectedItem().equals("")) {
							
							JOptionPane.showMessageDialog(null, "Escolha o curso que deseja estudar!");
							 
							listaDosCursos.requestFocus();
						}else {
						
						String sql = "update cadastroAluno set nome=?, email=?,"+
								"cidade=?, bairro=?, curso=?, knew=? where id=?";
						
						try {							 
							PreparedStatement stmt = connection.prepareStatement(sql);
							 stmt.setString(1,campoNome.getText());
					         stmt.setString(2,campoEmail.getText());
					         stmt.setString(3,(String) listaDasCidades.getSelectedItem());
					         stmt.setString(4,campoBairro.getText());
					         stmt.setString(5,(String) listaDosCursos.getSelectedItem());
					         if(yes.isSelected()) {
									stmt.setString(6, yes.getText());
								}if(no.isSelected()) {
									stmt.setString(6, no.getText());
								}
								stmt.setString(7,campoCodigo.getText());
					         
					         // executa
					         stmt.execute();
					         stmt.close();
					         
					         String a = ultimoResg(campoEmail.getText());
					         
					         JOptionPane.showMessageDialog(null,
										"Alteração realizada com Sucesso!\nAluno(a) está matriculado(a) com registro: "+a);
								
								campoCodigo.setText("");
								campoNome.setText("");
								campoEmail.setText("");
								listaDasCidades.setSelectedItem(null);
								campoBairro.setText("");
								listaDosCursos.setSelectedItem(null);
								grupo.clearSelection();				         
							
		 
							} catch (SQLException Erro) {
								JOptionPane.showMessageDialog(null,
										"Erro ao Alterar o registro" + Erro);
							}
						}
					}
					});
							
				itemMenuEditar2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						//conexão com o banco
						Connection connection = new ConnectionFactory().getConnection();
						
						String id = JOptionPane.showInputDialog(null,
								"Infome o Código a abrir:");
						try {
							PreparedStatement stmt = connection.prepareStatement("delete from cadastroAluno where id = '"+id+"'");
							campoCodigo.setText(String.valueOf(id));
							  // executa
					         stmt.execute();
					         stmt.close();
					         
					         JOptionPane.showMessageDialog(null,
										"Registro deletado com sucesso!!!");
						}catch (SQLException Erro) {
							JOptionPane.showMessageDialog(null,
									"Erro ao deletar o registro" + Erro);
						}
	}
				});
				
				}

	public static void main(String[] args) {
		CadastroAluno cadastro = new CadastroAluno();
		cadastro.setVisible(true);

	}

}