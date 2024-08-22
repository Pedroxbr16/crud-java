package Telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtemail;
	private JPasswordField txtsenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setResizable(false);
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 691, 295);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(146, 187, 219));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtemail = new JTextField();
		txtemail.setBounds(436, 53, 198, 20);
		contentPane.add(txtemail);
		txtemail.setColumns(10);
		
		txtsenha = new JPasswordField();
		txtsenha.setBounds(436, 89, 198, 20);
		txtsenha.setColumns(10);
		contentPane.add(txtsenha);
		
		JLabel lblNewLabel = new JLabel("Email :");
		lblNewLabel.setBounds(361, 55, 49, 14);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblNewLabel);
		
		JLabel lblSenha = new JLabel("Senha :");
		lblSenha.setBounds(361, 91, 60, 14);
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblSenha);
		
		JButton btnNewButton = new JButton("Logar");
		btnNewButton.setBounds(481, 120, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			
					try {
					
					//INVOCAR O CONECTOR DO BANCO DE DADOS:
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					// REALIZAR A CONEXÃO COM BANCO DE DADOS:
					
					Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/projeto2", "root", "alunolab");
					
					String consulta = txtemail.getText();
					
		            // Executar a consulta
		           PreparedStatement pesquisa = conexao.prepareStatement("SELECT * FROM usuario where email = ?");
		           
		           pesquisa.setString(1, consulta);
		            
		        	ResultSet resultado = pesquisa.executeQuery();
		        	
		        	String email = "";
		        	String senha = "";
		       
		        	
		        	


		            // Processar os resultados
		            while (resultado.next()) {//INICIO DO ENQUANTO
		            	
		                // Supondo que você tenha uma coluna chamada "nome" na tabela
		            	email = resultado.getString("email");
		                senha = resultado.getString("senha");
		             
		                
		                if(txtemail.getText().equals(email) && txtsenha.getText().equals(senha) ) {
		                	
		                	JOptionPane.showMessageDialog(null, "Seja Bem Vindo(a) ao Sistema!");
		                	
		                	Menu pedidos = new Menu();
		                	
		                	pedidos.setVisible(true);
			                pedidos.setLocationRelativeTo(null);
			                setVisible(false);
			                
		                	
		            	
			                
		            		}//FIMSE
		            
		             
			                	
			                else {
		            			
			            		JOptionPane.showMessageDialog(null, "A Senha esta Incorreta!!!");	
		            			
		            			
			                }
		                
		                
		                
		                
		            }//FIM DO ENQUANTO
		            
		            
					}
					
					//TRATANDO CONEXÃO COM BANCO DE DADOS SIM OU NÃO:
					
					 catch (Exception erro) {
						erro.printStackTrace();
						JOptionPane.showMessageDialog(null, "ERRO DE CONEXÃO COM BANCO DE DADOS");
					}
			
			
				
				
			}

				
				
				
				
			
			
			
			}
			
			
			
		);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(btnNewButton);
		
		JLabel lblSemCadastro = new JLabel("Sem Cadastro?");
		lblSemCadastro.setBounds(361, 165, 109, 14);
		lblSemCadastro.setForeground(Color.WHITE);
		lblSemCadastro.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblSemCadastro);
		
		JButton btnCadastreSe = new JButton("Cadastre - se");
		btnCadastreSe.setBounds(495, 161, 139, 23);
		btnCadastreSe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CadastroLogin abrir = new CadastroLogin();
				
				abrir.setVisible(true);
				abrir.setLocationRelativeTo(null);
				
				
				
				
			}
		});
		btnCadastreSe.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(btnCadastreSe);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(53, 0, 298, 235);
		lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/img/17004 (1).png")));
		contentPane.add(lblNewLabel_1);
	}
}
