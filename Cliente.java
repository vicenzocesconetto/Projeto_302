import java.util.ArrayList;

public class Cliente {
	private static int numClientes=0;
	
	private String nome;
	private String telefone;
	private String email;
	private Endereco endereco;
	
	private ArrayList<Veiculo> veiculos;
	private ArrayList<Venda> historico;
	
	public Cliente(String nome, String telefone, String email, Endereco endereco) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
		this.veiculos = new ArrayList<Veiculo>();
		this.historico = new ArrayList<Venda>();
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
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public ArrayList<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(ArrayList<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}
}