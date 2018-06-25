import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PaginaCaixa extends JFrame implements ActionListener {

    private Empresa empresa;
    private ArrayList<Cliente> clientes;
    private ArrayList<Produto> produtos;
    private ArrayList<Servico> servicos;
    private Funcionario funcionario;

    public PaginaCaixa(Empresa empresa, ArrayList<Cliente> clientes, ArrayList<Produto> produtos, ArrayList<Servico> servicos, Funcionario funcionario) {
        this.empresa = empresa;
        this.clientes = clientes;
        this.produtos = produtos;
        this.servicos = servicos;
        this.funcionario = funcionario;

        FuncoesPrint biblioteca = new FuncoesPrint();

        JTextField caixa = new JTextField();
//        JButton encerrante = new JButton("Imprimir Encerrante");
        JButton retirada = new JButton("Fazer retirada");
        JButton voltar = new JButton("Voltar");
        Container contentPane = getContentPane();

        caixa.setBounds(140, 30, 200, 35);
        caixa.setEditable(false);
        caixa.setText("R$" + Float.toString(empresa.getCaixa()));
//        encerrante.setBounds(140, 70, 200, 30);
        retirada.setBounds(140, 70, 200, 30);
        voltar.setBounds(140, 110, 200, 30);

//        encerrante.addActionListener(this);
        retirada.addActionListener(this);

        contentPane.setLayout(null);
        contentPane.add(caixa);
//        contentPane.add(encerrante);
        contentPane.add(retirada);

        JTextField texto = new JTextField();
        texto.setBounds(40, 170, 400, 300);
        texto.setText(biblioteca.imprimeEncerrante(empresa, funcionario));
        getContentPane().add(texto);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Caixa");
        setSize(Main.TAMANAHO_DA_JANELA, Main.TAMANAHO_DA_JANELA);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();

        if(source.toString().contains("Fazer retirada")) {
            PaginaRetirada paginaRetirada = new PaginaRetirada(empresa, clientes, produtos, servicos, funcionario);
        }
        else if(source.toString().contains("Voltar")) {
            MenuPrincipal menuPrincipal = new MenuPrincipal(empresa, clientes, produtos, servicos, funcionario);
        }
        dispose();
    }

    public static void main(String[] args) {
        Empresa empresa = new Empresa("imperio", "12345678");
        empresa.setCaixa(420.69f);
        PaginaCaixa p = new PaginaCaixa(empresa, new ArrayList<Cliente>(), new ArrayList<Produto>(), new ArrayList<Servico>(), new Funcionario("344", "r4e", "eer", Cargo.ATENDENTE));
    }

}
