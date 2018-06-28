package locais;

import gerenciadores.GerenciadorClienteAluguel;
import gerenciadores.GerenciadorClienteGaragem;
import usuarios.Carro;
import usuarios.CarroAluguel;
import usuarios.ClienteAluguel;
import usuarios.ClienteGaragem;

public class Estacionamento {
	//private static Estacionamento estacionamento;
	private int linhas;
	private int colunas;
	private AndarGaragem[] vetorAndares; //vetor de 4 andares para estacionamento
	private AndarAluguel andarDeAluguel; //andar de alugueis
	private GerenciadorClienteGaragem gerenciadorClienteGaragem;
	private GerenciadorClienteAluguel gerenciadorClienteAluguel;
	

	public Estacionamento(int linhas, int colunas, double[] precosGaragem, double diariaAluguel, double precoSeguro,
			int limiteMultas, double taxaMultas) {//inicio de metodo construtor
	
		AndarGaragem[] andares = new AndarGaragem[4];
		for (int i = 0; i < 4; i++) {
			andares[i] = (new AndarGaragem(linhas, colunas, i));
		} //inicia andares para estacionamento com numero de linhas e colunas especificado 
		
		this.linhas = linhas;
		this.colunas = colunas;
		gerenciadorClienteGaragem = new GerenciadorClienteGaragem(); //
		gerenciadorClienteAluguel = new GerenciadorClienteAluguel(); //
		gerenciadorClienteGaragem.setPrecoGaragem(precosGaragem);
		gerenciadorClienteAluguel.setDiariaValor(diariaAluguel); gerenciadorClienteAluguel.setLimiteMultas(limiteMultas);
		gerenciadorClienteAluguel.setSeguroValor(precoSeguro); gerenciadorClienteAluguel.setTaxaMultas(taxaMultas);
		//guarda os precoes dos servicoes nos gerenciadores
		vetorAndares = andares;
		andarDeAluguel = new AndarAluguel(5);	//inicia andar de alugueis
	} //fim de metodo construtor
	

	/*
	 * Aplicação de Padrão: Singleton
	 */
	
	 /*
	 //public static Estacionamento getInstance() {
		if(Estacionamento.estacionamento == null) {
			Estacionamento.estacionamento = new Estacionamento(); 
			/*
			 * TODO 
			 */
			
		//}
		
		//return Estacionamento.getInstance();
	//} */
	
	/*
	 * Método bscaClienteGaragem: chama metodo GerenciadorGaragem para busca
	 * param: placa
	 * return: clienteGaragem
	 */
	public ClienteGaragem buscaClienteGaragem(String placa) {
		return gerenciadorClienteGaragem.buscaCliente(placa);
	}
	
	
	
	/*
	 * Método estacionar: verifica se cliente é maior de idade, verifica localização válida para estacionar, se houver vaga estacionaCarro,
	 * caso contrário não é possível estacionar
	 * param: clienteGaragem, andar, linha, coluna
	 * return boolean 
	 */
	public boolean estacionarCarro (ClienteGaragem cliente, Carro carro, int andar, char linha, int coluna) {
		if(!cliente.calcularIdade(cliente.getDataDeNascimento())) {
			System.out.println("Cliente nao eh maior que 18 anos");
			return false;
		}
		cliente.setCarro(carro); //recebe um cliente, seu carro e a vaga pretendida
		
		if(andar >= 4 || andar  < 0 || ((int)linha - 65) >= this.linhas || ((int)linha - 65) < 0 || coluna >= this.colunas || coluna < 0) {
			System.out.println("Coordenadas invalidas"); //verificacao de erro coordenadas do estacionamento
			return false;
		}else {
			boolean estacionado = vetorAndares[andar].estacionarCarro(cliente, linha, coluna, andar); //verifica de vaga esta disponivel
			if(estacionado) {
				System.out.printf("Carro %s estacionado no andar %d, na linha %c, coluna %d\n",
						cliente.getCarro().getPlaca(), andar, (char) (cliente.getCarro().getLocalizacao()[0] + 65),
						cliente.getCarro().getLocalizacao()[1]); //se conseguiu estacionar
				
				gerenciadorClienteGaragem.cadastrarCliente(cliente); //adiciona cliente a lista de cliente estacionados
				return true;
			}else {
				System.out.println("Vaga ocupada"); //se vaga estiver ocupada
				return false;
			}
		}
	}
	
	
	
	/*
	 * Método desestacionarCarro: avisa o sistema que o carro foi retirado, chama método gerenciadorClienteGaragem
	 * param: placa
	 * return: boolean 
	 */
	public ClienteGaragem desestacionarCarro (String placa) { 
		ClienteGaragem cliente = gerenciadorClienteGaragem.buscaCliente(placa); //busca dono do carro pretendido pela sua placa
		
		if(cliente != null) { //se existe carro com placa dada
			Carro desestacionado = vetorAndares[cliente.getCarro().getAndarLocalizado()].desestacionarCarro(cliente); //invoca metodo de desestacionar de andar
			gerenciadorClienteGaragem.descadastrarCliente(cliente); //retira o cliente da lista de clientes
			System.out.println("Carro " + desestacionado.getPlaca() + " desestacionado. O preco total a ser pago e igual a: " 
					+ gerenciadorClienteGaragem.calcularMontante(cliente)); //calcula preco a ser pago
			return cliente;
		}
		
		return cliente;
	}
	
	
	
	/*
	 * Método desestacionarCarro: avisa o sistema que o carro foi retirado, chama método gerenciadorClienteGaragem
	 * param: cpf
	 * return: boolean 
	 */
	public ClienteGaragem desestacionarCarro (long CPF) { 
		ClienteGaragem cliente = gerenciadorClienteGaragem.buscaCliente(CPF); //busca dono do carro pretendido por seu CPF
		if(cliente != null) { //se existe carro com placa dada
			vetorAndares[cliente.getCarro().getAndarLocalizado()].desestacionarCarro(cliente); //invoca metodo de desestacionar de andar
			gerenciadorClienteGaragem.descadastrarCliente(cliente); //retira o cliente da lista de clientes
		}
		
		return cliente;
	}
	
	
	
	/*
	 * Método imprimirClienteGaragem: imprimir dado do cliente, com base na busca pelo cpf
	 * param: cpf
	 * return: String
	 */
	public String imprimirClienteGaragem(long CPF) {
		ClienteGaragem impresso = gerenciadorClienteGaragem.buscaCliente(CPF);
		String saida = impresso.imprimirCliente();
		return saida;
//		impresso.imprimirCliente(); //impressao de cliente da garagem
	}
	
	
	
	/*
	 * Método imprimirClienteAluguel: imprimir dado do cliente, com base na busca pelo cpf
	 * param: cpf
	 * return: String
	 */
	public String imprimirClienteAluguel(long CPF) {
		ClienteAluguel impresso = gerenciadorClienteAluguel.buscaCliente(CPF);
		String saida = impresso.imprimirCliente();
		return saida;
		
//		impresso.imprimirCliente(); //impresaao de cliente de aluguel
	}
		
	
	
	/*
	 * Método alugarCarro: verifica se há carro disponível, caso tenha cliente é cadastrado e carro é alugado
	 * invoca metodo de AndarAluguel para buscar um carro disponivel
	 * param: clienteAlguel
	 * return: boolean
	 */
	public boolean alugarCarro(ClienteAluguel cliente) {
		CarroAluguel carroAlugado = andarDeAluguel.alugarCarro(cliente); 
		if(carroAlugado == null) {
			System.out.println("Nao ha carros disponivel para aluguel no momento"); //se nao ha carros
			return false;
		}else {
			System.out.println("Carro de placa: "+ carroAlugado.getPlaca() + ", ID: " + carroAlugado.getIDAlugado() + " alugado para " +
				cliente.getNome()); //se o carro foi alugado com sucesso
			gerenciadorClienteAluguel.cadastrarCliente(cliente);
			return true;
		}
	}
	
	
	
	/*
	 * Método devolverCarro: com base na busca pela placa, verificar se carro existe e avisar o sistema que ele foi devolvido
	 * metodo polimorfico para devolucao do carro por sua placa
	 * param: placa
	 * return: boolean
	 */
	public double devolverCarro(String placa, double quiloAtual) { 
		ClienteAluguel clienteAlugado = gerenciadorClienteAluguel.buscaCliente(placa);
		CarroAluguel carroRetornado = andarDeAluguel.retornarCarro(clienteAlugado);
		
		if(clienteAlugado == null && carroRetornado == null ) {
			return -1;
		}else {
		//	System.out.println("Carro placa: " + carroRetornado.getPlaca() + ", ID: " + carroRetornado.getIDAlugado() + " retornado."
		//		+ "O valor a ser pago eh igual a :" + gerenciadorClienteAluguel.calcularMontante(clienteAlugado));
			return gerenciadorClienteAluguel.calcularMontante(clienteAlugado, quiloAtual, carroRetornado.getQuilometragem(), carroRetornado.getTipo());	
		}
	}
	
	
	
	/*
	 * Método devolverCarro: com base na busca pelo IDAlugado, verificar se carro existe e avisar o sistema que ele foi deolvido
	 * metodo polimorfico para devolucao do carro por seu ID de aluguel
	 * param: IDAlugado
	 * return: boolean
	 */
	public ClienteAluguel devolverCarro(int IDAlugado) { 
		ClienteAluguel clienteAlugado = gerenciadorClienteAluguel.buscaCliente(IDAlugado);
		//CarroAluguel carroRetornado = andarDeAluguel.retornarCarro(clienteAlugado);
		
		if(clienteAlugado == null) {
			return clienteAlugado;
		}else {
		//	System.out.println("Carro placa: " + carroRetornado.getPlaca() + ", ID: " + carroRetornado.getIDAlugado() + " retornado."
		//		+ "O valor a ser pago eh igual a :" + gerenciadorClienteAluguel.calcularMontante(clienteAlugado));
			return clienteAlugado;
		}
	}
	
	
	
	/*
	 * Método imprimirEstacionamento: imprimi mapa de vaga
	 * param:
	 * return: String 
	 */
	public String imprimirEstacionamento() { //metodo para impressao dos carros estacionado linearmente por andar
		String saida = "\n ----------IMPRIMINDO MAPA ESTACIONAMENTO ----------" + "\n";
	//	System.out.println("\n ----------IMPRIMINDO MAPA ESTACIONAMENTO ----------");
		
		int i = 0;
		for(i = 0 ; i < 4; i++) {

			saida = saida + "###### ANDAR NUMERO" + i + " / " + vetorAndares[i].getVagasDisponiveis() +  "VAGAS DISPONIVEIS ######" + "\n";
			saida = saida + vetorAndares[i].imprimirMapa();

		//	System.out.printf("###### ANDAR NUMERO %d / %d VAGAS DISPONIVEIS ######\n", i, vetorAndares[i].getVagasDisponiveis());
		//	vetorAndares[i].imprimirMapa();
		//	System.out.println();
		
		}
	//	System.out.println("####################\n");
		return saida;
	}
	
	
	
	/*
	 * Método imprimirAlugueis: imprimir carros disponíveis para aluguel
	 * param:
	 * return: String
	 */
	public String imprimirAlugueis() {
		String saida = andarDeAluguel.imprimirMapa();
		return saida;
		//	andarDeAluguel.imprimirMapa(); //impressao dos carros para aluguel
	}
	
	public GerenciadorClienteGaragem getClienteGaragem() {
		return this.gerenciadorClienteGaragem;
	}
	
	public GerenciadorClienteAluguel getClienteAluguel() {
		return this.gerenciadorClienteAluguel;
	}

} //fim da classe Estacionamento
