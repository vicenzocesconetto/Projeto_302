import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Funcoes {
	
	public ArrayList<Modelos> carregaModelos (String caminhoMarcas, String caminhoModelos ){
		ArrayList<Modelos> modelos = new ArrayList<Modelos>();
		
		try {
			Scanner input = new Scanner(new File(caminhoMarcas));
			while(input.hasNext()) {
				String ler = input.nextLine();
				Scanner lineScanner = new Scanner(ler);
			    lineScanner.useDelimiter("\\s*,\\s*");
			    modelos.add(new Modelos(lineScanner.nextInt(), lineScanner.next()));
			    lineScanner.close();
			}
			input.close();
		}catch(IOException e) {
			return null;
		}
		
		try {
			Scanner input = new Scanner(new File(caminhoModelos));
			while(input.hasNext()) {
				String ler = input.nextLine();
				Scanner lineScanner = new Scanner(ler);
			    lineScanner.useDelimiter("\\s*,\\s*");
			    int idMarca=lineScanner.nextInt();
			    for(int i=0; i<modelos.size();i++) {
			    	if(modelos.get(i).getId()==idMarca) modelos.get(i).addModelos(lineScanner.next());
			    }
			    lineScanner.close();
			}
			input.close();
		}catch(IOException e) {
			return null;
		}
		
		return modelos;
	}	

	public boolean salvarEncerrante(String m) throws IOException {
		String caminho = dataHoje()+".txt";
		try {
			FileWriter arquivo = new FileWriter (caminho);
			arquivo.write(m);
			arquivo.close();
			return true;
		} catch (IOException e) {
			return false;
		} catch (Exception e) {
			return false;
		}
	}
	/*
	public boolean salvarVenda(String m, String d) throws IOException {
		String caminho = "vendas/"+dataHoje()+"_"+d+".txt";
		System.out.println(caminho);
		try {
			FileWriter arquivo = new FileWriter (caminho);
			arquivo.write(m);
			arquivo.close();
			return true;
		} catch (IOException e) {
			return false;
		} catch (Exception e) {
			return false;
		}
	}
	*/	
	public String dataHoje() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy");
		return sdf.format( new Date( System.currentTimeMillis() ) );
	}
	
	public String dataHojeBarra() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format( new Date( System.currentTimeMillis() ) );
	}
	
	public String horaSistema() {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		return  sdf.format( new Date( System.currentTimeMillis())) ;
	}
	public String horaSistemaArquivo() {
		SimpleDateFormat sdf = new SimpleDateFormat("HH_mm");
		return  sdf.format( new Date( System.currentTimeMillis())) ;
	}
	
	public boolean login(Empresa empresa, String login, String password) {
		for (int i = 0; i<empresa.getFuncionarios().size() ;i++) {
			if(empresa.getFuncionarios().get(i).getLogin().equals(login))
				if(empresa.getFuncionarios().get(i).getSenha().equals(password))return true;
		}
		return false;
	}
	
	public boolean loginGerente(Empresa empresa, String login, String password) {
		for (int i=0;i<empresa.getFuncionarios().size();i++) {
			if(empresa.getFuncionarios().get(i).getLogin().equals(login))
				if(empresa.getFuncionarios().get(i).getSenha().equals(password)) {
					if(empresa.getFuncionarios().get(i).getCargo()==Cargo.GERENTE)return true;
				}
			}
		return false;
	}
	
	public boolean produtoCompativel(Produto p, Veiculo veiculo) {
		for(int i=0;i<p.getModelosCompativeis().size();i++) {	
			if(p.getModelosCompativeis().get(i).getMarca().equals(veiculo.getMarca())) {
				if(p.getModelosCompativeis().get(i).getModelo().equals(veiculo.getModelo())) {
					for(int a=0;a<p.getModelosCompativeis().get(i).getPotencias().size();a++) {
						if(p.getModelosCompativeis().get(i).getPotencias().get(a)==veiculo.getPotencia()) return true;
					}
				}
			}
		}
		return false;		
	}
	
	public void finalizarVenda(Venda venda) throws EstoqueInsuficienteException {
		//SALVA HISTORICO DO CLIENTE
		venda.getCliente().addHistorico(venda);
		
		//DIMINUI O ESTOQUE DOS PRODUTOS
		for (int i=0; i<venda.getProdutos().size(); i++) {
		    venda.getProdutos().get(i).diminuirEstoque(venda.getQtd().get(i));
		}
		//SALVA MOVIMENTACAO
		venda.getEmpresa().addMovimentacao(new Entrada(venda.getTotal(),venda.getFormaPagamento()));
		
		//CALCULA DATA DE RETORNO DO CLIENTE SE FOR O CASO
				for (int i=0; i<venda.getServicos().size(); i++) {
					if(venda.getServicos().get(i).isRetorno()) {
						venda.getCliente().setRetorno(new Retorno(venda, venda.getVeiculos().get(i)));
					}
				}
	}
		
	public Cliente buscarCliente(ArrayList<Cliente> clientes, String nome) {
		 for (int i = 0; i<clientes.size(); i++) {
			 if (clientes.get(i).getNome().equals(nome.toUpperCase())) return clientes.get(i);
		 }
		 return null;
	 }    
	  
	public Produto buscarProduto(ArrayList<Produto> produtos, String nome) {
		 for (int i = 0; i<produtos.size(); i++) {
			 if (produtos.get(i).getNome().equals(nome.toUpperCase())) return produtos.get(i);
		  }
		  return null;
	 }
	  
	public Servico buscarServico(ArrayList<Servico> servicos, String nome) {
		for (int i = 0; i<servicos.size(); i++) {
			if (servicos.get(i).getNome().equals(nome.toUpperCase())) return servicos.get(i);
		}
		return null;
	}
	  
	public boolean retirarDinheiro(Empresa empresa, float valor, String motivo) {
		if(valor<=empresa.getCaixa()) {
			empresa.addMovimentacao(new Retirada(valor, motivo));
			return true;
		}
		return false;
	}
	  
	public boolean atualizarEstoque(Produto produto, int estoque) {
		if (estoque >= 0) {
			produto.setEstoque(estoque);
			return true;
		}
		return false;
	}
}
