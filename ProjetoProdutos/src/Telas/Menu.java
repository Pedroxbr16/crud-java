package Telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setResizable(false);
		setTitle("Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,708, 359);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(146, 187, 219));
		contentPane.setForeground(new Color(146, 187, 219));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 717, 22);
		contentPane.add(menuBar);
		
		JButton btnNewButton = new JButton("Cadastro de Produtos");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CadastroProdutos abrir = new CadastroProdutos();
				
				abrir.setVisible(true);
				abrir.setLocationRelativeTo(null);
				setVisible(false);
				
				
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		menuBar.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Listagem de Produtos");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Listagem abrir = new Listagem();
				
				abrir.setVisible(true);
				abrir.setLocationRelativeTo(null);
				
				
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		menuBar.add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("Excluir Produtos");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			    ExcluirProdutos abrir = new ExcluirProdutos();
				
				abrir.setVisible(true);
				abrir.setLocationRelativeTo(null);
				setVisible(false);

				
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		menuBar.add(btnNewButton_3);
		
		JButton btnNewButton_3_1 = new JButton("Alterar Produtos");
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AlterarProdutos abrir = new AlterarProdutos();
				
				abrir.setVisible(true);
				abrir.setLocationRelativeTo(null);
				setVisible(false);
				
				
				
			}
		});
		btnNewButton_3_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		menuBar.add(btnNewButton_3_1);
		
		JButton btnNewButton_2 = new JButton("Deslogar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Login abrir = new Login();
				
				abrir.setVisible(true);
				abrir.setLocationRelativeTo(null);
				setVisible(false);
				
				JOptionPane.showMessageDialog(null, "Sessão Encerrada");
				
				
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_2.setBounds(10, 282, 112, 27);
		contentPane.add(btnNewButton_2);
		
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar_1.setBounds(0, 0, 682, 22);
		contentPane.add(menuBar_1);
		
		JButton btnCategorias = new JButton("Categorias");
		btnCategorias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SeleçãoCategorias abrir = new SeleçãoCategorias();
				
				abrir.setVisible(true);
				abrir.setLocationRelativeTo(null);
			
				
				
				
			}
		});
		btnCategorias.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCategorias.setBounds(0, 24, 193, 20);
		contentPane.add(btnCategorias);
	}

	

	
}
