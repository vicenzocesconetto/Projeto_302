import java.text.DecimalFormat;

public class FuncoesPrint {
	Funcoes funcoes = new Funcoes();
	
	public String imprimeEncerrante(Empresa empresa, Funcionario f){
		DecimalFormat df = new DecimalFormat("0.00");
	    String  str = funcoes.dataHojeBarra() + " - " + funcoes.horaSistema()+"\n";
	    str += "Funcionario: " + f.getNome()+"\n";
       
	    for (int i=0;i<empresa.getMovimentacoes().size();i++) {
	    	if(empresa.getMovimentacoes().get(i) instanceof Entrada) {
				Entrada e = (Entrada)empresa.getMovimentacoes().get(i);
				str += "-------------------------------------\n";
				str += "Entrada!\n";
				str += "Valor: R$" + df.format(e.getValor())+"\n";
				str += "Forma de pagamento: " + e.getFormaPagamento()+"\n";	
			}else {
				Retirada r = (Retirada)empresa.getMovimentacoes().get(i);
					str += "-------------------------------------\n";
					str += "Retirada!\n";
					str += "Valor: R$" + df.format(r.getValor())+"\n";
					str += "Motivo: " + r.getMotivo()+"\n";	
				}
			}
        return str;
   }
		
		public String printDadosCliente(Cliente cliente) {
			if (cliente == null) return "Cliente nao encontrado!";
			String str = "";
			str += "Nome: " + cliente.getNome() + "\n";
			str += "Telefone: " + cliente.getTelefone() + "\n";
			str += "Email: " + cliente.getEmail() + "\n";
			str += "Endereco\n";
			str += "Rua: " + cliente.getEndereco().getRua();
			str += "\tNumero: " + cliente.getEndereco().getNumero() + "\n";
			str += "Bairro: " + cliente.getEndereco().getBairro();
			str += "\tCidade: " + cliente.getEndereco().getCidade();
			str += "\tUF: " + cliente.getEndereco().getUf() + "\n"; 
			 	
			return str;
		}

		public String printVenda(Venda venda) {
			if(venda == null) return "Venda nao encontrada";
			DecimalFormat df = new DecimalFormat("0.00");
			String str="Detalhes da venda:\n";
			str+="Cliente: " + venda.getCliente().getNome() +"\n";
			str+="Data da compra: " + venda.getData();
			str+="\tFuncionario: " + venda.getFuncionario()+"\n";
			
			for (int i=0; i < venda.getProdutos().size();i++) {
				str+="--------------------------------------------------\n";
				str+=venda.getProdutos().get(i).getNome() + "\t";
				str+="Quantidade: " + venda.getQtd().get(i) + "\n";
				str+="Valor Unitario: " + df.format(venda.getProdutos().get(i).getValor());
				str+="\tSubTotal: R$" + df.format(venda.getProdutos().get(i).getValor()*venda.getQtd().get(i)) + "\n";
			}
			for (int i=0; i < venda.getServicos().size();i++) {
				str+="--------------------------------------------------\n";
				str+=venda.getServicos().get(i).getNome()+ "\n";;
				str+="Valor: R$" + df.format(venda.getServicos().get(i).getValor()) + "\n";
			}
			
			str+="--------------------------------------------------\n";
			str+="Valor Total: R$" + df.format(venda.getTotal())+"\n";
			str+="Forma de Pagamento: " + venda.getFormaPagamento()+"\n";
					
			return str;
		}
		
		public String printVeiculosMotorista(Cliente cliente) {
			if (cliente == null) return "Cliente nao encontrado!";
			String str = "Veiculos do cliente\n\n";
			for (int i = 0; i<cliente.getVeiculos().size(); i++) {
					Veiculo veiculo = cliente.getVeiculos().get(i);
					str += "Veiculo " + (i + 1) + "\n\n";
					str += "Tipo " + veiculo.getTipo() + "\n";
					str += "Marca: " + veiculo.getMarca() + "\n";
					str += "Modelo: " + veiculo.getModelo() + "\n";
					//str += "Kilometragem da ultima visita: " + veiculo.getKms() + "\n";
					str += "Ano de fabricacao: " + veiculo.getAnoFabricacao() + "\n";
					str += "Ano do modelo: " + veiculo.getAnoModelo() + "\n";
					str += "Placa: " + veiculo.getPlaca() + "\n";
				}
				return str;
			}
		
		public String printHistoricoDeComprasCliente(Cliente cliente) {
			if (cliente == null) return "Cliente nao encontrado!";
			String str = "Historico de compras do cliente\n\n";
			for (int i = 0; i<cliente.getHistorico().size(); i++) {
				Venda venda = cliente.getHistorico().get(i);
				str += "Compra" + (i + 1) + "\n\n";
				str += "Data da compra: " + venda.getData() + "\n";
				str += "Funcionario responsavel: " + venda.getFuncionario() + "\n"; 
				str += "Forma de pagamento: " + venda.getFormaPagamento() + "\n";
				
				str += "Produtos comprados\n\n";
				for (int j = 0; j<venda.getProdutos().size(); j++) {
					str += venda.getQtd().get(j) + " " + venda.getProdutos().get(j).getNome() + "\n";
				}
				str += "Servicos comprados\n\n";
				for (int j = 0; j<venda.getServicos().size(); j++) {
					str += venda.getServicos().get(j).getNome() + "\n";
				}
				str += "Valor total da venda: " + venda.getTotal() + '\n';	
			}
			return str;
		}
		
		public String printProduto(Produto produto) {
			if (produto == null) return "Produto nao encontrado!";
			String str = "";
			str += "ID: " + produto.getId() + "\n";
			str += "Nome: " + produto.getNome() + "\n";
			str += "Valor: R$" + produto.getValor() + "\n";
			str += "Quantidade em estoque: " + produto.getEstoque() + "\n";
			return str;
		}
		
		public String printServico(Servico servico) {
			if (servico == null) return "Servico nao encontrado!";
			String str = "";
			str += "ID: " + servico.getId() + "\n";
			str += "Nome: " + servico.getNome() + "\n";
			str += "Valor: R$" + servico.getValor() + "\n";
			return str;
		}
}
