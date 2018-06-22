import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaginaLogin extends JFrame implements ActionListener{

    public PaginaLogin() {

        setTitle("Login");

        JLabel labelUsuario = new JLabel("Usuario");
        JTextField campoDoUsuario = new JTextField(10);
        labelUsuario.setLabelFor(campoDoUsuario);

        JLabel labelSenha = new JLabel("Senha");
        JPasswordField campoDaSenha = new JPasswordField(10);
        labelSenha.setLabelFor(campoDaSenha);

        JButton login = new JButton("Login!");
        login.addActionListener(this);

        Container contentPane = getContentPane();

        contentPane.setLayout(new FlowLayout());
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

    }

    public static void main(String[] args) {
        PaginaLogin p = new PaginaLogin();
    }
}
