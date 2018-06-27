import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class RealizarVendaAdicionarProdutos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JComboBox comboBoxProdutos;
	private JTextField textQtd;
	JLabel lblPesquisa = new JLabel("Entre com o nome do produto:");
	private int qtd=1;
	private JButton btnMinus;
	private JButton btnPlus;

	public RealizarVendaAdicionarProdutos(Venda venda, ArrayList<Produto> produtos) {
		setTitle("Adicionar Produto");
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
	    
	    for(int i=0; i<produtos.size(); i++) comboBoxProdutos.addItem(produtos.get(i).getNome());
	       
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
		
		//QTD
		//NUMERO
		textQtd = new JTextField();
		textQtd.setHorizontalAlignment(SwingConstants.CENTER);
		textQtd.setBounds(311, 188, 45, 20);
		textQtd.setText(""+qtd);
		
		//BOTAO +
		JButton btnPlus;
		btnPlus = new JButton("+");
		
		btnPlus.setBackground(new Color(59, 89, 182));
		btnPlus.setForeground(Color.white);
		
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int comboSelected = comboBoxProdutos.getSelectedIndex();
				if(qtd<produtos.get(comboSelected).getEstoque()) {
					qtd++;
				}
				textQtd.setText(""+qtd);				
			}
		});
		btnPlus.setBounds(360, 188, 45, 20);
	
		//BOTAO -
		JButton btnMinus;
		btnMinus = new JButton("-");
		
		btnMinus.setBackground(new Color(59, 89, 182));
		btnMinus.setForeground(Color.white);
		
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
		contentPanel.add(lblPesquisa);
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
			
			//BOTAO CANCELAR
			{
				JButton cancelButton = new JButton("Cancelar");
				
				cancelButton.setBackground(new Color(59, 89, 182));
				cancelButton.setForeground(Color.white);				
				
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
			//BOTAO ADICIONAR
			{
				JButton okButton = new JButton("Adicionar");
				
				okButton.setBackground(new Color(59, 89, 182));
				okButton.setForeground(Color.white);
				
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Funcoes funcoes = new Funcoes();
						int comboSelected = comboBoxProdutos.getSelectedIndex();
						
						if(venda.getVeiculo()!=null) {
							if(funcoes.produtoCompativel(produtos.get(comboSelected), venda.getVeiculo())) {
								venda.addProduto(produtos.get(comboSelected), qtd);
								JOptionPane.showMessageDialog(null, "Produto Adicionado", null, JOptionPane.INFORMATION_MESSAGE);
								dispose();
							}
							else {
								JOptionPane.showMessageDialog(null, "Produto não compativel com o veiculo informado", null, JOptionPane.ERROR_MESSAGE);
							}
						}
						else {
							venda.addProduto(produtos.get(comboSelected), qtd);
							JOptionPane.showMessageDialog(null, "Produto Adicionado", null, JOptionPane.INFORMATION_MESSAGE);
							dispose();
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
}
