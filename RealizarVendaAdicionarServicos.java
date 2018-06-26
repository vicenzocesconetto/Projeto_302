import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class RealizarVendaAdicionarServicos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JComboBox comboBoxServicos;
	private JComboBox comboBoxCarros;
	
	public RealizarVendaAdicionarServicos(Venda venda, ArrayList<Servico> servicos){
		setTitle("Adicionar Servico");
		contentPanel.setLayout(null);
        setModalityType(DEFAULT_MODALITY_TYPE);
        setBounds(100, 100, 450, 300);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		
		//DEFINE LABEL: ENTRE COM O NOME
		JLabel lblEntreComO = new JLabel("Entre com o nome do servico:");
		lblEntreComO.setBounds(12, 12, 214, 15);
		
		//DEFINE O COMBOBOX	
	    comboBoxServicos = new JComboBox();
	    comboBoxServicos.setBounds(22, 42, 383, 24);
		
		
		for(int i=0; i<servicos.size(); i++) {				
			comboBoxServicos.addItem(servicos.get(i).getNome());
		}	
       
		//DEFINE O JTEXT PANE
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(12, 78, 416, 72);
	
		ActionListener comboBoxSelect = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int comboSelected = comboBoxServicos.getSelectedIndex();
				String str = "Nome: " + servicos.get(comboSelected).getNome() + "\n";
				str += "Valor: R$" + servicos.get(comboSelected).getValor();
				textPane.setText(str);
			}
		};			
		comboBoxServicos.addActionListener(comboBoxSelect);
			
		JLabel lblVeiculo = new JLabel("Veiculo");
		lblVeiculo.setBounds(12, 162, 70, 15);
		
		//DEFINE O COMBOBOX	
		comboBoxCarros = new JComboBox();
		comboBoxCarros.setBounds(22, 186, 383, 24);
		
		
		for(int i=0; i<servicos.size(); i++) {				
			comboBoxCarros.addItem(venda.getCliente().getVeiculos().get(i).getMarca()+" - " + venda.getCliente().getVeiculos().get(i).getModelo()+" - " + venda.getCliente().getVeiculos().get(i).getPotencia() );
		}	
		
		//ADICIONA A TELA
				contentPanel.add(lblEntreComO);
				contentPanel.add(comboBoxServicos);
				contentPanel.add(textPane);
				contentPanel.add(lblVeiculo);
				contentPanel.add(comboBoxCarros);
		
		//BOTOES
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			//BOTAO CANCELAR
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
			//BOTAO ADICIONAR
			{
				JButton okButton = new JButton("Adicionar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int comboSelected = comboBoxServicos.getSelectedIndex();
						
						venda.addServico(servicos.get(comboSelected));
						
						comboSelected = comboBoxCarros.getSelectedIndex();
						
						venda.addVeiculo(venda.getCliente().getVeiculos().get(comboSelected));
						
						JOptionPane.showMessageDialog(null, "Servico Adicionado", null, JOptionPane.INFORMATION_MESSAGE);
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
