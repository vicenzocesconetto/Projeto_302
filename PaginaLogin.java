import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaginaLogin extends JFrame implements ActionListener{

    private JTextField campoDoUsuario;
    private JPasswordField campoDaSenha;

    public PaginaLogin() {

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

//        labelUsuario.setLabelFor(campoDoUsuario);
//        labelSenha.setLabelFor(campoDaSenha);


        login.addActionListener(this);

        contentPane.setLayout(null);
        contentPane.add(labelUsuario);
        contentPane.add(campoDoUsuario);
        contentPane.add(labelSenha);
        contentPane.add(campoDaSenha);
        contentPane.add(login);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String login = campoDoUsuario.getText();
        String senha = String.valueOf(campoDaSenha.getPassword());
    }

    public static void main(String[] args) {
        PaginaLogin p = new PaginaLogin();
    }
}
