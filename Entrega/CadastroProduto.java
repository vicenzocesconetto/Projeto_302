import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class CadastroProduto extends JDialog {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textValor;
	private JTextField textEstoque;
	private JComboBox comboBoxMarca;
	private JComboBox comboBoxModelo;
	private JTextField textEstoqueMinimo;
	private JTextField textRendimento;
	private JTextField textValidade;
	private ArrayList<JCheckBox> checkBoxPots;
	private ArrayList<JTextField> textTextosProduto;
	private ArrayList<Compatibilidade> produtosModelosCompativeis;
	private ArrayList<Produto> produtos;
	
	public CadastroProduto(ArrayList<Produto> produtos, ArrayList<Modelos> marcas) {
		setTitle("CADASTRO PRODUTO");
		this.produtos = produtos;
		this.produtosModelosCompativeis = new ArrayList<Compatibilidade>();
		this.textTextosProduto = new ArrayList<JTextField>();
		this.checkBoxPots = new ArrayList<JCheckBox>();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 603, 441);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
						
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(5, 130, 424, 0);
		contentPane.add(lblNewLabel);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(5, 8, 60, 29);
		contentPane.add(lblNome);
		
		textNome = new JTextField();
		lblNome.setLabelFor(textNome);
		textNome.setBounds(90, 12, 146, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);
		textTextosProduto.add(textNome);

		JLabel lblVallor = new JLabel("Valor:");
		lblVallor.setBounds(5, 43, 79, 14);
		contentPane.add(lblVallor);

		
		textValor = new JTextField();
		lblVallor.setLabelFor(textValor);
		textValor.setColumns(10);
		textValor.setBounds(90, 40, 50, 20);
		contentPane.add(textValor);
		textTextosProduto.add(textValor);

		
		JLabel lblEstoque = new JLabel("Estoque:");
		lblEstoque.setBounds(5, 68, 65, 14);
		contentPane.add(lblEstoque);
		
		textEstoque = new JTextField();
		lblEstoque.setLabelFor(textEstoque);
		textEstoque.setColumns(10);
		textEstoque.setBounds(90, 65, 50, 20);
		contentPane.add(textEstoque);
		textTextosProduto.add(textEstoque);

		
		JButton btnAdicionarProduto = new JButton("ADICIONAR PRODUTO");
		
		btnAdicionarProduto.setBounds(5, 181, 249, 79);
		contentPane.add(btnAdicionarProduto);
		btnAdicionarProduto.addActionListener(new AdicionaProduto());
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setBounds(291, 28, 60, 29);
		contentPane.add(lblMarca);
	
		comboBoxMarca = new JComboBox();
		comboBoxMarca.setBounds(361, 32, 146, 20);
		contentPane.add(comboBoxMarca);
		
		for(int i=0; i<marcas.size(); i++) {				
			comboBoxMarca.addItem(marcas.get(i).getNome());
		}	

		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setBounds(291, 68, 60, 29);
		contentPane.add(lblModelo);
	
		comboBoxModelo = new JComboBox();
		comboBoxModelo.setBounds(362, 72, 146, 20);
		contentPane.add(comboBoxModelo);
		
		for(int i=0; i<=marcas.get(0).getModelos().size(); i++) {
			if(comboBoxMarca.getSelectedItem().equals(marcas.get(i).getNome())) {
				for(int a=0;a<marcas.get(i).getModelos().size();a++) {
					comboBoxModelo.addItem(marcas.get(i).getModelos().get(a));
				}
			}
		}	
		
		ActionListener comboBoxSelect = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int comboSelected = comboBoxMarca.getSelectedIndex();
				ArrayList<String> modelosMarca = marcas.get(comboSelected).getModelos();
				DefaultComboBoxModel model = new DefaultComboBoxModel();//Cria um novo model de listaMunicipio
				model.removeAllElements(); //Remove todos elementos
				
				for(Object obj: modelosMarca){ //Para cada Objeto add
					model.addElement(obj);						
				}
				comboBoxModelo.setModel(model); //Set o modelo na comboBox 
			}
		};			
		comboBoxMarca.addActionListener(comboBoxSelect);
		
		JButton btnAdicionarModeloCompativel = new JButton("ADICIONAR MODELO COMPATIVEL");
		
		btnAdicionarModeloCompativel.addActionListener(new AdicionaModeloCompativel());
		
		btnAdicionarModeloCompativel.setBounds(291, 181, 270, 79);
		contentPane.add(btnAdicionarModeloCompativel);
		
		textEstoqueMinimo = new JTextField();
		textEstoqueMinimo.setColumns(10);
		textEstoqueMinimo.setBounds(90, 95, 50, 20);
		contentPane.add(textEstoqueMinimo);
		textTextosProduto.add(textEstoqueMinimo);

		
		JLabel lblEstoqueMinimo = new JLabel("Estoque Minimo:");
		lblEstoqueMinimo.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblEstoqueMinimo.setBounds(5, 93, 79, 14);
		contentPane.add(lblEstoqueMinimo);
		
		JLabel lblRendimento = new JLabel("Rendimento:");
		lblRendimento.setBounds(5, 123, 79, 14);
		contentPane.add(lblRendimento);
		
		JLabel lblValidade = new JLabel("Validade:");
		lblValidade.setBounds(5, 156, 79, 14);
		contentPane.add(lblValidade);
		
		textRendimento = new JTextField();
		textRendimento.setColumns(10);
		textRendimento.setBounds(90, 120, 50, 20);
		contentPane.add(textRendimento);
		textTextosProduto.add(textRendimento);

		
		textValidade = new JTextField();
		textValidade.setColumns(10);
		textValidade.setBounds(90, 150, 50, 20);
		contentPane.add(textValidade);
		textTextosProduto.add(textValidade);

		JLabel lblPotencias = new JLabel("Potencias:");
		lblPotencias.setBounds(291, 123, 79, 14);
		contentPane.add(lblPotencias);
		
		JCheckBox checkBoxPot1 = new JCheckBox("1.0 ");
		checkBoxPot1.setBounds(345, 119, 45, 23);
		contentPane.add(checkBoxPot1);
		checkBoxPots.add(checkBoxPot1);
		
		JCheckBox checkBoxPot2 = new JCheckBox("1.4");
		checkBoxPot2.setBounds(392, 119, 45, 23);
		contentPane.add(checkBoxPot2);
		checkBoxPots.add(checkBoxPot2);
		
		JCheckBox checkBoxPot3 = new JCheckBox("1.6");
		checkBoxPot3.setBounds(440, 119, 45, 23);
		contentPane.add(checkBoxPot3);
		checkBoxPots.add(checkBoxPot3);
		
		JCheckBox checkBoxPot4 = new JCheckBox("1.8");
		checkBoxPot4.setBounds(487, 119, 45, 23);
		contentPane.add(checkBoxPot4);
		checkBoxPots.add(checkBoxPot4);

		JCheckBox checkBoxPot5 = new JCheckBox("2.0");
		checkBoxPot5.setBounds(536, 119, 45, 23);
		contentPane.add(checkBoxPot5);
		checkBoxPots.add(checkBoxPot5);

		this.setVisible(true);



	}
	
	private class AdicionaModeloCompativel implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				 int k = 0; // conta o numero de checkBox selecionados
				 ArrayList<Float> potencias = new ArrayList<Float>();
				 for (int i = 0; i<checkBoxPots.size(); i++) {
					 if (checkBoxPots.get(i).isSelected()) {
						 k++;
						 potencias.add(Float.parseFloat(checkBoxPots.get(i).getText()));
					 }
				 }	 
				 if (k == 0) {
					 JOptionPane.showMessageDialog(null, "Voce deve selecionar pelo menos uma potencia", null, JOptionPane.ERROR_MESSAGE);
					 return;
				 }
				produtosModelosCompativeis.add(new Compatibilidade((String) comboBoxModelo.getSelectedItem(), (String) comboBoxMarca.getSelectedItem(), potencias));
				potencias = new ArrayList<Float>();
				 
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(null,ex.toString(), null, JOptionPane.ERROR_MESSAGE);
				return;
			}
			JOptionPane.showMessageDialog(null, "MODELO COMPATIVEL ADICIONADO COM SUCESSO",  null, JOptionPane.INFORMATION_MESSAGE);
		}
	}	
	
	private class AdicionaProduto implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			for (int i = 0; i< textTextosProduto.size(); i++) {
				if (textTextosProduto.get(i).getText().equals("")) {
					JOptionPane.showMessageDialog(null, "NENHUM campo pode estar vazio", null, JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
			try{
				Produto p = new Produto(Integer.parseInt(textEstoqueMinimo.getText()), Integer.parseInt(textEstoque.getText()), Float.parseFloat(textEstoqueMinimo.getText()), textNome.getText());
				p.setRendimento(Integer.parseInt(textRendimento.getText()));
				p.setValidade(Integer.parseInt(textValidade.getText()));
				for (int i = 0; i<produtosModelosCompativeis.size(); i++) {
					p.addModeloCompativel(produtosModelosCompativeis.get(i));
				}
				produtosModelosCompativeis = new ArrayList<Compatibilidade>();
				produtos.add(p);
				JOptionPane.showMessageDialog(null, "PRODUTO ADICIONADO COM SUCESSO",  null, JOptionPane.INFORMATION_MESSAGE);
			}catch(NumberFormatException ex){
				JOptionPane.showMessageDialog(null, ex.toString(), null, JOptionPane.ERROR_MESSAGE);
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(null, ex.toString(), null, JOptionPane.ERROR_MESSAGE);
			}
			
		}
	}
}
	
	







