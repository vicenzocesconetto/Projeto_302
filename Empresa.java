import java.util.ArrayList;
import java.io.Serializable;

public class Empresa implements Serializable {
	private static final long serialVersionUID = 1L;
	private String nome;
    private String cnpj;
    private float caixa;
    private ArrayList<Movimentacao> movimentacoes;
    private ArrayList<Funcionario> funcionarios;

    public Empresa(String nome, String cnpj) {
    	this.nome = nome.toUpperCase();
        this.cnpj = cnpj;
        this.movimentacoes = new ArrayList<Movimentacao>();
        this.funcionarios = new ArrayList<Funcionario>();
    }
    
    public void setNome(String nome) {
        this.nome = nome.toUpperCase();
    }

   public void addMovimentacao(Movimentacao m) {
		if(m instanceof Entrada) this.caixa += m.getValor();
		else if(m instanceof Retirada) this.caixa -= m.getValor();
		else return;
		movimentacoes.add(m);
	}
	
	public boolean addFuncionario(Funcionario novo) {
		if(funcionarios.contains(novo)) return false;
		funcionarios.add(novo);
		return true;
	}

	public Funcionario getFuncionarioPeloLogin(String loginFuncionario) {
        for (Funcionario f: funcionarios) {
            if(f.getLogin().equals(loginFuncionario))
                return f;
        }
        return null;
    }

	public void limpaMovimentacoes() {
		this.movimentacoes.clear();
	}
	
	 //GETTERS E SETTER PADROES

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getNome() {
		return nome;
	}

	public ArrayList<Movimentacao> getMovimentacoes() {
		return movimentacoes;
	}

	public ArrayList<Funcionario> getFuncionarios() {
		return funcionarios;
	}
}