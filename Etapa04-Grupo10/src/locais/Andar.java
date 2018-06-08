package locais;

public abstract class Andar { //inicio da classe Andar

	private int nomeAndar; //guarda numero do andar e numero de vagas totais (numero de carros para alugule eh igual a vagas totais)
	
	public Andar(int nomeAndar) { //inicio do metodo construtor
		this.nomeAndar = nomeAndar;
	} //fim do metodo construtor
	
	public int getNomeAndar() { //inidioc do metodo getNomeAndar
		return nomeAndar;
	} //fim do metodo getNomeAndar
	
	public void setNomeAndar(int nomeAndar) {
		this.nomeAndar = nomeAndar;
	}

	public abstract void imprimirMapa();
	
} //fim da classe Andar


