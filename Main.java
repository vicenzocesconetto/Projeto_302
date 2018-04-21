import java.util.ArrayList;
import java.util.Scanner;

public class Main{
	
   	private ArrayList<Cliente> clientes;
	private ArrayList<Produto> produtos;
	private ArrayList<Servico> servicos;
	private Empresa empresa;
  
	private Cliente BuscarCliente(String nome) {
		 for (int i = 0; i<clientes.size(); i++) {
			 if (clientes.get(i).getNome() == nome) {
				 return clientes.get(i);
			 }
		  }
		  return null;
	 }    
	  
	private Produto BuscarProduto(String nome) {
		 for (int i = 0; i<produtos.size(); i++) {
			 if (produtos.get(i).getNome() == nome) {
				 return produtos.get(i);
			  }
		  }
		  return null;
	 }
	  
	private Servico BuscarServico(String nome) {
		for (int i = 0; i<servicos.size(); i++) {
			if (servicos.get(i).getNome() == nome) {
				return servicos.get(i);
			 }
		 }
		 return null;
	 }
	  
	private boolean adicionarCliente(Cliente cliente) {
		return clientes.add(cliente);
	}
	  
	private boolean adicionarProduto(Produto produto) {
		return produtos.add(produto);
	}
	  
	private boolean adicionarServico(Servico servico) {
		return servicos.add(servico);
	}
	  
	private void retirarDinheiro(float valor) {
		empresa.setCaixa(empresa.getCaixa() - valor);
		// precisa da implementacao da movimentacao (motivo,...)
	}
	  
	private boolean atualizarEstoque(String nome, int estoque) {
		if (estoque >= 0) {
			BuscarProduto(nome).setEstoque(estoque);
			return true;
		}
		return false;
	}
	
	private boolean checarEstoqueMinimo(Produto produto) {
		if (produto.checarEstoqueMinimo() == true) {
			System.out.println("AVISO: Estoque atual menor que o estoque minimo");
		}
		return false;
	}
  
  public static void main(String[] args) {
    int comandoDoUsuario;
    Scanner usuarioInput = new Scanner(System.in);

    System.out.println("O que voce deseja fazer?");
    System.out.println("[1] Buscar cliente, produtos ou servicos");
    System.out.println("[2] Adicionar cliente, produtos ou servicos");
    System.out.println("[3] Atualizar estoque");

    comandoDoUsuario = usuarioInput.nextInt();

    switch (comandoDoUsuario) {
      case 1:
      case 2:
      case 3:
    }
  }  
}
