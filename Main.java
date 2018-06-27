import java.util.ArrayList;
import java.util.Scanner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		String serFilename = "serializationData.ser";
		//INICIALIZA O ARRAYLIST QUE SALVAM OS DADOS DO SISTEMA
		ArrayList<Cliente> clientes = null;
		ArrayList<Produto> produtos = null;
		ArrayList<Servico> servicos = null;
		Empresa empresa = null;

		//INICIALIZA A CLASSE QUE GUARDA AS FUNCOES USADAS NA MAIN
		Funcoes funcoes = new Funcoes();

		ObjectInputStream in = null;
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

		ArrayList<Modelos> carros = funcoes.carregaModelos("marcas-carros.txt", "modelos-carro.txt");

		// SETUP
		Funcionario admin = new Funcionario("Admin", "admin", "123", Cargo.GERENTE);
		if(empresa == null)
		    empresa = new Empresa("Oficina", "98876");
		empresa.addFuncionario(admin);

		Produto produtoGenerico = new Produto(0, 14, 19.99f, "Lubrificante");
		produtoGenerico.setRendimento(5000);
		produtoGenerico.setValidade(6);
		if(produtos == null)
		    produtos = new ArrayList<Produto>();

		produtos.add(produtoGenerico);

		Cliente cliente = new Cliente("Igor", "333456", "email@gmail.com", new Endereco("calle", "234","villa", "Camp", "SP"));

		if(clientes == null)
		    clientes = new ArrayList<Cliente>();
		clientes.add(cliente);

		Servico servico = new Servico("Limpeza", 30f, false);

		if(servicos == null)
		    servicos = new ArrayList<Servico>();

		servicos.add(servico);

		PaginaLogin l = new PaginaLogin(empresa, clientes, produtos, servicos);
	}
}