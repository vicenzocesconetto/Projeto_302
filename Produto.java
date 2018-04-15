import java.util.ArrayList;

public class Produto {
	
	private int id;
	private String nome;
	private float valor;
	private int estoque;
	private int estoqueMinimo;
	private static int numeroProdutos = 0;
	private ArrayList<String> modelosCompativeis;
	
	public Produto() {
		id = numeroProdutos++;
		modelosCompativeis = new ArrayList<String>();
	}
	
	public Produto(int estoqueMinimo, int estoque, float valor) {
		this();
		this.estoqueMinimo = estoqueMinimo;
		this.estoque = estoque;
		this.valor = valor;
	}
	
	public Produto(int estoqueMinimo, int estoque, float valor, String nome) {
		this(estoqueMinimo, estoque, valor);
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

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

	public static int getNumeroProdutos() {
		return numeroProdutos;
	}

	public static void setNumeroProdutos(int numeroProdutos) {
		Produto.numeroProdutos = numeroProdutos;
	}
	
	public ArrayList<String> getModelosCompativeis() {
		return modelosCompativeis;
	}

	public void setModelosCompativeis(ArrayList<String> modelosCompativeis) {
		this.modelosCompativeis = modelosCompativeis;
	}

	@Override
	public String toString() {
		String str = "";
		str += "ID: " + id + "\n";
		str += "Nome: " + nome + "\n";
		str += "Valor: " + valor + "\n";
		str += "Estoque Minimo: " + estoqueMinimo + "\n";
		str += "Estoque: " + estoque + "\n";
		str += "Modelos Compativeis: " + modelosCompativeis.toString() + "\n";
		return str;
	}
	
	public boolean adicionarModeloCompativel(String modelo) {
		return modelosCompativeis.add(modelo);
	}
	
	public boolean removerModeloCompativel(String modelo) {
		return modelosCompativeis.remove(modelo);
	}
	
	public boolean checarModeloCompativel(String modelo) {
		return modelosCompativeis.contains(modelo);
	}
	
	public boolean checarEstoqueMinimo() { // Retorna true se o estoqueAtual esta menor que o estoqueMinimo. False caso contrario
		if (estoque < estoqueMinimo) {
			return true;
		}
		return false;
	}
	
	public boolean ReporEstoqueMinimo() { // Retorna true se ha reposicao de estoque. Retorna false caso contrario
		if (checarEstoqueMinimo() == true) {
			estoque = estoqueMinimo;
			return true;
		}
		return false;
	}
	
	public void aumentarEstoque(int quantia) {
		estoque += quantia;
	}
	
	public boolean diminuirEstoque(int quantia) { // Retorna false se o estoque for menor que a quantia removida. Retorna true se houver diminuicao de estoque e avisa quando o estoque minimo eh atingido
		if (estoque >= quantia) {
			estoque -= quantia;
			if (estoque < estoqueMinimo) {
				System.out.println("AVISO: Estoque atual menor que o estoque minimo"); // Decide-se depois se havera reposicao
			}
			return true;
		}
		return false;
	}
	
	
	
	
	
	
	
	
	

}
