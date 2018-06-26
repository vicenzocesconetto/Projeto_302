import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ConsultarCadastroProduto extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JComboBox comboBoxProdutos;
	JLabel lblPesquisa = new JLabel("Entre com o nome do produto:");
	private JTextField textFieldNome;
	private JTextField textFieldValor;
	private JTextField textFieldEst;
	private JTextField textFieldEstMin;
	private DecimalFormat df = new DecimalFormat("0.00");
	
	public ConsultarCadastroProduto(ArrayList<Produto> produtos) {
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
		
		
		{
			JLabel lblNome = new JLabel("Nome:");
			lblNome.setBounds(12, 90, 45, 15);
			contentPanel.add(lblNome);
		}
		{
			JLabel lblValorun = new JLabel("Valor (UN):");
			lblValorun.setBounds(12, 116, 83, 15);
			contentPanel.add(lblValorun);
		}
		{
			JLabel lblEstoque = new JLabel("Estoque:");
			lblEstoque.setBounds(12, 142, 70, 15);
			contentPanel.add(lblEstoque);
		}
		{
			textFieldNome = new JTextField();
			textFieldNome.setBounds(112, 88, 114, 19);
			contentPanel.add(textFieldNome);
			textFieldNome.setColumns(10);
		}
		{
			textFieldValor = new JTextField();
			textFieldValor.setBounds(112, 114, 114, 19);
			contentPanel.add(textFieldValor);
			textFieldValor.setColumns(10);
		}
		{
			textFieldEst = new JTextField();
			textFieldEst.setBounds(112, 140, 114, 19);
			contentPanel.add(textFieldEst);
			textFieldEst.setColumns(10);
		}
		{
			JLabel lblEstoqueMinimo = new JLabel("Estoque Min.:");
			lblEstoqueMinimo.setBounds(12, 168, 127, 15);
			contentPanel.add(lblEstoqueMinimo);
		}
		{
			textFieldEstMin = new JTextField();
			textFieldEstMin.setBounds(112, 166, 114, 19);
			contentPanel.add(textFieldEstMin);
			textFieldEstMin.setColumns(10);
		}
		
		ActionListener comboBoxSelect = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int comboSelected = comboBoxProdutos.getSelectedIndex();
				
				textFieldNome.setText(produtos.get(comboSelected).getNome());
				textFieldValor.setText(df.format(produtos.get(comboSelected).getValor()));
				textFieldEst.setText(df.format(produtos.get(comboSelected).getEstoque()));
				textFieldEstMin.setText(df.format(produtos.get(comboSelected).getEstoqueMinimo()));
			}
		};			
		comboBoxProdutos.addActionListener(comboBoxSelect);
		
		contentPanel.add(lblPesquisa);
		contentPanel.add(comboBoxProdutos);
		
		
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
				JButton okButton = new JButton("Salvar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int comboSelected = comboBoxProdutos.getSelectedIndex();
						produtos.get(comboSelected).setNome(textFieldNome.getText());
						produtos.get(comboSelected).setValor(Float.parseFloat(textFieldValor.getText()));
						produtos.get(comboSelected).setEstoque(Integer.parseInt(textFieldEst.getText()));
						produtos.get(comboSelected).setEstoqueMinimo(Integer.parseInt(textFieldEstMin.getText()));
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
