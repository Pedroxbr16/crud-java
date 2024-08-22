package Telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Window.Type;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Selecao extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Selecao frame = new Selecao();
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
	public Selecao() {
		setResizable(false);
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 397, 234);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(146, 187, 219));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox txtcategoria = new JComboBox();
		txtcategoria.setBounds(108, 95, 127, 22);
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
		
		
		
		JLabel lblNewLabel = new JLabel("Selecione a Categoria do Produto");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(67, 49, 218, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Selecionar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			
				

				
				
				
				
				
				
				
				
				
				
				
				
				
				
			}

			private void elseif(boolean b) {
				// TODO Auto-generated method stub
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(120, 151, 104, 23);
		contentPane.add(btnNewButton);
	}
}
