import java.io.Serializable;
import java.util.ArrayList;

public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;
	private static int numeroProdutos = 0;
	private int id;
	private String nome;
	private float valor;
	private int estoque;
	private int estoqueMinimo;
	private int rendimento; //QUANDO APLICADO REFERECE AO NUMERO DE KM QUE UM CARRO PODE RODAR COM ESSE PRODUTO
	private int validade; //QUANDO APLICADO REFERECE AO NUMERO DE MESES QUE UM CARRO PODE RODAR COM ESSE PRODUTO
	private ArrayList<Compatibilidade> modelosCompativeis;
	
	public Produto() {
		id = numeroProdutos++;
		modelosCompativeis = new ArrayList<Compatibilidade>();
	}
	
	public Produto(int estoqueMinimo, int estoque, float valor, String nome) {
		this();
		this.estoqueMinimo = estoqueMinimo;
		this.estoque = estoque;
		this.valor = valor;
		this.nome = nome.toUpperCase();
	}

	public boolean checarEstoqueMinimo() { // Retorna true se o estoqueAtual esta menor que o estoqueMinimo. False caso contrario
		if (estoque < estoqueMinimo) {
			return true;
		}
		return false;
	}
	
	public boolean checarEstoque(int q) {
		if(q<=this.estoque) return true;
		return false;
	}
	
	public void aumentarEstoque(int quantia) {
		estoque += quantia;
	}
	
	public boolean diminuirEstoque(int quantia) { // Retorna false se o estoque for menor que a quantia removida. Retorna true se houver diminuicao de estoque e avisa quando o estoque minimo eh atingido
		if (estoque >= quantia) {
			estoque -= quantia;
			return true;
		}
		return false;
	}
	
	public void setNome(String nome) {
		this.nome = nome.toUpperCase();
	}
	
	public void addModeloCompativel(Compatibilidade novo) {
		this.modelosCompativeis.add(novo);
	}

	//GETTERS E SETTER PADROES
	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

	public int getEstoqueMinimo() {
		return estoqueMinimo;
	}

	public void setEstoqueMinimo(int estoqueMinimo) {
		this.estoqueMinimo = estoqueMinimo;
	}

	public int getRendimento() {
		return rendimento;
	}

	public void setRendimento(int rendimento) {
		this.rendimento = rendimento;
	}

	public int getValidade() {
		return validade;
	}

	public void setValidade(int validade) {
		this.validade = validade;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static int getNumeroProdutos() {
		return numeroProdutos;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public ArrayList<Compatibilidade> getModelosCompativeis() {
		return modelosCompativeis;
	}

}
