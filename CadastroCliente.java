import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JFormattedTextField;

public class CadastroCliente extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textTelefone;
	private JTextField textEmail;
	private JTextField textRua;
	private JTextField textBairro;
	private JTextField textCidade;
	private JTextField textEstado;
	private JTextField textNumero;
	private JTextField textPotencia;
	private JTextField textPlaca;
	private JTextField textAnoFabricacao;
	private JTextField textAnoModelo;
	private JTextField textQuilometragem;
	private JComboBox comboBoxTipo;
	private JComboBox comboBoxMarca;
	private JComboBox comboBoxModelo;
	private ArrayList<JTextField> textVeiculos; 
	private ArrayList<Veiculo> clienteVeiculos;
	private ArrayList<Cliente> clientes;

	public CadastroCliente(ArrayList<Cliente> clientes, ArrayList<Modelos> marcas) {
		setTitle("CADASTRO CLIENTE");
		this.clientes = clientes;
		this.textVeiculos = new ArrayList<JTextField>();
		this.clienteVeiculos = new ArrayList<Veiculo>();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 603, 441);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
						
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(5, 130, 424, 0);
		contentPane.add(lblNewLabel);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(5, 40, 60, 29);
		contentPane.add(lblNome);
		
		textNome = new JTextField();
		lblNome.setLabelFor(textNome);
		textNome.setBounds(80, 45, 146, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(5, 75, 79, 14);
		contentPane.add(lblTelefone);
		
		textTelefone = new JTextField();
		lblTelefone.setLabelFor(textTelefone);
		textTelefone.setColumns(10);
		textTelefone.setBounds(80, 75, 146, 20);
		contentPane.add(textTelefone);
		
		JLabel lblEmail = new JLabel("e-mail: ");
		lblEmail.setBounds(5, 104, 65, 14);
		contentPane.add(lblEmail);
		
		textEmail = new JTextField();
		lblEmail.setLabelFor(textEmail);
		textEmail.setColumns(10);
		textEmail.setBounds(80, 101, 146, 20);
		contentPane.add(textEmail);
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setLabelFor(textEmail);
		lblRua.setBounds(5, 173, 65, 14);
		contentPane.add(lblRua);
		
		textRua = new JTextField();
		textRua.setColumns(10);
		textRua.setBounds(80, 170, 146, 20);
		contentPane.add(textRua);
		
		JLabel lblNumero = new JLabel("Numero:");
		lblNumero.setBounds(5, 198, 65, 14);
		contentPane.add(lblNumero);
		
		textNumero = new JTextField();
		textNumero.setColumns(10);
		textNumero.setBounds(80, 195, 50, 20);
		contentPane.add(textNumero);
		
		JLabel lblEndereo = new JLabel("ENDERECO");
		lblEndereo.setBounds(5, 141, 103, 14);
		contentPane.add(lblEndereo);
		
		JLabel lblInformacoesPessoais = new JLabel("INFORMACOES PESSOAIS");
		lblInformacoesPessoais.setBounds(5, 15, 192, 14);
		contentPane.add(lblInformacoesPessoais);
		
		JLabel lblBairro = new JLabel("Bairro: ");
		lblBairro.setBounds(5, 223, 65, 14);
		contentPane.add(lblBairro);
		
		textBairro = new JTextField();
		textBairro.setColumns(10);
		textBairro.setBounds(80, 220, 146, 20);
		contentPane.add(textBairro);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(5, 248, 65, 14);
		contentPane.add(lblCidade);
		
		textCidade = new JTextField();
		textCidade.setColumns(10);
		textCidade.setBounds(80, 245, 146, 20);
		contentPane.add(textCidade);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(5, 274, 60, 20);
		contentPane.add(lblEstado);
		
		textEstado = new JTextField();
		textEstado.setColumns(10);
		textEstado.setBounds(80, 274, 146, 20);
		contentPane.add(textEstado);
		
		JButton btnAdicionarCliente = new JButton("ADICIONAR CLIENTE");
		
		btnAdicionarCliente.setBounds(5, 314, 296, 79);
		contentPane.add(btnAdicionarCliente);
		btnAdicionarCliente.addActionListener(new AdicionaCliente());
		JLabel lblVeiculos = new JLabel("VEICULO");
		lblVeiculos.setBounds(276, 15, 103, 14);
		contentPane.add(lblVeiculos);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setBounds(276, 40, 60, 29);
		contentPane.add(lblMarca);
	
		comboBoxMarca = new JComboBox();
		comboBoxMarca.setBounds(362, 44, 146, 20);
		contentPane.add(comboBoxMarca);
		
		for(int i=0; i<marcas.size(); i++) {				
			comboBoxMarca.addItem(marcas.get(i).getNome());
		}	

		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setBounds(276, 68, 60, 29);
		contentPane.add(lblModelo);
	
		comboBoxModelo = new JComboBox();
		comboBoxModelo.setBounds(362, 72, 146, 20);
		contentPane.add(comboBoxModelo);
		
		for(int i=0; i<=marcas.get(0).getModelos().size(); i++) {
			if(comboBoxMarca.getSelectedItem().equals(marcas.get(i).getNome())) {
				for(int a=0;a<marcas.get(i).getModelos().size();a++) {
					comboBoxModelo.addItem(marcas.get(i).getModelos().get(a));
				}
			}
		}	
		
		ActionListener comboBoxSelect = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int comboSelected = comboBoxMarca.getSelectedIndex();
				ArrayList<String> modelosMarca = marcas.get(comboSelected).getModelos();
				DefaultComboBoxModel model = new DefaultComboBoxModel();//Cria um novo model de listaMunicipio
				model.removeAllElements(); //Remove todos elementos
				
				for(Object obj: modelosMarca){ //Para cada Objeto add
					model.addElement(obj);						
				}
				comboBoxModelo.setModel(model); //Set o modelo na comboBox 
			}
		};			
		comboBoxMarca.addActionListener(comboBoxSelect);
	
		JLabel lblPotencia = new JLabel("Potencia:");
		lblPotencia.setBounds(276, 95, 79, 29);
		contentPane.add(lblPotencia);
		
		textPotencia = new JTextField();
		textPotencia.setColumns(10);
		textPotencia.setBounds(362, 99, 50, 20);
		contentPane.add(textPotencia);
		
		JLabel lblPlaca = new JLabel("Placa:");
		lblPlaca.setBounds(276, 130, 60, 20);
		contentPane.add(lblPlaca);
		
		textPlaca = new JTextField();
		textPlaca.setColumns(10);
		textPlaca.setBounds(362, 130, 146, 20);
		contentPane.add(textPlaca);
		
		JLabel lblAnoFabricacao = new JLabel("Ano de Fabricacao:");
		lblAnoFabricacao.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblAnoFabricacao.setBounds(276, 153, 97, 20);
		contentPane.add(lblAnoFabricacao);
		
		textAnoFabricacao = new JTextField();
		textAnoFabricacao.setColumns(10);
		textAnoFabricacao.setBounds(383, 153, 125, 20);
		contentPane.add(textAnoFabricacao);
		
		JLabel lblAnoDeModelo = new JLabel("Ano de Modelo:");
		lblAnoDeModelo.setBounds(276, 181, 97, 20);
		contentPane.add(lblAnoDeModelo);
		
		textAnoModelo = new JTextField();
		textAnoModelo.setColumns(10);
		textAnoModelo.setBounds(362, 181, 146, 20);
		contentPane.add(textAnoModelo);
		
		JLabel lblQuilometragem = new JLabel("Quilometragem:");
		lblQuilometragem.setBounds(276, 212, 97, 20);
		contentPane.add(lblQuilometragem);
		
		textQuilometragem = new JTextField();
		textQuilometragem.setColumns(10);
		textQuilometragem.setBounds(362, 212, 146, 20);
		
		contentPane.add(textQuilometragem);
		
		textVeiculos.add(textPotencia);
		textVeiculos.add(textPlaca);
		textVeiculos.add(textAnoFabricacao);
		textVeiculos.add(textAnoModelo);
		textVeiculos.add(textQuilometragem);
		
		JButton btnAdicionarVeiculo = new JButton("ADICIONAR VEICULO");
		comboBoxTipo = new JComboBox();
		comboBoxTipo.setBounds(372, 244, 136, 29);
		contentPane.add(comboBoxTipo);
		comboBoxTipo.addItem(TipoVeiculo.CARRO);
		comboBoxTipo.addItem(TipoVeiculo.CAMINHAO);
		comboBoxTipo.addItem(TipoVeiculo.MOTO);
		
		btnAdicionarVeiculo.addActionListener(new AdicionaVeiculo());
		
		btnAdicionarVeiculo.setBounds(307, 314, 270, 79);
		contentPane.add(btnAdicionarVeiculo);
		
		JLabel lblTipo = new JLabel("TIPO:");
		lblTipo.setBounds(324, 244, 49, 28);
		contentPane.add(lblTipo);
		this.setVisible(true);
	}
	
	private class AdicionaVeiculo implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				for (int i = 0; i<textVeiculos.size(); i++) {
					if (textVeiculos.get(i).getText().equals("")) throw new Exception("Nenhum campo pode estar vazio"); 
				}
			}catch(Exception ex) {	
				JOptionPane.showMessageDialog(null,ex.toString(), null, JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			try {
				 clienteVeiculos.add(new Veiculo((TipoVeiculo)comboBoxTipo.getSelectedItem(), (String) comboBoxMarca.getSelectedItem(), (String) comboBoxMarca.getSelectedItem(), textPlaca.getText(), 
						Integer.parseInt(textAnoFabricacao.getText()), Integer.parseInt(textAnoModelo.getText()), Integer.parseInt(textQuilometragem.getText()), Float.parseFloat(textPotencia.getText())));
			}catch(NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, ex.toString(), null, JOptionPane.ERROR_MESSAGE);
				return;
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(null,ex.toString(), null, JOptionPane.ERROR_MESSAGE);
				return;
			}
			JOptionPane.showMessageDialog(null, "VEICULO ADICIONADO COM SUCESSO",  null, JOptionPane.INFORMATION_MESSAGE);
			for (int i = 0; i<textVeiculos.size(); i++) {
				textVeiculos.get(i).setText(""); 
			}

		}	
	}
	
	private class AdicionaCliente implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (textNome.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "O campo NOME nao pode estar vazio", null, JOptionPane.ERROR_MESSAGE);
				return;
			}
			Cliente c = new Cliente(textNome.getText(), textTelefone.getText(), textEmail.getText(),
					new Endereco(textRua.getText(), textNumero.getText(), textBairro.getText(), 
					textCidade.getText(), textEstado.getText()));
			for (int i = 0; i<clienteVeiculos.size(); i++) {
				c.addVeiculo(clienteVeiculos.get(i));
			}
			clienteVeiculos = new ArrayList<Veiculo>();
			clientes.add(c);
			JOptionPane.showMessageDialog(null, "CLIENTE ADICIONADO COM SUCESSO",  null, JOptionPane.INFORMATION_MESSAGE);
			textNome.setText("");
			textRua.setText("");
			textNumero.setText("");
			textEstado.setText("");
			textCidade.setText("");
			textEmail.setText("");
			textTelefone.setText("");
			textBairro.setText("");
		}
	}
}






