import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class CadastroVeiculo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JComboBox comboBoxMarca;
	private JComboBox comboBoxModelo;
	private JTextField textFieldPLacaA;
	private JTextField textFieldPLacaB;
	private JTextField textFieldFab;
	private JTextField textFieldModelo;
	private JTextField textFieldKm;
	
	private Funcoes funcoes = new Funcoes();
	
	private ArrayList<Modelos> carros = funcoes.carregaModelos("/home/greenseiya/eclipse-workspace/Oficina/src/dados/marcas-carros.txt", "/home/greenseiya/eclipse-workspace/Oficina/src/dados/modelos-carro.txt");
	private ArrayList<Modelos> motos = funcoes.carregaModelos("/home/greenseiya/eclipse-workspace/Oficina/src/dados/marcas-motos.txt", "/home/greenseiya/eclipse-workspace/Oficina/src/dados/modelos-moto.txt");
	private ArrayList<Modelos> caminhoes = funcoes.carregaModelos("/home/greenseiya/eclipse-workspace/Oficina/src/dados/marcas-caminhao.txt", "/home/greenseiya/eclipse-workspace/Oficina/src/dados/modelos-caminhao.txt");
	
	private ArrayList<Modelos> modelos;
	
	public CadastroVeiculo(ArrayList<Veiculo> veiculos) {
		setTitle("Cadastrar Veiculo");
        setModalityType(DEFAULT_MODALITY_TYPE);
        setBounds(100, 100, 350, 375);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		//BOTAO RADIAL
		JLabel lblTipo = new JLabel("Tipo de Veiculo:");
		lblTipo.setBounds(12, 12, 112, 28);
		contentPanel.add(lblTipo);
		
		JRadioButton rdbtnCarro = new JRadioButton("Carro");
		rdbtnCarro.setBounds(27, 37, 70, 20);
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
		rdbtnMoto.setBounds(124, 37, 70, 20);
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
		rdbtnCaminho.setBounds(221, 37, 100, 20);
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
		lblModelo.setBounds(12, 118, 60, 29);
		contentPanel.add(lblModelo);
				
		comboBoxModelo = new JComboBox();
		comboBoxModelo.setBounds(9, 145, 320, 25);
		contentPanel.add(comboBoxModelo);
				
		//MARCA
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setBounds(12, 65, 60, 29);
		contentPanel.add(lblMarca);
		
		comboBoxMarca = new JComboBox();
		comboBoxMarca.setBounds(9, 93, 320, 25);
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
		
		JLabel lblPotencia = new JLabel("Potencia:");
		lblPotencia.setBounds(12, 240, 79, 29);
		contentPanel.add(lblPotencia);
		
		JLabel lblPlaca = new JLabel("Placa:");
		lblPlaca.setBounds(12, 182, 60, 20);
		contentPanel.add(lblPlaca);
		
		JLabel lblAnoFabricacao = new JLabel("Ano de Fabricacao:");
		lblAnoFabricacao.setBounds(12, 211, 140, 20);
		contentPanel.add(lblAnoFabricacao);
		
		JLabel lblAnoDeModelo = new JLabel(" / Modelo:");
		lblAnoDeModelo.setBounds(207, 211, 80, 20);
		contentPanel.add(lblAnoDeModelo);
		
		JLabel lblQuilometragem = new JLabel("Quilometragem:");
		lblQuilometragem.setBounds(12, 275, 120, 20);
		contentPanel.add(lblQuilometragem);
		
		textFieldPLacaA = new JTextField();
		textFieldPLacaA.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldPLacaA.setBounds(66, 180, 45, 25);
		contentPanel.add(textFieldPLacaA);
		textFieldPLacaA.setColumns(10);
		
		textFieldPLacaB = new JTextField();
		textFieldPLacaB.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldPLacaB.setBounds(120, 180, 60, 25);
		contentPanel.add(textFieldPLacaB);
		textFieldPLacaB.setColumns(10);
		
		textFieldFab = new JTextField();
		textFieldFab.setBounds(148, 209, 60, 25);
		contentPanel.add(textFieldFab);
		textFieldFab.setColumns(10);
		
		textFieldModelo = new JTextField();
		textFieldModelo.setBounds(278, 209, 60, 25);
		contentPanel.add(textFieldModelo);
		textFieldModelo.setColumns(10);
		
		JComboBox comboBoxPot = new JComboBox();
		comboBoxPot.setBounds(86, 242, 79, 24);
		contentPanel.add(comboBoxPot);
		comboBoxPot.addItem("1.0");
		comboBoxPot.addItem("1.4");
		comboBoxPot.addItem("1.6");
		comboBoxPot.addItem("1.8");
		comboBoxPot.addItem("2.0");
		comboBoxPot.addItem("2.2");
		
		
		textFieldKm = new JTextField();
		textFieldKm.setBounds(133, 273, 114, 25);
		contentPanel.add(textFieldKm);
		textFieldKm.setColumns(10);
		
		
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
						int comboSelectMarca = comboBoxMarca.getSelectedIndex();
						int comboSelectModelo = comboBoxModelo.getSelectedIndex();
						
						if(rdbtnMoto.isSelected()) {
							try {
							veiculos.add(new Veiculo(TipoVeiculo.MOTO, motos.get(comboSelectMarca).getNome(), motos.get(comboSelectMarca).getModelos().get(comboSelectModelo) , textFieldPLacaA.getText()+"-"+textFieldPLacaB.getText(), Integer.parseInt(textFieldFab.getText()), Integer.parseInt(textFieldModelo.getText()), Integer.parseInt(textFieldKm.getText()), Float.parseFloat(comboBoxPot.getSelectedItem().toString())));							
							JOptionPane.showMessageDialog(null, "Veiculo Cadastrado", null, JOptionPane.INFORMATION_MESSAGE);
							}catch(Exception e1) {
								JOptionPane.showMessageDialog(null, "Erro ao cadastrar veiculo!", null, JOptionPane.ERROR_MESSAGE);
							}
						}
						else if(rdbtnCarro.isSelected()) {
							try {
							veiculos.add(new Veiculo(TipoVeiculo.CARRO, carros.get(comboSelectMarca).getNome(), carros.get(comboSelectMarca).getModelos().get(comboSelectModelo) , textFieldPLacaA.getText()+"-"+textFieldPLacaB.getText(), Integer.parseInt(textFieldFab.getText()), Integer.parseInt(textFieldModelo.getText()), Integer.parseInt(textFieldKm.getText()), Float.parseFloat(comboBoxPot.getSelectedItem().toString())));							
							JOptionPane.showMessageDialog(null, "Veiculo Cadastrado", null, JOptionPane.INFORMATION_MESSAGE);
							}catch(Exception e2) {
								JOptionPane.showMessageDialog(null, "Erro ao cadastrar veiculo!", null, JOptionPane.ERROR_MESSAGE);
							}
						}
						else if(rdbtnCaminho.isSelected()) {
							try {
							veiculos.add(new Veiculo(TipoVeiculo.CAMINHAO, caminhoes.get(comboSelectMarca).getNome(), caminhoes.get(comboSelectMarca).getModelos().get(comboSelectModelo) , textFieldPLacaA.getText()+"-"+textFieldPLacaB.getText(), Integer.parseInt(textFieldFab.getText()), Integer.parseInt(textFieldModelo.getText()), Integer.parseInt(textFieldKm.getText()), Float.parseFloat(comboBoxPot.getSelectedItem().toString())));							
							JOptionPane.showMessageDialog(null, "Veiculo Cadastrado", null, JOptionPane.INFORMATION_MESSAGE);
							}catch(Exception e3) {
								JOptionPane.showMessageDialog(null, "Erro ao cadastrar veiculo!", null, JOptionPane.ERROR_MESSAGE);
							}
						}
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
