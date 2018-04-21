public class Retirada extends Movimentacao {
	private String motivo;

	public Retirada(float valor, String motivo) {
		super(valor);
		this.motivo = motivo;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
}
