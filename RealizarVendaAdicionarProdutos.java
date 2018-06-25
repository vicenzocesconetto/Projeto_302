import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class RealizarVendaAdicionarProdutos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JComboBox comboBoxProdutos;
	private JTextField textQtd;
	private int qtd=0;

	public RealizarVendaAdicionarProdutos(ArrayList<Produto> produtos) {
		setTitle("Adicionar Produto");
	    contentPanel.setLayout(null);
	    setModalityType(DEFAULT_MODALITY_TYPE);
	    	
	    setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		{
			JLabel lblEntreComO = new JLabel("Entre com o nome do produto:");
			lblEntreComO.setBounds(12, 12, 214, 15);
			contentPanel.add(lblEntreComO);
		}
		
	    comboBoxProdutos = new JComboBox();
	    comboBoxProdutos.setBounds(22, 42, 383, 24);
		contentPanel.add(comboBoxProdutos);
		
		for(int i=0; i<produtos.size(); i++) {				
			comboBoxProdutos.addItem(produtos.get(i).getNome());
		}	
       
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(12, 78, 416, 72);
		contentPanel.add(textPane);
		
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
		
		
		
		
		textQtd = new JTextField();
		textQtd.setHorizontalAlignment(SwingConstants.CENTER);
		textQtd.setBounds(311, 188, 45, 20);
		contentPanel.add(textQtd);
		textQtd.setColumns(1);
		textQtd.setText(""+qtd);
		
		JButton btnNewButton = new JButton("+");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int comboSelected = comboBoxProdutos.getSelectedIndex();
				if(qtd<produtos.get(comboSelected).getEstoque()) {
					qtd++;
				}
				textQtd.setText(""+qtd);				
			}
		});
		btnNewButton.setBounds(360, 188, 45, 20);
		contentPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("-");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int comboSelected = comboBoxProdutos.getSelectedIndex();
				if(qtd>0) {
					qtd--;
				}
				textQtd.setText(""+qtd);	
			}
		});
		btnNewButton_1.setBounds(262, 188, 45, 20);
		contentPanel.add(btnNewButton_1);
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setBounds(156, 191, 99, 15);
		contentPanel.add(lblQuantidade);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
			{
				JButton okButton = new JButton("Adicionar");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
}
