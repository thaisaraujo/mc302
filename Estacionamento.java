import java.util.ArrayList;

public class Estacionamento{
	private int[] precosGaragem;
	private int[] precosAluguel; //guarda precos em vetor, aumentando de acordo com periodo
	private AndarGaragem[] vetorAndares; //vetor de 4 andares para estacionamento
	private AndarAluguel andarDeAluguel; //andar de alugueis
	private ArrayList < Cliente > listaClientes; //lista ligada de clientes cadastrados
	
	public Estacionamento(int linhas, int colunas, int[] precosGaragem, int[] precosAluguel, int limiteMultas, double taxaMultas) {
		
		AndarGaragem[] andares = new AndarGaragem[4];
		for (int i = 0; i < 4; i++) {
			andares[i] = (new AndarGaragem(linhas, colunas, i));
		} //inicia andares para estacionamento com numero de linhas e colunas especificado 
		
		this.precosGaragem = precosGaragem;
		this.precosAluguel = precosAluguel;
		vetorAndares = andares;
		listaClientes = new ArrayList < Cliente >();
		andarDeAluguel = (new AndarAluguel(linhas, colunas, 5, limiteMultas, taxaMultas));	//inicia andar de alugueis
	}
	
	public Carro procurarCarro(String placa) {
		Carro carroBuscado = null;
		for(AndarGaragem AndarBuscado : vetorAndares) {
			carroBuscado = AndarBuscado.buscaCarro(placa);
			if(carroBuscado != null)
				break; //busca um carro por sua placa, chamando funcao de busca em cada andar
		}
		
		return carroBuscado;
		
	}
	
	public Carro desestacionarCarro(String placa) {
		Carro carroDesestacionado = procurarCarro(placa);
		carroDesestacionado.getAndarLocalizado().desestacionaCarroAndar(carroDesestacionado.getPlaca(), carroDesestacionado.getLocalizacao());
		this.descadastrarCliente(placa); //chama funcao para retirar carro de seu andar e retira cliente da lista
		
		return carroDesestacionado;
	}
	
	public void estacionarCarro(Cliente cliente) {
		for(AndarGaragem AndarBuscado : vetorAndares) {
			if(!AndarBuscado.getAndarCheio()) {
				AndarBuscado.estacionaCarroAndar(cliente.getCarro()); //busca um andar com vagas disponiveis
				this.cadastrarCliente(cliente); //cadastra cliente
				
				System.out.printf("Carro estacionado. O valor a ser pago eh igual a %d \n", calcularMontanteEstacionamento(cliente)); //calcula montante de acordo com periodo
				return;
			}
		}
		
		System.out.println("Estacionamento cheio");
	}
	
	public void cadastrarCliente(Cliente cliente) {
		listaClientes.add(cliente);
	}
	
	public Cliente descadastrarCliente(String placa) {
		
		Cliente clienteRemovido = null;
		for(Cliente clienteTemp : listaClientes){
			if(clienteTemp.getCarro().getPlaca().equals(placa)) {
				clienteRemovido = clienteTemp;
				listaClientes.remove(clienteTemp); //busca cliente pela placa de seu carro e o retira da lista de cliente
			}
		}
		
		return clienteRemovido;
	}
	
	public void imprimeTabelaPrecos() {
		System.out.printf("Ate uma semana: %d \n De uma a duas semanas: %d \n De duas a tres semanas: %d \n Tres semanas ou mais: %d \n",
				 precosGaragem[0], precosGaragem[1], precosGaragem[2], precosGaragem[3]);
	} 

	public int calcularMontanteEstacionamento(Cliente cliente) {
		
		int periodo = cliente.getPeriodoSemanas();
		
		if(periodo < 1) {
			return precosGaragem[0];
		}else if(periodo >= 1 && periodo < 2){
			return precosGaragem[1];
		}else if(periodo >= 2 && periodo < 3) {
			return precosGaragem[2];
		}else if(periodo >= 3) {
			return precosGaragem[3];
		}
		
		return 0;
	}
	
	public void imprimirEstacionamento() {
		int i = 0;
		for(i = 0 ; i < 4; i++) {
			System.out.println("---------------------\n");
			System.out.printf("###### ANDAR NUMERO %d / %d VAGAS DISPONIVEIS ######\n", i, vetorAndares[i].getVagasDisponiveis());
			vetorAndares[i].imprimeMapa();
			System.out.println();
		}
		System.out.println("####################\n");
	}
}
