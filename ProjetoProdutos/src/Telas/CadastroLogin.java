package Telas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Window.Type;
import java.awt.Font;

public class CadastroLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtcpf;
	private JTextField txtnome;
	private JTextField txtemail;
	private JTextField txtsenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroLogin frame = new CadastroLogin();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CadastroLogin() {
		setTitle("Cadastro de Usuário");
		setType(Type.UTILITY);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 512, 345);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(146, 187, 219));
		contentPane.setForeground(new Color(0, 0, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cpf");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(280, 80, 46, 14);
		contentPane.add(lblNewLabel);
		
		txtcpf = new JTextField();
		txtcpf.setBounds(336, 77, 118, 20);
		contentPane.add(txtcpf);
		txtcpf.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNome.setForeground(new Color(255, 255, 255));
		lblNome.setBounds(53, 120, 46, 14);
		contentPane.add(lblNome);
		
		txtnome = new JTextField();
		txtnome.setBounds(106, 117, 148, 20);
		txtnome.setColumns(10);
		contentPane.add(txtnome);
		
		JLabel lblNewLabel_1_1 = new JLabel("Email");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setBounds(53, 80, 46, 14);
		contentPane.add(lblNewLabel_1_1);
		
		txtemail = new JTextField();
		txtemail.setBounds(106, 77, 148, 20);
		txtemail.setColumns(10);
		contentPane.add(txtemail);
		
		JLabel lblNewLabel_2 = new JLabel("senha");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(280, 120, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		txtsenha = new JTextField();
		txtsenha.setBounds(336, 117, 125, 20);
		contentPane.add(txtsenha);
		txtsenha.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Cadastrar");
		btnNewButton_1.setBounds(184, 216, 103, 30);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			
				try {
					
					//INVOCAR O CONECTOR DO BANCO DE DADOS:
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					// REALIZAR A CONEXÃO COM BANCO DE DADOS:
					
					Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/projeto2", "root", "deadpool");
					
					//PEGAR VALORES DAS CAIXAS DE TEXTOS:
					String cpf = txtcpf.getText();
					String nome = txtnome.getText();					
					String email = txtemail.getText();					
					String senha = txtsenha.getText();			
				
					
					
					
					
					//INSERIR DADOS ATRAVÉS DE LINGUAGEM SQL:
					
					String inserir = "INSERT INTO usuario (cpf, nome, email, senha) VALUES (?, ?, ?, ?)";
					
					//PREPARANDO PARA ENVIAR:
					
					PreparedStatement statement = conexao.prepareStatement(inserir);
					
					statement.setString(1, cpf);
					statement.setString(2, nome);
					statement.setString(3, email);
					statement.setString(4, senha);
				
					int resultado = statement.executeUpdate();
					
					//TRATANDO CONDIÇÃO PARA SABER A A LINHA DO CADASTRO SERÁ PREENCHIDA:
					
					if (resultado > 0) {
						
						JOptionPane.showMessageDialog(null, "Usuário Cadastrado Com Sucesso!");
					}else{
							JOptionPane.showMessageDialog(null, "ERRO DE CADASTRO, CONFIRA OS DADOS E TENTE NOVAMENTE!");
						}
					
					//TRATANDO CONEXÃO COM BANCO DE DADOS SIM OU NÃO:22
					
					} catch (Exception erro) {
						erro.printStackTrace();
						JOptionPane.showMessageDialog(null, "ERRO DE CONEXÃO COM BANCO DE DADOS");
					}
			
			
				txtnome.setText("");
				txtcpf.setText("");
				txtsenha.setText("");
				txtemail.setText("");
			
			
			}
		});
		contentPane.add(btnNewButton_1);
	}
}
