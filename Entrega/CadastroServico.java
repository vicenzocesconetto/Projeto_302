import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class CadastroServico extends JDialog {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textValor;
	private ArrayList<JTextField> textTextosServico;
	private ArrayList<Servico> servicos;
	private JCheckBox checkBoxRetorno;
	
	public CadastroServico(ArrayList<Servico> servicos) {
		setTitle("CADASTRO SERVICO");
		this.servicos = servicos;
		this.textTextosServico = new ArrayList<JTextField>();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 284, 229);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
						
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(5, 130, 424, 0);
		contentPane.add(lblNewLabel);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(5, 8, 60, 29);
		contentPane.add(lblNome);
		
		textNome = new JTextField();
		lblNome.setLabelFor(textNome);
		textNome.setBounds(90, 12, 146, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);
		textTextosServico.add(textNome);

		JLabel lblVallor = new JLabel("Valor:");
		lblVallor.setBounds(5, 43, 79, 14);
		contentPane.add(lblVallor);
		
		textValor = new JTextField();
		lblVallor.setLabelFor(textValor);
		textValor.setColumns(10);
		textValor.setBounds(90, 40, 50, 20);
		contentPane.add(textValor);
		textTextosServico.add(textValor);

		JButton btnAdicionarProduto = new JButton("ADICIONAR SERVICO");
		
		btnAdicionarProduto.setBounds(5, 101, 252, 79);
		contentPane.add(btnAdicionarProduto);
		btnAdicionarProduto.addActionListener(new AdicionaProduto());
		
		checkBoxRetorno = new JCheckBox("Servico Ciclico");
		checkBoxRetorno.setBounds(0, 67, 126, 23);
		contentPane.add(checkBoxRetorno);

		this.setVisible(true);
	}
	
	private class AdicionaProduto implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			for (int i = 0; i< textTextosServico.size(); i++) {
				if (textTextosServico.get(i).getText().equals("")) {
					JOptionPane.showMessageDialog(null, "NENHUM campo pode estar vazio", null, JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
			try{
				Servico s = new Servico(textNome.getText(), Float.parseFloat(textValor.getText()), checkBoxRetorno.isSelected());
				servicos.add(s);
				JOptionPane.showMessageDialog(null, "SERVICO ADICIONADO COM SUCESSO",  null, JOptionPane.INFORMATION_MESSAGE);
			}catch(NumberFormatException ex){
				JOptionPane.showMessageDialog(null, ex.toString(), null, JOptionPane.ERROR_MESSAGE);
				return;
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(null, ex.toString(), null, JOptionPane.ERROR_MESSAGE);
				return;
			}
			
		}
	}
}
	
	







