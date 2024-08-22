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
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;

public class ExcluirCategoria extends JFrame {
	
	

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

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
	public ExcluirCategoria() {
		setType(Type.UTILITY);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 427, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(146, 187, 219));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Selecione a Categoria que deseja excluir");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(65, 51, 387, 14);
		contentPane.add(lblNewLabel);
		
		JComboBox txtcategoria = new JComboBox();
		txtcategoria.setBounds(138, 102, 130, 22);
		contentPane.add(txtcategoria);
	
		try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projeto2", "root", "alunolab");

            // Consulta SQL
            String query = "SELECT * FROM cat";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            // Preenchendo a ComboBox com os resultados da consulta
            while (resultSet.next()) {
                String item = resultSet.getString("categoria");
                txtcategoria.addItem(item);
            }

            connection.close(); // Fechando a conexão
        } catch (SQLException e) {
            e.printStackTrace();
        }

		
		
		JButton btnNewButton = new JButton("Excluir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try {
					
					//INVOCAR O CONECTOR DO BANCO DE DADOS:
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					// REALIZAR A CONEXÃO COM BANCO DE DADOS:
					
					Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/projeto2", "root", "alunolab");
					
					//PEGAR VALORES DAS CAIXAS DE TEXTOS:
					String categoria = txtcategoria.getSelectedItem().toString();
					
					
					
					//INSERIR DADOS ATRAVÉS DE LINGUAGEM SQL:
					
					String excluir = "DELETE FROM cat WHERE categoria = ?";
					
					//PREPARANDO PARA ENVIAR:
					
					PreparedStatement statement = conexao.prepareStatement(excluir);
					
					statement.setString(1, categoria);
					
					
					int resultado = statement.executeUpdate();
					
					//TRATANDO CONDIÇÃO PARA SABER A A LINHA DO CADASTRO SERÁ PREENCHIDA:
					
					if (resultado > 0) {
						
						JOptionPane.showMessageDialog(null, "Categoria Excluida Com Sucesso!");
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


