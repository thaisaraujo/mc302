
public abstract class Andar { //inicio da classe Andar

	private int nomeAndar; //guarda numero do andar e numero de vagas totais (numero de carros para alugule eh igual a vagas totais)
	
	public Andar(int nomeAndar) { //inicio do metodo construtor
		this.nomeAndar = nomeAndar;
	} //fim do metodo construtor
	
	public int getNomeAndar() { //inidioc do metodo getNomeAndar
		return nomeAndar;
	} //fim do metodo getNomeAndar

	public abstract void imprimirPrecos();
	public abstract double calcularMontante(Cliente cliente);
} //fim da classe Andar
