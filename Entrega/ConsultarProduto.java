import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;

public class ConsultarProduto extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JComboBox comboBoxProdutos;
	JLabel lblPesquisa = new JLabel("Entre com o nome do produto:");
	private JTextField textField;
	
	public ConsultarProduto(ArrayList<Produto> produtos) {
		setTitle("Consultar/Atualizar Estoque de Produtos");
		contentPanel.setLayout(null);
        setModalityType(DEFAULT_MODALITY_TYPE);
        setBounds(100, 100, 450, 300);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
			
		//DEFINE O TAMANHO DA LABEL: ENTRE COM O NOME...
		lblPesquisa.setBounds(12, 12, 214, 15);
				
		//DEFINE COMBOBOX
	    comboBoxProdutos = new JComboBox();
	    comboBoxProdutos.setBounds(22, 42, 383, 24);
		
		for(int i=0; i<produtos.size(); i++) {				
			comboBoxProdutos.addItem(produtos.get(i).getNome());
		}	
			
		//DEFINE JTEXT PANE
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(12, 78, 416, 72);
		
		ActionListener comboBoxSelect = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int comboSelected = comboBoxProdutos.getSelectedIndex();
				String str = "Nome: " + produtos.get(comboSelected).getNome() + "\n";
				str += "Valor: R$" + produtos.get(comboSelected).getValor();
				str += "\tQuantidade em estoque: " + produtos.get(comboSelected).getEstoque() + "\n";
				textPane.setText(str);
			}
		};			
		comboBoxProdutos.addActionListener(comboBoxSelect);
		
		JLabel lblEntreComO = new JLabel("Entre com o novo valor do estoque:");
		lblEntreComO.setEnabled(false);
		lblEntreComO.setBounds(22, 192, 262, 15);
			
		textField = new JTextField();
		textField.setBounds(288, 190, 80, 19);
		textField.setEnabled(false);
		textField.setColumns(10);
		
		JCheckBox chckbxAtualizarEstoque = new JCheckBox("Atualizar estoque");
		chckbxAtualizarEstoque.setBounds(22, 158, 182, 23);
		
		chckbxAtualizarEstoque.addItemListener(new ItemListener() {
		    @Override
		    public void itemStateChanged(ItemEvent e) {
		        if(e.getStateChange() == ItemEvent.SELECTED) {
		        	lblEntreComO.setEnabled(true);
		        	textField.setEnabled(true);
		        } 
		    }
		});
				
		contentPanel.add(lblPesquisa);
		contentPanel.add(comboBoxProdutos);
		contentPanel.add(textPane);
		contentPanel.add(lblEntreComO);
		contentPanel.add(chckbxAtualizarEstoque);
		contentPanel.add(textField);
		
		JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
			{
				JButton okButton = new JButton("Salvar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int comboSelected = comboBoxProdutos.getSelectedIndex();
						produtos.get(comboSelected).setEstoque(Integer.parseInt(textField.getText()));
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	
	

}

