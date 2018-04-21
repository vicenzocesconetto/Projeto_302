import java.util.ArrayList;

public class Veiculo {
	private TipoVeiculo tipo;
	private String marca;
	private String modelo;
	private String placa;
	private short anoFabricacao;
	private short anoModelo;
	private ArrayList<Integer> kms;
	
	public Veiculo(TipoVeiculo tipo, String marca, String modelo, String placa, short anoFabricacao, short anoModelo, int km) {
		this.tipo = tipo;
		this.marca = marca;
		this.modelo = modelo;
		this.placa = placa;
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
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public short getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(short anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public short getAnoModelo() {
		return anoModelo;
	}

	public void setAnoModelo(short anoModelo) {
		this.anoModelo = anoModelo;
	}
	
	public ArrayList<Integer> getKms() {
		return kms;
	}
	
	public void addkm (int km) {
		this.kms.add(km);
	}	
	
}
