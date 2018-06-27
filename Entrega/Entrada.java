public class Entrada extends Movimentacao implements PrettyPrint{
	private FormaPagamento formaPagamento;

	public Entrada(float valor, FormaPagamento formaPagamento) {
		super(valor);
		this.formaPagamento = formaPagamento;
	}
	
	 //GETTERS E SETTER PADROES
	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}
	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

    @Override
    public String prettyPrint() {
        String str = "Entrada\n" +
                "Valor: " + Float.toString(getValor()) + "\n" +
                "Forma de Pagamento: ";

        switch (formaPagamento) {
            case DINHEIRO:
                str += "DINHEIRO";
            case VISA_DEBITO:
                str += "VISA DEBITO";
            case VISA_CREDITO:
                str += "VISA CREDITO";
            case MASTERCARD_DEBITO:
                str += "MASTERCARD DEBITO";
            case MASTERCARD_CREDITO:
                str += "MASTERCARD CREDITO";
        }
        str += "\n";
        return str;
    }
}
