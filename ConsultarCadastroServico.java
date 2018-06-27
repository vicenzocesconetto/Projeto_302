import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import javax.swing.JCheckBox;

public class ConsultarCadastroServico extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JComboBox comboBoxServicos;
	private JTextField textFieldNome;
	private JTextField textFieldValor;
	JLabel lblPesquisa = new JLabel("Entre com o nome do serviço:");

	public ConsultarCadastroServico(ArrayList<Servico> servicos) {
		setTitle("Consultar/Atualizar Estoque de Serviços");
		contentPanel.setLayout(null);
        setModalityType(DEFAULT_MODALITY_TYPE);
        setBounds(100, 100, 450, 250);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		//DEFINE O TAMANHO DA LABEL: ENTRE COM O NOME...
		lblPesquisa.setBounds(12, 12, 214, 15);
	
		//DEFINE O COMBOBOX	
	    comboBoxServicos = new JComboBox();
	    comboBoxServicos.setBounds(22, 42, 383, 24);
				
		for(int i=0; i<servicos.size(); i++) comboBoxServicos.addItem(servicos.get(i).getNome());
		
		//LABEL NOME
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(12, 90, 45, 15);
				
		textFieldNome = new JTextField();
		textFieldNome.setBounds(112, 88, 300, 19);
		contentPanel.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		//LABEL VALOR
		JLabel lblValorun = new JLabel("Valor (UN):");
		lblValorun.setBounds(12, 116, 83, 15);
						
		textFieldValor = new JTextField();
		textFieldValor.setBounds(112, 114, 114, 19);
		contentPanel.add(textFieldValor);
		textFieldValor.setColumns(10);
				
		//CHECK BOX SERVICO CICLICO
		JCheckBox chckbxServioCiclico = new JCheckBox("Serviço ciclico");
		chckbxServioCiclico.setBounds(12, 141, 129, 23);
		
			
		ActionListener comboBoxSelect = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int comboSelected = comboBoxServicos.getSelectedIndex();
				textFieldNome.setText(servicos.get(comboSelected).getNome());
				textFieldValor.setText(""+servicos.get(comboSelected).getValor());
				
				if(servicos.get(comboSelected).isRetorno())	chckbxServioCiclico.setSelected(true);
				else chckbxServioCiclico.setSelected(false); 
			}
		};			
		comboBoxServicos.addActionListener(comboBoxSelect);
		
		//ADICIONA NA TELA
		contentPanel.add(lblPesquisa);
		contentPanel.add(comboBoxServicos);
		contentPanel.add(lblNome);
		contentPanel.add(lblValorun);
		contentPanel.add(chckbxServioCiclico);
		
		//BOTOES BASE
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
			//BOTAO SALVAR
			{
				JButton okButton = new JButton("Salvar");
				okButton.setBackground(new Color(59, 89, 182));
				okButton.setForeground(Color.white);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int comboSelected = comboBoxServicos.getSelectedIndex();
						
						servicos.get(comboSelected).setNome(textFieldNome.getText());
						servicos.get(comboSelected).setValor(Float.parseFloat(textFieldValor.getText()));
						
						if(chckbxServioCiclico.isSelected())servicos.get(comboSelected).setRetorno(true);
						else servicos.get(comboSelected).setRetorno(false);
										
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
