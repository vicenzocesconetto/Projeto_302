import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class MenuPrincipal extends JFrame implements ActionListener {

	String serFilename = "serializationData.ser";
    private Empresa empresa;
    private ArrayList<Cliente> clientes;
    private ArrayList<Produto> produtos;
    private ArrayList<Servico> servicos;
    private Funcionario funcionario;

    public MenuPrincipal(Empresa empresa, ArrayList<Cliente> clientes, ArrayList<Produto> produtos, ArrayList<Servico> servicos, Funcionario funcionario) {

        this.empresa = empresa;
        this.clientes = clientes;
        this.produtos = produtos;
        this.servicos = servicos;
        this.funcionario = funcionario;
        
        Funcoes funcoes = new Funcoes();

        JButton[] botoes = new JButton[9];

    	botoes[0] = new JButton("Realizar venda");
        botoes[1] = new JButton("Cadastrar cliente");
        botoes[2] = new JButton("Cadastrar produto");
        botoes[3] = new JButton("Cadastrar servico");
        botoes[4] = new JButton("Consultar/Atualizar Estoque de Produtos");
        botoes[5] = new JButton("Caixa");
        botoes[6] = new JButton("Retorno de Clientes");
        botoes[7] = new JButton("Consultar/Atualizar Cliente/Produto/Servico");
        botoes[8] = new JButton("Sair do sistema");

        Container contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout());

        for(int i = 0; i < 9; ++i) {
            botoes[i].addActionListener(this);
            contentPane.add(botoes[i]);
        }

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(Main.TAMANAHO_DA_JANELA, Main.TAMANAHO_DA_JANELA);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
    	Funcoes funcoes = new Funcoes();
		ArrayList<Modelos> carros = funcoes.carregaModelos("marcas-carros.txt", "modelos-carro.txt");
        Object source = event.getSource();

        if(source.toString().contains("Realizar venda")) {
        	RealizarVenda rVenda = new RealizarVenda(empresa, funcionario, clientes, servicos, produtos);
        	rVenda.setVisible(true);
        }
        else if(source.toString().contains("Cadastrar cliente")) {
            CadastroCliente cadastroC = new CadastroCliente(clientes, carros);
            cadastroC.setVisible(true);
        }
        else if(source.toString().contains("Cadastrar produto")) {
    		CadastroProduto cadastroP = new CadastroProduto(produtos, carros);
    		cadastroP.setVisible(true);
        }
        else if(source.toString().contains("Cadastrar servico")) {
        	CadastroServico cadastroS = new CadastroServico(servicos);
        	cadastroS.setVisible(true);
        }
        else if(source.toString().contains("Consultar/Atualizar Estoque de Produtos")) {
            ConsultarProduto consultarP = new ConsultarProduto(produtos);
            consultarP.setVisible(true);
        }
        else if(source.toString().contains("Caixa")) {
            PaginaCaixa paginaCaixa = new PaginaCaixa(empresa, clientes, produtos, servicos, funcionario);
            paginaCaixa.setVisible(true);
        }
        else if(source.toString().contains("Retorno de Clientes")) {
            RetornoCliente retornoC = new RetornoCliente(clientes);
            retornoC.setVisible(true);
        }
        else if(source.toString().contains("Consultar/Atualizar Cliente/Produto/Servico")) {
            ConsultarCadastro consulta = new ConsultarCadastro(servicos, clientes, produtos);
            consulta.setVisible(true);
        }
        else if(source.toString().contains("Sair do sistema")) {
        	ObjectOutputStream out = null; //serializacao
    		try {
    			out = new ObjectOutputStream(new FileOutputStream(serFilename));
    			out.writeObject(clientes);
    			out.writeObject(produtos);
    			out.writeObject(servicos);
    			out.writeObject(empresa);
    			out.flush();
    		}catch(IOException ex) {

    		}finally {
    			try {
    				out.close();
    			}catch (IOException e) {

    			}
    		}
        }
        setVisible(false);
    }
    
    
}
