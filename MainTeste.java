import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainTeste {
	public static void main(String[] args) throws IOException {
		Funcoes funcoes = new Funcoes();
		
		ArrayList<Modelos> carros = funcoes.carregaModelos("/home/greenseiya/eclipse-workspace/Oficina/src/dados/marcas-carros.txt", "/home/greenseiya/eclipse-workspace/Oficina/src/dados/modelos-carro.txt");
		/*
		for(int i=0; i<carros.size();i++) {
			System.out.println(carros.get(i));
	    }
	*/
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		CadastroCliente cadastro = new CadastroCliente(clientes, carros);
		
		
		
	}
}