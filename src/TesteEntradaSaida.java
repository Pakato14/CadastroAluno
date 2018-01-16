import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
 
/**
 * @author Francisco de Assis de Souza Rodrigues. 10/02/2014
 *         www.clubedosgeeks.com.br
 * 
 *         Referência Bibliografica: Livro Java7 Ensino Didático (Sergio
 *         Furgeri).
 */
 
public class TesteEntradaSaida extends JFrame {
 
	private static final long serialVersionUID = 1L;
	private JLabel labelCodigo, labelNome, labelEmail;
	private JButton btnAbrir, btnGravar, btnLimpar;
	private JTextField tfCodigo, tfNome, tfEmail;
 
	public static void main(String args[]) {
		// Instâcia do Objeto da Class JFrame.
		JFrame frame = new TesteEntradaSaida();
 
		// Permite Feichar a JFrame.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
		// Define JFrame Visivel.
		frame.setVisible(true);
	}
 
	// Construtor da Class.
	public TesteEntradaSaida() {
		// Chamada dos Métodos.
		inicializarComponentes();
		definirEventos();
	}
 
	/**
	 * Método inicializarComponentes, contem todos os componetes da JFrame.
	 */
	public void inicializarComponentes() {
		// Define Título da JFrame.
		setTitle("Cadastro usando Arquivo de Texto");
 
		//
		setBounds(250, 50, 340, 160);
 
		//
		setBackground(new Color(150, 150, 150));
 
		// Instância dos objetos JLabel, JButton, JTextField.
		labelCodigo = new JLabel("Código");
		labelNome = new JLabel("Nome");
		labelEmail = new JLabel("Email");
 
		btnAbrir = new JButton("Abrir");
		btnGravar = new JButton("Gravar");
		btnLimpar = new JButton("Limpar");
 
		tfCodigo = new JTextField();
		tfEmail = new JTextField();
		tfNome = new JTextField();
 
		//
		setLayout(null);
 
		// Coordenadas das posições dos Componentes JLabel, JButton, JTextField.
		labelCodigo.setBounds(10, 15, 40, 20);
		labelNome.setBounds(10, 40, 45, 20);
		labelEmail.setBounds(10, 65, 45, 20);
 
		btnAbrir.setBounds(10, 100, 75, 20);
		btnGravar.setBounds(95, 100, 75, 20);
		btnLimpar.setBounds(180, 100, 75, 20);
 
		tfCodigo.setBounds(60, 15, 55, 20);
		tfNome.setBounds(60, 40, 255, 20);
		tfEmail.setBounds(60, 65, 255, 20);
 
		// Adiciona Componentes JLabel, JButton, JTextField, a JFrame.
		add(labelCodigo);
		add(labelNome);
		add(labelEmail);
 
		add(btnAbrir);
		add(btnGravar);
		add(btnLimpar);
 
		add(tfCodigo);
		add(tfEmail);
		add(tfNome);
	}
 
	/**
	 * Define Eventos que será executado por cada componete JButton.
	 */
	public void definirEventos() {
		// Evento do Botão Limpar.
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Limpa todos os Campos.
				tfCodigo.setText("");
				tfNome.setText("");
				tfEmail.setText("");
			}
		});
 
		// Evento do Botão Gravar.
		btnGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Condição, verifica se os campo estão vazios.
				if (tfCodigo.getText().equals("")) {
					// Exibe caixa de Dialogo.
					JOptionPane.showMessageDialog(null,
							"O Código não pode está vazio!");
 
					// Fornece o foco ao cursor da caixa de Texto
					// correspondente.
					tfCodigo.requestFocus();
 
				} else if (tfNome.getText().equals("")) {
					// Exibe caixa de Dialogo.
					JOptionPane.showMessageDialog(null,
							"O Nome não pode está vazio!");
 
					// Fornece o foco ao cursor da caixa de Texto
					// correspondente.
					tfNome.requestFocus();
 
				} else if (tfEmail.getText().equals("")) {
					// Exibe caixa de Dialogo.
					JOptionPane.showMessageDialog(null, "");
 
					// Fornece o foco ao cursor da caixa de Texto
					// correspondente.
					tfEmail.requestFocus();
 
				} else {
					// Tratamento de Erros.
					try {
						// Instância de um Objeto da Class Java(PrintWriter
						// "para Gravação do Arquivo").
						PrintWriter out = new PrintWriter(tfCodigo.getText()
								+ ".txt");// Define o extensão do arquivo que
											// deseja criar.
 
						// Captura o Texto dos JTextField.
						out.println(tfCodigo.getText());
						out.println(tfNome.getText());
						out.println(tfEmail.getText());
 
						// Fecha Conexão.
						out.close();
 
						// Exibe caixa de Dialogo.
						JOptionPane.showMessageDialog(null,
								"Arquivo Gravado com Sucesso!");
 
					} catch (IOException Erro) {
						JOptionPane.showMessageDialog(null,
								"Erro ao Gravar no Arquivo" + Erro);
					}
				}
			}
		});
 
		// Evento do Botão Abrir.
		btnAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Tratamento de Erros
				try {
					// Solicita ao usuário que informe qual o arquivo deseja
					// abrir.
					String arquivo = JOptionPane.showInputDialog(null,
							"Infome o Código a abrir:");
 
					// Instância de um Objeto da Class java(BufferedReader
					// "Para Leitura do Arquivo"), que Instância um Objeto da
					// Class java(FileReader) referenciando o arquivo a ser
					// aberto.
					BufferedReader br = new BufferedReader(new FileReader(
							arquivo + ".txt"));
 
					// Ler o conteúdo do arquivo e exibe nos JTextField.
					tfCodigo.setText(br.readLine());
					tfNome.setText(br.readLine());
					tfEmail.setText(br.readLine());
 
				} catch (IOException Erro) {
 
				}
			}
		});
 
	}
}