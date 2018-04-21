import java.util.ArrayList;

public class Motorista extends Cliente {
	private ArrayList<Veiculo> veiculos;
	private ArrayList<Integer> kms;
	
	public Motorista(String nome, String telefone, String email, Endereco endereco, Veiculo veiculo, int km) {
		super(nome, telefone, email, endereco);
		this.veiculos = new ArrayList<Veiculo>();
		this.veiculos.add(veiculo);
		this.kms = new ArrayList<Integer>();
		this.kms.add(km);
	}

	public ArrayList<Veiculo> getVeiculos() {
		return veiculos;
	}

	public ArrayList<Integer> getKms() {
		return kms;
	}
	
	public void addVeiculo (Veiculo novo) {
		this.veiculos.add(novo);
	}
	
	public void addkm (int km) {
		this.kms.add(km);
	}	
}