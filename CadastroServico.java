import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroServico extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	private JTextField textFieldNome;
	private JTextField textFieldValor;

	public CadastroServico(ArrayList<Servico> servicos) {
		setTitle("Cadastrar Serviço");
		getContentPane().setLayout(null);
		contentPanel.setLayout(null);
		setBounds(100, 100, 320, 260);
				
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 189, 320, 35);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				cancelButton.setBackground(new Color(59, 89, 182));
				cancelButton.setForeground(Color.white);
				buttonPane.add(cancelButton);
			}
		}
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(137, 24, 150, 25);
		getContentPane().add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldValor = new JTextField();
		textFieldValor.setBounds(137, 59, 80, 25);
		getContentPane().add(textFieldValor);
		textFieldValor.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(83, 29, 50, 15);
		getContentPane().add(lblNome);
		
		JLabel lblValorR = new JLabel("Valor: R$");
		lblValorR.setBounds(63, 64, 70, 15);
		getContentPane().add(lblValorR);
		
		JCheckBox chckbxRetorno = new JCheckBox("Serviço Ciclico");
		chckbxRetorno.setBounds(95, 92, 129, 23);
		getContentPane().add(chckbxRetorno);
		
		JButton btnAdicionarServio = new JButton("Adicionar Serviço");
		btnAdicionarServio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textFieldNome.getText().equals("") || textFieldValor.getText().equals("")) JOptionPane.showMessageDialog(null, "NENHUM campo pode estar vazio", null, JOptionPane.ERROR_MESSAGE);
				else {
				try{
					Servico s = new Servico(textFieldNome.getText(), Float.parseFloat(textFieldValor.getText()), chckbxRetorno.isSelected());
					servicos.add(s);
					JOptionPane.showMessageDialog(null, "SERVICO ADICIONADO COM SUCESSO",  null, JOptionPane.INFORMATION_MESSAGE);
					dispose();
				}catch(NumberFormatException ex){
					JOptionPane.showMessageDialog(null, ex.toString(), null, JOptionPane.ERROR_MESSAGE);
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex.toString(), null, JOptionPane.ERROR_MESSAGE);
				}
				}
			}
		});
		btnAdicionarServio.setBounds(70, 137, 180, 40);
		btnAdicionarServio.setBackground(new Color(59, 89, 182));
		btnAdicionarServio.setForeground(Color.white);
		getContentPane().add(btnAdicionarServio);
		
		
	}
}
