import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

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
        
        Funcoes funcoes = new Funcoes();


        JButton[] botoes = new JButton[8];

    	botoes[0] = new JButton("Realizar venda");
        botoes[1] = new JButton("Cadastrar cliente");
        botoes[2] = new JButton("Cadastrar produto/servico");
        botoes[3] = new JButton("Consultar/Atualizar Estoque de Produtos");
        botoes[4] = new JButton("Caixa");
        botoes[5] = new JButton("Retorno de Clientes");
        botoes[6] = new JButton("Consultar/Atualizar Cliente/Produto/Servico");
        botoes[7] = new JButton("Sair do sistema"); 
        
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        JComboBox listaSuspensa = new JComboBox(model);
        listaSuspensa.setRenderer(new ObjectNameListCellRenderer());
        JTextField text = new JTextField("", 20);
        text.getDocument().addDocumentListener(new DocumentListener() {
        
        	public void changedUpdate(DocumentEvent e) {
        		
        	}
        	public void removeUpdate(DocumentEvent e) {
        		for (int i = 0; i<produtos.size(); i++) {
        			if (produtos.get(i).getNome().toLowerCase().contains(text.getText().toLowerCase())) {
        				if (model.getIndexOf(produtos.get(i)) == -1) {
            				listaSuspensa.addItem(produtos.get(i));
        				}
        			}else {
        				listaSuspensa.removeItem(produtos.get(i));
        			}
            	}
        	}
        	public void insertUpdate(DocumentEvent e) {
        		for (int i = 0; i<produtos.size(); i++) {
        			if (produtos.get(i).getNome().toLowerCase().contains(text.getText().toLowerCase())) {
        				if (model.getIndexOf(produtos.get(i)) == -1) {
            				listaSuspensa.addItem(produtos.get(i));
        				}
        			}else {
        				listaSuspensa.removeItem(produtos.get(i));
        			}
            	}
        	}
        });
        
        Container contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout());

        for(int i = 0; i < 8; ++i) {
            botoes[i].addActionListener(this);
            contentPane.add(botoes[i]);
        }
        contentPane.add(text);
        contentPane.add(listaSuspensa);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(Main.TAMANAHO_DA_JANELA, Main.TAMANAHO_DA_JANELA);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent event) {
    	Funcoes funcoes = new Funcoes();
		ArrayList<Modelos> carros = funcoes.carregaModelos("C:/Users/Pichau/Desktop/UNICAMP/3SEM/MC302/Proj - MyClasses/src/dados/marcas-carros.txt" , "C:/Users/Pichau/Desktop/UNICAMP/3SEM/MC302/Proj - MyClasses/src/dados/modelos-carro.txt");
        Object source = event.getSource();

        if(source.toString().contains("Realizar venda")) {
            System.out.println("Ragnar Lothbrok");
    		for (int i = 0; i<clientes.size(); i++) {
    			System.out.println(clientes.get(i).getNome());
    		}
        }
        else if(source.toString().contains("Cadastrar cliente")) {
            System.out.println("Rollo Lothbrok");
        }
        else if(source.toString().contains("Cadastrar produto/servico")) {
            System.out.println("Broonhilda");
    		CadastroCliente cadastro = new CadastroCliente(clientes, carros);
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


    public class ObjectNameListCellRenderer extends DefaultListCellRenderer {
        private static final long serialVersionUID = 1L;
        public Component getListCellRendererComponent(JList list,Object value,int index, boolean isSelected, boolean cellHasFocus) {
            if (value instanceof Produto) {
                value = ((Produto)value).getNome();
            }else if (value instanceof Cliente) {
                value = ((Cliente)value).getNome();
            }else if (value instanceof Servico) {
                value = ((Servico)value).getNome();
            }
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            return this;
        }
    }
    
    public static void main(String[] args) {
        MenuPrincipal m = new MenuPrincipal(new Empresa("e", "er"), new ArrayList<Cliente>(), new ArrayList<Produto>(), new ArrayList<Servico>());
    }
}
