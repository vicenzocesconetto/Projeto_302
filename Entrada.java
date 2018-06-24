public class Entrada extends Movimentacao {
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
}
