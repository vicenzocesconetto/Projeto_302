import java.util.ArrayList;

public class Venda {
	private Funcoes funcoes;
	private Cliente cliente;
    private ArrayList<Produto> produtos;
    private ArrayList<Servico> servicos;
    private ArrayList<Integer> qtd; //GUARDA A QTD DE ITENS COMPRADOS DO PRODUTO I, QUE ESTA NA IESIMA POSICAO DO ARRAY THIS.PRODUTOS
    private FormaPagamento formaPagamento;
    private final String data;
    private String funcionario;
    private Empresa empresa;
    private float total;
    
    public Venda() {
    	this.produtos = new ArrayList<Produto>();
    	this.servicos = new ArrayList<Servico>();
    	this.qtd = new ArrayList<Integer>();
    	this.funcoes= new Funcoes();
    	this.data = funcoes.dataHojeBarra();
    }

	public Venda(Cliente cliente, String funcionario, Empresa empresa) {
		this();
		this.cliente = cliente;
		this.funcionario = funcionario;
		this.empresa = empresa;
	}
	
	public void addProduto(Produto p, int q) {
		qtd.add(q);	
		produtos.add(p);
		this.total += (p.getValor()*q);
	}
	
	public void addServico(Servico s) {
		servicos.add(s);
		this.total += (s.getValor());
	}
	
	public void removeProduto(int i, int qtd){
		if(this.qtd.get(i)==qtd) {
			this.total -= (produtos.get(i).getValor()*this.qtd.get(i));
			this.qtd.remove(i);
			produtos.remove(i);
			return;
		}
		
		this.qtd.set(i, this.qtd.get(i)-qtd);
		this.total -= (produtos.get(i).getValor()*this.qtd.get(i));
	}
	
	public void removeServico(int i) {
		this.total -= (servicos.get(i).getValor());
		servicos.remove(i);		
	}	
	
//	public boolean descontoPorcentagem (Float desconto, Empresa empresa, String login, String password) {
//		if(funcoes.loginGerente(empresa, login, password)) {
//			if(desconto<=100) {
//				desconto = desconto/100;
//				this.total= this.total*desconto;
//				return true;
//			}
//		}
//		return false;
//	}
//
//	public boolean descontoValor (Float valor, Float desconto, Empresa empresa, String login, String password) {
//		if(funcoes.loginGerente(empresa, login, password)) {
//			if(desconto<=valor) {
//				this.total = this.total-desconto;
//				return true;
//			}
//		}
//		return false;
//	}
	
	//GETS E SETS PADROES
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public String getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(String funcionario) {
		this.funcionario = funcionario;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public ArrayList<Produto> getProdutos() {
		return produtos;
	}

	public ArrayList<Servico> getServicos() {
		return servicos;
	}

	public ArrayList<Integer> getQtd() {
		return qtd;
	}

	public String getData() {
		return data;
	}
}
