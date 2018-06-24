import java.io.Serializable;

public class Funcionario implements Serializable {
	private static final long serialVersionUID = 1L;
	private String nome;
	private String login;
	private String senha;
	private Cargo cargo;
	
	public Funcionario(String nome, String login, String senha, Cargo cargo) {
		this.nome = nome.toUpperCase();
		this.login = login;
		this.senha = senha;
		this.cargo = cargo;
	}

	public void setNome(String nome) {
		this.nome = nome.toUpperCase();
	}

	 //GETTERS E SETTER PADROES
	public String getNome() {
		return nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}	
}