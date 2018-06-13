Neste projeto desenvolvemos um programa para gerenciar uma oficina mecânica. Um dos principais diferenciais do nosso programa é a possibilidade de prever o retorno do cliente à oficina, pois serviços cíclicos como trocas de óleo, filtros, limpezas, checagem de correias, balanceamento, etc, devem ocorrer a cada determinada quantidade de quilômetros rodados. Dada a previsão, o funcionário da oficina entra em contato com seu cliente e assim garante uma fidelização, contudo, note que essa última parte ainda será implementada na segunda parte do projeto.

Outro diferencial que o sistema de gerenciamento tem é guardar os modelos dos carros compatíveis com um dado produto - não é raro ouvir casos de pessoas que tiveram o óleo ou filtro errados colocados em seu carro. Nessa perspectiva, o programa checa se o produto pode ser utilizado no carro do cliente, também a ser implementado na segunda parte do projeto.

Funcionalidades

No nosso programa de gerenciamento é possível:

 1. Controlar o caixa: o programa salva as entradas e saídas de dinheiro em todas as formas de pagamento aceitas, em suma, a movimentação. Ademais, é possível imprimir um encerrante que mostra todas as transações daquele turno - o tempo de trabalho de um funcionário no caixa.

 2. Cadastrar e gerenciar o estoque dos produtos.
	
 3. Cadastrar serviços oferecidos pela oficina.

 4. Cadastrar e gerenciar os clientes:
 a) Existem dois tipos de cliente: os que não tem carro - apenas compram produtos e não tem um carro cadastrado - e o cliente que tem um carro cadastrado, isto é, um motorista.
 b) Para cada cliente é associado um histórico de compras e serviços realizados.

 5. Gerenciar os dados da empresa e os funcionários presentes nela.

 6. Realizar vendas de diversos produtos e serviços cadastrados.


## To Do List

### FEITO

#### Gustavo

#### Evandro

#### Vicenzo


### A FAZER

#### Gustavo
Serializar classes:
		
		Cliente/Motorista
		Produto
		Servico
		Funcionario

#### Evandro
Dados para o programa
	
	Salvar o caixa
	Salvar dados da empresa
	
#### Vicenzo

Tratamento de excecao
Classe Abstrata: Movimentacao

#### Tarefas Livres
	-Adicionar carros a um cliente
	-Trocar modelo do carro
	-Adicionar mais de um carro
	-Calcular retorno
	-Login/Senha
	-Desconto
	-Detalhe na impressão do encerrante
	-Adicionar a empresa ArrayList de funcionarios
