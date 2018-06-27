
public class Retirada extends Movimentacao implements PrettyPrint{
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

    @Override
    public String prettyPrint() {
        String str = "Retirada\n" +
                "Valor: " + Float.toString(getValor()) + "\n" +
                "Motivo: " + motivo + "\n";
        return str;
    }
}
