import java.io.*;
//import java.sql.Date;
//import java.util.ArrayList;


public class MainTeste {
	//@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	//	Funcoes funcoes = new Funcoes();
		/*
		String caminho = "/home/greenseiya/Documents/Projeto_302/testes/empresa.txt";
		
		Empresa empresa1 = new Empresa("Peixola", "10000000");
		empresa1.setCaixa(500f);
		empresa1.addFuncionario(new Funcionario("joao", "Joao", "123abc", Cargo.ATENDENTE));
					
		
		try {
			ObjectOutputStream output = new ObjectOutputStream( new FileOutputStream(caminho));
			output.writeObject(empresa1);
			output.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
		try {
			ObjectInputStream input = new ObjectInputStream(new FileInputStream(caminho));
			
			Empresa empresa = (Empresa) input.readObject();
			input.close();
			System.out.println("Dados carregados");
			System.out.println("Nome: "+empresa.getNome());
			System.out.println("CNPJ: "+empresa.getCnpj());
			System.out.println("Caixa: "+empresa.getCaixa());
			System.out.println("Funcionarios");
			System.out.println(empresa.getFuncionarios().get(0).getNome());
			System.out.println(empresa.getFuncionarios().get(0).getCargo());	
		}catch(EOFException e) {
			return;
		}catch (ClassNotFoundException e2) {
			System.out.println("Classe nao encontrada!");
			System.exit(1);
		}catch (IOException e3) {
			e3.printStackTrace();
		}
		*/	
/*
		Date data = new Date( System.currentTimeMillis());
		float kmDia=26.6f;
		int km=5000;
		int dias;
		
		dias = (int) (km/kmDia);
		data.setDate(data.getDate()+dias);
		
		System.out.println(data);
		*/
		System.out.println("Teste 1");
		teste(2.5f,3.6f);
		System.out.println("Teste 2");
		teste(2.5f,3.6f,5.9f,8f);
		System.out.println("Teste 3");	
		teste();
	}
	
	public static void teste (float... potencia) {
		for (float c: potencia) {
			System.out.println(c);
		}
	}
	
}
