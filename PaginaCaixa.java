import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Container;

public class PaginaCaixa extends JFrame {

    Empresa empresa;

    public PaginaCaixa(Empresa empresa) {
        this.empresa = empresa;

        JTextField caixa = new JTextField();
        JButton encerrante = new JButton("Imprimir Encerrante");
        JButton retirada = new JButton("Fazer retirada");
        Container contentPane = getContentPane();

        caixa.setBounds(140, 30, 200, 35);
        caixa.setEditable(false);
        caixa.setText(Float.toString(empresa.getCaixa()));

        encerrante.setBounds(140, 70, 200, 30);
        retirada.setBounds(140, 110, 200, 30);

        contentPane.setLayout(null);
        contentPane.add(caixa);
        contentPane.add(encerrante);
        contentPane.add(retirada);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Caixa");
        setSize(Main.TAMANAHO_DA_JANELA, Main.TAMANAHO_DA_JANELA);
        setVisible(true);
    }

    public static void main(String[] args) {
        Empresa empresa = new Empresa("imperio", "12345678");
        PaginaCaixa p = new PaginaCaixa(empresa);
    }

}
