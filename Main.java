import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		String serFilename = "serialization.ser";
		
		ArrayList<Cliente> clientes = null;
		ArrayList<Produto> produtos = null;
		ArrayList<Servico> servicos = null;
		ObjectInputStream in = null;
		Empresa empresa  = null;
		
		try { //desserializacao
			in = new ObjectInputStream(new FileInputStream(serFilename));
			try {
				clientes = (ArrayList<Cliente>) in.readObject();
				produtos = (ArrayList<Produto>) in.readObject();
				servicos = (ArrayList<Servico>) in.readObject();
				empresa = (Empresa) in.readObject();
				if(clientes != null)
				    Cliente.setNumClientes(clientes.size());
				if(produtos != null)
				    Produto.setNumeroProdutos(produtos.size());
				if(servicos != null)
				    Servico.setGeradorId(servicos.size());

			}catch (ClassNotFoundException ex) {

			}catch (IOException ex) {

			}finally {
				in.close();
			}
		}catch(FileNotFoundException ex) {

		}catch (IOException ex) {

		}
		

		if (clientes == null) {
			clientes = new ArrayList<Cliente>();
			Cliente evandro = new Cliente("Evandro Luis", "(19)97402-8267", "evandro@unicamp.br", new Endereco("Albert Einstein", "100", "Unicamp", "Campinas", "SP"));
			evandro.addVeiculo(new Veiculo(TipoVeiculo.CARRO, "CHEVROLET", "CORSA", "ABC-1234", 2008, 2009, 164000, 1.4f));
			evandro.addVeiculo(new Veiculo(TipoVeiculo.CARRO, "VOLWSVAGEM", "VOYAGE", "ABC-6789", 2013, 2014, 50000, 1.6f));
			clientes.add(evandro);
		}
		
		if(produtos == null) {
			produtos = new ArrayList<Produto>();	
		}
		if (servicos == null) {
			servicos = new ArrayList<Servico>();
		}

		Funcionario admin = new Funcionario("Administrador", "admin", "admin", Cargo.GERENTE);
		Funcionario funcionario = new Funcionario("Joao", "joao", "joao", Cargo.ATENDENTE);
		
		empresa = new Empresa("Oficina", "132456798");
		empresa.addFuncionario(funcionario);
		empresa.addFuncionario(admin);
			
		PaginaLogin login = new PaginaLogin(empresa, clientes, produtos, servicos);
		login.setVisible(true);
	}
}
