import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class VendaConcluida extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	public VendaConcluida(Venda venda) {
		FuncoesPrint print = new FuncoesPrint();
		Funcoes funcoes = new Funcoes();
		
		setTitle("Venda Concluida");
		contentPanel.setLayout(null);
        setModalityType(DEFAULT_MODALITY_TYPE);
        setBounds(100, 100, 450, 300);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(10, 10, 430, 210);
		textPane.setText(print.printVenda(venda));
				
		contentPanel.add(textPane);
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
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
