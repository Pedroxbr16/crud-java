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
import java.awt.event.ItemEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;

public class CadastroProdutos extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final String List = null;
	private JPanel contentPane;
	private JTextField txtcodigo;
	private JTextField txtnome;
	private JTextField txtdescricao;
	private JTextField txtquantidade;
	private JTextField txtfornecedor;
	private JTextField txtvalidade;
	private JTextField txtbarras;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroProdutos frame = new CadastroProdutos();
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
	public CadastroProdutos() {
		setResizable(false);
		setTitle("Cadastro de Produtos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 761, 401);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(146, 187, 219));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Código");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(36, 78, 73, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setForeground(Color.WHITE);
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNome.setBackground(Color.WHITE);
		lblNome.setBounds(36, 122, 73, 14);
		contentPane.add(lblNome);
		
		JLabel lblDescrio = new JLabel("Descrição");
		lblDescrio.setForeground(Color.WHITE);
		lblDescrio.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDescrio.setBackground(Color.WHITE);
		lblDescrio.setBounds(36, 161, 73, 14);
		contentPane.add(lblDescrio);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setForeground(Color.WHITE);
		lblQuantidade.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblQuantidade.setBackground(Color.WHITE);
		lblQuantidade.setBounds(36, 200, 73, 14);
		contentPane.add(lblQuantidade);
		
		JLabel lblFornecedor = new JLabel("Fornecedor");
		lblFornecedor.setForeground(Color.WHITE);
		lblFornecedor.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFornecedor.setBackground(Color.WHITE);
		lblFornecedor.setBounds(318, 79, 73, 14);
		contentPane.add(lblFornecedor);
		
		JLabel lblValidade = new JLabel("Validade");
		lblValidade.setForeground(Color.WHITE);
		lblValidade.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblValidade.setBackground(Color.WHITE);
		lblValidade.setBounds(318, 122, 73, 14);
		contentPane.add(lblValidade);
		
		JLabel lblCdigoDeBarras = new JLabel("Código de Barras");
		lblCdigoDeBarras.setForeground(Color.WHITE);
		lblCdigoDeBarras.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCdigoDeBarras.setBackground(Color.WHITE);
		lblCdigoDeBarras.setBounds(318, 162, 111, 14);
		contentPane.add(lblCdigoDeBarras);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setForeground(Color.WHITE);
		lblCategoria.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCategoria.setBackground(Color.WHITE);
		lblCategoria.setBounds(318, 201, 73, 14);
		contentPane.add(lblCategoria);
		
		txtcodigo = new JTextField();
		txtcodigo.setBounds(120, 76, 164, 20);
		contentPane.add(txtcodigo);
		txtcodigo.setColumns(10);
		
		txtnome = new JTextField();
		txtnome.setColumns(10);
		txtnome.setBounds(120, 120, 164, 20);
		contentPane.add(txtnome);
		
		txtdescricao = new JTextField();
		txtdescricao.setColumns(10);
		txtdescricao.setBounds(119, 159, 164, 20);
		contentPane.add(txtdescricao);
		
		txtquantidade = new JTextField();
		txtquantidade.setColumns(10);
		txtquantidade.setBounds(120, 198, 164, 20);
		contentPane.add(txtquantidade);
		
		txtfornecedor = new JTextField();
		txtfornecedor.setColumns(10);
		txtfornecedor.setBounds(451, 76, 164, 20);
		contentPane.add(txtfornecedor);
		
		txtvalidade = new JTextField();
		txtvalidade.setColumns(10);
		txtvalidade.setBounds(451, 120, 164, 20);
		contentPane.add(txtvalidade);
		
		txtbarras = new JTextField();
		txtbarras.setColumns(10);
		txtbarras.setBounds(451, 159, 164, 20);
		contentPane.add(txtbarras);
	
		
		
		      
		
		JComboBox txtcategoria = new JComboBox();
		txtcategoria.setBounds(451, 197, 164, 22);
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
    
		
		
 		
	
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
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
					String categoria = txtcategoria.getSelectedItem().toString();
					String codbarras = txtbarras.getText();
					
					
					int quant = Integer.parseInt(quantidade);
					
					
					//INSERIR DADOS ATRAVÉS DE LINGUAGEM SQL:
					
					String inserir = "INSERT INTO produtos (codigo, nome, descricao, quantidade, fornecedor, validade, codbarras, categorias) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
					
					//PREPARANDO PARA ENVIAR:
					
					PreparedStatement statement = conexao.prepareStatement(inserir);
					
					statement.setString(1, codigo);
					statement.setString(2, nome);
					statement.setString(3, descricao);
					statement.setInt(4, quant);
					statement.setString(5, fornecedor);
					statement.setString(6, validade);
					statement.setString(7, codbarras);
					statement.setString(8, categoria);
					
					int resultado = statement.executeUpdate();
					
					//TRATANDO CONDIÇÃO PARA SABER A A LINHA DO CADASTRO SERÁ PREENCHIDA:
					
					if (resultado > 0) {
						
						JOptionPane.showMessageDialog(null, "Produto Cadastrado Com Sucesso!");
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
               
		     
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(591, 310, 148, 41);
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
		
		JButton btnConsultarProdutos = new JButton("Consultar Produtos");
		btnConsultarProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ConsultaProduto abrir = new ConsultaProduto();
				
				abrir.setVisible(true);
				abrir.setLocationRelativeTo(null);
				setVisible(false);
				
				
				
			}
		});
		btnConsultarProdutos.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnConsultarProdutos.setBounds(10, 310, 164, 41);
		contentPane.add(btnConsultarProdutos);
		

		
	}

	 

	}

