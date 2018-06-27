import java.io.Serializable;
import java.util.ArrayList;

public class Cliente implements Serializable{
	private static final long serialVersionUID = 1L;
	private static int numClientes=0;
	private String nome;
	private String telefone;
	private String email;
	private Endereco endereco;
	private ArrayList<Veiculo> veiculos;
	private ArrayList<Venda> historico;
	private Retorno retorno;
	
	public Cliente(String nome, String telefone, String email, Endereco endereco) {
		this.nome = nome.toUpperCase();
		this.telefone = telefone.toUpperCase();
		this.email = email.toLowerCase();
		this.endereco = endereco;
		this.historico = new ArrayList<Venda>();
		this.veiculos = new ArrayList<Veiculo>();
		++numClientes;
	}

	public void setNome(String nome) {
		this.nome = nome.toUpperCase();
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone.toUpperCase();
	}
	
	public void setEmail(String email) {
		this.email = email.toLowerCase();
	}

	public void addHistorico(Venda n) {
		this.historico.add(n);
	}
	public void addVeiculo (Veiculo novo) {
		this.veiculos.add(novo);
	}
	
	public boolean removeVeiculo (int i) {
		try {
			this.veiculos.remove(i);
			return true;
		}catch(ArrayIndexOutOfBoundsException e) {
			return false;
		}catch(Exception e2) {
			return false;
		}
	}

	//GETTERS E SETTER PADROES
	public static int getNumClientes() {
		return numClientes;
	}

	public static void setNumClientes(int numClientes) {
		Cliente.numClientes = numClientes;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Retorno getRetorno() {
		return retorno;
	}

	public void setRetorno(Retorno retorno) {
		this.retorno = retorno;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getNome() {
		return nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getEmail() {
		return email;
	}

	public ArrayList<Veiculo> getVeiculos() {
		return veiculos;
	}

	public ArrayList<Venda> getHistorico() {
		return historico;
	}
}
