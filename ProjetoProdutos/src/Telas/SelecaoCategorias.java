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
import java.awt.event.ActionEvent;

public class SelecaoCategorias extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelecaoCategorias frame = new SelecaoCategorias();
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
	public SelecaoCategorias() {
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
		txtcategoria.setModel(new DefaultComboBoxModel(new String[] {"", "Adicionar", "Excluir", "Alterar"}));
		txtcategoria.setBounds(108, 95, 127, 22);
		contentPane.add(txtcategoria);
		
		JLabel lblNewLabel = new JLabel("Selecione a Ação Desejada");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(93, 48, 218, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Selecionar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String escolha = txtcategoria.getSelectedItem().toString();
				
				
				if(escolha.equals("Adicionar")  ) {
                	
                	
                	
					AdicionarCategoria pedidos = new AdicionarCategoria();
                	
                	pedidos.setVisible(true);
	                pedidos.setLocationRelativeTo(null);
	                setVisible(false);
	                
                	
            	
	                
            		}//FIMSE
					
				else if(escolha.equals("Excluir")){
					
					ExcluirCategoria abrir = new ExcluirCategoria();
					
					abrir.setVisible(true);
					abrir.setLocationRelativeTo(null);
					setVisible(false);

				
			
				
				
				
				
			}

		
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(120, 151, 104, 23);
		contentPane.add(btnNewButton);
	}
}
