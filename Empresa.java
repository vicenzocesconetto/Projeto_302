import java.util.ArrayList;

public class Empresa {

    private String nome;
    private String cnpj;
    private float caixa;
    private ArrayList<String> movimentacao;

    public Empresa(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public float getCaixa() {
        return caixa;
    }

    public void setCaixa(float caixa) {
        this.caixa = caixa;
    }

    public ArrayList<String> getMovimentacao() {
        return movimentacao;
    }

    public void setMovimentacao(ArrayList<String> movimentacao) {
        this.movimentacao = movimentacao;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "nome='" + nome + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", caixa=" + caixa +
                ", movimentacao=" + movimentacao +
                '}';
    }
}