import java.io.Serializable;

public class Endereco implements Serializable{
	private static final long serialVersionUID = 1L;
	private String rua;
	private String numero;
	private String bairro;
	private String cidade;
	private String uf;
	
	public Endereco(String rua, String numero, String bairro, String cidade, String uf) {
		super();
		this.rua = rua.toUpperCase();
		this.numero = numero.toUpperCase();
		this.bairro = bairro.toUpperCase();
		this.cidade = cidade.toUpperCase();
		this.uf = uf.toUpperCase();
	}

	public void setRua(String rua) {
		this.rua = rua.toUpperCase();
	}
	
	public void setNumero(String numero) {
		this.numero = numero.toUpperCase();
	}
	
	public void setBairro(String bairro) {
		this.bairro = bairro.toUpperCase();
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade.toUpperCase();
	}
	
	public void setUf(String uf) {
		this.uf = uf.toUpperCase();
	}	
	//GETTERS E SETTER PADROES
	public String getRua() {
		return rua;
	}

	public String getNumero() {
		return numero;
	}

	public String getBairro() {
		return bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public String getUf() {
		return uf;
	}
}
