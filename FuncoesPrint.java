
public class FuncoesPrint {
	Funcoes funcoes = new Funcoes();
	
	public String imprimeEncerrante(Empresa empresa, Funcionario f){
	       String  str = funcoes.dataHojeBarra() + " - " + funcoes.horaSistema()+"\n";
	       str += "Funcionario: " + f.getNome()+"\n";
	       
	       for (int i=0;i<empresa.getMovimentacoes().size();i++) {
				if(empresa.getMovimentacoes().get(i) instanceof Entrada) {
					Entrada e = (Entrada)empresa.getMovimentacoes().get(i);
					str += "-------------------------------------\n";
					str += "Entrada!\n";
					str += "Valor: R$" + e.getValor()+"\n";
					str += "Forma de pagamento: " + e.getFormaPagamento()+"\n";	
				}else {
					Retirada r = (Retirada)empresa.getMovimentacoes().get(i);
						str += "-------------------------------------\n";
						str += "Retirada!\n";
						str += "Valor: R$" + r.getValor()+"\n";
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
			str += "Rua: " + cliente.getEndereco().getRua() + "\n";
			str += "Numero: " + cliente.getEndereco().getNumero() + "\n";
			str += "Bairro: " + cliente.getEndereco().getBairro() + "\n";
			str += "Cidade: " + cliente.getEndereco().getCidade() + "\n";
			str += "UF: " + cliente.getEndereco().getUf() + "\n"; 
			 	
			return str;
		}

		public String printVenda(Venda venda) {
			if(venda == null) return "Venda nao encontrada";
			
			String str="Detalhes da venda:\n";
			str+="Nome: " + venda.getCliente().getNome() +"\n";
			str+="Forma de Pagamento: " + venda.getFormaPagamento()+"\n";
			str+="Data: " + venda.getData()+"\n";
			str+="Funcionario: " + venda.getFuncionario()+"\n";
			str+="Total: " + venda.getTotal();
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
