


import java.util.Scanner;

public class AndarAluguel extends Andar { //inicio do metodo AndarAluguel
	private final int MAX_CARRO = 10; //variavel magic number
	
	private double diariaAluguel; 
	private double precoSeguro;
	private boolean aluguelDisponivel = true;
	private int numParaAluguel = MAX_CARRO;
	private int limiteMultas;
	private double taxaMultas;
	private CarroAluguel [] carrosAluguel = new CarroAluguel[MAX_CARRO]; //vetor de 10 carros pre estabelescidos para aluguel
	//aumenta valor do preco por taxaMultas de numero de multas do cliente ultrapassa limiteMultas
	
	
	private Scanner scan = new Scanner(System.in);
	
	public AndarAluguel(int nomeAndar,  int limiteMultas, double taxaMultas, double diariaAluguel, double precoSeguro) { //inicio do metodo construtor
		super(nomeAndar);
		this.limiteMultas = limiteMultas;
		this.taxaMultas = taxaMultas; //chama construtor de super classe e atribui limite de multas e taxa
				
		carrosAluguel[0] = new CarroAluguel ("Marca 1", "Modelo1", "KHJ9531", "vermelho", 15000, 0);
		carrosAluguel[1] = new CarroAluguel ("Marca 2", "Modelo2", "DME8366", "verde", 10000, 1);
		carrosAluguel[2] = new CarroAluguel ("Marca 1", "Modelo3", "LMD0293", "vermelho", 56000, 2);
		carrosAluguel[3] = new CarroAluguel ("Marca 1", "Modelo1", "KEM3942",  "preto", 10000, 3);
		carrosAluguel[4] = new CarroAluguel ("Marca 2", "Modelo2", "MEM2938",  "vermelho", 2000, 4);
		carrosAluguel[5] = new CarroAluguel ("Marca 3", "Modelo4", "LEL5464", "branco", 30000, 5);
		carrosAluguel[6] = new CarroAluguel ("Marca 3", "Modelo4", "LEK3212", "azul",  22000, 6);
		carrosAluguel[7] = new CarroAluguel ("Marca 1", "Modelo3", "MLK9531",  "vermelho", 15000, 7);
		carrosAluguel[8] = new CarroAluguel ("Marca 1", "Modelo1", "YHR8343", "vermelho", 35000, 8);
		carrosAluguel[9] = new CarroAluguel ("Marca 2", "Modelo2", "BAC2312",  "preto", 5000, 9);
		
		this.diariaAluguel = diariaAluguel;
		this.precoSeguro = precoSeguro;
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
	
	public void retornaAlugado(int ID, double quilometragem) { //inicio do metodo retornaAlugado
		carrosAluguel[ID].setAlugado(false); //marca carro como disponivel para aluguel
		carrosAluguel[ID].setQuilometragem(quilometragem);
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
	
	public double calcularMontante(Cliente cliente) {
		
		ClienteAluguel clienteAluguel = (ClienteAluguel) cliente; //////////////////////////////////////////////////////////////
		
		double diferençaQuilo, quiloAtual, taxa;
		System.out.println("Entre com a quilometragem atual do carro alugado");
		
		quiloAtual = scan.nextDouble();
		diferençaQuilo = quiloAtual - cliente.getCarro().getQuilometragem();
		taxa = 1;
		
		if(clienteAluguel.getQtdMultas() > limiteMultas)
			taxa = taxaMultas; //caso cliente ultrapasse limite de multas pre estabelescido
		   
		double preçoQuilometragem = diariaAluguel; //iguala preco da diaria
		
		if(clienteAluguel.isSeguro()) {
			preçoQuilometragem += precoSeguro; //caso seja contratado o seguro
		}
		
		if(diferençaQuilo< 500) {
			preçoQuilometragem += diferençaQuilo *1.99;  
		}else if (diferençaQuilo >= 500 && diferençaQuilo < 1000) {
			preçoQuilometragem += diferençaQuilo *2.99; 
		}else if (diferençaQuilo >= 1000){
			preçoQuilometragem += diferençaQuilo *3.5; 
		} //soma ao preco da diaria valor propocional a quilometragem rodada pelo carro alugado
		return clienteAluguel.getDiarias() * taxa * preçoQuilometragem;		
		//fim de calcularMontanteAluguelQuilometragem
		
	}
	
	public void imprimirPrecos() { //imprime tabela de precos de estacionamento
		System.out.println("Preco da diaria do aluguel: " + diariaAluguel + "\nPreco do seguro: " + precoSeguro);
	}  //fim do metodo imprimeTabelaPrecosAluguel
} //fim da classe AndarAluguel
