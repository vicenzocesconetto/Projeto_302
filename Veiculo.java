
public class Veiculo {
	private TipoVeiculo tipo;
	private String Marca;
	private String Modelo;
	private String placa;
	private int km;
	private short anoF;
	private short anoM;

	public Veiculo(TipoVeiculo tipo, String marca, String modelo, String placa, int km, short anoF, short anoM) {
		this.tipo = tipo;
		Marca = marca;
		Modelo = modelo;
		this.placa = placa;
		this.km = km;
		this.anoF = anoF;
		this.anoM = anoM;
	}

	public TipoVeiculo getTipo() {
		return tipo;
	}

	public void setTipo(TipoVeiculo tipo) {
		this.tipo = tipo;
	}

	public String getMarca() {
		return Marca;
	}

	public void setMarca(String marca) {
		Marca = marca;
	}

	public String getModelo() {
		return Modelo;
	}

	public void setModelo(String modelo) {
		Modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public int getKm() {
		return km;
	}

	public void setKm(int km) {
		this.km = km;
	}

	public short getAnoF() {
		return anoF;
	}

	public void setAnoF(short anoF) {
		this.anoF = anoF;
	}

	public short getAnoM() {
		return anoM;
	}

	public void setAnoM(short anoM) {
		this.anoM = anoM;
	}
}