package Telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;

public class AlterarProdutos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtcodigo;
	private JTextField txtnome;
	private JTextField txtdescricao;
	private JTextField txtquantidade;
	private JTextField txtfornecedor;
	private JTextField txtvalidade;
	private JTextField txtbarras;
	private JTextField txtcategoria;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlterarProdutos frame = new AlterarProdutos();
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
	public AlterarProdutos() {
		setTitle("Alterar Produtos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 654, 401);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(146, 187, 219));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Código");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(120, 40, 73, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setForeground(Color.WHITE);
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNome.setBackground(Color.WHITE);
		lblNome.setBounds(10, 106, 73, 14);
		contentPane.add(lblNome);
		
		JLabel lblDescrio = new JLabel("Descrição");
		lblDescrio.setForeground(Color.WHITE);
		lblDescrio.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDescrio.setBackground(Color.WHITE);
		lblDescrio.setBounds(10, 140, 73, 14);
		contentPane.add(lblDescrio);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setForeground(Color.WHITE);
		lblQuantidade.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblQuantidade.setBackground(Color.WHITE);
		lblQuantidade.setBounds(10, 174, 73, 14);
		contentPane.add(lblQuantidade);
		
		JLabel lblFornecedor = new JLabel("Fornecedor");
		lblFornecedor.setForeground(Color.WHITE);
		lblFornecedor.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFornecedor.setBackground(Color.WHITE);
		lblFornecedor.setBounds(10, 210, 73, 14);
		contentPane.add(lblFornecedor);
		
		JLabel lblValidade = new JLabel("Validade");
		lblValidade.setForeground(Color.WHITE);
		lblValidade.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblValidade.setBackground(Color.WHITE);
		lblValidade.setBounds(318, 106, 73, 14);
		contentPane.add(lblValidade);
		
		JLabel lblCdigoDeBarras = new JLabel("Código de Barras");
		lblCdigoDeBarras.setForeground(Color.WHITE);
		lblCdigoDeBarras.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCdigoDeBarras.setBackground(Color.WHITE);
		lblCdigoDeBarras.setBounds(318, 140, 111, 14);
		contentPane.add(lblCdigoDeBarras);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setForeground(Color.WHITE);
		lblCategoria.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCategoria.setBackground(Color.WHITE);
		lblCategoria.setBounds(318, 174, 73, 14);
		contentPane.add(lblCategoria);
		
		txtcodigo = new JTextField();
		txtcodigo.setBounds(192, 38, 164, 20);
		contentPane.add(txtcodigo);
		txtcodigo.setColumns(10);
		
		txtnome = new JTextField();
		txtnome.setColumns(10);
		txtnome.setBounds(93, 104, 164, 20);
		contentPane.add(txtnome);
		
		txtdescricao = new JTextField();
		txtdescricao.setColumns(10);
		txtdescricao.setBounds(93, 138, 164, 20);
		contentPane.add(txtdescricao);
		
		txtquantidade = new JTextField();
		txtquantidade.setColumns(10);
		txtquantidade.setBounds(93, 169, 164, 20);
		contentPane.add(txtquantidade);
		
		txtfornecedor = new JTextField();
		txtfornecedor.setColumns(10);
		txtfornecedor.setBounds(93, 208, 164, 20);
		contentPane.add(txtfornecedor);
		
		txtvalidade = new JTextField();
		txtvalidade.setColumns(10);
		txtvalidade.setBounds(439, 104, 164, 20);
		contentPane.add(txtvalidade);
		
		txtbarras = new JTextField();
		txtbarras.setColumns(10);
		txtbarras.setBounds(439, 138, 164, 20);
		contentPane.add(txtbarras);
		
		JButton btnNewButton = new JButton("Buscar Produto");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					
					//INVOCAR O CONECTOR DO BANCO DE DADOS:
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					// REALIZAR A CONEXÃO COM BANCO DE DADOS:
					
					Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/projeto2", "root", "alunolab");
					
					String consulta = txtcodigo.getText();
					
		            // Executar a consulta
		           PreparedStatement pesquisa = conexao.prepareStatement("SELECT * FROM produtos where codigo = ?");
		           
		           pesquisa.setString(1, consulta);
		            
		        	ResultSet resultado = pesquisa.executeQuery();


		            // Processar os resultados
		            while (resultado.next()) {
		            	
		                // captura
		                
		                String nome = resultado.getString("nome");
		                String descricao = resultado.getString("descricao");
		                String fornecedor = resultado.getString("fornecedor");
		                String validade = resultado.getString("validade");
		                String quanti = resultado.getString("quantidade");
		                String barras = resultado.getString("codbarras");
		                String categoria = resultado.getString("categorias");
		               
		               
		               
		                txtnome.setText(nome);
		                txtdescricao.setText(descricao);
		                txtfornecedor.setText(fornecedor);
		                txtvalidade.setText(validade);
		               
		                txtquantidade.setText(quanti);
		                txtbarras.setText(barras);
		                txtcategoria.setText(categoria);
		                
		            }
					
					//TRATANDO CONEXÃO COM BANCO DE DADOS SIM OU NÃO:
					
					} catch (Exception erro) {
						erro.printStackTrace();
						JOptionPane.showMessageDialog(null, "ERRO DE CONEXÃO COM BANCO DE DADOS");
					}
				}
	       }
		);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(365, 40, 139, 18);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Menu abrir = new Menu();
				
				
				abrir.setVisible(true);
				abrir.setLocationRelativeTo(null);
				setVisible(false);
				
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(10, 11, 89, 23);
		contentPane.add(btnNewButton_1);
		
		txtcategoria = new JTextField();
		txtcategoria.setColumns(10);
		txtcategoria.setBounds(439, 172, 164, 20);
		contentPane.add(txtcategoria);
		
		JButton btnNewButton_2 = new JButton("Alterar Dados");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					
					//INVOCAR O CONECTOR DO BANCO DE DADOS:
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					// REALIZAR A CONEXÃO COM BANCO DE DADOS:
					
					Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/projeto2", "root", "alunolab");
					
					//PEGAR VALORES DAS CAIXAS DE TEXTOS:
					String codigo = txtcodigo.getText();
					String nome = txtnome.getText();	
					String descricao = txtdescricao.getText();
					String quantidade = txtquantidade.getText();
					String fornecedor = txtfornecedor.getText();
					String validade = txtvalidade.getText();		
					String codbarras = txtbarras.getText();
					String categoria = txtcategoria.getText();	
					
					int quanti = Integer.parseInt(quantidade);
					
					
					//INSERIR DADOS ATRAVÉS DE LINGUAGEM SQL:
					
					String atualizar = "UPDATE produtos SET nome = ?, descricao = ?, quantidade = ?, fornecedor = ?, validade = ?, codbarras = ?, categorias = ? WHERE codigo = ?";
					
					//PREPARANDO PARA ENVIAR:
					
					PreparedStatement statement = conexao.prepareStatement(atualizar);
					
				
					statement.setString(1, nome);
					statement.setString(2, descricao);
					statement.setInt(3, quanti);
					statement.setString(4, fornecedor);
					statement.setString(5, validade);
					statement.setString(6, codbarras);
					statement.setString(7, categoria);
					statement.setString(8, codigo);
					
					
					
					
					int resultado = statement.executeUpdate();
					
					//TRATANDO CONDIÇÃO PARA SABER A A LINHA DO CADASTRO SERÁ PREENCHIDA:
					
					if (resultado > 0) {
						
						JOptionPane.showMessageDialog(null, "DADOS ATUALIZADOS COM SUCESSO!");
					}else{
							JOptionPane.showMessageDialog(null, "ERRO DE CADASTRO, CONFIRA OS DADOS E TENTE NOVAMENTE!");
						}
					
					//TRATANDO CONEXÃO COM BANCO DE DADOS SIM OU NÃO:22
					
					} catch (Exception erro) {
						erro.printStackTrace();
						JOptionPane.showMessageDialog(null, "ERRO DE CONEXÃO COM BANCO DE DADOS");
					}
				
				txtnome.setText("");
                txtdescricao.setText("");
                txtfornecedor.setText("");
                txtvalidade.setText("");
               
                txtquantidade.setText("");
                txtbarras.setText("");
                txtcategoria.setText("");
				
				
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.setBounds(478, 292, 125, 41);
		contentPane.add(btnNewButton_2);
	}
}
