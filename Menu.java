import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;

public class Menu extends JDialog {

	private final JPanel contentPanel = new JPanel();
	String serFilename = "serialization.ser";
    private Funcoes funcoes = new Funcoes();
	
	public Menu(Empresa empresa, ArrayList<Cliente> clientes, ArrayList<Produto> produtos, ArrayList<Servico> servicos, Funcionario funcionario){
		//PADROES DA PAGINA
		setTitle("Menu");
	    setBounds(100, 100, 450, 750);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		ImageIcon icon = new ImageIcon("/home/greenseiya/eclipse-workspace/Oficina/src/dados/logo.png");
		
		JPanel panel = new JPanel();
		panel.setBounds(20, 12, 410, 130);
		contentPanel.add(panel);
		panel.setLayout(null);
		JLabel lblIcon = new JLabel("",icon, JLabel.CENTER);
		lblIcon.setBounds(0, 0, 410, 130);
		panel.add(lblIcon);
			
		
		//BOTAO REALIZAR VENDA
		JButton btnRealizarVenda = new JButton("Realizar Venda");
		btnRealizarVenda.setBackground(new Color(59, 89, 182));
		btnRealizarVenda.setForeground(Color.white);
		btnRealizarVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RealizarVenda venda = new RealizarVenda(empresa, funcionario, clientes, servicos, produtos);
				venda.setVisible(true);
			}
		});
		btnRealizarVenda.setBounds(25, 162, 400, 50);
		contentPanel.add(btnRealizarVenda);
		
		//BOTAO CADASTRAR CLIENTE
		JButton btnCadastraCliente = new JButton("Cadastrar Cliente");
		btnCadastraCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroCliente cCliente = new CadastroCliente(clientes);
				cCliente.setVisible(true);
			}
		});
		btnCadastraCliente.setBackground(new Color(59, 89, 182));
		btnCadastraCliente.setForeground(Color.white);
		btnCadastraCliente.setBounds(25, 224, 400, 50);
		contentPanel.add(btnCadastraCliente);
		
		//BOTAO CADASTRAR PRODUTO
		JButton btnCadastrarProduto = new JButton("Cadastrar Produto");
		btnCadastrarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroProduto cProduto = new CadastroProduto(produtos);
				cProduto.setVisible(true);
			}
		});
		btnCadastrarProduto.setBackground(new Color(59, 89, 182));
		btnCadastrarProduto.setForeground(Color.white);		
		btnCadastrarProduto.setBounds(25, 286, 400, 50);
		contentPanel.add(btnCadastrarProduto);
		
		//BOTAO CADASTRAR SERVICO
		JButton btnCadastrarServio = new JButton("Cadastrar Serviço");
		btnCadastrarServio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroServico cServico = new CadastroServico(servicos);
				cServico.setVisible(true);
			}
		});
		btnCadastrarServio.setBackground(new Color(59, 89, 182));
		btnCadastrarServio.setForeground(Color.white);	
		btnCadastrarServio.setBounds(25, 348, 400, 50);
		contentPanel.add(btnCadastrarServio);
		
		//BOTAO CONSULTA/ATUALIZAR ESTOQUE
		JButton btnConsultaratualizarEstoque = new JButton("Consultar/Atualizar Estoque");
		btnConsultaratualizarEstoque.setBackground(new Color(59, 89, 182));
		btnConsultaratualizarEstoque.setForeground(Color.white);	
		btnConsultaratualizarEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultarProduto consultaEstoque = new ConsultarProduto(produtos);
				consultaEstoque.setVisible(true);
			}
		});
		btnConsultaratualizarEstoque.setBounds(25, 410, 400, 50);
		contentPanel.add(btnConsultaratualizarEstoque);
		
		//BOTAO CAIXA
		JButton btnCaixa = new JButton("Caixa");
		btnCaixa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PaginaCaixa caixa = new PaginaCaixa(empresa, funcionario);
				caixa.setVisible(true);
			}
		});
		btnCaixa.setBackground(new Color(59, 89, 182));
		btnCaixa.setForeground(Color.white);
		btnCaixa.setBounds(25, 472, 400, 50);
		contentPanel.add(btnCaixa);
		
		//BOTAO RETORNO
		JButton btnRetornoDeClientes = new JButton("Retorno de Clientes");
		btnRetornoDeClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RetornoCliente rCliente = new RetornoCliente(clientes);
				rCliente.setVisible(true);
			}
		});
		btnRetornoDeClientes.setBackground(new Color(59, 89, 182));
		btnRetornoDeClientes.setForeground(Color.white);
		btnRetornoDeClientes.setBounds(25, 534, 400, 50);
		contentPanel.add(btnRetornoDeClientes);
		
		JButton btnConsultarAtualizarClientesprodutosservios = new JButton("Consultar/ Atualizar Clientes/Produtos/Serviços");
		btnConsultarAtualizarClientesprodutosservios.setBackground(new Color(59, 89, 182));
		btnConsultarAtualizarClientesprodutosservios.setForeground(Color.white);
		btnConsultarAtualizarClientesprodutosservios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultarCadastro consultarCadastro = new ConsultarCadastro(servicos, clientes, produtos);
				consultarCadastro.setVisible(true);
			}
		});
		btnConsultarAtualizarClientesprodutosservios.setBounds(25, 596, 400, 50);
		contentPanel.add(btnConsultarAtualizarClientesprodutosservios);
		
		//BOTAO SAIR
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ObjectOutputStream out = null; //serializacao
	    		try {
	    			out = new ObjectOutputStream(new FileOutputStream(serFilename));
	    			out.writeObject(clientes);
	    			out.writeObject(produtos);
	    			out.writeObject(servicos);
	    			out.writeObject(empresa);
	    			out.flush();
	    			System.out.println("BATATA");
	    		}catch(IOException ex) {

	    		}finally {
	    			try {
	    				out.close();
	    			}catch (IOException ex) {

	    			}
	    		}
	            setVisible(false);
				dispose();
			}
		});
		btnSair.setBackground(new Color(59, 89, 182));
		btnSair.setForeground(Color.white);
		
		btnSair.setBounds(25, 658, 400, 50);
		contentPanel.add(btnSair);
		
		

	}
}
