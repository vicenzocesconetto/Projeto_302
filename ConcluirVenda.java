import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class ConcluirVenda extends JDialog {

	private final JPanel contentPanel = new JPanel();

	public ConcluirVenda(Venda venda) {
		setTitle("Concluir Venda");
		contentPanel.setLayout(null);
        setModalityType(DEFAULT_MODALITY_TYPE);
        setBounds(100, 100, 450, 300);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(101, 17, 75, 25);
		DecimalFormat df = new DecimalFormat("0.00");
		textPane.setText("R$"+df.format(venda.getTotal()));
			
		JLabel lblValorTotal = new JLabel("Valor Total:");
		lblValorTotal.setBounds(12, 22, 107, 15);
			
		JLabel lblDefinirFormaDe = new JLabel("Definir forma de pagamento:");
		lblDefinirFormaDe.setBounds(12, 56, 228, 15);
		
		JRadioButton rdbtnDinheiro = new JRadioButton("Dinheiro");
		rdbtnDinheiro.setBounds(12, 79, 149, 23);
		
		JRadioButton rdbtnVisaCredito = new JRadioButton("Visa Credito");
		rdbtnVisaCredito.setBounds(12, 106, 179, 23);
		
		JRadioButton rdbtnVisaDebito = new JRadioButton("Visa Debito");
		rdbtnVisaDebito.setBounds(12, 133, 149, 23);
		
		JRadioButton rdbtnMastercardCrdito = new JRadioButton("MasterCard Credito");
		rdbtnMastercardCrdito.setBounds(12, 159, 179, 23);
		
		JRadioButton rdbtnMastercardDebito = new JRadioButton("MasterCard Debito");
		rdbtnMastercardDebito.setBounds(12, 186, 179, 23);
		
		contentPanel.add(lblValorTotal);
		contentPanel.add(textPane);
		contentPanel.add(lblDefinirFormaDe);
		contentPanel.add(rdbtnVisaDebito);
		contentPanel.add(rdbtnDinheiro);
		contentPanel.add(rdbtnVisaCredito);
		contentPanel.add(rdbtnMastercardCrdito);
		contentPanel.add(rdbtnMastercardDebito);
		
		ButtonGroup grupo = new ButtonGroup();
		grupo.add(rdbtnMastercardDebito);
		grupo.add(rdbtnMastercardCrdito);
		grupo.add(rdbtnVisaDebito);
		grupo.add(rdbtnVisaCredito);
		grupo.add(rdbtnDinheiro);
		
		
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
				JButton okButton = new JButton("Avançar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(rdbtnMastercardDebito.isSelected()) {
							venda.setFormaPagamento(FormaPagamento.MASTERCARD_DEBITO);
							VendaConcluida concluir = new VendaConcluida(venda);
							concluir.setVisible(true);
							dispose();
						}
						else if(rdbtnMastercardCrdito.isSelected()) {
							venda.setFormaPagamento(FormaPagamento.MASTERCARD_CREDITO);
							VendaConcluida concluir = new VendaConcluida(venda);
							concluir.setVisible(true);
							dispose();
						}else if(rdbtnVisaCredito.isSelected()) {
							venda.setFormaPagamento(FormaPagamento.VISA_CREDITO);
							VendaConcluida concluir = new VendaConcluida(venda);
							concluir.setVisible(true);
							dispose();
						}else if(rdbtnVisaDebito.isSelected()) {
							venda.setFormaPagamento(FormaPagamento.VISA_DEBITO);
							VendaConcluida concluir = new VendaConcluida(venda);
							concluir.setVisible(true);
							dispose();
						}else if(rdbtnDinheiro.isSelected()) {
							venda.setFormaPagamento(FormaPagamento.DINHEIRO);
							VendaConcluida concluir = new VendaConcluida(venda);
							concluir.setVisible(true);
							dispose();
						}else {
							JOptionPane.showMessageDialog(null, "Selecione uma forma de pagamento!", null, JOptionPane.ERROR_MESSAGE);
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
