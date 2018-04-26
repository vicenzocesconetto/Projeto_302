import java.util.ArrayList;
import java.util.Date;

public class Venda {
    private Cliente cliente;
    private ArrayList<Produto> produtos;
    private ArrayList<Servico> servicos;
    private ArrayList<Integer> qtd; //GUARDA A QTD DE ITENS COMPRADOS DO PRODUTO I, QUE ESTA NA IESIMA POSICAO DO ARRAY THIS.PRODUTOS
    private FormaPagamento formaPagamento;
    private final Date data;
    private String funcionario;
    private Empresa empresa;
    private float total;
    
    public Venda() {
    	this.produtos = new ArrayList<Produto>();
    	this.servicos = new ArrayList<Servico>();
    	this.qtd = new ArrayList<Integer>();
    	this.data = new Date();
    }

	public Venda(Cliente cliente, String funcionario, Empresa empresa) {
		this();
		this.cliente = cliente;
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

	public Date getData() {
		return data;
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
		this.total += (p.getValor()*q);
	}
	
	public void addServico(Servico s) {
		servicos.add(s);
		this.total += (s.getValor());
	}
	
	public void removeProduto(int i){
		this.total -= (produtos.get(i).getValor()*qtd.get(i));
		qtd.remove(i);
		produtos.remove(i);		
	}
	
	public void removeServico(int i) {
		this.total -= (servicos.get(i).getValor());
		servicos.remove(i);		
	}	
	
	public void desconto(Float d) {
		this.total=(1-d)*total;
	}
	
	public void finalizarVenda() {
		//SALVA HISTORICO DO CLIENTE
		this.cliente.addHistorico(this);
		
		//DIMINUI O ESTOQUE DOS PRODUTOS
		for (int i=0; i<this.produtos.size(); i++) {
			this.produtos.get(i).diminuirEstoque(qtd.get(i));
		}
		//SALVA MOVIMENTACAO
		empresa.addMovimentacao(new Entrada(this.getTotal(),this.getFormaPagamento()));		
	}
}
