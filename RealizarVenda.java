import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.JCheckBox;

public class RealizarVenda extends JDialog {
	
	private JComboBox comboBoxClientes;

	private final JPanel contentPanel = new JPanel();
	private final JButton btnAvancar = new JButton("Avançar");
	private final JLabel lblPesquisa = new JLabel("Entre com o nome do cliente:");
	private final JButton btnCadastrarCliente = new JButton("Cadastrar cliente");
	private final JLabel lblSelecioneOVeiculo = new JLabel("Selecione o Veiculo do Cliente");
	private final JCheckBox chckbxNoInformarVeiculo = new JCheckBox("Não informar veiculo");

	public RealizarVenda(Empresa empresa, Funcionario funcionario, ArrayList<Cliente> clientes, ArrayList<Servico> servicos,ArrayList<Produto> produtos) {
		setTitle("NOVA VENDA");
        contentPanel.setLayout(null);
        setModalityType(DEFAULT_MODALITY_TYPE);
        setBounds(100, 100, 440, 390);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
        
        //DEFINE O TAMANHO DA LABEL: ENTRE COM O NOME...
        lblPesquisa.setBounds(12, 15, 205, 15);
        
        //DEFINE AS COMBOBOX
        comboBoxClientes = new JComboBox();
        comboBoxClientes.setBounds(22, 42, 383, 24);
				
		for(int i=0; i<clientes.size(); i++) {				
			comboBoxClientes.addItem(clientes.get(i).getNome());
		}
		
		//DEFINE O COMBOBOX	
		JComboBox comboBoxCarros = new JComboBox();
		comboBoxCarros.setBounds(22, 255, 383, 24);
				
	    //DEFINE O JTEXTPANE
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(12, 78, 416, 138);
		
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
				comboBoxCarros.removeAllItems();
				for(int i=0; i<clientes.get(comboSelected).getVeiculos().size(); i++) {
					comboBoxCarros.addItem(clientes.get(comboSelected).getVeiculos().get(i).getMarca()+" - " + clientes.get(comboSelected).getVeiculos().get(i).getModelo()+" - " + clientes.get(comboSelected).getVeiculos().get(i).getPotencia() );
				}
			}
		};			
		comboBoxClientes.addActionListener(comboBoxSelect);
		
        
		contentPanel.add(lblPesquisa);
		contentPanel.add(comboBoxClientes);
		contentPanel.add(comboBoxCarros);
		contentPanel.add(textPane);
		lblSelecioneOVeiculo.setBounds(12, 228, 255, 15);
		
		contentPanel.add(lblSelecioneOVeiculo);
		chckbxNoInformarVeiculo.setBounds(22, 290, 170, 23);
		
		contentPanel.add(chckbxNoInformarVeiculo);
		
		
		//BOTOES DA BASE
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			btnCadastrarCliente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					CadastroCliente cCliente = new CadastroCliente(clientes);
					cCliente.setVisible(true);
					dispose();
				}
			});
			
			//BOTAO CADASTRAR NOVO CLIENTE
			buttonPane.add(btnCadastrarCliente);
			btnCadastrarCliente.setBackground(new Color(59, 89, 182));
			btnCadastrarCliente.setForeground(Color.white);
			
			//BOTAO AVANCAR
			buttonPane.add(btnAvancar);
			btnAvancar.setBackground(new Color(59, 89, 182));
			btnAvancar.setForeground(Color.white);
			btnAvancar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int comboSelected = comboBoxClientes.getSelectedIndex();
					Venda venda = new Venda(clientes.get(comboSelected), funcionario.getNome(), empresa);
					
					if(!chckbxNoInformarVeiculo.isSelected()) {
					venda.addVeiculo(clientes.get(comboSelected).getVeiculos().get(comboBoxCarros.getSelectedIndex()));
					}
					setVisible(false);
					RealizarVendaMenu menu = new RealizarVendaMenu(venda, servicos, produtos);
					menu.setVisible(true);
					dispose();
				}
			});
		}
	}
}
