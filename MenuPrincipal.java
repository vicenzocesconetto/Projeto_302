import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.*;
import java.util.ArrayList;

public class MenuPrincipal extends JFrame {

    public MenuPrincipal() {

    	Funcoes funcoes = new Funcoes();
        JButton[] botoes = new JButton[8];
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    	ArrayList<Produto> produtos = new ArrayList<Produto>();
    	ArrayList<Servico> servicos = new ArrayList<Servico>();
    	produtos.add(new Produto(3,3,3,"BATATA"));
    	produtos.add(new Produto(3,3,3,"EITA"));
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
            contentPane.add(botoes[i]);
        }
        contentPane.add(text);
        contentPane.add(listaSuspensa);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
        setVisible(true);
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
        MenuPrincipal m = new MenuPrincipal();
    }
}
