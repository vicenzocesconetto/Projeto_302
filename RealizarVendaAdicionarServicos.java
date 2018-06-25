import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class RealizarVendaAdicionarServicos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JComboBox comboBoxServicos;
	
	public RealizarVendaAdicionarServicos(ArrayList<Servico> servicos){
		setTitle("Adicionar Servico");
	    contentPanel.setLayout(null);
	    
	    setModalityType(DEFAULT_MODALITY_TYPE);
	    setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
	    {
			JLabel lblEntreComO = new JLabel("Entre com o nome do servico:");
			lblEntreComO.setBounds(12, 12, 214, 15);
			contentPanel.add(lblEntreComO);
		}
	
	    comboBoxServicos = new JComboBox();
	    comboBoxServicos.setBounds(22, 42, 383, 24);
		contentPanel.add(comboBoxServicos);
		
		for(int i=0; i<servicos.size(); i++) {				
			comboBoxServicos.addItem(servicos.get(i).getNome());
		}	
       
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(12, 78, 416, 72);
		contentPanel.add(textPane);
		
		ActionListener comboBoxSelect = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int comboSelected = comboBoxServicos.getSelectedIndex();
				String str = "Nome: " + servicos.get(comboSelected).getNome() + "\n";
				str += "Valor: R$" + servicos.get(comboSelected).getValor();
				textPane.setText(str);
			}
		};			
		comboBoxServicos.addActionListener(comboBoxSelect);
			
		{
			JLabel lblEntreComO = new JLabel("Entre com o nome do servico:");
			lblEntreComO.setBounds(12, 12, 214, 15);
			contentPanel.add(lblEntreComO);
		}

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
