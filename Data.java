public class Data {
	private short dia;
	private short mes;
	private short ano;
	
	public Data(short dia, short mes, short ano) {
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}

	public short getDia() {
		return dia;
	}

	public void setDia(short dia) {
		this.dia = dia;
	}

	public short getMes() {
		return mes;
	}

	public void setMes(short mes) {
		this.mes = mes;
	}

	public short getAno() {
		return ano;
	}

	public void setAno(short ano) {
		this.ano = ano;
	}
}
