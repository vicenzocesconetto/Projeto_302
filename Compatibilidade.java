import java.util.ArrayList;

public class Compatibilidade {
	private String modelo;
	private String marca;
	private ArrayList<Float> potencias;
		
	public Compatibilidade (String modelo, String marca, float... potencia){
		this.modelo=modelo;
		this.marca=marca;
		this.potencias= new ArrayList<Float>();
		for (float c: potencia) {
			this.potencias.add(c);
		}
	}

	public void addPotencias(float potencia) {
		this.potencias.add(potencia);
	}
	
	//GETTERS E SETTER PADROES
	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public ArrayList<Float> getPotencias() {
		return potencias;
	}


	
}
