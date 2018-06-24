import java.io.Serializable;
import java.sql.Date;

public class Veiculo implements Serializable{
	private static final long serialVersionUID = 1L;
	private TipoVeiculo tipo;
	private String marca;
	private String modelo;
	private Float potencia;
	private String placa;
	private int anoFabricacao;
	private int anoModelo;
	private float kmDia;
	private float kmAtual;
	private Date ultimaKm;
	
	public Veiculo(TipoVeiculo tipo, String marca, String modelo, String placa, int anoFabricacao, int anoModelo, int km, Float potencia) {
		this.tipo = tipo;
		this.marca = marca.toUpperCase();
		this.modelo = modelo.toUpperCase();
		this.placa = placa.toUpperCase();
		this.anoFabricacao = anoFabricacao;
		this.anoModelo = anoModelo;
		this.potencia = potencia;
		this.kmAtual=km;
		this.ultimaKm =  new Date(System.currentTimeMillis());
		setkmDiaInicial(km);
	}
	
	@SuppressWarnings("deprecation")
	public void setkmDia(float km, boolean evento) {
		if(evento)return;
		Date dtInicio = this.ultimaKm;//Data menor  
		Date dtFim = new Date( System.currentTimeMillis());//Data maior  
		int dias;
		for (dias = 0; dtFim.after(dtInicio); dias++) {  
		   dtFim.setDate(dtFim.getDate() - 1);  
		}  
		this.ultimaKm=dtFim;
		this.kmAtual=km;
		this.kmDia = km/dias;
	}
	@SuppressWarnings("deprecation")
	public void setkmDiaInicial(float km) {
		Date dtInicio;
		if(anoFabricacao==anoModelo) {
			dtInicio = new Date(anoFabricacao, 06, 01);//Data menor  
		}else {
			dtInicio = new Date(anoFabricacao, 01, 01);//Data menor
		}
		Date dtFim = new Date( System.currentTimeMillis());//Data maior
		int dias;
		for (dias = 0; dtFim.after(dtInicio); dias++) {  
		   dtFim.setDate(dtFim.getDate() - 1);  
		}  
		this.ultimaKm=dtFim;
		this.kmAtual=km;
		this.kmDia = km/dias;
	}
	
	//GETTERS E SETTER PADROES
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

	public Float getPotencia() {
		return potencia;
	}

	public void setPotencia(Float potencia) {
		this.potencia = potencia;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
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

	public float getKmAtual() {
		return kmAtual;
	}

	public void setKmAtual(float kmAtual) {
		this.kmAtual = kmAtual;
	}

	public Date getUltimaKm() {
		return ultimaKm;
	}

	public void setUltimaKm(Date ultimaKm) {
		this.ultimaKm = ultimaKm;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public float getKmDia() {
		return kmDia;
	}
}