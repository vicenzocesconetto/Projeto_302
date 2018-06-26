import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {

	public static final int TAMANAHO_DA_JANELA = 500;

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
				Cliente.setNumClientes(clientes.size());
				Produto.setNumeroProdutos(produtos.size());
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


		ObjectOutputStream out = null; //serializacao
		try {
			out = new ObjectOutputStream(new FileOutputStream(serFilename));
			out.writeObject(clientes);
			out.writeObject(produtos);
			out.writeObject(servicos);
			out.writeObject(empresa);
			out.flush();
		}catch(IOException ex) {

		}finally {
			try {
				out.close();
			}catch (IOException e) {

			}
		}
	}
}