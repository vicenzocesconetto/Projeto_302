import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaginaCaixa extends JFrame implements ActionListener {

    Empresa empresa;

    public PaginaCaixa(Empresa empresa) {
        this.empresa = empresa;

        JTextField caixa = new JTextField();
        JButton encerrante = new JButton("Imprimir Encerrante");
        JButton retirada = new JButton("Fazer retirada");
        JButton voltar = new JButton("Voltar");
        Container contentPane = getContentPane();

        caixa.setBounds(140, 30, 200, 35);
        caixa.setEditable(false);
        caixa.setText("R$" + Float.toString(empresa.getCaixa()));
        encerrante.setBounds(140, 70, 200, 30);
        retirada.setBounds(140, 110, 200, 30);
        voltar.setBounds(140, 150, 200, 30);

        contentPane.setLayout(null);
        contentPane.add(caixa);
        contentPane.add(encerrante);
        contentPane.add(retirada);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Caixa");
        setSize(Main.TAMANAHO_DA_JANELA, Main.TAMANAHO_DA_JANELA);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
    }

    public static void main(String[] args) {
        Empresa empresa = new Empresa("imperio", "12345678");
        empresa.setCaixa(420.69f);
        PaginaCaixa p = new PaginaCaixa(empresa);
    }

}
