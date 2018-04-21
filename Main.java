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
	
	private String printCliente(Cliente cliente) {
		String str = "";
		str += "Nome: " + cliente.getNome() + "\n";
		str += "Telefone: " + cliente.getTelefone() + "\n";
		str += "Email: " + cliente.getEmail() + "\n";
		str += "Endereço\n\n";
		str += "UF: " + cliente.getEndereco().getUf() + "\n"; 
		str += "Cidade: " + cliente.getEndereco().getCidade() + "\n"; 
		str += "Bairro: " + cliente.getEndereco().getBairro() + "\n"; 
		str += "Rua: " + cliente.getEndereco().getRua() + "\n"; 
		str += "Numero: " + cliente.getEndereco().getNumero() + "\n\n";
		str += "Veiculos do cliente\n\n";
		if (cliente instanceof Motorista) {
			for (int i = 0; i<((Motorista)cliente).getVeiculos().size(); i++) {
				Veiculo veiculo = ((Motorista)cliente).getVeiculos().get(i);
				str += "Veiculo" + (i + 1) + "\n\n";
				str += "Tipo " + veiculo.getTipo() + "\n";
				str += "Marca: " + veiculo.getMarca() + "\n";
				str += "Modelo: " + veiculo.getModelo() + "\n";
				// str += "Kilometragem da ultima visita: " + veiculo.getKms();
				str += "Ano de fabricacao: " + veiculo.getAnoFabricacao() + "\n";
				str += "Ano do modelo: " + veiculo.getAnoModelo() + "\n";
				str += "Placa: " + veiculo.getPlaca() + "\n";
			}
		}
		str += "Historico de vendas do cliente\n\n";
		for (int i = 0; i<cliente.getHistorico().size(); i++) {
			Venda venda = cliente.getHistorico().get(i);
			str += "Venda" + (i + 1) + "\n\n";
			str += "Data da venda: " + venda.getData().getDia() + "/" + venda.getData().getMes() + "/" + venda.getData().getAno() + "\n";
			str += "Funcionario responsavel: " + venda.getFuncionario() + "\n"; 
			str += "Forma de pagamento: " + venda.getFormaPagamento() + "\n";
			str += "" + venda.getProdutos().toString();

		}
		str += "Modelos Compativeis: " + modelosCompativeis.toString() + "\n";
		return str;
	}
	
	private String printProduto(Produto produto) {
		String str = "";
		str += "ID: " + produto.getId() + "\n";
		str += "Nome: " + produto.getNome() + "\n";
		str += "Valor" + produto.getValor() + "\n";
		str += "Quantidade em estoque: " + produto.getEstoque() + "\n";
		checarEstoqueMinimo(produto);
		return str;
	}
	
	private String printServico(Servico servico) {
		String str = "";
		str += "ID: " + servico.getId() + "\n";
		str += "Nome: " + servico.getNome() + "\n";
		str += "Valor" + servico.getValor() + "\n";
		return str;
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
