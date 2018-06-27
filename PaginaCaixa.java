import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollBar;

public class PaginaCaixa extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtR;
	private FuncoesPrint print = new FuncoesPrint();

	public PaginaCaixa(Empresa empresa, Funcionario funcionario) {
		setTitle("Caixa");
        setModalityType(DEFAULT_MODALITY_TYPE);
        setBounds(100, 100, 450, 450);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblValorNoCaixa = new JLabel("Valor no Caixa:");
		lblValorNoCaixa.setFont(new Font("Dialog", Font.BOLD, 16));
		lblValorNoCaixa.setBounds(110, 19, 138, 17);
	
		
		{
			txtR = new JTextField();
			txtR.setHorizontalAlignment(SwingConstants.CENTER);
			txtR.setBackground(Color.WHITE);
			txtR.setEditable(false);
			txtR.setFont(new Font("Dialog", Font.PLAIN, 16));
			txtR.setBounds(249, 12, 110, 30);
			txtR.setColumns(10);
			DecimalFormat df = new DecimalFormat("0.00");
			txtR.setText("R$"+df.format(empresa.getCaixa()));
		}		
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(15, 97, 400, 276);
		textPane.setText(print.imprimeEncerrante(empresa, funcionario));
		
		JScrollPane scroll = new JScrollPane(textPane, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setBounds(12, 97, 423, 276);
		
		JButton btnRetirada = new JButton("Fazer Retirada");
		btnRetirada.setBackground(new Color(59, 89, 182));
		btnRetirada.setForeground(Color.white);
		btnRetirada.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				PaginaRetirada retirada = new PaginaRetirada(empresa);
				retirada.setVisible(true);
				dispose();
			}
		});
		btnRetirada.setBounds(125, 55, 200, 30);
		
		contentPanel.add(lblValorNoCaixa);
		contentPanel.add(txtR);
		contentPanel.add(scroll);
		contentPanel.add(btnRetirada);
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Voltar");
				
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
