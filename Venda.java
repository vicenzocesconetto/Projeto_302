import java.util.ArrayList;

public class Venda {
    private Cliente cliente;
    private ArrayList<Produto> produtos;
    private ArrayList<Servico> servicos;
    private ArrayList<Integer> qtd;
    private FormaPagamento formaPagamento;
    private Data data;
    private String funcionario;
    private Empresa empresa;
    private float total;
    
    public Venda() {
    	this.produtos = new ArrayList<Produto>();
    	this.servicos = new ArrayList<Servico>();
    	this.qtd = new ArrayList<Integer>();
    }

	public Venda(Cliente cliente, Data data, String funcionario, Empresa empresa) {
		this.cliente = cliente;
		this.data = data;
		this.funcionario = funcionario;
		this.empresa = empresa;
	}

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

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
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

	public ArrayList<Produto> getProdutos() {
		return produtos;
	}

	public ArrayList<Servico> getServicos() {
		return servicos;
	}

	public ArrayList<Integer> getQtd() {
		return qtd;
	}

	public float getTotal() {
		return total;
	}
	
	public void addProduto(Produto p, int q) {
		qtd.add(q);	
		produtos.add(p);
	}
	
	public void addServico(Servico s) {
		servicos.add(s);
	}
	
	public void desconto(Float d) {
		this.total=(1-d)*total;
	}
	
	public void finalizarVenda() {
		//Salva no historico do Produto
		this.cliente.addHistorico(this);
		//Diminui o estoque dos produtos
		for (int i=0; i<this.produtos.size(); i++) {
			this.produtos.get(i).diminuirEstoque(qtd.get(i));
		}
		//Salva Movimentacao
		empresa.addMovimentacao(new Entrada(this.getTotal(),this.getFormaPagamento()));		
	}
}
