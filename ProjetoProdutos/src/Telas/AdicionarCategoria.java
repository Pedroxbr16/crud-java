package Telas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class AdicionarCategoria extends JFrame {
	


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtadicionar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdicionarCategoria frame = new AdicionarCategoria();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdicionarCategoria() {
		setType(Type.UTILITY);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(146, 187, 219));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtadicionar = new JTextField();
		txtadicionar.setBounds(118, 104, 170, 20);
		contentPane.add(txtadicionar);
		txtadicionar.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Digite o nome da Categoria que deseja adicionar");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(22, 55, 387, 14);
		contentPane.add(lblNewLabel);
		
	
		
		
		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try {
					
					//INVOCAR O CONECTOR DO BANCO DE DADOS:
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					// REALIZAR A CONEXÃO COM BANCO DE DADOS:
					
					Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/projeto2", "root", "alunolab");
					
					//PEGAR VALORES DAS CAIXAS DE TEXTOS:
					String adicionar = txtadicionar.getText();
					
					
					
					//INSERIR DADOS ATRAVÉS DE LINGUAGEM SQL:
					
					String inserir = "INSERT INTO cat (categoria) VALUES (?)";
					
					//PREPARANDO PARA ENVIAR:
					
					PreparedStatement statement = conexao.prepareStatement(inserir);
					
					statement.setString(1, adicionar);
					
					
					int resultado = statement.executeUpdate();
					
					//TRATANDO CONDIÇÃO PARA SABER A A LINHA DO CADASTRO SERÁ PREENCHIDA:
					
					if (resultado > 0) {
						
						JOptionPane.showMessageDialog(null, "Categoria Cadastrada Com Sucesso!");
					}else{
							JOptionPane.showMessageDialog(null, "ERRO DE CADASTRO, CONFIRA OS DADOS E TENTE NOVAMENTE!");
						}
					
					//TRATANDO CONEXÃO COM BANCO DE DADOS SIM OU NÃO:22
					
					} catch (Exception erro) {
						erro.printStackTrace();
						JOptionPane.showMessageDialog(null, "ERRO DE CONEXÃO COM BANCO DE DADOS");
					}
				
			
	}
			});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(138, 172, 130, 31);
		contentPane.add(btnNewButton);
	

	}
}


