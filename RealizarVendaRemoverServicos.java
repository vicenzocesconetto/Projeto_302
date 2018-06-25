import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class RealizarVendaRemoverServicos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JComboBox comboBoxServicos;
	
	public RealizarVendaRemoverServicos(Venda venda) {
		setTitle("Remover Servico");
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
		
		
		for(int i=0; i<venda.getServicos().size(); i++) {				
			comboBoxServicos.addItem(venda.getServicos().get(i).getNome());
		}	
       
		//DEFINE O JTEXT PANE
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(12, 78, 416, 72);
	
		ActionListener comboBoxSelect = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int comboSelected = comboBoxServicos.getSelectedIndex();
				String str = "Nome: " + venda.getServicos().get(comboSelected).getNome() + "\n";
				str += "Valor: R$" + venda.getServicos().get(comboSelected).getValor() + "\n";
				textPane.setText(str);
			}
		};			
		comboBoxServicos.addActionListener(comboBoxSelect);
			
		//ADICIONA A TELA
		contentPanel.add(lblEntreComO);
		contentPanel.add(comboBoxServicos);
		contentPanel.add(textPane);
		
		
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
						int comboSelected = comboBoxServicos.getSelectedIndex();
						venda.removeServico(comboSelected);
						JOptionPane.showMessageDialog(null, "Servico Removido", null, JOptionPane.INFORMATION_MESSAGE);
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
