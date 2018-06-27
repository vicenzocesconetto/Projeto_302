import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PaginaLogin extends JFrame{

    private JTextField campoDoUsuario;
    private JPasswordField campoDaSenha;
    
    public PaginaLogin(Empresa empresa, ArrayList<Cliente> clientes, ArrayList<Produto> produtos, ArrayList<Servico> servicos) {

        Container contentPane = getContentPane();
        JLabel labelUsuario = new JLabel("Usuario:");
        JLabel labelSenha = new JLabel("Senha:");
        campoDoUsuario = new JTextField(10);
        campoDaSenha = new JPasswordField(10);
        JButton login = new JButton("Login!");

        setTitle("Login");
        
        ImageIcon icon = new ImageIcon("/home/greenseiya/eclipse-workspace/Oficina/src/dados/logo.png");

        labelUsuario.setBounds(127, 282, 63, 30);
        labelSenha.setBounds(135, 323, 55, 30);
        campoDoUsuario.setBounds(195, 282, 200, 30);
        campoDaSenha.setBounds(195, 323, 200, 30);
        login.setBounds(195, 372, 100, 30);

        login.setBackground(new Color(59, 89, 182));
        login.setForeground(Color.white);

        login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                Funcoes biblioteca = new Funcoes();

                if(biblioteca.login(empresa, campoDoUsuario.getText(), String.valueOf(campoDaSenha.getPassword()))) {
                    Funcionario funcionario = empresa.getFuncionarioPeloLogin(campoDoUsuario.getText());
                    Menu menu = new Menu(empresa, clientes, produtos, servicos, funcionario);
                    menu.setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null,"Usuario ou senha incorretos",
                            "Erro",JOptionPane.ERROR_MESSAGE);
                }
            }
		});

        contentPane.setLayout(null);
        contentPane.add(labelUsuario);
        contentPane.add(campoDoUsuario);
        contentPane.add(labelSenha);
        contentPane.add(campoDaSenha);
        contentPane.add(login);
        JLabel lblIcon = new JLabel("",icon, JLabel.CENTER);
        lblIcon.setBounds(40, 85, 410, 130);
        getContentPane().add(lblIcon);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
    }
}
