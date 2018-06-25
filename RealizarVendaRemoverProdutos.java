import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class RealizarVendaRemoverProdutos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JComboBox comboBoxProdutos;
	private JTextField textQtd;
	private JButton btnMinus;
	private JButton btnPlus;
	private int qtd=1;
	
	public RealizarVendaRemoverProdutos(Venda venda) {
		setTitle("Remover Servico");
		contentPanel.setLayout(null);
        setModalityType(DEFAULT_MODALITY_TYPE);
        setBounds(100, 100, 450, 300);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		//DEFINE LABEL: ENTRE COM O NOME
		JLabel lblEntreComO = new JLabel("Qual produto deseja remover?");
		lblEntreComO.setBounds(12, 12, 214, 15);
				
		//DEFINE O COMBOBOX	
		comboBoxProdutos = new JComboBox();
		comboBoxProdutos.setBounds(22, 42, 383, 24);
				
		for(int i=0; i<venda.getProdutos().size(); i++) {				
			comboBoxProdutos.addItem(venda.getProdutos().get(i).getNome());
		}
		
		//DEFINE O JTEXT PANE
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(12, 78, 416, 72);
	
		ActionListener comboBoxSelect = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int comboSelected = comboBoxProdutos.getSelectedIndex();
				DecimalFormat df = new DecimalFormat("0.00");
				String str = "Nome: " + venda.getProdutos().get(comboSelected).getNome() + "\n";
				str += "Quantidade: " + venda.getQtd().get(comboSelected) + "\n";
				str += "Valor Unitario: R$" + venda.getProdutos().get(comboSelected).getValor();
				str += "\t\tTotal: R$" + df.format((venda.getProdutos().get(comboSelected).getValor()*venda.getQtd().get(comboSelected))) + "\n";
				textPane.setText(str);
			}
		};			
		comboBoxProdutos.addActionListener(comboBoxSelect);
			
		//QTD
		//NUMERO
		textQtd = new JTextField();
		textQtd.setHorizontalAlignment(SwingConstants.CENTER);
		textQtd.setBounds(311, 188, 45, 20);
		textQtd.setText(""+qtd);
		
		//BOTAO +
		JButton btnPlus;
		btnPlus = new JButton("+");
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int comboSelected = comboBoxProdutos.getSelectedIndex();
				if(qtd<venda.getQtd().get(comboSelected)) {
					qtd++;
				}
				textQtd.setText(""+qtd);				
			}
		});
		btnPlus.setBounds(360, 188, 45, 20);
	
		//BOTAO -
		JButton btnMinus;
		btnMinus = new JButton("-");
		btnMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(qtd>1) qtd--;
				textQtd.setText(""+qtd);	
			}
		});
		btnMinus.setBounds(262, 188, 45, 20);
		
		//LABEL QTD
		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setBounds(156, 191, 99, 15);

		//ADICIONA A TELA
		contentPanel.add(lblEntreComO);
		contentPanel.add(comboBoxProdutos);
		contentPanel.add(textPane);
		contentPanel.add(textQtd);
		contentPanel.add(btnPlus);
		contentPanel.add(btnMinus);
		contentPanel.add(lblQuantidade);
		
		//BOTOES	
		{
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
				JButton okButton = new JButton("Remover");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int comboSelected = comboBoxProdutos.getSelectedIndex();
						venda.removeProduto(comboSelected, qtd);
						JOptionPane.showMessageDialog(null, "Produto Removido", null, JOptionPane.INFORMATION_MESSAGE);
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}

}
