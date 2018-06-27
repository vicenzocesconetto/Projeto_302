import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

public class CadastroCliente extends JDialog {
	private static final long serialVersionUID = 1L;
	private JPanel contentPanel = new JPanel();
	
	private JTextField textNome;
	private JTextField textTelefone;
	private JTextField textEmail;
	private JTextField textRua;
	private JTextField textBairro;
	private JTextField textCidade;
	private JTextField textEstado;
	private JTextField textNumero;
	
	private JComboBox comboBoxTipo;
	private JComboBox comboBoxVeiculos;
	
	private ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
		
	public CadastroCliente(ArrayList<Cliente> clientes) {
		
		setTitle("Cadastrar Cliente");
        setModalityType(DEFAULT_MODALITY_TYPE);
        setBounds(100, 100, 350, 530);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblInformacoesPessoais = new JLabel("INFORMACOES PESSOAIS");
		lblInformacoesPessoais.setBounds(79, 15, 192, 14);
		contentPanel.add(lblInformacoesPessoais);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(58, 48, 50, 15);
		contentPanel.add(lblNome);
		
		textNome = new JTextField();
		textNome.setBounds(114, 45, 180, 20);
		lblNome.setLabelFor(textNome);
		contentPanel.add(textNome);
		textNome.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(38, 76, 70, 15);
		contentPanel.add(lblTelefone);
		
		textTelefone = new JTextField();
		textTelefone.setBounds(114, 73, 146, 20);
		lblTelefone.setLabelFor(textTelefone);
		textTelefone.setColumns(10);
		contentPanel.add(textTelefone);
		
		JLabel lblEmail = new JLabel("e-mail: ");
		lblEmail.setBounds(55, 104, 53, 15);
		contentPanel.add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setBounds(114, 101, 180, 20);
		lblEmail.setLabelFor(textEmail);
		textEmail.setColumns(10);
		contentPanel.add(textEmail);
		
		JLabel lblEndereo = new JLabel("ENDERECO");
		lblEndereo.setBounds(123, 141, 103, 14);
		contentPanel.add(lblEndereo);
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setBounds(76, 173, 32, 15);
		lblRua.setLabelFor(textEmail);
		contentPanel.add(lblRua);
		
		textRua = new JTextField();
		textRua.setBounds(114, 170, 146, 20);
		textRua.setColumns(10);
		contentPanel.add(textRua);
		
		JLabel lblNumero = new JLabel("Numero:");
		lblNumero.setBounds(48, 199, 60, 15);
		contentPanel.add(lblNumero);
		
		textNumero = new JTextField();
		textNumero.setBounds(114, 196, 50, 20);
		textNumero.setColumns(10);
		contentPanel.add(textNumero);
		
		JLabel lblBairro = new JLabel("Bairro: ");
		lblBairro.setBounds(58, 225, 52, 15);
		contentPanel.add(lblBairro);
		
		textBairro = new JTextField();
		textBairro.setBounds(114, 222, 146, 20);
		textBairro.setColumns(10);
		contentPanel.add(textBairro);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(53, 251, 55, 15);
		contentPanel.add(lblCidade);
		
		textCidade = new JTextField();
		textCidade.setBounds(114, 248, 146, 20);
		textCidade.setColumns(10);
		contentPanel.add(textCidade);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(53, 277, 55, 15);
		contentPanel.add(lblEstado);
		
		textEstado = new JTextField();
		textEstado.setBounds(114, 274, 100, 20);
		textEstado.setColumns(10);
		contentPanel.add(textEstado);
		
		JButton btnAdicionarCliente = new JButton("Adicionar Cliente");
		btnAdicionarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				Cliente clienteNovo = new Cliente(textNome.getText(), textTelefone.getText(), textEmail.getText(), new Endereco(textRua.getText(), textNumero.getText(), textBairro.getText(), textCidade.getText(), textEstado.getText()));
				if(veiculos.size()>0) for(int i=0; i<veiculos.size(); i++) clienteNovo.addVeiculo(veiculos.get(i));
				clientes.add(clienteNovo);
				JOptionPane.showMessageDialog(null, "Cliente Cadastrado!", null, JOptionPane.INFORMATION_MESSAGE);
				dispose();
				}catch(Exception erro) {
					JOptionPane.showMessageDialog(null, "Erro ao cadastrar cliente!", null, JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnAdicionarCliente.setBounds(75, 413, 200, 40);
		btnAdicionarCliente.setBackground(new Color(59, 89, 182));
		btnAdicionarCliente.setForeground(Color.white);
		contentPanel.add(btnAdicionarCliente);
		
		//DEFINE O COMBOBOX	
		comboBoxVeiculos = new JComboBox();
		comboBoxVeiculos.setBounds(9, 330, 326, 24);
		contentPanel.add(comboBoxVeiculos);
				
		JLabel lblVeiculos = new JLabel("Veiculos");
		lblVeiculos.setFont(new Font("Dialog", Font.BOLD, 14));
		lblVeiculos.setBounds(12, 304, 96, 22);
		contentPanel.add(lblVeiculos);
		
		JButton btnCadastrarVeiculo = new JButton("Cadastrar Veiculo");
		btnCadastrarVeiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroVeiculo cVeiculo = new CadastroVeiculo(veiculos);
				cVeiculo.setVisible(true);
				comboBoxVeiculos.removeAllItems();
				for(int i=0; i<veiculos.size(); i++) {
					comboBoxVeiculos.addItem(veiculos.get(i).getMarca()+" - " + veiculos.get(i).getModelo()+" - " + veiculos.get(i).getPotencia());
				}				
			}
		});
		btnCadastrarVeiculo.setForeground(Color.WHITE);
		btnCadastrarVeiculo.setBackground(new Color(59, 89, 182));
		btnCadastrarVeiculo.setBounds(75, 366, 200, 40);
		contentPanel.add(btnCadastrarVeiculo);
		
		//BOTOES
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			//BOTAO CANCELAR
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
		}
	}
}
