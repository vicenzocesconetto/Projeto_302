import java.io.Serializable;
import java.util.ArrayList;

public class Veiculo implements Serializable{
	private static final long serialVersionUID = 1L;
	private TipoVeiculo tipo;
	private String marca;
	private String modelo;
	private String placa;
	private int anoFabricacao;
	private int anoModelo;
	private ArrayList<Integer> kms;
	
	public Veiculo(TipoVeiculo tipo, String marca, String modelo, String placa, int anoFabricacao, int anoModelo, int km) {
		this.tipo = tipo;
		this.marca = marca.toUpperCase();
		this.modelo = modelo.toUpperCase();
		this.placa = placa.toUpperCase();
		this.anoFabricacao = anoFabricacao;
		this.anoModelo = anoModelo;
		this.kms = new ArrayList<Integer>();
		this.kms.add(km);
	}

	public TipoVeiculo getTipo() {
		return tipo;
	}

	public void setTipo(TipoVeiculo tipo) {
		this.tipo = tipo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca.toUpperCase();
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo.toUpperCase();
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa.toUpperCase();
	}

	public int getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(int anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public int getAnoModelo() {
		return anoModelo;
	}

	public void setAnoModelo(int anoModelo) {
		this.anoModelo = anoModelo;
	}
	
	public ArrayList<Integer> getKms() {
		return kms;
	}
	
	public void addkm (int km) {
		this.kms.add(km);
	}	
}