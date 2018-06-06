import java.util.ArrayList;

public class Estacionamento{ //inicio da classe Estacionamento

	private int linhas;
	private int colunas;
	private AndarGaragem[] vetorAndares; //vetor de 4 andares para estacionamento
	private AndarAluguel andarDeAluguel; //andar de alugueis
	private ArrayList < ClienteGaragem > listaClientesGaragem; //lista ligada de clientes cadastrados
	private ArrayList < ClienteAluguel > listaClientesAluguel; //lista ligada de clientes de aluguel
	
	public Estacionamento(int linhas, int colunas, double[] precosGaragem, double diariaAluguel, double precoSeguro,
			int limiteMultas, double taxaMultas) {
	//inicio de metodo construtor
		AndarGaragem[] andares = new AndarGaragem[4];
		for (int i = 0; i < 4; i++) {
			andares[i] = (new AndarGaragem(linhas, colunas, i, precosGaragem));
		} //inicia andares para estacionamento com numero de linhas e colunas especificado 
		
		this.linhas = linhas;
		this.colunas = colunas;
		vetorAndares = andares;
		listaClientesGaragem = new ArrayList < ClienteGaragem >();
		listaClientesAluguel = new ArrayList < ClienteAluguel >(); //inicia lista ligadas
		andarDeAluguel = (new AndarAluguel(5, limiteMultas, taxaMultas, diariaAluguel, precoSeguro));	//inicia andar de alugueis
	} //fim de metodo construtor
	
	public Carro procurarCarro(String placa) { //inicio de metodo procurar carro
		Carro carroBuscado = null;
		for(AndarGaragem AndarBuscado : vetorAndares) {
			carroBuscado = AndarBuscado.buscaCarro(placa);
			if(carroBuscado != null)
				break; //busca um carro por sua placa, chamando funcao de busca em cada andar
		}
		
		return carroBuscado;
		
	} //fim de metodo procurarCarro
	
	public Carro desestacionarCarro(String placa) { //inicio de metodo desestacionarCarro
		Carro carroDesestacionado = null;
		for(ClienteGaragem clienteTemp : listaClientesGaragem) { //procura cliente que tem o carro com placa especificada
			if(placa.equals(clienteTemp.getCarro().getPlaca())){ 
				carroDesestacionado = clienteTemp.getCarro(); //pega objeto carro desestacionado
				vetorAndares[carroDesestacionado.getAndarLocalizado()].desestacionaCarroAndar(carroDesestacionado.getLocalizacao());
				//acessa o andar do carro e o retira da matriz via sua localizacao
				this.descadastrarCliente(clienteTemp.getCPF()); //chama funcao para retirar carro de seu andar e retira cliente da lista
				
					System.out.printf("Carro %s desestacionado. O valor a ser pago eh igual a %f \n", carroDesestacionado.getPlaca(), 
							vetorAndares[clienteTemp.getCarro().getAndarLocalizado()].calcularMontante(clienteTemp));
					
				//calcula preco a ser pago de acordo com o atributo periodo do cliente achado
					
				break;
			}
		}
		return carroDesestacionado;
	} //fim de desestacionarCarro
	
	public void estacionarCarro(ClienteGaragem cliente, int andar, char linha, int coluna) { //inicio do metodo estacionarCarro
		
		if(andar >= 4 || andar  < 0 || ((int)linha - 65) >= this.linhas || ((int)linha - 65) < 0 || coluna >= this.colunas || coluna < 0) {
			System.out.println("Coordenadas invalidas");
			return; //verificacao de erro coordenadas do estacionamento
		}
		
		AndarGaragem AndarBuscado = vetorAndares[andar];
		
		if(AndarBuscado.getAndarCheio()) {
			System.out.println("Andar " + andar +  " cheio");
			return;
		}
		AndarBuscado.estacionaCarroAndar(cliente, linha, coluna, andar); //busca um andar com vagas disponiveis
		this.cadastrarCliente(cliente); //cadastra cliente
		return;
		
	} //fim do metodo estacionarCarro
	
	public void cadastrarCliente(ClienteGaragem cliente) { //inicio do metodo cadastrarCliente
		listaClientesGaragem.add(cliente); 
	} //fim do metodo cadastrar cliente
	
	public Cliente descadastrarCliente(String CPF) { //inicio do metodo descadastrarCliente
		
		Cliente clienteRemovido = null;
		for(ClienteGaragem clienteTemp : listaClientesGaragem){
			if(clienteTemp.getCPF().equals(CPF)) { //procura cliente na lista via seu CPF
				clienteRemovido = clienteTemp;
				listaClientesGaragem.remove(clienteTemp); //busca cliente pela placa de seu carro e o retira da lista de cliente
				break;
			}
		}
		
		return clienteRemovido;
	} //fim do metodo descadastarCliente
	
	public void imprimeTabelaPrecos() {
		vetorAndares[0].imprimirPrecos();
		andarDeAluguel.imprimirPrecos();
	}

	public double calcularMontanteEstacionamento(Cliente cliente) {
	//inicio do metodo calcularMontanteEstacionamento	
		return vetorAndares[cliente.getCarro().getAndarLocalizado()].calcularMontante(cliente);
	} //fim do metodo calcularMontanteEstacionamento
	
	public void alugarCarro(ClienteAluguel cliente) { //inicio do metodo alugarCarro
		
		if(!andarDeAluguel.getAluguelDisponivel())
			System.out.println("Nao ha carros para aluguel"); //se nao ha carros para aluguel
		else {
			cliente.setCarro(andarDeAluguel.buscaCarroDisponivel(cliente));	//se tem carro disponivel, chama funcao que atribui um carro a ele
			System.out.printf("Carro de placa %s, ID de numero %d, alugado para %s", cliente.getCarro().getPlaca(),
				cliente.getIDAlugado(), cliente.getNome());
			this.cadastrarClienteAluguel(cliente); //cadastra cliente a lista de cliente aluguel
		}
	} //fim do metodo alugarCarro
		
	public void devolverCarroAluguel(String placa, double quilometragem) { //inicio do metodo devolverCarroAluguel
		
		for(ClienteAluguel clienteTemp : listaClientesAluguel) {
			if(placa.equals(clienteTemp.getCarro().getPlaca())) { //busca carro alugado com placa especificada
				andarDeAluguel.retornaAlugado(clienteTemp.getIDAlugado(), quilometragem); //marca carro como disponivel
				
				System.out.printf("Carro %s retornado. O valor a ser pago eh igual a %f \n", 
						clienteTemp.getCarro().getPlaca() , andarDeAluguel.calcularMontante(clienteTemp));
				
				this.descadastrarClienteAluguel(clienteTemp.getCPF()); //cobra o cliente e o retira da lista
				
				break;
			}
		}		
	} //fim do metodo devolverCarroAluguel
	
	public void cadastrarClienteAluguel(ClienteAluguel cliente) { //inicio do metodo cadastrarClienteAluguel
		listaClientesAluguel.add(cliente);
	} //fim do metodo devolverCarroAluguel

	
	public ClienteAluguel descadastrarClienteAluguel (String CPF) {
		//inicio do metodo descadastrarClienteAluguel
		
		ClienteAluguel clienteRemovido = null;
		for(ClienteAluguel clienteTemp : listaClientesAluguel){
			if(clienteTemp.getCPF().equals(CPF)) {
				clienteRemovido = clienteTemp;
				listaClientesAluguel.remove(clienteTemp); //busca cliente pela placa de seu carro e o retira da lista de cliente aluguel
				break;
			}
		}
		
		return clienteRemovido;
	} //fim de descadastrarClienteAluguel
	
	public int numeroDeCarrosAluguel() { //inicio do metodo numeroDeCarrosAluguel
		return andarDeAluguel.getNumParaAluguel();
	} //fim do metodo numeroDeCarrosAluguel
	
	public void imprimirDadosCliente(String CPF) { //inicio do metodo imprimirDadosClientes
		
		for(Cliente clienteTemp : listaClientesGaragem) {
			if(clienteTemp.getCPF() == CPF) {
				clienteTemp.imprimirCliente();
				return;
			}
		}
		
		for(Cliente clienteTemp : listaClientesAluguel) {
			if(clienteTemp.getCPF() == CPF) {
				clienteTemp.imprimirCliente();
				return;
			}
		}
	} //fim do metodo imprimirDadosClientes
	
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
} //fim da classe Estacionamento
