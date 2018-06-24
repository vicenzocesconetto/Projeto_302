import java.sql.Date;

public class Retorno {
	private Date data;
	private Venda venda;
	private Veiculo veiculo;
	
	public Retorno(Venda venda, Veiculo veiculo) {
		this.venda=venda;
		this.veiculo=veiculo;
		this.setData();
	}

	@SuppressWarnings("deprecation")
	public void setData() {
		Date data = new Date( System.currentTimeMillis());
		int dias=0;
		
		for (int i=0;i<venda.getProdutos().size();i++) {
			if(venda.getProdutos().get(i).getRendimento()!=0) { //CALCULA O RETORNO DE ACORDO COM O CONSUMO DO CARRO
				dias=(int) (venda.getProdutos().get(i).getRendimento()/veiculo.getKmDia());
				if(venda.getProdutos().get(i).getValidade()*30<dias) { //CASO A VALIDADE DO PRODUTO SEJA MENOR QUE O TEMPO DE ACORDO COM O CONSUMO
					dias=venda.getProdutos().get(i).getValidade()*30;
				}
			}
		}
		data.setDate(data.getDate()+dias);
		this.data=data;
	}
	
	//GETTERS E SETTER PADROES
	public Date getData() {
		return data;
	}

	public Venda getVenda() {
		return venda;
	}	
}
