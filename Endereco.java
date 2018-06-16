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

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua.toUpperCase();
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero.toUpperCase();
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro.toUpperCase();
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade.toUpperCase();
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf.toUpperCase();
	}	
}
