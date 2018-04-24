import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;

public class Main {

	public static void main(String[] args) {

		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		ArrayList<Produto> produtos = new ArrayList<Produto>();
		ArrayList<Servico> servicos = new ArrayList<Servico>();
		Date hoje = new Date();
		Empresa empresa = new Empresa("Oficina Imperial, LLC.", "4206969");
		Funcoes funcoes = new Funcoes();
		Scanner input = new Scanner(System.in);
		String comando;

		System.out.println("Qual o caixa atual?");
		empresa.setCaixa(Float.parseFloat(input.nextLine()));

		do {
			System.out.println("O que voce quer fazer?");
			System.out.println("[1] Realizar venda");
			System.out.println("[2] Cadastrar cliente");
			System.out.println("[3] Cadastrar produto");
			System.out.println("[4] Cadastrar servico");
			System.out.println("[5] Buscar cliente");
			System.out.println("[6] Buscar produto");
			System.out.println("[7] Buscar servico");
			System.out.println("[8] Sair do sistema");

			comando = input.nextLine();

//			Switch is ugly and untransparent
			if(comando.equals("1")) {
				System.out.println("Qual o nome do cliente da compra?");
				Cliente cliente = funcoes.buscarCliente(clientes, input.nextLine());
				Venda venda = new Venda(cliente, "Joao", empresa);

				System.out.println("Nome do Produto (aperte enter para pular):");
				Produto produto = funcoes.buscarProduto(produtos, input.nextLine());
				int qtd = 0;
				if(produto != null) {

					System.out.println("Quantidade:");
					qtd = Integer.parseInt(input.nextLine());
					venda.addProduto(produto, qtd);
				}

				System.out.println("Nome do servico (aperte enter para pular):");
				Servico servico = funcoes.buscarServico(servicos, input.nextLine());
				venda.setCliente(cliente);
				venda.setEmpresa(empresa);
				venda.addServico(servico);
				cliente.addHistorico(venda);

				System.out.println("Qual a forma de pagamento?");
				System.out.println("[1] Dinheiro");
				System.out.println("[2] Cartao de Credito");
				System.out.println("[3] Cartao de Debito");

				byte pag = Byte.parseByte(input.nextLine());
				if(pag == 1)
					venda.setFormaPagamento(FormaPagamento.DINHEIRO);
				else if(pag == 2)
					venda.setFormaPagamento(FormaPagamento.CARTAO_DE_CREDITO);
				else if(pag == 3)
					venda.setFormaPagamento(FormaPagamento.CARTAO_DE_DEBITO);

				funcoes.printVenda(venda);
			}

			else if(comando.equals("2")) {

				System.out.println("Insira os dados do cliente");

				System.out.println("Nome:");
				String nome = input.nextLine();

				System.out.println("Telefone:");
				String telefone = input.nextLine();

				System.out.println("Email:");
				String email = input.nextLine();

				System.out.println("Rua:");
				String rua = input.nextLine();

				System.out.println("Numero:");
				short numero = Short.parseShort(input.nextLine());

				System.out.println("Bairro:");
				String bairro = input.nextLine();

				System.out.println("Cidade:");
				String cidade = input.nextLine();

				System.out.println("Estado:");
				String uf = input.nextLine();

				clientes.add(new Cliente(nome, telefone, email, new Endereco(rua, numero, bairro, cidade, uf)));
			}

			else if(comando.equals("3")) {

				System.out.println("Insira os dados do produto");
				System.out.println("Nome:");
				String nome = input.nextLine();
				System.out.println("Valor:");
				float valor = Integer.parseInt(input.nextLine());
				System.out.println("Estoque:");
				int estoque = Integer.parseInt(input.nextLine());
				System.out.println("Estoque Minimo:");
				int estoqueMinimo = Integer.parseInt(input.nextLine());

				produtos.add(new Produto(estoqueMinimo, estoque, valor, nome));
			}

			else if(comando.equals("4")) {
				String nome;
				float valor;

				System.out.println("Insira os dados do servico");
				System.out.println("Nome:");
				nome = input.nextLine();
				System.out.println("Valor:");
				valor = Float.parseFloat(input.nextLine());
				
				servicos.add(new Servico(nome, valor));
			}

			else if(comando.equals("5")) {
				System.out.println("Qual o nome do Cliente?");
				Cliente cliente = funcoes.buscarCliente(clientes, input.nextLine());
				if(cliente != null)
					System.out.println(funcoes.printDadosCliente(cliente));
				else
					System.out.println("Cliente nao encontrado");
			}

			else if(comando.equals("6")) {
				System.out.println("Qual o nome do Produto?");
				Produto produto = funcoes.buscarProduto(produtos, input.nextLine());
				if(produto != null)
					System.out.println(funcoes.printProduto(produto));
				else
					System.out.println("Produto nao encontrado");
			}

			else if(comando.equals("7")) {
				System.out.println("Qual o nome do Servico?");
				Servico servico = funcoes.buscarServico(servicos, input.nextLine());
				if(servico != null)
					System.out.println(funcoes.printServico(servico));
				else
					System.out.println("Servico nao encontrado");
			}

		} while(!comando.equals("8"));

		System.out.println(funcoes.imprimeEncerrante(empresa.getMovimentacoes()));
	}
}
