import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
	//INICIALIZA O ARRAYLIST QUE SALVAM OS DADOS DO SISTEMA
	ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	ArrayList<Produto> produtos = new ArrayList<Produto>();
	ArrayList<Servico> servicos = new ArrayList<Servico>();
		
	//INICIALIZA OS DADOS DA CLASSE EMPRESA E FUNCIONARIO
	Empresa empresa = new Empresa("Oficina Imperial, LLC.", "4206969");
	Funcionario funcionario = new Funcionario("Joao", "joao", "1234", Cargo.ATENDENTE);
	
	//INICIALIZA A CLASSE QUE GUARDA AS FUNÇOES USADAS NA MAIN
	Funcoes funcoes = new Funcoes();

	//VARIAVEIS PARA LER A ENTRADA DE DADOS DO USUARIO
	Scanner input = new Scanner(System.in); 
	int op=10;								
		
	//VARIAVEIS AUXILIARES
	String aux;
	boolean continua=true;
	boolean bool=true;
		
	//INICIANDO O SISTEMA
	System.out.println("Bem-vindo a Oficina 3.0!");
	System.out.println("Qual o valor do seu caixa atual?");
	empresa.setCaixa(input.nextFloat());
		
	while(continua) {
		//MENU INICIAL
		System.out.print("\033[H\033[2J");
		System.out.println("O que voce quer fazer?");
		System.out.println("[1] Realizar venda");
		System.out.println("[2] Cadastrar cliente");
		System.out.println("[3] Cadastrar produto/servico");
		System.out.println("[4] Consultar/Atualizar Estoque de Produtos");
		System.out.println("[5] Caixa");
		System.out.println("[6] Retorno de Clientes");
		System.out.println("[7] Consultar/Atualizar Cliente/Produto/Servico");
		System.out.println("[0] Sair do sistema");
		op=input.nextInt();input.nextLine(); //LEITURA DE INTS, ESTOU USANDO UM "NEXTLINE" APOS A LEITURA DO INT PARA LER O "\N"
			
		switch(op) {
		//FAZER VENDA
		case 1:

		bool = true;
			
		//BUSCA O CADASTRO DO CLIENTE
		Cliente c=null;
		while(true) {
			System.out.print("\033[H\033[2J");
			System.out.println("****************** Realizar venda! ******************\n");
			System.out.println("Precione [0] para voltar");
			System.out.print("Entre com nome do Cliente:");
		
			aux=input.nextLine();
				
			//AQUI A PESSOA PODE VOLTAR PARA O MENU ANTERIOR
			if(aux.equals("0")) break; 
									
			c=funcoes.buscarCliente(clientes, aux);
			if(c==null) {
				System.out.println("------------------------------------------------------------");	
				System.out.println("Cliente nao encontrado!");
				System.out.println("------------------------------------------------------------");	
			}
			else break;	
		}
		//SE A PESSOA INTERROMPE A EXECUÇAO AQUI ELA E MANDADA PARA O MENU ANTERIOR
		if(c==null) break;
						
		Venda vendaNova = new Venda(c, funcionario.getNome(), empresa);
						
		//NOVO MENU
		while(bool) {
			System.out.print("\033[H\033[2J");
			System.out.println("O que voce quer fazer?");
			System.out.println("[1] Adicionar Produto");
			System.out.println("[2] Remover Produto");
			System.out.println("[3] Adicionar Servico");
			System.out.println("[4] Remover Servico");
			System.out.println("[5] Concluir Venda");
			System.out.println("Precione [0] para voltar");
			
			op=input.nextInt();input.nextLine();
									
			switch (op) {
			case 1:
			//ADICIONAR PRODUTO
				Produto p=null;
				//PROCURA O CADASTRO DO PRODUTO
				while(true) {
					System.out.print("\033[H\033[2J");
					System.out.println("****************** Adicionar produto a venda! ******************\n");
					System.out.println("Precione [0] para voltar");
					System.out.print("Entre com nome do produto:");
								
					aux=input.nextLine();
						
					//AQUI A PESSOA PODE VOLTAR PARA O MENU ANTERIOR
					if(aux.equals("0")) break;
												
					p=funcoes.buscarProduto(produtos, aux);
					if(p==null) {
						System.out.println("------------------------------------------------------------");	
						System.out.println("Produto nao encontrado!");
						System.out.println("------------------------------------------------------------");	
					}
					else break;	
				}
				//SE A PESSOA INTERROMPE A EXECUÇAO AQUI ELA E MANDADA PARA O MENU ANTERIOR
				if(p==null) break;
											
				System.out.println(funcoes.printProduto(p));
									
				//ADICIONA A QTD DO PRODUTO
				while (true) {
					System.out.println(funcoes.printProduto(p));
					System.out.println("Precione [0] para voltar");
					System.out.print("Quantas unidades? ");					
						
					op=input.nextInt();input.nextLine();
						
					//AQUI A PESSOA PODE VOLTAR PARA O MENU ANTERIOR
					if(op==0) break;
					else {
						if(p.checarEstoque(op)){
							vendaNova.addProduto(p, op);
							break;
						}
						else {
							System.out.println("------------------------------------------------------------");
							System.out.println("Sem Estoque!");
							System.out.println("------------------------------------------------------------");
						}
					}
				}
				//SE A PESSOA INTERROMPE A EXECUÇAO AQUI ELA E MANDADA PARA O MENU ANTERIOR
				if(op==0) break;
				
				System.out.println("------------------------------------------------------------");							
				System.out.println("Produto adicionado!");
				System.out.println("------------------------------------------------------------");
			break;						
				
			case 2:
			//REMOVER PRODUTO					
				System.out.print("\033[H\033[2J");
				System.out.println("****************** Remover produtos da venda! ******************\n");
								
				if(vendaNova.getProdutos().size()==0) {
					System.out.println("Nenhum produto adicionado!");
					System.out.println("------------------------------------------------------------");
					break;
				}
									
				//LISTA PRODUTOS ADICIONADOS
				System.out.println("Produtos adicionados:\n");
				for (int i=0; i<vendaNova.getProdutos().size();i++) {
					System.out.println("Item nº: " +(i+1));
					System.out.println("Quantidade: " + vendaNova.getQtd().get(i));
					System.out.println(funcoes.printProduto(vendaNova.getProdutos().get(i)));
				}
				System.out.println("------------------------------------------------------------");
				//REMOVE OS PRODUTOS PELO N DO ITEM
				while (true) {
					System.out.println("Precione [0] para voltar");
					System.out.print("Entre com o numero do item que voce quer excluir: ");
										
					op=input.nextInt();input.nextLine();;
						
					//AQUI A PESSOA PODE VOLTAR PARA O MENU ANTERIOR
					if(op==0) break;
										
					if(op>vendaNova.getProdutos().size()) {
						System.out.println("------------------------------------------------------------");
						System.out.println("Numero do item incorreto!");
						System.out.println("------------------------------------------------------------");
					}
					else {								
						vendaNova.removeProduto(op-1);
						System.out.println("------------------------------------------------------------");
						System.out.println("Produto removido!");
						System.out.println("------------------------------------------------------------");
					}
				}
				break;
						
				case 3:
				//ADICIONAR SERVICO				
					Servico s=null;
					//PROCURA O CADASTRO DO SERVICO		
					while(true) {
						System.out.print("\033[H\033[2J");
						System.out.println("****************** Adicionar servico a venda! ******************\n");
						System.out.println("Precione [0] para voltar");
						System.out.println("Entre com nome do servico: ");
								
						aux=input.nextLine();
						
						//AQUI A PESSOA PODE VOLTAR PARA O MENU ANTERIOR
						if(aux.equals("0")) break;										
												
						s=funcoes.buscarServico(servicos, aux);
						if(s==null) {
							System.out.println("------------------------------------------------------------");
							System.out.println("Servico nao encontrado!");
							System.out.println("------------------------------------------------------------");
						}
						else break;	
					}
					//SE A PESSOA INTERROMPE A EXECUÇAO AQUI ELA E MANDADA PARA O MENU ANTERIOR
					if(s==null) break;
											
					vendaNova.addServico(s);
					//NA PROXIMA IMPLEMENTACAO SE O CLIENTE TIVER UM CARRO CADASTRADO (MOTORISTA) VAMOS ATUALIZAR O VETOR KMS DO MESMO
					System.out.println("------------------------------------------------------------");
					System.out.println("Servico adicionado!");
					System.out.println("------------------------------------------------------------");					
				break;									
				
				case 4:
				//REMOVER SERVICO
					System.out.print("\033[H\033[2J");
					System.out.println("****************** Remover servicos da venda! ******************\n");
									
					if(vendaNova.getServicos().size()==0) {
						System.out.println("Nenhum servico adicionado!");
						System.out.println("------------------------------------------------------------");
						break;
					}
									
					//LISTA OS SERVICO ADICIONADOS
					System.out.println("Servico adicionados:");
					for (int i=0; i<vendaNova.getProdutos().size();i++) {
						System.out.println("Item nº: " +(i+1));
						System.out.println(funcoes.printServico(vendaNova.getServicos().get(i)));
					}
					System.out.println("------------------------------------------------------------");
					//REMOVE OS SERVICO PELO N DO ITEM
					while (true) {
						System.out.println("Precione [0] para voltar");
						System.out.print("Entre com o numero do item que voce quer excluir: ");
												
						op=input.nextInt();input.nextLine();
						
						//AQUI A PESSOA PODE VOLTAR PARA O MENU ANTERIOR
						if(op==0) break;
												
						if(op>vendaNova.getServicos().size()) {
							System.out.println("------------------------------------------------------------");
							System.out.println("Numero do item incorreto!");
							System.out.println("------------------------------------------------------------");
						}
						else {								
							vendaNova.removeServico(op-1);
							System.out.println("------------------------------------------------------------");
							System.out.println("Servico removido!");
							System.out.println("------------------------------------------------------------");
						}
					}
				break;
									
				case 5:
					while(bool) {
						System.out.print("\033[H\033[2J");
						System.out.printf("Valor da Venda: R$%.2f\n", vendaNova.getTotal());
						System.out.println("Qual a forma de pagamento:");
						System.out.println("[1] Dinheiro");
						System.out.println("[2] Cartao de Credito");
						System.out.println("[3] Cartao de Debito");
						System.out.println("Precione [0] para voltar");
						op=input.nextInt();input.nextLine();
							
						switch(op) {
						case 1:
							vendaNova.setFormaPagamento(FormaPagamento.DINHEIRO);
							bool=false;
							break;
						
						case 2:
							vendaNova.setFormaPagamento(FormaPagamento.CARTAO_DE_CREDITO);
							bool=false;
							break;
							
						case 3:
							vendaNova.setFormaPagamento(FormaPagamento.CARTAO_DE_DEBITO);
							bool=false;
							break;
							
						case 0:
							bool=false;
							break;
							
						default:
							System.out.println("------------------------------------------------------------");
							System.out.println("Opcao INVALIDA!");
							System.out.println("Precione [ENTER] para voltar");
							System.out.println("------------------------------------------------------------");
							System.in.read();
							break;
						}
					}			
					bool=true;
					if(op==0) break;
																			
					while(bool) {
						System.out.print("\033[H\033[2J");
						System.out.println(funcoes.printVenda(vendaNova)+"\n");
						System.out.println("Precione [1] para concluir venda");
						System.out.println("Precione [0] para voltar");
						
						op=input.nextInt();input.nextLine();;
							
						switch (op) {
						case 1:
							vendaNova.finalizarVenda();
							System.out.println("------------------------------------------------------------");
							System.out.println("Venda concluida!");
							System.out.println("------------------------------------------------------------");
							bool=false;
							break;
						case 0:
							bool=false;
							break;
						default:
							System.out.println("------------------------------------------------------------");
							System.out.println("Opcao INVALIDA!");
							System.out.println("Precione [ENTER] para voltar");
							System.out.println("------------------------------------------------------------");
							System.in.read();
							break;
						}
					}
				if(op==0)bool=true;
				break;
				
				case 0:
					bool=false;
					break;
				
				default:
					System.out.println("------------------------------------------------------------");
					System.out.println("Opcao INVALIDA!");
					System.out.println("Precione [ENTER] para voltar");
					System.out.println("------------------------------------------------------------");
					System.in.read();
					break;						
			}			
			}
		break;	

		//CADASTRAR CLIENTE			
		case 2:				
		
		bool=true;
		
		while(bool) {
			System.out.print("\033[H\033[2J");
			System.out.println("****************** Cadastrar Clientes! ******************\n");
			System.out.println("Precione [1] para cadastrar de novo cliente:");
			System.out.println("Precione [0] para voltar");
			op=input.nextInt();input.nextLine();;
				
			switch (op) {
			case 1:
				System.out.print("\033[H\033[2J");
				System.out.print("Nome: ");
				String nome = input.nextLine();
				System.out.print("Telefone: ");
				String telefone = input.nextLine();
				System.out.print("e-mail: ");
				String email = input.nextLine();
				System.out.println("\nEndereco\n");
				System.out.print("Rua: ");
				String rua = input.nextLine();
				System.out.print("Numero: ");
				String numero = input.nextLine();
				System.out.print("Bairro: ");
				String bairro = input.nextLine();
				System.out.print("Cidade: ");
				String cidade = input.nextLine();
				System.out.print("Estado: ");
				String uf = input.nextLine();
				
				while(bool) {
					System.out.println("------------------------------------------------------------");
					System.out.println("Precione [1] para cadastrar o veiculo do cliente");
					System.out.println("Precione [2] para finalizar o cadastramento");
					System.out.println("Precione [0] para voltar");
					System.out.println("------------------------------------------------------------");

					op=input.nextInt();input.nextLine();
					
					switch(op) {
					case 1:
						System.out.print("\033[H\033[2J");
						System.out.print("Marca: ");
						String marca = input.nextLine().toUpperCase();
						System.out.print("Modelo: ");
						String modelo = input.nextLine().toUpperCase();
						System.out.print("Placa: ");
						String placa = input.nextLine().toUpperCase();
						System.out.print("Ano de Fabricacao: ");
						int anoFabricacao= input.nextInt();
						System.out.print("Ano Modelo: ");
						int anoModelo= input.nextInt();
						System.out.print("Kilometragem atual: ");
						int km= input.nextInt();
					
						while(bool) {
							System.out.println("------------------------------------------------------------");
							System.out.println("Qual o tipo do veiculo?");
							System.out.println("Precione [1] para carros/SUVs");
							System.out.println("Precione [2] para motocicletas");
							System.out.println("Precione [3] para caimnhoes/onibus");
							System.out.println("------------------------------------------------------------");
							op=input.nextInt();input.nextLine();
							
							switch(op) {
							case 1:
								clientes.add(new Motorista(nome, telefone, email, new Endereco(rua, numero, bairro, cidade, uf), new Veiculo(TipoVeiculo.CARRO, marca, modelo, placa, anoFabricacao, anoModelo, km)));
								bool=false;
								break;
							case 2:
								clientes.add(new Motorista(nome, telefone, email, new Endereco(rua, numero, bairro, cidade, uf), new Veiculo(TipoVeiculo.MOTO, marca, modelo, placa, anoFabricacao, anoModelo, km)));
								bool=false;
								break;
							case 3:
								clientes.add(new Motorista(nome, telefone, email, new Endereco(rua, numero, bairro, cidade, uf), new Veiculo(TipoVeiculo.CAMINHÃO, marca, modelo, placa, anoFabricacao, anoModelo, km)));
								bool=false;
								break;
							default:
								System.out.println("------------------------------------------------------------");
								System.out.println("Opcao INVALIDA!");
								System.out.println("Precione [ENTER] para voltar");
								System.out.println("------------------------------------------------------------");
								System.in.read();
								break;
							}
						}
						break;
					case 2:
						clientes.add(new Cliente(nome, telefone, email, new Endereco(rua, numero, bairro, cidade, uf)));
						bool=false;
						break;
					case 0:
						bool=false;
						break;
					default:
						System.out.println("------------------------------------------------------------");
						System.out.println("Opcao INVALIDA!");
						System.out.println("Precione [ENTER] para voltar");
						System.out.println("------------------------------------------------------------");
						System.in.read();
						break;					
					}
				}
				System.out.println("------------------------------------------------------------");
				System.out.println("Cliente Cadastrado");
				System.out.println("Precione [ENTER] para voltar");
				System.out.println("------------------------------------------------------------");
				System.in.read();
				break;

			case 0:
				bool=false;
				break;
			default:
				System.out.println("------------------------------------------------------------");
				System.out.println("Opcao INVALIDA!");
				System.out.println("Precione [ENTER] para voltar");
				System.out.println("------------------------------------------------------------");
				System.in.read();
				break;
			}
		}
		break;

		//CADASTRAR PRODUTO/SERVICO				
		case 3:	
		
		bool=true;	
		
		while (bool) {
			System.out.print("\033[H\033[2J");
			System.out.println("****************** Cadastrar Produto/Servico ******************\n");
			
			System.out.println("Precione [1] para cadastrar um produto");
			System.out.println("Precione [2] para cadastrar um servico");
			System.out.println("Precione [0] para voltar");
			
			op=input.nextInt();input.nextLine();
					
			switch(op) {
			case 1:
				System.out.print("\033[H\033[2J");
				System.out.print("Nome: ");
				String nome = input.nextLine();
				System.out.print("Valor: R$");
				float valor = input.nextFloat();
				System.out.print("Estoque Atual: ");
				int estoque = input.nextInt();
				System.out.print("Estoque Minimo: ");
				int estoqueMinimo = input.nextInt();
					
				produtos.add(new Produto(estoqueMinimo, estoque, valor, nome));
				System.out.println("------------------------------------------------------------");
				System.out.println("Novo Produto Cadastrado!");
				System.out.println("Precione [ENTER] para voltar");
				System.out.println("------------------------------------------------------------");
				System.in.read();
				break;
			case 2:
				System.out.print("\033[H\033[2J");
				System.out.print("Nome:");
				String nome_s = input.nextLine();
				System.out.print("Valor (R$):");
				float valor_s = input.nextFloat();
				
				servicos.add(new Servico(nome_s, valor_s));
				System.out.println("------------------------------------------------------------");
				System.out.println("Novo Servico Cadastrado!");
				System.out.println("Precione [ENTER] para voltar");
				System.out.println("------------------------------------------------------------");
				System.in.read();
				break;
			case 0:
				bool=false;
				break;
			default:
				System.out.println("------------------------------------------------------------");
				System.out.println("Opcao INVALIDA!");
				System.out.println("Precione [ENTER] para voltar");
				System.out.println("------------------------------------------------------------");
				System.in.read();
				break;
			}
		}
		break;
		
		//CONSULTAR/ATUALIZAR ESTOQUE				
		case 4:

		bool=true;
		
		while (true) {
			System.out.print("\033[H\033[2J");
			System.out.println("****************** Consultar/Atualizar estoque ******************\n");
	
			System.out.println("Precione [0] para voltar");
			System.out.print("Digite o nome do produto: ");
					
			aux=input.nextLine();
			
			//AQUI A PESSOA PODE VOLTAR PARA O MENU ANTERIOR
			if(aux.equals("0")) break; 
			
			Produto produto=funcoes.buscarProduto(produtos, aux);
			if(produto==null) {
				System.out.println("------------------------------------------------------------");
				System.out.println("Produto nao encontrado");
				System.out.println("------------------------------------------------------------");
			}
			else {
				while(bool) {
					System.out.print("\033[H\033[2J");
					System.out.println(produto.getNome());
					System.out.println("Estoque atual: "+produto.getEstoque());
					System.out.println("------------------------------------------------------------");
					System.out.println("Precione [1] para atualizar o estoque");
					System.out.println("Precione [0] para voltar");
					System.out.println("------------------------------------------------------------");
					
					op=input.nextInt();input.nextLine();
						
					switch (op) {
					case 1:					
						System.out.print("Digite o valor do estoque: ");
						produto.setEstoque(input.nextInt());
						System.out.println("------------------------------------------------------------");
						System.out.println("Novo valor de estoque salvo");
						System.out.println("Precione [ENTER] para voltar");
						System.out.println("------------------------------------------------------------");
						System.in.read();
						bool=false;
						break;
					
					case 0:
						bool=false;
						break;
						
					default:
						System.out.println("------------------------------------------------------------");
						System.out.println("Opcao INVALIDA!");
						System.out.println("Precione [ENTER] para voltar");
						System.out.println("------------------------------------------------------------");
						System.in.read();
						break;
					}
				}
			}
		}
		break;
			
		//CAIXA				
		case 5:
			
		bool = true;
		
		while(bool) {
			System.out.print("\033[H\033[2J");
			System.out.println("****************** Caixa ******************\n");
			
			System.out.println("O que voce quer fazer?");
			System.out.println("[1] Exibir caixa atual");
			System.out.println("[2] Imprimir encerrante");
			System.out.println("[3] Fazer Retirada");
			System.out.println("Precione [0] para voltar");
			
			op=input.nextInt();input.nextLine();
				
			switch (op) {
			case 1:
				System.out.print("\033[H\033[2J");
				System.out.printf("Valor do Caixa: R$%.2f\n",  empresa.getCaixa() );
				System.out.println("Precione [ENTER] para voltar");
				System.in.read();
				break;
			case 2:
				System.out.print("\033[H\033[2J");
				System.out.println(funcoes.imprimeEncerrante(empresa.getMovimentacoes()));
				System.out.println("Precione [ENTER] para voltar");
				System.out.println("------------------------------------------------------------");
				System.in.read();
				break;
					
			case 3:
				System.out.print("\033[H\033[2J");
				System.out.println("Qual o valor da retirada(R$)?");
				float valor = input.nextFloat();input.nextLine();
				System.out.println("Qual o motivo da retirada?");
				String motivo = input.nextLine();
				if(funcoes.retirarDinheiro(empresa, valor, motivo)) {
					System.out.println("------------------------------------------------------------");
					System.out.println("Retirada Autorizada!");
					System.out.println("Precione [ENTER] para voltar");
					System.out.println("------------------------------------------------------------");
					System.in.read();
				}
				else {
					System.out.println("------------------------------------------------------------");
					System.out.println("Retirada NAO Autorizada!");
					System.out.println("Precione [ENTER] para voltar");
					System.out.println("------------------------------------------------------------");
					System.in.read();
				}
				break;
			case 0:
				bool=false;
				break;
			default:
				System.out.println("------------------------------------------------------------");
				System.out.println("Opcao INVALIDA!");
				System.out.println("Precione [ENTER] para voltar");
				System.out.println("------------------------------------------------------------");
				System.in.read();
				break;
			}
		}		
		break;			
		
		//RETORNO DE CLIENTES
		case 6:
		//A SER IMPLEMTENTADO
			System.out.println("NÃO DISPONIVEL!");
			System.out.println("Precione [ENTER] para voltar");
			System.out.println("------------------------------------------------------------");
			System.in.read();
			break;
		
		//CONSULTAR/ATUALIZAR DADOS
		case 7:
			
		bool=true;
		
		while(bool) {
			System.out.print("\033[H\033[2J");
			System.out.println("****************** Consultar/Atualizar dados ******************\n");
					
			System.out.println("O que voce quer consultar?");
			System.out.println("[1] Cliente");
			System.out.println("[2] Produto");
			System.out.println("[3] Servico");
			System.out.println("Precione [0] para voltar");
			
			op=input.nextInt();input.nextLine();
					
			switch(op) {
			case 1:
				Cliente cliente=null;
				while (true) {
					System.out.print("\033[H\033[2J");
					System.out.println("Precione [0] para voltar");
					System.out.print("Entre com o nome do Cliente: ");
										
					aux=input.nextLine();
					
					//AQUI A PESSOA PODE VOLTAR PARA O MENU ANTERIOR
					if(aux.equals("0")) break;
					
					cliente = funcoes.buscarCliente(clientes, aux);
					if(cliente != null) { 
						System.out.println(funcoes.printDadosCliente(cliente));
						break;
					}
					else System.out.println("Cliente nao encontrado");
				}
				//SE A PESSOA INTERROMPE A EXECUÇAO AQUI ELA E MANDADA PARA O MENU ANTERIOR
				if(cliente==null) break;
					
				while(bool) {
					System.out.println("------------------------------------------------------------");
					System.out.println("Precione [1] para atualizar os dados do cliente");
					System.out.println("Precione [0] para voltar");
					System.out.println("------------------------------------------------------------");
	
					op=input.nextInt();input.nextLine();
						
					switch (op) {
					case 1:
						atualizarCliente(cliente);
						bool=false;
					case 0:
						bool=false;
						break;
					default:
						System.out.println("------------------------------------------------------------");
						System.out.println("Opcao INVALIDA!");
						System.out.println("Precione [ENTER] para voltar");
						System.out.println("------------------------------------------------------------");
						System.in.read();
						break;
					}
				}
			bool=true;
			break;
				
			case 2:
				Produto produto=null;
				while (true) {
					System.out.print("\033[H\033[2J");
					System.out.println("Precione [0] para voltar");
					System.out.print("Entre com o nome do Produto: ");
										
					aux=input.nextLine();
					
					//AQUI A PESSOA PODE VOLTAR PARA O MENU ANTERIOR
					if(aux.equals("0")) break;
					
					produto = funcoes.buscarProduto(produtos, aux);
					if(produto != null) {
						System.out.println(funcoes.printProduto(produto));
						break;
					}
					else System.out.println("Produto nao encontrado");
				}
				//SE A PESSOA INTERROMPE A EXECUÇAO AQUI ELA E MANDADA PARA O MENU ANTERIOR
				if(produto==null) break;
					
				while(bool) {
					System.out.println("------------------------------------------------------------");
					System.out.println("Precione [1] para atualizar os dados do produto");
					System.out.println("Precione [0] para voltar");
					System.out.println("------------------------------------------------------------");
	
					op=input.nextInt();input.nextLine();
						
					switch (op) {
					case 1:
						atualizarProduto(produto);
						bool=false;
					case 0:
						bool=false;
						break;
					default:
						System.out.println("------------------------------------------------------------");
						System.out.println("Opcao INVALIDA!");
						System.out.println("Precione [ENTER] para voltar");
						System.out.println("------------------------------------------------------------");
						System.in.read();
						break;
					}
				}
			bool=true;
			break;
				
			case 3:
				Servico servico=null;
				while (true) {
					System.out.print("\033[H\033[2J");
					System.out.println("Precione [0] para voltar");
					System.out.print("Entre com o nome do servico: ");
					
					aux=input.nextLine();
					
					//AQUI A PESSOA PODE VOLTAR PARA O MENU ANTERIOR
					if(aux.equals("0")) break;
					
					servico = funcoes.buscarServico(servicos, aux);
					if(servico != null) {
						System.out.println(funcoes.printServico(servico));
						break;
					}
					else System.out.println("Servico nao encontrado");
				}
				//SE A PESSOA INTERROMPE A EXECUÇAO AQUI ELA E MANDADA PARA O MENU ANTERIOR
				if(servico==null) break;
					
				while(bool) {
					System.out.println("------------------------------------------------------------");
					System.out.println("Precione [1] para atualizar os dados do Servico");
					System.out.println("Precione [0] para voltar");
					System.out.println("------------------------------------------------------------");
	
					op=input.nextInt();input.nextLine();
						
					switch (op) {
					case 1:
						atualizarServico(servico);
						bool=false;
					case 0:
						bool=false;
						break;
					default:
						System.out.println("------------------------------------------------------------");
						System.out.println("Opcao INVALIDA!");
						System.out.println("Precione [ENTER] para voltar");
						System.out.println("------------------------------------------------------------");
						System.in.read();
						break;
					}
				}
			bool=false;
			break;
		
			case 0:
				bool=false;
				break;
		
			default:
				System.out.println("------------------------------------------------------------");
				System.out.println("Opcao INVALIDA!");
				System.out.println("Precione [ENTER] para voltar");
				System.out.println("------------------------------------------------------------");
				System.in.read();
				break;
			}
		}
		break;
		
		//ENCERRA O PROGRAMA
		case 0:
			System.out.print("\033[H\033[2J");
			System.out.println("************************************************************");
			System.out.println("Encerrando o sistema...");
			continua=false;
			System.out.println("Encerrado");
			System.out.println("************************************************************");
			break;
		
		default:
			System.out.println("------------------------------------------------------------");
			System.out.println("Opcao INVALIDA!");
			System.out.println("Precione [ENTER] para voltar");
			System.out.println("------------------------------------------------------------");
			System.in.read();
			break;
		}
	}
	input.close();
	}
	
	public static void atualizarCliente(Cliente cliente) throws IOException {
		int op;
		Scanner input = new Scanner(System.in);
		boolean bool=true;
		
		while(bool) {
			System.out.print("\033[H\033[2J");
			System.out.println("O que voce quer Atualizar?");
			System.out.println("[1] Nome: "+cliente.getNome());
			System.out.println("[2] Telefone: "+cliente.getTelefone());
			System.out.println("[3] e-mail: "+cliente.getEmail());
			System.out.println("[4] Endereco");
			System.out.println("Precione [0] para voltar");
			
			op=input.nextInt();input.nextLine();
					
			switch(op) {
			case 1:
				System.out.print("\033[H\033[2J");
				System.out.print("Digite o novo Nome: ");
				cliente.setNome(input.nextLine());
				System.out.println("------------------------------------------------------------");
				System.out.println("Dado Atualizado!");
				System.out.println("Precione [ENTER] para voltar");
				System.out.println("------------------------------------------------------------");
				System.in.read();
			break;
			
			case 2:
				System.out.print("\033[H\033[2J");
				System.out.print("Digite o novo Telefone: ");
				cliente.setTelefone(input.nextLine());
				System.out.println("------------------------------------------------------------");
				System.out.println("Dado Atualizado!");
				System.out.println("Precione [ENTER] para voltar");
				System.out.println("------------------------------------------------------------");
				System.in.read();
			break;
			
			case 3:
				System.out.print("\033[H\033[2J");
				System.out.print("Digite o novo e-mail: ");
				cliente.setEmail(input.nextLine());
				System.out.println("------------------------------------------------------------");
				System.out.println("Dado Atualizado!");
				System.out.println("Precione [ENTER] para voltar");
				System.out.println("------------------------------------------------------------");
				System.in.read();
			break;
			
			case 4:
				while(bool) {
					System.out.print("\033[H\033[2J");
					System.out.println("O que voce quer Atualizar?");
					System.out.println("[1] Rua: "+cliente.getEndereco().getRua());
					System.out.println("[2] Numero: "+cliente.getEndereco().getNumero());
					System.out.println("[3] Bairro: "+cliente.getEndereco().getBairro());
					System.out.println("[4] Cidade:"+cliente.getEndereco().getCidade());
					System.out.println("[5] UF:"+cliente.getEndereco().getUf());
					System.out.println("Precione [0] para voltar");
					op=input.nextInt();input.nextLine();
										
					switch (op) {
					case 1:
						System.out.print("\033[H\033[2J");
						System.out.print("Digite a nova Rua: ");
						cliente.getEndereco().setRua(input.nextLine());
						System.out.println("------------------------------------------------------------");
						System.out.println("Dado Atualizado!");
						System.out.println("Precione [ENTER] para voltar");
						System.out.println("------------------------------------------------------------");
						System.in.read();
					break;
					
					case 2:
						System.out.print("\033[H\033[2J");
						System.out.print("Digite o novo Numero: ");
						cliente.getEndereco().setNumero(input.nextLine());
						System.out.println("------------------------------------------------------------");
						System.out.println("Dado Atualizado!");
						System.out.println("Precione [ENTER] para voltar");
						System.out.println("------------------------------------------------------------");
						System.in.read();
					break;
					
					case 3:
						System.out.print("\033[H\033[2J");
						System.out.print("Digite o novo Bairro: ");
						cliente.getEndereco().setBairro(input.nextLine());
						System.out.println("------------------------------------------------------------");
						System.out.println("Dado Atualizado!");
						System.out.println("Precione [ENTER] para voltar");
						System.out.println("------------------------------------------------------------");
						System.in.read();
					break;
						
					case 4:
						System.out.print("\033[H\033[2J");
						System.out.print("Digite a nova Cidade: ");
						cliente.getEndereco().setCidade(input.nextLine());
						System.out.println("------------------------------------------------------------");
						System.out.println("Dado Atualizado!");
						System.out.println("Precione [ENTER] para voltar");
						System.out.println("------------------------------------------------------------");
						System.in.read();
					break;
					
					case 5:
						System.out.print("\033[H\033[2J");
						System.out.print("Digite a nova UF: ");
						cliente.getEndereco().setUf(input.nextLine());
						System.out.println("------------------------------------------------------------");
						System.out.println("Dado Atualizado!");
						System.out.println("Precione [ENTER] para voltar");
						System.out.println("------------------------------------------------------------");
						System.in.read();
					break;
					
					case 0:
						bool=false;
						break;
					default:
						System.out.println("------------------------------------------------------------");
						System.out.println("Opcao INVALIDA!");
						System.out.println("Precione [ENTER] para voltar");
						System.out.println("------------------------------------------------------------");
						System.in.read();
						break;
					}
				}
			bool = true;
			case 0:
				bool =false;
				break;
			default:
				System.out.println("------------------------------------------------------------");
				System.out.println("Opcao INVALIDA!");
				System.out.println("Precione [ENTER] para voltar");
				System.out.println("------------------------------------------------------------");
				System.in.read();
				break;
			}			
		}
		input.close();	
		}

	public static void atualizarProduto(Produto produto) throws IOException {
		int op;
		Scanner input = new Scanner(System.in);
		boolean bool=true;
		
		while(bool) {
			System.out.print("\033[H\033[2J");
			System.out.println("O que voce quer Atualizar?");
			System.out.println("[1] Nome: "+produto.getNome());
			System.out.println("[2] Valor: R$"+produto.getValor());
			System.out.println("[3] Estoque Minimo: "+produto.getEstoqueMinimo());
			System.out.println("Precione [0] para voltar");
			
			op=input.nextInt();input.nextLine();
					
			switch(op) {
			case 1:
				System.out.print("\033[H\033[2J");
				System.out.print("Digite o novo Nome: ");
				produto.setNome(input.nextLine());
				System.out.println("------------------------------------------------------------");
				System.out.println("Dado Atualizado!");
				System.out.println("Precione [ENTER] para voltar");
				System.out.println("------------------------------------------------------------");
				System.in.read();
			break;
			
			case 2:
				System.out.print("\033[H\033[2J");
				System.out.print("Digite o novo Valor: R$");
				produto.setValor(input.nextFloat());
				System.out.println("------------------------------------------------------------");
				System.out.println("Dado Atualizado!");
				System.out.println("Precione [ENTER] para voltar");
				System.out.println("------------------------------------------------------------");
				System.in.read();
			break;
			
			case 3:
				System.out.print("\033[H\033[2J");
				System.out.print("Digite o novo Estoque Minimo: ");
				produto.setEstoqueMinimo(input.nextInt());
				System.out.println("------------------------------------------------------------");
				System.out.println("Dado Atualizado!");
				System.out.println("Precione [ENTER] para voltar");
				System.out.println("------------------------------------------------------------");
				System.in.read();
			break;
			
			case 0:
				return;
			default:
				System.out.println("------------------------------------------------------------");
				System.out.println("Opcao INVALIDA!");
				System.out.println("Precione [ENTER] para voltar");
				System.out.println("------------------------------------------------------------");
				System.in.read();
				break;
			}			
		}
		input.close();	
	}	
	
	public static void atualizarServico(Servico servico) throws IOException {
		int op;
		Scanner input = new Scanner(System.in);
		boolean bool=true;
		
		while(bool) {
			System.out.print("\033[H\033[2J");
			System.out.println("O que voce quer Atualizar?");
			System.out.println("[1] Nome: "+servico.getNome());
			System.out.println("[2] Valor: "+servico.getValor());
			System.out.println("Precione [0] para voltar");
			
			op=input.nextInt();input.nextLine();
					
			switch(op) {
			case 1:
				System.out.print("\033[H\033[2J");
				System.out.print("Digite o novo Nome: ");
				servico.setNome(input.nextLine());
				System.out.println("------------------------------------------------------------");
				System.out.println("Dado Atualizado!");
				System.out.println("Precione [ENTER] para voltar");
				System.out.println("------------------------------------------------------------");
				System.in.read();
			break;
			
			case 2:
				System.out.print("\033[H\033[2J");
				System.out.print("Digite o novo Valor: R$");
				servico.setValor(input.nextFloat());
				System.out.println("------------------------------------------------------------");
				System.out.println("Dado Atualizado!");
				System.out.println("Precione [ENTER] para voltar");
				System.out.println("------------------------------------------------------------");
				System.in.read();
			break;
			
			case 0:
				bool =false;
				break;
			default:
				System.out.println("------------------------------------------------------------");
				System.out.println("Opcao INVALIDA!");
				System.out.println("Precione [ENTER] para voltar");
				System.out.println("------------------------------------------------------------");
				System.in.read();
				break;
			}
		}
		input.close();
	}
}		
