import javax.swing.*;
import java.awt.*;

public class MenuPrincipal extends JFrame {

    public MenuPrincipal() {

        JButton[] botoes = new JButton[8];

        botoes[0] = new JButton("Realizar venda");
        botoes[1] = new JButton("Cadastrar cliente");
        botoes[2] = new JButton("Cadastrar produto/servico");
        botoes[3] = new JButton("Consultar/Atualizar Estoque de Produtos");
        botoes[4] = new JButton("Caixa");
        botoes[5] = new JButton("Retorno de Clientes");
        botoes[6] = new JButton("Consultar/Atualizar Cliente/Produto/Servico");
        botoes[7] = new JButton("Sair do sistema");

        Container contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout());

        for(int i = 0; i < 8; ++i) {
            contentPane.add(botoes[i]);
        }


        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
        setVisible(true);
    }

    public static void main(String[] args) {
        MenuPrincipal m = new MenuPrincipal();
    }
}
