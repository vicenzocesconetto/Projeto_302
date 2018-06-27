import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextArea;

public class RetornoCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Funcoes funcoes = new Funcoes();

	@SuppressWarnings("deprecation")
	public RetornoCliente(ArrayList<Cliente> clientes) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(12, 12, 426, 211);
		contentPanel.add(textArea);
		
		Date data = new Date( System.currentTimeMillis());
		data.setDate(data.getDate()+8);
			
		String str="";
		for (int i = 0; i<clientes.size(); i++) {
			if(clientes.get(i).getRetorno()!=null) {
				
			if (data.after(clientes.get(i).getRetorno().getData())) {
				str= "Nome: " + clientes.get(i).getNome() + "\n" + "Telefone: " + clientes.get(i).getTelefone() + "\n" + "Email: " + clientes.get(i).getEmail()+"\n";
				str+= "Data de Retorno: "+ funcoes.dataFormatada(clientes.get(i).getRetorno().getData())+"\n";  
				for(int a=0;a<clientes.get(i).getRetorno().getVenda().getServicos().size();a++) {
					str+= "Serviço: "+ clientes.get(i).getRetorno().getVenda().getServicos().get(a).getNome() +"\n";
				}
				textArea.setText(str);				
			}else {
				textArea.setText("Sem clientes para retornar essa semana!");
			}
		}	
		}
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Voltar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setBackground(new Color(59, 89, 182));
				cancelButton.setForeground(Color.white);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
