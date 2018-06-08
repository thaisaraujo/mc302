package locais;

import gerenciadores.GerenciadorClienteAluguel;
import gerenciadores.GerenciadorClienteGaragem;
import usuarios.Carro;
import usuarios.CarroAluguel;
import usuarios.ClienteAluguel;
import usuarios.ClienteGaragem;

public class Estacionamento {
	private int linhas;
	private int colunas;
	private AndarGaragem[] vetorAndares; //vetor de 4 andares para estacionamento
	private AndarAluguel andarDeAluguel; //andar de alugueis
	private GerenciadorClienteGaragem gerenciadorClienteGaragem;
	private GerenciadorClienteAluguel gerenciadorClienteAluguel;
	
	public Estacionamento(int linhas, int colunas, double[] precosGaragem, double diariaAluguel, double precoSeguro,
			int limiteMultas, double taxaMultas) {
	//inicio de metodo construtor
		AndarGaragem[] andares = new AndarGaragem[4];
		for (int i = 0; i < 4; i++) {
			andares[i] = (new AndarGaragem(linhas, colunas, i));
		} //inicia andares para estacionamento com numero de linhas e colunas especificado 
		
		this.linhas = linhas;
		this.colunas = colunas;
		gerenciadorClienteGaragem = new GerenciadorClienteGaragem();
		gerenciadorClienteAluguel = new GerenciadorClienteAluguel();
		gerenciadorClienteGaragem.setPrecoGaragem(precosGaragem);
		gerenciadorClienteAluguel.setDiariaValor(diariaAluguel); gerenciadorClienteAluguel.setLimiteMultas(limiteMultas);
		gerenciadorClienteAluguel.setSeguroValor(precoSeguro); gerenciadorClienteAluguel.setTaxaMultas(taxaMultas);
		//guarda os precoes dos servicoes nos gerenciadores
		vetorAndares = andares;
		andarDeAluguel = new AndarAluguel(5);	//inicia andar de alugueis
	} //fim de metodo construtor
	
	public ClienteGaragem buscaClienteGaragem(String placa) {
		return gerenciadorClienteGaragem.buscaCliente(placa);
	}
	
	
	public void estacionarCarro (ClienteGaragem cliente, Carro carro, int andar, char linha, int coluna) {
		if(!cliente.calcularIdade(cliente.getDataDeNascimento())) {
			System.out.println("Cliente nao eh maior que 18 anos");
			return;
		}
		cliente.setCarro(carro); //recebe um cliente, seu carro e a vaga pretendida
		
		if(andar >= 4 || andar  < 0 || ((int)linha - 65) >= this.linhas || ((int)linha - 65) < 0 || coluna >= this.colunas || coluna < 0) {
			System.out.println("Coordenadas invalidas");
			return; //verificacao de erro coordenadas do estacionamento
		}else {
			boolean estacionado = vetorAndares[andar].estacionarCarro(cliente, linha, coluna, andar); //verifica de vaga esta disponivel
			if(estacionado) {
				System.out.printf("Carro %s estacionado no andar %d, na linha %c, coluna %d\n",
						cliente.getCarro().getPlaca(), andar, (char) (cliente.getCarro().getLocalizacao()[0] + 65),
						cliente.getCarro().getLocalizacao()[1]); //se conseguiu estacionar
				
				gerenciadorClienteGaragem.cadastrarCliente(cliente); //adiciona cliente a lista de cliente estacionados
			}else {
				System.out.println("Vaga ocupada"); //se vaga estiver ocupada
			}
		}
	}
	
	public void desestacionarCarro (String placa) { 
		ClienteGaragem cliente = gerenciadorClienteGaragem.buscaCliente(placa); //busca dono do carro pretendido pela sua placa
		
		if(cliente != null) { //se existe carro com placa dada
			Carro desestacionado = vetorAndares[cliente.getCarro().getAndarLocalizado()].desestacionarCarro(cliente); //invoca metodo de desestacionar de andar
			gerenciadorClienteGaragem.descadastrarCliente(cliente); //retira o cliente da lista de clientes
			System.out.println("Carro " + desestacionado.getPlaca() + " desestacionado. O preco total a ser pago e igual a: " 
					+ gerenciadorClienteGaragem.calcularMontante(cliente)); //calcula preco a ser pago
		}else {
			System.out.println("Carro nao encontrado");
		}
		
	}
	
	public void desestacionarCarro (long CPF) { 
		ClienteGaragem cliente = gerenciadorClienteGaragem.buscaCliente(CPF); //busca dono do carro pretendido por seu CPF
		if(cliente != null) { //se existe carro com placa dada
			Carro desestacionado = vetorAndares[cliente.getCarro().getAndarLocalizado()].desestacionarCarro(cliente); //invoca metodo de desestacionar de andar
			gerenciadorClienteGaragem.descadastrarCliente(cliente); //retira o cliente da lista de clientes
			System.out.println("Carro " + desestacionado.getPlaca() + " desestacionado. O preco total a ser pago e igual a: " 
					+ gerenciadorClienteGaragem.calcularMontante(cliente)); //calcula preco a ser pago
		}else {
			System.out.println("Carro nao encontrado");
		}
		
	}
	
	public void imprimirClienteGaragem(long CPF) {
		ClienteGaragem impresso = gerenciadorClienteGaragem.buscaCliente(CPF);
		
		impresso.imprimirCliente(); //impressao de cliente da garagem
	}
	
	public void imprimirClienteAluguel(long CPF) {
		ClienteAluguel impresso = gerenciadorClienteAluguel.buscaCliente(CPF);
		
		
		impresso.imprimirCliente(); //impresaao de cliente de aluguel
		
	}
		
	public void alugarCarro(ClienteAluguel cliente) {
		CarroAluguel carroAlugado = andarDeAluguel.alugarCarro(cliente); //invoca metodo de AndarAluguel para buscar um carro disponivel
		if(carroAlugado == null) {
			System.out.println("Nao ha carros disponivel para aluguel no momento"); //se nao ha carros
		}else {
			System.out.println("Carro de placa: "+ carroAlugado.getPlaca() + ", ID: " + carroAlugado.getIDAlugado() + " alugado para " +
				cliente.getNome()); //se o carro foi alugado com sucesso
			gerenciadorClienteAluguel.cadastrarCliente(cliente);
		}
	}
	
	public void devolverCarro(String placa) { //metodo polimorfico para devolucao do carro por sua placa
		ClienteAluguel clienteAlugado = gerenciadorClienteAluguel.buscaCliente(placa);
		CarroAluguel carroRetornado = andarDeAluguel.retornarCarro(clienteAlugado);
	
		System.out.println("Carro placa: " + carroRetornado.getPlaca() + ", ID: " + carroRetornado.getIDAlugado() + " retornado."
				+ "O valor a ser pago eh igual a :" + gerenciadorClienteAluguel.calcularMontante(clienteAlugado));
		
	}
	
	public void devolverCarro(int IDAlugado) { //metodo polimorfico para devolucao do carro por seu ID de aluguel
		ClienteAluguel clienteAlugado = gerenciadorClienteAluguel.buscaCliente(IDAlugado);
		CarroAluguel carroRetornado = andarDeAluguel.retornarCarro(clienteAlugado);
	
		System.out.println("Carro placa: " + carroRetornado.getPlaca() + ", ID: " + carroRetornado.getIDAlugado() + " retornado."
				+ "O valor a ser pago eh igual a :" + gerenciadorClienteAluguel.calcularMontante(clienteAlugado));
		
	}
	
	public void imprimirEstacionamento() { //metodo para impressao dos carros estacionado linearmente por andar
		System.out.println("\n ----------IMPRIMINDO MAPA ESTACIONAMENTO ----------");
		
		int i = 0;
		for(i = 0 ; i < 4; i++) {
			System.out.printf("###### ANDAR NUMERO %d / %d VAGAS DISPONIVEIS ######\n", i, vetorAndares[i].getVagasDisponiveis());
			vetorAndares[i].imprimirMapa();
			System.out.println();
		}
		System.out.println("####################\n");
	}
	
	
	public void imprimirAlugueis() {
		andarDeAluguel.imprimirMapa(); //impressao dos carros para aluguel
	}

} //fim da classe Estacionamento
