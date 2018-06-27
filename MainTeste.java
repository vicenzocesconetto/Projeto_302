import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainTeste {
	public static void main(String[] args) throws IOException {
		Funcoes funcoes = new Funcoes();
	
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		Cliente evandro = new Cliente("Evandro Luis", "(19)97402-8267", "evandro@unicamp.br", new Endereco("Albert Einstein", "100", "Unicamp", "Campinas", "SP"));
		evandro.addVeiculo(new Veiculo(TipoVeiculo.CARRO, "CHEVROLET", "CORSA", "ABC-1234", 2008, 2009, 164000, 1.4f));
		evandro.addVeiculo(new Veiculo(TipoVeiculo.CARRO, "VOLWSVAGEM", "VOYAGE", "ABC-6789", 2013, 2014, 50000, 1.6f));
		clientes.add(evandro);
		
		clientes.add(new Cliente("Larissa", "123", "1233", new Endereco("132", "12", "132", "13", "49")));
		
		ArrayList<Produto> produtos = new ArrayList<Produto>();
		produtos.add(new Produto(2, 5, 9.98f, "Oleo 5W20"));
		produtos.add(new Produto(2, 5, 9.98f, "Oleo 10W20"));
		produtos.add(new Produto(2, 5, 9.98f, "Oleo 5W40"));
		produtos.add(new Produto(2, 5, 9.98f, "Oleo 20W30"));
		
	
		ArrayList<Servico> servicos = new ArrayList<Servico>();
		servicos.add(new Servico("troca de oleo", 49.99f, true));
		servicos.add(new Servico("troca do filtro", 78.50f, true));
		servicos.add(new Servico("Da uma olhada", 1000f, false));
		
		Funcionario funcionario = new Funcionario("Joao", "joao", "1234", Cargo.ATENDENTE);
		
		Empresa empresa = new Empresa("Oficina", "132456798");
		empresa.addFuncionario(funcionario);
		
		PaginaLogin login = new PaginaLogin(empresa, clientes, produtos, servicos);
		login.setVisible(true);
		
		
		
	}
}