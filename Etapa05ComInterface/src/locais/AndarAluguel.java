package locais;

import gerenciadores.GerenciadorAluguel;
import usuarios.CarroAluguel;
import usuarios.ClienteAluguel;

public class AndarAluguel extends Andar { //inicio da classe AndarAluguel
	
	private final int MAX_CARRO = 10; //variavel magic number
	private boolean aluguelDisponivel = true;
	private int numParaAluguel = MAX_CARRO;

	private CarroAluguel [] carrosAluguel = new CarroAluguel[MAX_CARRO]; //vetor de 10 carros pre estabelescidos para aluguel
	//aumenta valor do preco por taxaMultas de numero de multas do cliente ultrapassa limiteMultas
	

	public AndarAluguel(int nomeAndar) {
		super(nomeAndar);
		
		carrosAluguel[0] = new CarroAluguel ("Marca 1", "Modelo1", "KHJ9531", "vermelho",15000, CarroAluguel.GRANDE, 0);
		carrosAluguel[1] = new CarroAluguel ("Marca 2", "Modelo2", "DME8366", "verde", 10000, CarroAluguel.PEQUENO, 1);
		carrosAluguel[2] = new CarroAluguel ("Marca 1", "Modelo3", "LMD0293", "vermelho", 56000, CarroAluguel.MEDIO, 2);
		carrosAluguel[3] = new CarroAluguel ("Marca 1", "Modelo1", "KEM3942",  "preto", 10000, CarroAluguel.PEQUENO, 3);
		carrosAluguel[4] = new CarroAluguel ("Marca 2", "Modelo2", "MEM2938",  "vermelho", 2000, CarroAluguel.MEDIO, 4);
		carrosAluguel[5] = new CarroAluguel ("Marca 3", "Modelo4", "LEL5464", "branco", 30000, CarroAluguel.MEDIO, 5);
		carrosAluguel[6] = new CarroAluguel ("Marca 3", "Modelo4", "LEK3212", "azul",  22000, CarroAluguel.PEQUENO, 6);
		carrosAluguel[7] = new CarroAluguel ("Marca 1", "Modelo3", "MLK9531",  "vermelho", 15000, CarroAluguel.GRANDE, 7);
		carrosAluguel[8] = new CarroAluguel ("Marca 1", "Modelo1", "YHR8343", "vermelho", 35000, CarroAluguel.MEDIO, 8);
		carrosAluguel[9] = new CarroAluguel ("Marca 2", "Modelo2", "BAC2312",  "preto", 5000, CarroAluguel.MEDIO,9);
		

		//cria objetos de carro aluguel em um vetor
	} //fim do metodo construto
	
	
	
	/*
	 * Classe alugarCarro: responsável por avisar o sistema que um carro foi alugado, chama método do gerenciadorAluguel
	 * param: clienteAluguel
	 * return carroAluguel que será alugado
	 */
	public CarroAluguel alugarCarro (ClienteAluguel cliente) {
		if(!aluguelDisponivel) {
			return null; //se variavel aluguelDisponivel eh false
		}else {
			CarroAluguel carroAlugado = GerenciadorAluguel.alugarCarro(cliente, carrosAluguel); //chama funcao de GerenciadorAluguel para alugar
			this.diminuiNumAluguel(); //diminui numero de carros disponiveis
			return carroAlugado;
		}
	}
	
	
	
	/*
	 * Classe: retornarCarro: responsável por avisar o sistema que um carro foi devolvido, chama método do gerenciadorAluguel 
	 * param: clienteAlguel
	 * return: carroAlugadao que foi devolvido
	 */
	public CarroAluguel retornarCarro (ClienteAluguel cliente) { //retornar um carro
		CarroAluguel carroRetornado = GerenciadorAluguel.retornarCarro(cliente, carrosAluguel); //chama funcao de GerenciadorAluguel para retorno
		this.aumentaNumAluguel(); //aumenta numero de carros disponveis
		return carroRetornado;
	}

	
	
	/*
	 * Classe imprimirMapa: mostrar o mapa de vagas
	 * param:
	 * return: void
	 */
	@Override
	public String imprimirMapa() { 
		
		String saida = "---------- CARROS PARA ALUGUEL -----------" + "\n";
		saida = saida + "Ha " + numParaAluguel + " carro disponiveis para aluguel" + "\n";
				
	//	System.out.println("---------- CARROS PARA ALUGUEL -----------");
	//	System.out.println("Ha " + numParaAluguel + " carro disponiveis para aluguel");
		for(CarroAluguel carroTemp : carrosAluguel) {
			if(!carroTemp.isAlugado()) {
				saida = saida + carroTemp.imprimirCarro();
		//		carroTemp.imprimirCarro(); //imprime dados de carros ainda nao alugados
			}
		}
		return saida;
	}
	
	public int getNumParaAluguel() {//inicio do metodo getNumParaAluguel
		return numParaAluguel;
	}//fim do metodo getNumParaAluguel
	
	public void aumentaNumAluguel() { //inicio do metodo aumentaNumAluguel
		numParaAluguel++;
		this.checaCheio();
	}//fim do metodo aumentaNumAluguel
	
	public void diminuiNumAluguel() { //inicio do metodo diminuiNumAluguel
		numParaAluguel--;
		this.checaCheio();
	}//fim do metodo diminuiNumAluguel
	
	public void checaCheio() { //inicio do metodo checaCheio
		if(numParaAluguel == 0) {
			aluguelDisponivel = false;
		}
		else {
			aluguelDisponivel = true; //checa se ainda ha vagas
		}
	}//fim do metodo checaCheio
	
	public boolean getAluguelDisponivel(){//inicio do metodo getAluguelDisponivel
		return aluguelDisponivel;
	}//fim do metodo getAluguelDisponivel
	
} //fim da classe AndarAluguel
