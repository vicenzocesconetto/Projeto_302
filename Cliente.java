import java.io.Serializable;
import java.util.ArrayList;

public class Cliente implements Serializable{
	private static final long serialVersionUID = 1L;
	private static int numClientes=0;
	private String nome;
	private String telefone;
	private String email;
	private Endereco endereco;
	
	private ArrayList<Venda> historico;
	
	public Cliente(String nome, String telefone, String email, Endereco endereco) {
		this.nome = nome.toUpperCase();
		this.telefone = telefone.toUpperCase();
		this.email = email.toLowerCase();
		this.endereco = endereco;
		this.historico = new ArrayList<Venda>();
		++numClientes;
	}

	public static int getNumClientes() {
		return numClientes;
	}
	
	public static void setNumClientes(int numClientes) {
		Cliente.numClientes = numClientes;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome.toUpperCase();
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone.toUpperCase();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email.toLowerCase();
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public ArrayList<Venda> getHistorico() {
		return historico;
	}
	
	public void addHistorico(Venda n) {
		this.historico.add(n);
	}
}
