import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

public class CadastroProduto extends JDialog {
	private static final long serialVersionUID = 1L;
	private JPanel contentPanel = new JPanel();
	
	private JTextField textNome;
	private JTextField textValor;
	private JTextField textEstoque;
	private JTextField textEstoqueMinimo;
	private JTextField textRendimento;
	private JTextField textValidade;
	
	private JComboBox comboBoxMarca;
	private JComboBox comboBoxModelo;
	
	private ArrayList<JCheckBox> checkBoxPots = new ArrayList<JCheckBox>();
	private ArrayList<Compatibilidade> produtosModelosCompativeis = new ArrayList<Compatibilidade>();
	
	private Funcoes funcoes = new Funcoes();
	
	private ArrayList<Modelos> carros = funcoes.carregaModelos("/home/greenseiya/eclipse-workspace/Oficina/src/dados/marcas-carros.txt", "/home/greenseiya/eclipse-workspace/Oficina/src/dados/modelos-carro.txt");
	private ArrayList<Modelos> motos = funcoes.carregaModelos("/home/greenseiya/eclipse-workspace/Oficina/src/dados/marcas-motos.txt", "/home/greenseiya/eclipse-workspace/Oficina/src/dados/modelos-moto.txt");
	private ArrayList<Modelos> caminhoes = funcoes.carregaModelos("/home/greenseiya/eclipse-workspace/Oficina/src/dados/marcas-caminhao.txt", "/home/greenseiya/eclipse-workspace/Oficina/src/dados/modelos-caminhao.txt");
	
	private ArrayList<Modelos> modelos;
	
	private ArrayList<JTextField> textTextosProduto = new ArrayList<JTextField>();
	
	public CadastroProduto(ArrayList<Produto> produtos) {
		
		setTitle("Cadastrar Produto");
        setModalityType(DEFAULT_MODALITY_TYPE);
        setBounds(100, 100, 350, 625);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
					
		//NOME
		JLabel lblNome = new JLabel("Nome:*");
		lblNome.setHorizontalAlignment(SwingConstants.LEFT);
		lblNome.setBounds(90, 13, 55, 20);
		contentPanel.add(lblNome);
		
		textNome = new JTextField();
		lblNome.setLabelFor(textNome);
		textNome.setBounds(145, 13, 146, 20);
		contentPanel.add(textNome);
		textNome.setColumns(10);
		textTextosProduto.add(textNome);
		
		//VALOR
		JLabel lblVallor = new JLabel("Valor:*");
		lblVallor.setHorizontalAlignment(SwingConstants.LEFT);
		lblVallor.setBounds(90, 45, 50, 15);
		contentPanel.add(lblVallor);
		
		textValor = new JTextField();
		lblVallor.setLabelFor(textValor);
		textValor.setColumns(10);
		textValor.setBounds(145, 40, 50, 20);
		contentPanel.add(textValor);
		textTextosProduto.add(textValor);

		//ESTOQUE
		JLabel lblEstoque = new JLabel("Estoque:*");
		lblEstoque.setHorizontalAlignment(SwingConstants.LEFT);
		lblEstoque.setBounds(70, 70, 70, 14);
		contentPanel.add(lblEstoque);
		
		textEstoque = new JTextField();
		lblEstoque.setLabelFor(textEstoque);
		textEstoque.setColumns(10);
		textEstoque.setBounds(145, 67, 50, 20);
		contentPanel.add(textEstoque);
		textTextosProduto.add(textEstoque);
		
		//ESTOQUE MINIMO
		JLabel lblEstoqueMinimo = new JLabel("Estoque Min:*");
		lblEstoqueMinimo.setHorizontalAlignment(SwingConstants.LEFT);
		lblEstoqueMinimo.setFont(new Font("Dialog", Font.BOLD, 12));
		lblEstoqueMinimo.setBounds(40, 97, 100, 14);
		contentPanel.add(lblEstoqueMinimo);
		
		textEstoqueMinimo = new JTextField();
		textEstoqueMinimo.setColumns(10);
		textEstoqueMinimo.setBounds(145, 94, 50, 20);
		contentPanel.add(textEstoqueMinimo);
		textTextosProduto.add(textEstoqueMinimo);
		
		//RENDIMENTO
		JLabel lblRendimento = new JLabel("Rendimento (Kms):");
		lblRendimento.setHorizontalAlignment(SwingConstants.LEFT);
		lblRendimento.setBounds(5, 124, 135, 14);
		contentPanel.add(lblRendimento);
		
		textRendimento = new JTextField();
		textRendimento.setColumns(10);
		textRendimento.setBounds(145, 121, 50, 20);
		contentPanel.add(textRendimento);
		
		//VALIDADE
		JLabel lblValidade = new JLabel("Validade (Meses): ");
		lblValidade.setHorizontalAlignment(SwingConstants.LEFT);
		lblValidade.setBounds(9, 151, 131, 14);
		contentPanel.add(lblValidade);
				
		textValidade = new JTextField();
		textValidade.setColumns(10);
		textValidade.setBounds(145, 148, 50, 20);
		contentPanel.add(textValidade);
			
		JLabel lblAdicionarModelosCompativeis = new JLabel("Adicionar Modelos compativeis");
		lblAdicionarModelosCompativeis.setFont(new Font("Dialog", Font.BOLD, 14));
		lblAdicionarModelosCompativeis.setBounds(5, 190, 249, 19);
		contentPanel.add(lblAdicionarModelosCompativeis);
		
		//BOTAO RADIAL
		JLabel lblTipo = new JLabel("Tipo de Veiculo:");
		lblTipo.setBounds(5, 221, 112, 28);
		contentPanel.add(lblTipo);
		
		JRadioButton rdbtnCarro = new JRadioButton("Carro");
		rdbtnCarro.setBounds(31, 247, 70, 20);
		contentPanel.add(rdbtnCarro);
		rdbtnCarro.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				comboBoxMarca.removeAllItems();
			   	modelos = carros;
		    	for(int i=0; i<carros.size(); i++) comboBoxMarca.addItem(carros.get(i).getNome());
		    }
		});
		
		JRadioButton rdbtnMoto = new JRadioButton("Moto");
		rdbtnMoto.setBounds(128, 247, 70, 20);
		contentPanel.add(rdbtnMoto);
		rdbtnMoto.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				comboBoxMarca.removeAllItems();
				modelos = motos;
		    	for(int i=0; i<motos.size(); i++) comboBoxMarca.addItem(motos.get(i).getNome());
		    }
		});
		
		JRadioButton rdbtnCaminho = new JRadioButton("Caminhão");
		rdbtnCaminho.setBounds(225, 247, 100, 20);
		contentPanel.add(rdbtnCaminho);
		rdbtnCaminho.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				comboBoxMarca.removeAllItems();
				modelos = caminhoes;
		    	for(int i=0; i<caminhoes.size(); i++) comboBoxMarca.addItem(caminhoes.get(i).getNome());
		    }
		});		
					
		ButtonGroup grupo = new ButtonGroup();
		grupo.add(rdbtnMoto);
		grupo.add(rdbtnCarro);
		grupo.add(rdbtnCaminho);
				
		//MODELO
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setBounds(8, 327, 60, 29);
		contentPanel.add(lblModelo);
				
		comboBoxModelo = new JComboBox();
		comboBoxModelo.setBounds(8, 351, 320, 25);
		contentPanel.add(comboBoxModelo);
				
		//MARCA
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setBounds(8, 274, 60, 29);
		contentPanel.add(lblMarca);
		
		comboBoxMarca = new JComboBox();
		comboBoxMarca.setBounds(5, 302, 320, 25);
		contentPanel.add(comboBoxMarca);		
	
		comboBoxMarca.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				comboBoxModelo.removeAllItems();
				int comboSelected = comboBoxMarca.getSelectedIndex();
				if(comboSelected >= 0) {
					ArrayList<String> modelosMarca = modelos.get(comboSelected).getModelos();
					DefaultComboBoxModel model = new DefaultComboBoxModel();
					model.removeAllElements();
					for(String obj: modelosMarca) model.addElement(obj);						
					comboBoxModelo.setModel(model);				
				}
			}
		});
		
		JLabel lblModelosCompativeis = new JLabel("Modelos Compativeis");
		lblModelosCompativeis.setBounds(5, 468, 150, 15);
		contentPanel.add(lblModelosCompativeis);
		
		JComboBox comboBoxModelosCom = new JComboBox();
		comboBoxModelosCom.setBounds(18, 490, 300, 24);
		contentPanel.add(comboBoxModelosCom);
		
		//POTENCIAS
		JLabel lblPotencias = new JLabel("Potencias:");
		lblPotencias.setBounds(5, 381, 79, 14);
		contentPanel.add(lblPotencias);
		
		JCheckBox checkBoxPot6 = new JCheckBox("2.2");
		checkBoxPot6.setBounds(285, 403, 50, 14);
		contentPanel.add(checkBoxPot6);
		checkBoxPots.add(checkBoxPot6);
		
		JCheckBox checkBoxPot5 = new JCheckBox("2.0");
		checkBoxPot5.setBounds(229, 403, 50, 14);
		contentPanel.add(checkBoxPot5);
		checkBoxPots.add(checkBoxPot5);
		
		JCheckBox checkBoxPot4 = new JCheckBox("1.8");
		checkBoxPot4.setBounds(173, 403, 50, 14);
		contentPanel.add(checkBoxPot4);
		checkBoxPots.add(checkBoxPot4);
		
		JCheckBox checkBoxPot3 = new JCheckBox("1.6");
		checkBoxPot3.setBounds(117, 403, 50, 14);
		contentPanel.add(checkBoxPot3);
		checkBoxPots.add(checkBoxPot3);
		
		JCheckBox checkBoxPot2 = new JCheckBox("1.4");
		checkBoxPot2.setBounds(61, 403, 50, 14);
		contentPanel.add(checkBoxPot2);
		checkBoxPots.add(checkBoxPot2);
		
		JCheckBox checkBoxPot1 = new JCheckBox("1.0 ");
		checkBoxPot1.setBounds(5, 403, 50, 14);
		contentPanel.add(checkBoxPot1);
		checkBoxPots.add(checkBoxPot1);
		
		JButton btnNewButton = new JButton("Adicionar Modelo");
		btnNewButton.setBackground(new Color(59, 89, 182));
		btnNewButton.setForeground(Color.white);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<Float> potencias = new ArrayList<Float>();
				try {
					int k = 0;
						for (int i = 0; i<checkBoxPots.size(); i++) {
							if (checkBoxPots.get(i).isSelected()) {
								potencias.add(Float.parseFloat(checkBoxPots.get(i).getText()));
								k++;
							}
						}
					if (k == 0)	JOptionPane.showMessageDialog(null, "Voce deve selecionar pelo menos uma potencia", null, JOptionPane.ERROR_MESSAGE);
					else {
					produtosModelosCompativeis.add(new Compatibilidade(comboBoxModelo.getSelectedItem().toString(), comboBoxMarca.getSelectedItem().toString(),potencias));
					comboBoxModelosCom.removeAllItems();
					for(int i=0; i<produtosModelosCompativeis.size(); i++) comboBoxModelosCom.addItem(produtosModelosCompativeis.get(i).getMarca()+" - " + produtosModelosCompativeis.get(i).getModelo());
					}
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null,ex.toString(), null, JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
			});
		btnNewButton.setBounds(80, 430, 175, 25);
		contentPanel.add(btnNewButton);

		JButton btnAdicionarProduto = new JButton("Adicionar Produto");
		btnAdicionarProduto.setBackground(new Color(59, 89, 182));
		btnAdicionarProduto.setForeground(Color.white);
		btnAdicionarProduto.setBounds(75, 520, 200, 40);
		contentPanel.add(btnAdicionarProduto);
		
		btnAdicionarProduto.addActionListener(new ActionListener() {
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
					if(textRendimento.getText().equals("")) {
						p.setRendimento(Integer.parseInt(textRendimento.getText()));
					}
					if(textValidade.getText().equals("")) {
						p.setValidade(Integer.parseInt(textValidade.getText()));
					}
					
					for (int i = 0; i<produtosModelosCompativeis.size(); i++) {
						p.addModeloCompativel(produtosModelosCompativeis.get(i));
					}
					
					produtos.add(p);
					
					JOptionPane.showMessageDialog(null, "PRODUTO ADICIONADO COM SUCESSO",  null, JOptionPane.INFORMATION_MESSAGE);				
					dispose();
				}catch(NumberFormatException ex){
					JOptionPane.showMessageDialog(null, ex.toString(), null, JOptionPane.ERROR_MESSAGE);
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex.toString(), null, JOptionPane.ERROR_MESSAGE);
				}
				}
			
		});
		
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
				}
	}
}
