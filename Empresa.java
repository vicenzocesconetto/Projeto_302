import java.util.ArrayList;

public class Empresa {

    private String nome;
    private String cnpj;
    private float caixa;
    private ArrayList<Movimentacao> movimentacoes;

    public Empresa(String nome, String cnpj) {
    	this.nome = nome;
        this.cnpj = cnpj;
        this.movimentacoes = new ArrayList<Movimentacao>();
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

	public ArrayList<Movimentacao> getMovimentacoes() {
		return movimentacoes;
	}
	
	public void addMovimentacao(Movimentacao m) {
		movimentacoes.add(m);
		
		if(m instanceof Entrada) {
			this.caixa += m.getValor();
		}
		if(m instanceof Retirada) {
			this.caixa -= m.getValor();
		}
	}	
}