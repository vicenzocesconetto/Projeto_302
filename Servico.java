public class Servico {
	
	private int id;
	private static int geradorId = 0;
	private String nome;
	private float valor;
	
	public Servico() {
		id = geradorId++;
	}
	
	public Servico(String nome, float valor) {
		this();
		this.nome = nome.toUpperCase();
		this.valor = valor;
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
		this.nome = nome.toUpperCase();
	}
	
	public float getValor() {
		return valor;
	}
	
	public void setValor(float valor) {
		this.valor = valor;
	}
	
	public static int getGeradorId() {
		return geradorId;
	}

	public static void setGeradorId(int geradorId) {
		Servico.geradorId = geradorId;
	}

	@Override
	public String toString(){
		String str = "";
		str += "ID: " + id + "\n";
		str += "Nome: " + nome + "\n";
		str += "Valor: " + valor + "\n";
		return str;
	}
	
}
