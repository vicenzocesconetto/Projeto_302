import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainTeste {
	public static void main(String[] args) throws IOException {
		Funcoes funcoes = new Funcoes();
	
		//TESTANDO COMMIT
	/*	
		ArrayList<Modelos> carros = funcoes.carregaModelos("/home/greenseiya/eclipse-workspace/Oficina/src/dados/marcas-carros.txt", "/home/greenseiya/eclipse-workspace/Oficina/src/dados/modelos-carro.txt");
		
		for(int i=0; i<carros.size();i++) {
			System.out.println(carros.get(i));
	    }
	*/
		
	/*
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		clientes.add(new Cliente("Evandro Luis", "(19)97402-8267", "evandro@unicamp.br", new Endereco("Albert Einstein", "100", "Unicamp", "Campinas", "SP")));
		clientes.add(new Cliente("Larissa", "123", "1233", new Endereco("132", "12", "132", "13", "49")));
		RealizarVenda venda = new RealizarVenda(new Empresa("TESTE", "1331"), clientes);
		venda.setVisible(true);
	*/
		ArrayList<Produto> produtos = new ArrayList<Produto>();
		produtos.add(new Produto(2, 5, 9.98f, "Oleo 5W20"));
		produtos.add(new Produto(2, 5, 9.98f, "Oleo 10W20"));
		produtos.add(new Produto(2, 5, 9.98f, "Oleo 5W40"));
		produtos.add(new Produto(2, 5, 9.98f, "Oleo 20W30"));
		//RealizarVendaAdicionarProdutos addProtudo = new RealizarVendaAdicionarProdutos(produtos);
		//addProtudo.setVisible(true);
	
		ArrayList<Servico> servicos = new ArrayList<Servico>();
		servicos.add(new Servico("troca de oleo", 50f, true));
		servicos.add(new Servico("troca do filtro", 50f, true));
		//RealizarVendaAdicionarServicos addServico = new RealizarVendaAdicionarServicos(servicos);
		//addServico.setVisible(true);
		
//		RealizarVendaMenu venda = new RealizarVendaMenu(servicos, produtos);
//		venda.setVisible(true);
	}
}