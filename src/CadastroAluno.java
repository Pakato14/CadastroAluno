import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CadastroAluno extends JFrame {
	
	public CadastroAluno() {
		setTitle("Cadastro de Aluno");
		setBounds(100, 100, 450, 300);
		
		this.getContentPane().setLayout(null);
		
		JLabel information = new JLabel ("Insira suas informações abaixo para se inscrever!");
		information.setBounds(10, 20, 350, 20);
				
		JLabel nome = new JLabel("Nome");
		nome.setBounds(10, 70, 100, 20);
		
		JLabel cidade = new JLabel("Cidade");
		cidade.setBounds(10, 110, 100, 20);
		
		JLabel bairro = new JLabel("Bairro");
		bairro.setBounds(10, 150, 100, 20);
		
		JLabel foto = new JLabel("Foto");
		foto.setBounds(350, 220, 80, 20);
		
		this.getContentPane().add(information);
		this.getContentPane().add(nome);
		this.getContentPane().add(cidade);
		this.getContentPane().add(bairro);
		this.getContentPane().add(foto);
		
		JTextField  campoNome = new JTextField();
		campoNome.setBounds(100, 70, 170, 20);
		
		JTextField  campoBairro = new JTextField();
		campoBairro.setBounds(100, 150, 170, 20);
		
		String [] listaCidade = {"Aquiraz", "Caucaia", "Eusébio", "fortaleza", "Maracanaú", "Maranguape"};
		JComboBox listaDasCidades = new JComboBox(listaCidade);
		listaDasCidades.setBounds(100, 110, 120, 20);
		
		JPanel painelFoto = new JPanel();
		painelFoto.setBackground(Color.DARK_GRAY);
		painelFoto.setBounds(300, 70, 120, 145);
		
		JButton botaoConcluir = new JButton("Concluir");
		botaoConcluir.setBounds(10, 215, 100, 20);
		
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
		
		this.getContentPane().add(campoNome);
		this.getContentPane().add(campoBairro);
		this.getContentPane().add(listaDasCidades);
		this.getContentPane().add(painelFoto);
		this.getContentPane().add(botaoConcluir);
		this.getContentPane().add(menuBarra);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		
	}

	public static void main(String[] args) {
		CadastroAluno cadastro = new CadastroAluno();
		cadastro.setVisible(true);

	}

}
