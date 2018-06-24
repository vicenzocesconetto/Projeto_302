public class Retirada extends Movimentacao {
	private String motivo;

	public Retirada(float valor, String motivo) {
		super(valor);
		this.motivo = motivo.toUpperCase();
	}

	//GETTERS E SETTER PADROES
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo.toUpperCase();
	}
}
