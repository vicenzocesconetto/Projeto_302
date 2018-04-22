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

			if(comando.equals("1")) {

				System.out.println();

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
				int valor;

				System.out.println("Insira os dados do servico");
				System.out.println("Nome:");
				nome = input.nextLine();
				System.out.println("Valor:");
				valor = Integer.parseInt(input.nextLine());

				servicos.add(new Servico(nome, valor));
			}

			else if(comando.equals("5")) {
				System.out.println("Qual o nome do Cliente?");
				Cliente cliente = funcoes.buscarCliente(clientes, input.nextLine());
				if(cliente != null)
					funcoes.printDadosCliente(cliente);
				else
					System.out.println("Cliente nao encontrado");
			}

			else if(comando.equals("6")) {
				System.out.println("Qual o nome do Produto?");
				Produto produto = funcoes.buscarProduto(produtos, input.nextLine());
				if(produto != null)
					funcoes.printProduto(produto);
				else
					System.out.println("Produto nao encontrado");
			}

			else if(comando.equals("7")) {
				System.out.println("Qual o nome do Servico?");
				Servico servico = funcoes.buscarServico(servicos, input.nextLine());
				if(servico != null)
					funcoes.printServico(servico);
				else
					System.out.println("Servico nao encontrado");
			}

		} while(comando.equals("8"));

		funcoes.imprimeEncerrante();
	}
}
