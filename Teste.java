import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Teste extends JFrame implements ActionListener {
	ArrayList<String> nomes;
	
	public Teste (ArrayList<String> nomes) {
        this.nomes=nomes;
        
    
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        JComboBox listaSuspensa = new JComboBox(model);
        listaSuspensa.setRenderer(new ObjectNameListCellRenderer());
        JTextField text = new JTextField("", 30);
        text.getDocument().addDocumentListener(new DocumentListener() {
        
        	public void changedUpdate(DocumentEvent e) {
        		
        	}
        	public void removeUpdate(DocumentEvent e) {
        		for (int i = 0; i<nomes.size(); i++) {
        			if (nomes.get(i).toLowerCase().contains(text.getText().toLowerCase())) {
        				if (model.getIndexOf(nomes.get(i)) == -1) {
            				listaSuspensa.addItem(nomes.get(i));
        				}
        			}else {
        				listaSuspensa.removeItem(nomes.get(i));
        			}
            	}
        	}
        	public void insertUpdate(DocumentEvent e) {
        		for (int i = 0; i<nomes.size(); i++) {
        			if (nomes.get(i).toLowerCase().contains(text.getText().toLowerCase())) {
        				if (model.getIndexOf(nomes.get(i)) == -1) {
            				listaSuspensa.addItem(nomes.get(i));
        				}
        			}else {
        				listaSuspensa.removeItem(nomes.get(i));
        			}
            	}
        	}
        });
        
        Container contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout());
        contentPane.add(text);
        listaSuspensa.setMaximumSize(new Dimension(10, 10));
        contentPane.add(listaSuspensa);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 100);
        setVisible(true);
    }


    public class ObjectNameListCellRenderer extends DefaultListCellRenderer {
        private static final long serialVersionUID = 1L;
        public Component getListCellRendererComponent(JList list,Object value,int index, boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            return this;
        }
    }
    
    public static void main(String[] args) {
        ArrayList<String> nomes = new ArrayList<String>();
        nomes.add("Evandro");
        nomes.add("Evandro Luis");
        nomes.add("Evandro Luis Araujo de Sousa");
        nomes.add("Larissa");
    	Teste m = new Teste(nomes);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}