
public abstract class Andar { //inicio da classe Andar

	private int nomeAndar; //guarda numero do andar e numero de vagas totais (numero de carros para alugule eh igual a vagas totais)
	private AndarGaragem[] vetorAndares; //vetor de 4 andares para estacionamento
	
	public Andar(int nomeAndar) { //inicio do metodo construtor
		this.nomeAndar = nomeAndar;
	} //fim do metodo construtor
	
	public int getNomeAndar() { //inidioc do metodo getNomeAndar
		return nomeAndar;
	} //fim do metodo getNomeAndar

	public abstract void imprimirPrecos();
	public abstract double calcularMontante(Cliente cliente);
	
	public void imprimirEstacionamento() { //inicio do metodo imprimirEstacionamento
		System.out.println("\nIMPRIMINDO MAPA ESTACIONAMENTO");
		
		int i = 0;
		for(i = 0 ; i < 4; i++) {
			System.out.println("---------------------\n");
			System.out.printf("###### ANDAR NUMERO %d / %d VAGAS DISPONIVEIS ######\n", i, vetorAndares[i].getVagasDisponiveis());
			vetorAndares[i].imprimeMapa();
			System.out.println();
		}
		System.out.println("####################\n");
	} //fim do metodo imprimirEstacionamento
	
} //fim da classe Andar
