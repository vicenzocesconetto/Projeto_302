import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToggleButton;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JEditorPane;
import javax.swing.JTextPane;

public class RealizarVenda extends JDialog {
	
	private JComboBox comboBoxClientes;

	private final JPanel contentPanel = new JPanel();
	private final JButton btnAvancar = new JButton("Avançar");
	private final JLabel lblPesquisa = new JLabel("Entre com o nome do cliente:");
	private final JButton btnCadastrarCliente = new JButton("Cadastrar cliente");

	public RealizarVenda(Empresa empresa, ArrayList<Cliente> clientes, ArrayList<Servico> servicos,ArrayList<Produto> produtos) {
		setTitle("NOVA VENDA");
        contentPanel.setLayout(null);
        setModalityType(DEFAULT_MODALITY_TYPE);
        lblPesquisa.setBounds(12, 15, 205, 15);
        
        contentPanel.add(lblPesquisa);

        comboBoxClientes = new JComboBox();
        comboBoxClientes.setBounds(22, 42, 383, 24);
		contentPanel.add(comboBoxClientes);
		
		for(int i=0; i<clientes.size(); i++) {				
			comboBoxClientes.addItem(clientes.get(i).getNome());
		}	
       
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(12, 78, 416, 127);
		contentPanel.add(textPane);
		
		ActionListener comboBoxSelect = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int comboSelected = comboBoxClientes.getSelectedIndex();
				 String str = "Nome: " + clientes.get(comboSelected).getNome() + "\n";
						str += "Telefone: " + clientes.get(comboSelected).getTelefone() + "\n";
						str += "Email: " + clientes.get(comboSelected).getEmail() + "\n";
						str += "\nEndereco\n";
						str += "Rua: " + clientes.get(comboSelected).getEndereco().getRua();
						str += "\tNumero: " + clientes.get(comboSelected).getEndereco().getNumero() + "\n";
						str += "Bairro: " + clientes.get(comboSelected).getEndereco().getBairro();
						str += "\tCidade: " + clientes.get(comboSelected).getEndereco().getCidade();
						str += "\tUF: " + clientes.get(comboSelected).getEndereco().getUf() + "\n"; 
				textPane.setText(str);
			}
		};			
		comboBoxClientes.addActionListener(comboBoxSelect);
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			buttonPane.add(btnCadastrarCliente);
			
			buttonPane.add(btnAvancar);
		}
	}
}
