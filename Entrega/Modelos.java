import java.util.ArrayList;

public class Modelos {
	private int id;
	private String nome;
	private ArrayList<String> modelos;
	
	public Modelos(int id, String nome) {
		this.id=id;
		this.nome=nome;
		this.modelos= new ArrayList<String>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<String> getModelos() {
		return modelos;
	}

	public void addModelos(String modelo) {
		this.modelos.add(modelo);
	}

	@Override
	public String toString() {
		return "Modelos [id=" + id + ", nome=" + nome + ", modelos=" + modelos + "]";
	}

	
	
	
	
}
