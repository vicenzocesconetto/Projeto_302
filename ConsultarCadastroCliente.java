import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultarCadastroCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private final JLabel lblPesquisa = new JLabel("Entre com o nome do cliente:");
	private JComboBox comboBoxClientes;
	private JTextField textFieldNome;
	private JTextField textFieldTelefone;
	private JTextField textFieldEmail;
	private JTextField textFieldRua;
	private JTextField textFieldN;
	private JTextField textFieldBairro;
	private JTextField textFieldCidade;
	private JTextField textFieldUF;
	private ArrayList<Veiculo> cadastrarVeiculo= new ArrayList<Veiculo>();

	public ConsultarCadastroCliente(ArrayList<Cliente> clientes) {
		setTitle("Consultar/Atualizar Estoque de Clientes");
        contentPanel.setLayout(null);
        setModalityType(DEFAULT_MODALITY_TYPE);
        setBounds(100, 100, 450, 408);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
        
        //DEFINE O TAMANHO DA LABEL: ENTRE COM O NOME...
        lblPesquisa.setBounds(12, 15, 205, 15);
        
        //DEFINE AS COMBOBOX
        comboBoxClientes = new JComboBox();
        comboBoxClientes.setBounds(22, 42, 383, 24);
		
        //DEFINE O COMBOBOX	
  		JComboBox comboBoxCarros = new JComboBox();
  		comboBoxCarros.setBounds(33, 252, 383, 24);
        
		for(int i=0; i<clientes.size(); i++) {				
			comboBoxClientes.addItem(clientes.get(i).getNome());
		}
		
		//CAMPOS DO CADASTRO		
		{
			JLabel lblNome = new JLabel("Nome:");
			lblNome.setBounds(35, 88, 45, 15);
			contentPanel.add(lblNome);
		}
		{
			textFieldNome = new JTextField();
			textFieldNome.setBounds(92, 86, 114, 19);
			contentPanel.add(textFieldNome);
			textFieldNome.setColumns(10);
		}
		
		{
			JLabel lblTelefone = new JLabel("Telefone:");
			lblTelefone.setBounds(12, 111, 73, 15);
			contentPanel.add(lblTelefone);
		}
		{
			textFieldTelefone = new JTextField();
			textFieldTelefone.setBounds(92, 109, 114, 19);
			contentPanel.add(textFieldTelefone);
			textFieldTelefone.setColumns(10);
		}
		
		{
			JLabel lblEmail = new JLabel("e-mail:");
			lblEmail.setBounds(31, 134, 54, 15);
			contentPanel.add(lblEmail);
		}
		{
			textFieldEmail = new JTextField();
			textFieldEmail.setBounds(92, 132, 114, 19);
			contentPanel.add(textFieldEmail);
			textFieldEmail.setColumns(10);
		}
		
		{
			JLabel lblRua = new JLabel("Rua:");
			lblRua.setBounds(224, 88, 70, 15);
			contentPanel.add(lblRua);
		}
		{
			JLabel lblN = new JLabel("N.:");
			lblN.setBounds(224, 115, 70, 15);
			contentPanel.add(lblN);
		}
		{
			JLabel lblBairro = new JLabel("Bairro:");
			lblBairro.setBounds(224, 142, 70, 15);
			contentPanel.add(lblBairro);
		}
		{
			JLabel lblCidade = new JLabel("Cidade:");
			lblCidade.setBounds(220, 169, 70, 15);
			contentPanel.add(lblCidade);
		}
		{
			JLabel lblUf = new JLabel("UF:");
			lblUf.setBounds(224, 196, 70, 15);
			contentPanel.add(lblUf);
		}
		{
			textFieldRua = new JTextField();
			textFieldRua.setBounds(277, 86, 114, 19);
			contentPanel.add(textFieldRua);
			textFieldRua.setColumns(10);
		}
		{
			textFieldN = new JTextField();
			textFieldN.setBounds(277, 109, 114, 19);
			contentPanel.add(textFieldN);
			textFieldN.setColumns(10);
		}
		{
			textFieldBairro = new JTextField();
			textFieldBairro.setBounds(277, 140, 114, 19);
			contentPanel.add(textFieldBairro);
			textFieldBairro.setColumns(10);
		}
		{
			textFieldCidade = new JTextField();
			textFieldCidade.setBounds(277, 167, 114, 19);
			contentPanel.add(textFieldCidade);
			textFieldCidade.setColumns(10);
		}
		{
			textFieldUF = new JTextField();
			textFieldUF.setBounds(277, 194, 114, 19);
			contentPanel.add(textFieldUF);
			textFieldUF.setColumns(10);
		}
		
				
		ActionListener comboBoxSelect = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int comboSelected = comboBoxClientes.getSelectedIndex();
				
				comboBoxCarros.removeAllItems();
				for(int i=0; i<clientes.get(comboBoxClientes.getSelectedIndex()).getVeiculos().size(); i++) {
					comboBoxCarros.addItem(clientes.get(comboBoxClientes.getSelectedIndex()).getVeiculos().get(i).getMarca()+" - " + clientes.get(comboBoxClientes.getSelectedIndex()).getVeiculos().get(i).getModelo()+" - " + clientes.get(comboBoxClientes.getSelectedIndex()).getVeiculos().get(i).getPotencia() );
				}
				
				textFieldNome.setText(clientes.get(comboSelected).getNome());
				textFieldTelefone.setText(clientes.get(comboSelected).getTelefone());
				textFieldEmail.setText(clientes.get(comboSelected).getEmail());
				textFieldRua.setText(clientes.get(comboSelected).getEndereco().getRua());
				textFieldN.setText(clientes.get(comboSelected).getEndereco().getNumero());
				textFieldBairro.setText(clientes.get(comboSelected).getEndereco().getBairro());
				textFieldCidade.setText(clientes.get(comboSelected).getEndereco().getCidade());
				textFieldUF.setText(clientes.get(comboSelected).getEndereco().getUf());
			}
		};			
		comboBoxClientes.addActionListener(comboBoxSelect);		
		contentPanel.add(lblPesquisa);
		contentPanel.add(comboBoxClientes);
		contentPanel.add(comboBoxCarros);
			
		{
			JLabel lblVeiculos = new JLabel("Veiculos:");
			lblVeiculos.setBounds(12, 225, 70, 15);
			contentPanel.add(lblVeiculos);
		}
		{
			JButton btnAdicionarCarro = new JButton("Adicionar Carro");
			btnAdicionarCarro.setBackground(new Color(59, 89, 182));
			btnAdicionarCarro.setForeground(Color.white);
			btnAdicionarCarro.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cadastrarVeiculo.clear();
					CadastroVeiculo cVeiculo = new CadastroVeiculo(cadastrarVeiculo);
					cVeiculo.setVisible(true);
					clientes.get(comboBoxClientes.getSelectedIndex()).addVeiculo(cadastrarVeiculo.get(0));
					comboBoxCarros.removeAllItems();
					for(int i=0; i<clientes.get(comboBoxClientes.getSelectedIndex()).getVeiculos().size(); i++) {
						comboBoxCarros.addItem(clientes.get(comboBoxClientes.getSelectedIndex()).getVeiculos().get(i).getMarca()+" - " + clientes.get(comboBoxClientes.getSelectedIndex()).getVeiculos().get(i).getModelo()+" - " + clientes.get(comboBoxClientes.getSelectedIndex()).getVeiculos().get(i).getPotencia() );
					}
				}
			});
			btnAdicionarCarro.setBounds(224, 288, 150, 25);
			contentPanel.add(btnAdicionarCarro);
		}
		{
			JButton btnRemoverCarro = new JButton("Remover Carro");
			btnRemoverCarro.setBackground(new Color(59, 89, 182));
			btnRemoverCarro.setForeground(Color.white);
			btnRemoverCarro.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(clientes.get(comboBoxClientes.getSelectedIndex()).removeVeiculo(comboBoxCarros.getSelectedIndex())) {
						JOptionPane.showMessageDialog(null, "Veiculo Removido", null, JOptionPane.INFORMATION_MESSAGE);
					}else JOptionPane.showMessageDialog(null, "Erro ao remover o veiculo", null, JOptionPane.ERROR_MESSAGE);
					comboBoxCarros.removeAllItems();
					for(int i=0; i<clientes.get(comboBoxClientes.getSelectedIndex()).getVeiculos().size(); i++) {
						comboBoxCarros.addItem(clientes.get(comboBoxClientes.getSelectedIndex()).getVeiculos().get(i).getMarca()+" - " + clientes.get(comboBoxClientes.getSelectedIndex()).getVeiculos().get(i).getModelo()+" - " + clientes.get(comboBoxClientes.getSelectedIndex()).getVeiculos().get(i).getPotencia() );
					}
				}
			});
			btnRemoverCarro.setBounds(67, 288, 150, 25);
			contentPanel.add(btnRemoverCarro);
		}
		
		//BOTOES BASE			
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cancelar");
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
			{
				JButton okButton = new JButton("Salvar");
				okButton.setBackground(new Color(59, 89, 182));
				okButton.setForeground(Color.white);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int comboSelected = comboBoxClientes.getSelectedIndex();
						clientes.get(comboSelected).setNome(textFieldNome.getText());
						clientes.get(comboSelected).setTelefone(textFieldTelefone.getText());
						clientes.get(comboSelected).setEmail(textFieldEmail.getText());
						clientes.get(comboSelected).getEndereco().setRua(textFieldRua.getText());
						clientes.get(comboSelected).getEndereco().setNumero(textFieldN.getText());
						clientes.get(comboSelected).getEndereco().setBairro(textFieldBairro.getText());
						clientes.get(comboSelected).getEndereco().setCidade(textFieldCidade.getText());
						clientes.get(comboSelected).getEndereco().setUf(textFieldUF.getText());
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
