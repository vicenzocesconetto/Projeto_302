import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MenuPrincipal extends JFrame implements ActionListener {

    Empresa empresa;
    ArrayList<Cliente> clientes;
    ArrayList<Produto> produtos;
    ArrayList<Servico> servicos;

    public MenuPrincipal(Empresa empresa, ArrayList<Cliente> clientes, ArrayList<Produto> produtos, ArrayList<Servico> servicos) {
    	this.empresa = empresa;
        this.clientes = clientes;
        this.produtos = produtos;
        this.servicos = servicos;

    	JButton[] botoes = new JButton[8];

    	botoes[0] = new JButton("Realizar venda");
        botoes[1] = new JButton("Cadastrar cliente");
        botoes[2] = new JButton("Cadastrar produto/servico");
        botoes[3] = new JButton("Consultar/Atualizar Estoque de Produtos");
        botoes[4] = new JButton("Caixa");
        botoes[5] = new JButton("Retorno de Clientes");
        botoes[6] = new JButton("Consultar/Atualizar Cliente/Produto/Servico");
        botoes[7] = new JButton("Sair do sistema"); 
        
        Container contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout());

        for(int i = 0; i < 8; ++i) {
            botoes[i].addActionListener(this);
            contentPane.add(botoes[i]);
        }
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(Main.TAMANAHO_DA_JANELA, Main.TAMANAHO_DA_JANELA);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();

        if(source.toString().contains("Realizar venda")) {
            System.out.println("Ragnar Lothbrok");
        }
        else if(source.toString().contains("Cadastrar cliente")) {
            System.out.println("Rollo Lothbrok");
        }
        else if(source.toString().contains("Cadastrar produto/servico")) {
            System.out.println("Broonhilda");
        }
        else if(source.toString().contains("Consultar/Atualizar Estoque de Produtos")) {
            System.out.println("Helga");
        }
        else if(source.toString().contains("Caixa")) {
            System.out.println("Bjorn");
        }
        else if(source.toString().contains("Retorno de Clientes")) {
            System.out.println("Siggy");
        }
        else if(source.toString().contains("Consultar/Atualizar Cliente/Produto/Servico")) {
            System.out.println("Bretwalda");
        }
        else if(source.toString().contains("Sair do sistema")) {
            System.out.println("Mjolnir");
        }
    }

    
    public static void main(String[] args) {
        MenuPrincipal m = new MenuPrincipal(new Empresa("e", "er"), new ArrayList<Cliente>(), new ArrayList<Produto>(), new ArrayList<Servico>());
    }
}
