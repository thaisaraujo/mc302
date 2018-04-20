
public class AndarAluguel extends Andar { //inicio do metodo AndarAluguel
	private final int MAX_CARRO = 10; //variavel magic number
	
	private boolean aluguelDisponivel = true;
	private int numParaAluguel = MAX_CARRO;
	private int limiteMultas;
	private double taxaMultas;
	private CarroAluguel [] carrosAluguel = new CarroAluguel[MAX_CARRO]; //vetor de 10 carros pre estabelescidos para aluguel
	//aumenta valor do preco por taxaMultas de numero de multas do cliente ultrapassa limiteMultas
	
	public AndarAluguel(int nomeAndar,  int limiteMultas, double taxaMultas) { //inicio do metodo construtor
		super(nomeAndar);
		this.limiteMultas = limiteMultas;
		this.taxaMultas = taxaMultas; //chama construtor de super classe e atribui limite de multas e taxa
				
		carrosAluguel[0] = new CarroAluguel ("Marca 1", "Modelo1", "KHJ9531", "8372738", "vermelho", "80", 1999, "kgm101", "15000", 0);
		carrosAluguel[1] = new CarroAluguel ("Marca 2", "Modelo2", "DME8366", "831234738", "verde", "44", 2006, "fjek1234", "10000", 1);
		carrosAluguel[2] = new CarroAluguel ("Marca 1", "Modelo3", "LMD0293", "28381924", "vermelho", "70", 1989, "kek6942", "56000", 2);
		carrosAluguel[3] = new CarroAluguel ("Marca 1", "Modelo1", "KEM3942", "312731271", "preto", "20", 1999, "kfdk323124", "10000", 3);
		carrosAluguel[4] = new CarroAluguel ("Marca 2", "Modelo2", "MEM2938", "5838283289", "vermelho", "65", 2008, "mlemle9392", "2000", 4);
		carrosAluguel[5] = new CarroAluguel ("Marca 3", "Modelo4", "LEL5464", "83828392", "branco", "70", 2003, "meme9492", "30000", 5);
		carrosAluguel[6] = new CarroAluguel ("Marca 3", "Modelo4", "LEK3212", "75636234", "azul", "80", 2005, "ltoel2423", "22000", 6);
		carrosAluguel[7] = new CarroAluguel ("Marca 1", "Modelo3", "MLK9531", "784744343", "vermelho", "40", 1997, "oeokd1234", "15000", 7);
		carrosAluguel[8] = new CarroAluguel ("Marca 1", "Modelo1", "YHR8343", "4828841142", "vermelho", "50", 2009 , "bascw1234", "35000", 8);
		carrosAluguel[9] = new CarroAluguel ("Marca 2", "Modelo2", "BAC2312", "1929293", "preto", "80", 2006, "lmwle21313", "5000", 9);
		//cria objetos de carro aluguel em um vetor
	} //fim do metodo construtor
	
	public CarroAluguel buscaCarroDisponivel(ClienteAluguel cliente) { //inicio do metodo buscaCarroDisponivel
		for(int i = 0; i < MAX_CARRO; i++) {
			if(!carrosAluguel[i].isAlugado()) { //acha um carro nao alugado
				cliente.setIDAlugado(i); //marca o id do carro que cliente alugou
				cliente.setCarro(carrosAluguel[i]); //atribui carro alugado para o cliente
				carrosAluguel[i].setAlugado(true); //carro foi alugado
				this.diminuiNumParaAluguel();
				return carrosAluguel[i];
			}
		}		
		return null;
	} //fim do metodo buscaCarroDisponivel
	
	public void retornaAlugado(int ID) { //inicio do metodo retornaAlugado
		carrosAluguel[ID].setAlugado(false); //marca carro como disponivel para aluguel
		this.aumentaNumParaAluguel(); //aumenta numero de carros disponiveis
	} //fim do metodo retornaAlugado
	
	public int getNumParaAluguel() { //inicio do metodo getNumparaAluguel
		return numParaAluguel;
	} //fim do metodo getNumParaAluguel
	
	public boolean getAluguelDisponivel() { //inicio do metodo getAluguelDispinivel
		return aluguelDisponivel;
	} //fim do metodo getAluguelDisponivel
	
	public void checaAluguelDisponivel() { //inicio do metodo checaAluguelDisponivel
		if(numParaAluguel == 0)
			aluguelDisponivel = false;
	} //fim do meotdo checaAluguelDisponivel

	public int getLimiteMultas() { //inicio do metodo getLimiteMultas
		return limiteMultas;
	} //fim do metodo getLimiteMultas

	public void setLimiteMultas(int limiteMultas) { //inicio do metodo setLimiteMultas
		this.limiteMultas = limiteMultas;
	} //fim do metodo setLimiteMultas

	public double getTaxaMultas() { //inicio do metodo getTaxaMultas
		return taxaMultas;
	} //fim do metodo getTaxaMultas

	public void setTaxaMultas(double taxaMultas) { //inicio do metodo setTaxaMultas
		this.taxaMultas = taxaMultas;
	} //fim do metodo setTaxaMultas
	
	public void diminuiNumParaAluguel() { //inicio do metodo diminuiNumParaAluguel
		numParaAluguel --;
		this.checaAluguelDisponivel();
	} //fim do metodo diminuiNumParaAluguel
	
	public void aumentaNumParaAluguel() { //inicio do metodo aumentaNumParaAluguel
		numParaAluguel ++;
		this.checaAluguelDisponivel();
	} //fim do metodo aumentaNumParaAluguel
} //fim da classe AndarAluguel
