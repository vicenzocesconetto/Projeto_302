import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PaginaRetirada extends JFrame implements ActionListener {

    private JTextField valor;
    private JTextField motivo;
    private Empresa empresa;
    private ArrayList<Cliente> clientes;
    private ArrayList<Produto> produtos;
    private ArrayList<Servico> servicos;
    private Funcionario funcionario;

    public PaginaRetirada(Empresa empresa, ArrayList<Cliente> clientes, ArrayList<Produto> produtos, ArrayList<Servico> servicos, Funcionario funcionario) {

        Container contentPane = getContentPane();
        JLabel labelValor = new JLabel("Valor");
        JLabel labelMotivo = new JLabel("Motivo");
        valor = new JTextField(10);
        motivo = new JPasswordField(10);
        JButton retirada = new JButton("Login!");

        setTitle("Retirada");

        labelValor.setBounds(80, 70, 200, 30);
        labelMotivo.setBounds(80, 110, 200, 30);
        valor.setBounds(140, 70, 200, 30);
        motivo.setBounds(140, 110, 200, 30);
        retirada.setBounds(150, 160, 100, 30);

        retirada.setBackground(Color.red);
        retirada.setForeground(Color.white);

        retirada.addActionListener(this);

        contentPane.setLayout(null);
        contentPane.add(labelValor);
        contentPane.add(valor);
        contentPane.add(labelMotivo);
        contentPane.add(motivo);
        contentPane.add(retirada);


        setSize(Main.TAMANAHO_DA_JANELA, Main.TAMANAHO_DA_JANELA);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        Funcoes biblioteca = new Funcoes();

        if(biblioteca.retirarDinheiro(empresa, Float.parseFloat(valor.getText()), motivo.getText())) {
            JOptionPane.showMessageDialog(this,"Sucesso!",
                    "Missao Possivel",JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            JOptionPane.showMessageDialog(this,"Valor maior que o caixa!",
                    "Missao Impossivel",JOptionPane.ERROR_MESSAGE);
        }
    }
}
