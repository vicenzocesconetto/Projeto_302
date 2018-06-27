import java.io.Serializable;

public class Servico implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private static int geradorId = 0;
	private String nome;
	private float valor;
	private boolean retorno;
	
	public Servico() {
		id = geradorId++;
	}
	
	public Servico (String nome, float valor, boolean retorno) {
		this();
		this.nome = nome.toUpperCase();
		this.valor = valor;
		this.retorno=retorno;
	}
	
	public void setNome(String nome) {
		this.nome = nome.toUpperCase();
	}
	
	//GETTERS E SETTER PADROES
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
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

	public boolean isRetorno() {
		return retorno;
	}

	public void setRetorno(boolean retorno) {
		this.retorno = retorno;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
