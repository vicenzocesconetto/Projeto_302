import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class RetornoCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public RetornoCliente(ArrayList<Cliente> clientes) {
		this.setTitle("RETORNO CLIENTE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(48, 33, 339, 193);
		contentPane.add(textArea);
		Date data = new Date(System.currentTimeMillis() + 60 * 60 * 24 * 8);
		
		for (int i = 0; i<clientes.size(); i++) {
			if (data.before(clientes.get(i).getRetorno().getData())) {
				textArea.setText("Nome: " + clientes.get(i).getNome() + "\n" + "Telefone: " + clientes.get(i).getTelefone() + "\n" + "Email: " + clientes.get(i).getEmail());
				textArea.setText(textArea.getText() + "\n\n");
			}
		}
		
	}
		
}
