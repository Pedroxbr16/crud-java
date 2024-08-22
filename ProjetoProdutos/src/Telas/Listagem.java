package Telas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Listagem extends JFrame {

    private JComboBox<String> comboBoxCategorias;

    public Listagem() {
        setResizable(false);
        setTitle("Listagem de Produtos");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        // Criar um JPanel para conter a JComboBox
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        // Criar uma JComboBox para selecionar a categoria
        comboBoxCategorias = new JComboBox<>();
        comboBoxCategorias.addActionListener(e -> preencherTabela());
        
        
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projeto2", "root", "alunolab");

            // Consulta SQL
            String query = "SELECT * FROM cat";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            // Preenchendo a ComboBox com os resultados da consulta
            while (resultSet.next()) {
                String item = resultSet.getString("categoria");
                comboBoxCategorias.addItem(item);
            }

            connection.close(); // Fechando a conexão
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        
        
        
        // Adicionar a JComboBox ao JPanel
        panel.add(comboBoxCategorias);
        
        DefaultTableModel modeloTabela = new DefaultTableModel();
        // Adicionar colunas ao modelo de tabela
        modeloTabela.addColumn("codigo");
        modeloTabela.addColumn("nome");
        modeloTabela.addColumn("quantidade");
        modeloTabela.addColumn("codigo de barras");
        modeloTabela.addColumn("fornecedor");
        modeloTabela.addColumn("validade");
        
       

        JTable tabela = new JTable(modeloTabela);
        // Adicionar a tabela a um JScrollPane e exibi-la
        JScrollPane scrollPane = new JScrollPane(tabela);
        getContentPane().add(scrollPane);
        

        // Criar um JScrollPane e adicionar o JPanel a ele
        JScrollPane scrollPane2 = new JScrollPane(panel);
        
        JButton btnNewButton = new JButton("Listar");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		
        		  try {
        		    	
        		    	String categoria = comboBoxCategorias.getSelectedItem().toString();
        		    	
        		        // Conectar ao banco de dados
        		        Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/projeto2", "root", "alunolab");
        		        // Preparar e executar a consulta SQL
        		        PreparedStatement consulta = conexao.prepareStatement("SELECT * FROM produtos WHERE categorias = ?");
        		        consulta.setString(1, categoria);
        		        ResultSet resultado = consulta.executeQuery();
        		        // Processar os resultados e preencher a tabela
        		        while (resultado.next()) {
        		            modeloTabela.addRow(new Object[]{
        		                resultado.getString("codigo"),
        		                resultado.getString("nome"),
        		                resultado.getString("quantidade"),
        		                resultado.getString("codbarras"),
        		                resultado.getString("fornecedor"),
        		                resultado.getString("validade")
        		                
        		                // Adicione mais colunas conforme necessário
        		            });
        		        }
        		        // Fechar a conexão com o banco de dados
        		        conexao.close();
        		    } catch (SQLException e1) {
        		        e1.printStackTrace();
        		        JOptionPane.showMessageDialog(null, "Erro ao acessar o banco de dados");
        		    }
        		
        		
        		
        		
        		
        		
        		
        		
        		
        		
        		
        	}
        });
        panel.add(btnNewButton);
        
        JButton btnLimpar = new JButton("Limpar");
        btnLimpar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		
        		for (int row = 0; row < modeloTabela.getRowCount(); row++) {
                    for (int col = 0; col < modeloTabela.getColumnCount(); col++) {
                        modeloTabela.setValueAt("", row, col);
                    }
                }
        	}
        });
        panel.add(btnLimpar);
        
        
        	
        
       
        scrollPane2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        getContentPane().add(scrollPane2, BorderLayout.NORTH);

        setSize(600, 400);
        setVisible(true);
        setLocationRelativeTo(null);

        // Preencher a tabela com os produtos da categoria inicialmente selecionada
        preencherTabela();
    
    
    
  
    }

    private void preencherTabela() {
        // Implemente o método de preenchimento da tabela conforme necessário
    }

    public static void main(String[] args) {
        // Criar uma instância da classe e exibir a janela
        new Listagem();
    }
}
