import java.util.ArrayList;



public class Estacionamento{ //inicio da classe Estacionamento
	
	private int novaQuilometragem;
	private double[] precosGaragem;
	private double[] precosAluguel; //guarda precos em vetor, aumentando de acordo com periodo
	private AndarGaragem[] vetorAndares; //vetor de 4 andares para estacionamento
	private AndarAluguel andarDeAluguel; //andar de alugueis
	private ArrayList < Cliente > listaClientesGaragem; //lista ligada de clientes cadastrados
	private ArrayList < ClienteAluguel > listaClientesAluguel; //lista ligada de clientes de aluguel
	
	public Estacionamento(int linhas, int colunas, double[] precosGaragem, double[] precosAluguel, int limiteMultas, double taxaMultas) {
	//inicio de metodo construtor
		AndarGaragem[] andares = new AndarGaragem[4];
		for (int i = 0; i < 4; i++) {
			andares[i] = (new AndarGaragem(linhas, colunas, i));
		} //inicia andares para estacionamento com numero de linhas e colunas especificado 
		
		this.precosGaragem = precosGaragem; 
		this.precosAluguel = precosAluguel; //inicia vetores de preco
		vetorAndares = andares;
		listaClientesGaragem = new ArrayList < Cliente >();
		listaClientesAluguel = new ArrayList < ClienteAluguel >(); //inicia lista ligadas
		andarDeAluguel = (new AndarAluguel(5, limiteMultas, taxaMultas));	//inicia andar de alugueis
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
		for(Cliente clienteTemp : listaClientesGaragem) { //procura cliente que tem o carro com placa especificada
			if(placa.equals(clienteTemp.getCarro().getPlaca())){ 
				carroDesestacionado = clienteTemp.getCarro(); //pega objeto carro desestacionado
				carroDesestacionado.getAndarLocalizado().desestacionaCarroAndar(carroDesestacionado.getLocalizacao());
				//acessa o andar do carro e o retira da matriz via sua localizacao
				this.descadastrarCliente(clienteTemp.getCPF()); //chama funcao para retirar carro de seu andar e retira cliente da lista
				System.out.printf("Carro %s desestacionado. O valor a ser pago eh igual a %f \n", carroDesestacionado.getPlaca(), calcularMontanteEstacionamento(clienteTemp));
				//calcula preco a ser pago de acordo com o atributo periodo do cliente achado
				break;
			}
		}
		return carroDesestacionado;
	} //fim de desestacionarCarro
	
	public void estacionarCarro(Cliente cliente) { //inicio do metodo estacionarCarro
		for(AndarGaragem AndarBuscado : vetorAndares) { //procura um andar que nao esta cheio
			if(!AndarBuscado.getAndarCheio()) {
				AndarBuscado.estacionaCarroAndar(cliente.getCarro()); //busca um andar com vagas disponiveis
				this.cadastrarCliente(cliente); //cadastra cliente
				return;
			}
		}
		
		System.out.println("Estacionamento cheio"); //se nao retornou ainda, estacionamento esta cheio
	} //fim do metodo estacionarCarro
	
	public void cadastrarCliente(Cliente cliente) { //inicio do metodo cadastrarCliente
		listaClientesGaragem.add(cliente); 
	} //fim do metodo cadastrar cliente
	
	public Cliente descadastrarCliente(String CPF) { //inicio do metodo descadastrarCliente
		
		Cliente clienteRemovido = null;
		for(Cliente clienteTemp : listaClientesGaragem){
			if(clienteTemp.getCPF().equals(CPF)) { //procura cliente na lista via seu CPF
				clienteRemovido = clienteTemp;
				listaClientesGaragem.remove(clienteTemp); //busca cliente pela placa de seu carro e o retira da lista de cliente
				break;
			}
		}
		
		return clienteRemovido;
	} //fim do metodo descadastarCliente
	
	public void imprimeTabelaPrecos() { //imprime tabela de precos de estacionamento
		System.out.printf("Ate uma semana: %d \n De uma a duas semanas: %f \n De duas a tres semanas: %f \n Tres semanas ou mais: %f \n",
				 precosGaragem[0], precosGaragem[1], precosGaragem[2], precosGaragem[3]);
	}  //fim do metodo imprimeTabelaPrecos
	
	public void imprimeTabelaPrecosAluguel() { //imprime tabela de precos de estacionamento
		System.out.printf("Ate uma semana: %d \n De uma a duas semanas: %f \n De duas a tres semanas: %f \n  De tres a quatro semanas: %f \n Mais de quatro semanas é o valor de %d por el número de semanas",
				 precosAluguel[0], precosAluguel[1], precosAluguel[2], precosAluguel[3],precosAluguel[0]);
	}  //fim do metodo imprimeTabelaPrecosAluguel

	public double calcularMontanteEstacionamento(Cliente cliente) {
	//inicio do metodo calcularMontanteEstacionamento	
		int periodo = cliente.getPeriodoSemanas();
		
		if(periodo < 1) {
			return precosGaragem[0];
		}else if(periodo >= 1 && periodo < 2){
			return precosGaragem[1];
		}else if(periodo >= 2 && periodo < 3) {
			return precosGaragem[2];
		}else if(periodo >= 3) {
			return precosGaragem[3];
		} //retorna o valor do vetor presente na posicao adequada ao periodo de servico
		
		return 0;
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
	
	public void devolverCarroAluguel(String placa, int novaQuilometragem) { //inicio do mateodo devolverCarroAlugue
		
		for(ClienteAluguel clienteTemp : listaClientesAluguel) {
			if(placa.equals(clienteTemp.getCarro().getPlaca())) { //busca carro alugado com placa especificada
				andarDeAluguel.retornaAlugado(clienteTemp.getIDAlugado()); //marca carro como disponivel
	
				double diferençaQuilometragem = novaQuilometragem - clienteTemp.getCarro().getQuilometragem() ;
				System.out.printf("Carro %s retornado. O valor a ser pago por quilometragem é igual a %f \n",
						clienteTemp.getCarro().getPlaca() ,calcularMontanteAluguelQuilometragem(diferençaQuilometragem));						
				System.out.printf("Carro %s retornado. O valor final a ser pago com a tarifa base e tarifa quilometragem é igual a %f \n", 
						clienteTemp.getCarro().getPlaca() ,calcularMontanteAluguel(clienteTemp)+ calcularMontanteAluguelQuilometragem(diferençaQuilometragem));
//				clienteTemp.getCarro().setQuilometragem(novaQuilometragem);
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
	
	public double calcularMontanteAluguel(ClienteAluguel cliente) { //inicio do metodo calcularMontanteAluguel
		
		
		
		int periodo = cliente.getPeriodoSemanas();
		double taxa = 1.00;
		if(cliente.getQtdMultas() > andarDeAluguel.getLimiteMultas()) {
			taxa = andarDeAluguel.getTaxaMultas(); //se o cliente passou do limite de multas, aumenta o preco por taxa
		}
				
		if(periodo < 1) {
			return taxa * precosAluguel[0];
		}else if(periodo >= 1 && periodo < 2){
			return taxa * precosAluguel[1];
		}else if(periodo >= 2 && periodo < 3) {
			return taxa * precosAluguel[2];
		}else if(periodo >= 3 && periodo < 4) {
			return taxa * precosAluguel[3];
		} //retorna o valor do vetor presente na posicao adequada ao periodo de servico
		else if(periodo >= 4) {
			return taxa * precosAluguel[0]*periodo;
		}
		return 0;
	} //fim de calcularMontanteAluguel
	
	public double calcularMontanteAluguelQuilometragem( double diferençaQuilo) { //inicio do metodo calcularMontanteAluguel
		
   
		double preçoQuilometragem = 0;
		if(diferençaQuilo< 500) {
			preçoQuilometragem = diferençaQuilo *1.99; 
		}else if (diferençaQuilo >= 500 && novaQuilometragem < 1000) {
			preçoQuilometragem = diferençaQuilo *2.99; 
		}else if (diferençaQuilo >= 1000){
			preçoQuilometragem = diferençaQuilo *3.5; 
		}
		return preçoQuilometragem;
		
	} //fim de calcularMontanteAluguelQuilometragem
	
	
	public int numeroDeCarrosAluguel() { //inicio do metodo numeroDeCarrosAluguel
		return andarDeAluguel.getNumParaAluguel();
	} //fim do metodo numeroDeCarrosAluguel
	
	public void imprimirDadosCliente(String CPF, int tipoCliente) {
		
		if(tipoCliente == 0) {
			for(Cliente clienteTemp : listaClientesGaragem) {
				if(CPF.equals(clienteTemp.getCPF())) {
					clienteTemp.imprimirCliente();
					break;
				}
			}
		}else {
			for(ClienteAluguel clienteTemp : listaClientesAluguel) {
				if(CPF.equals(clienteTemp.getCPF())) {
					clienteTemp.imprimirCliente();
					break;
				}
			}
		}
	}
	
	public void imprimirEstacionamento() { //inicio do metodo imprimirEstacionamento
		System.out.println("IMPRIMINDO MAPA ESTACIONAMENTO");
		
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

