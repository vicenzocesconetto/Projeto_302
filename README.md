# Projeto 302

Classes bases:

	- Cliente:
		- Contato:
			-Nome
			-Telefone
			-Endereço -> classe endereço
			-email
		- Array historico
		- Static Num de Clientes

		+ addHistorico
		
	- Veiculo
		- Enum TipoVeiculo
		- Modelo/Marca
		- Placa
		- Ano fabricação/Ano Modelo
	
	- Motorista extends Cliente
		- ArrayList<Veiculo> veiculos
		- ArrayList<int> kms

		+ addVeiculos
		+ addKMs
		
	- Produto:
		- Id
		- Nome
		- Valor 
		- Estoque
		- Estoque Minimo
//		- ArrayLis<Veiculo> Modelos compativeis
		- Static Quantidade de produtos cadastrados
		
		+ checarEstoque
		+ diminuirEstoque
		+ aumentarEstoque		

	- Funcionarios:
		- Nome
		- Enum Cargo
		- login
		- senha

	- Empresa:
		- Nome
		- CNPJ
		- Caixa
		- ArrayList <Movimentacao>

		+ addMovimentacao

	- Movimentacao: 
		- valor 
		
	- Entrada extends Movimentacao
		- Tipo de pagamento
	
	- Retirada extends Movimentacao
		- Motivo
		
	- Venda:  
		- Cliente
		- ArrayList<Produto> Produtos
		- ArrayList<Servico> Servicos
		- Enum Tipo de pagamento
		- Data
		- Funcionario Responsavel 
		- Empresa
		- Total

		+ addProdutos
		+ addServicos
		+ Finalizar venda
			->alterar caixa
			->salvar a movimentação
			->diminuir estoque
			->salvar historico
		+ Desconto
		
	- Serviços:
		- Id
		- Nome
		- Preço

	- Main
		- ArrayList<Cliente> clientes
		- ArrayList<Produto> produtos
		- ArrayList<Servico> servicos
		- Empresa
		
		+ Buscas (Cliente/Produto/Servicos)
		+ Adicionar (Cliente/Produto/Servicos)
		+ Atualizar estoque
		+ Retira
		+ ImprimirEncerrante
