import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PaginaLogin extends JFrame implements ActionListener{

    private JTextField campoDoUsuario;
    private JPasswordField campoDaSenha;
    private Empresa empresa;
    ArrayList<Cliente> clientes;
    ArrayList<Produto> produtos;
    ArrayList<Servico> servicos;

    public PaginaLogin(Empresa empresa, ArrayList<Cliente> clientes, ArrayList<Produto> produtos, ArrayList<Servico> servicos) {

        this.empresa = empresa;

        Container contentPane = getContentPane();
        JLabel labelUsuario = new JLabel("Usuario");
        JLabel labelSenha = new JLabel("Senha");
        campoDoUsuario = new JTextField(10);
        campoDaSenha = new JPasswordField(10);
        JButton login = new JButton("Login!");

        setTitle("Login");

        labelUsuario.setBounds(80, 70, 200, 30);
        labelSenha.setBounds(80, 110, 200, 30);
        campoDoUsuario.setBounds(140, 70, 200, 30);
        campoDaSenha.setBounds(140, 110, 200, 30);
        login.setBounds(150, 160, 100, 30);

        login.setBackground(new Color(59, 89, 182));
        login.setForeground(Color.white);

        login.addActionListener(this);

        contentPane.setLayout(null);
        contentPane.add(labelUsuario);
        contentPane.add(campoDoUsuario);
        contentPane.add(labelSenha);
        contentPane.add(campoDaSenha);
        contentPane.add(login);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(Main.TAMANAHO_DA_JANELA, Main.TAMANAHO_DA_JANELA);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Funcoes biblioteca = new Funcoes();

        if(biblioteca.login(empresa, campoDoUsuario.getText(), String.valueOf(campoDaSenha.getPassword()))) {
            Funcionario funcionario = empresa.getFuncionarioPeloLogin(campoDoUsuario.getText());
            MenuPrincipal menuPrincipal = new MenuPrincipal(empresa, clientes, produtos, servicos, funcionario);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this,"Usuario ou senha incorretos",
                    "Erro",JOptionPane.ERROR_MESSAGE);
        }
    }
}
