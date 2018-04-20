import java.util.ArrayList;
import java.util.Scanner;

public class Main{
  private ArrayList<Cliente> clientes;
  private ArrayList<Produto> produtos;
  private ArrayList<Servico> servicos;
  private Empresa empresa;

  public static void main(String[] args) {
    int comandoDoUsuario;
    Scanner usuarioInput = new Scanner(System.in);

    System.out.println("O que voce deseja fazer?");
    System.out.println("[1] Buscar cliente, produtos ou servicos");
    System.out.println("[2] Adicionar cliente, produtos ou servicos");
    System.out.println("[3] Atualizar estoque");

    comandoDoUsuario = usuarioInput.NextLine();

    switch (comandoDoUsuario) {
      case 1:
      case 2:
      case 3:
    }
  }  
}
