import java.util.ArrayList;

public class AndarGaragem extends Andar { //inicio do metodo AndarGaragem

	private Vaga[][] mapaVagas; //matriz de Carros, null para vagas desocupadas
	private double[] precosGaragem;
	private int vagasDisponiveis;
	private boolean andarCheio = false;
	
	public AndarGaragem (int linhas, int colunas, int nomeAndar, double[] precosGaragem) { //inicio do metodo Construtor
		super(nomeAndar);
		vagasDisponiveis = linhas * colunas;
		mapaVagas = new Vaga[linhas][colunas]; //construtor para AndarGaragem
		for(int i = 0; i < linhas; i++) {
			for(int j = 0; j < colunas; j++) {
				mapaVagas[i][j] = new Vaga();
			}
		}
		
		this.precosGaragem = precosGaragem;
	} //fim do metodo construtor
	
	public void checaCheio() { //inicio do metodo checaCheio
		if(vagasDisponiveis == 0)
			andarCheio = true;
	} //fim do metodoChecaCheio
	
	public boolean getAndarCheio() { //inicio do metodo getAndarCheio
		return andarCheio;
	} //fim do metodo getAndarCheio
	
	public int getVagasDisponiveis() { //inicio do metodo getVagasDisponiveis
		return vagasDisponiveis;
	} //fim do metodo getVagasDisponiveis

	
	public void aumentaVagas() { //inicio do metodo aumentaVagas
		vagasDisponiveis++;
		this.checaCheio();
	} //fim do metodo aumentaVagas
	
	public void diminuiVagas() { //inicio do metodo diminuiVagas
		vagasDisponiveis--;
		this.checaCheio();
	} //fim do metodo diminuiVagas
	
	public Carro buscaCarro(String placa) { //inicio do metodo buscaCarro
		int i = 0, j = 0;
		for(i = 0; i < mapaVagas.length; i++) {
			for(j = 0; j < mapaVagas[i].length; j++) {
				if(mapaVagas[i][j].getCarro() != null) {
					if(mapaVagas[i][j].getCarro().getPlaca().equals(placa)) {
						return mapaVagas[i][j].getCarro(); //percorre linearmente matriz								
					}
				}
			}
		}		
		return null; //funcao de procura carro pela sua placa
	} //fim do metodo buscaCarro
	
	public Carro buscaCarro(String CPF, ArrayList < ClienteGaragem > listaClientes) { //inicio do metodo buscaCarro

		for(ClienteGaragem clienteTemp : listaClientes) {
			if(clienteTemp.getCPF().equals(CPF)) {
				return clienteTemp.getCarro();
			}
		}
		return null; //funcao de procura carro pela sua placa
	} //fim do metodo buscaCarro
	
	public Carro desestacionaCarroAndar(int[] localizacao) { //inicio do metodo desestacionarCarroAndar
		Carro desestacionado = mapaVagas[localizacao[0]][localizacao[1]].getCarro();
		mapaVagas[localizacao[0]][localizacao[1]].desocuparVaga();
		this.aumentaVagas(); //aumenta numero de vagas
		
		return desestacionado; //retira carro da matriz
	} //fim do metodo desestacionarCarroAndar
	
	public void estacionaCarroAndar(ClienteGaragem cliente, char linha, int coluna, int andar) { //inicio do metodo estacionarCarroAndar

		if(!mapaVagas[(int)linha - 65][coluna].isVagaOcupada()) {
			mapaVagas[(int)linha - 65][coluna].ocuparVaga(cliente); //converte caractere da linha para um inteiro via tabela ASCII
			int[] lugarVago = new int [2];
			lugarVago[0] = (int)linha - 65;
			lugarVago[1] = coluna;
			cliente.getCarro().setLocalizacao(lugarVago); //seta localizacao do carro no objeto em questao
			cliente.getCarro().setAndarLocalizado(andar); //atribui carro a posicao da matriz achada, e atualiza dados do carro para sua localizacao
		}
		System.out.printf("Carro %s estacionado no andar %d, na linha %c, coluna %d\n",
				cliente.getCarro().getPlaca(), this.getNomeAndar(), (char) (cliente.getCarro().getLocalizacao()[0] + 65),
				cliente.getCarro().getLocalizacao()[1]);
		this.diminuiVagas();
		//adiciona carro na matriz
		
	} //fim do metodo estacionarCarroAndar
	
	@Override
	public double calcularMontante(Cliente cliente) {
	//inicio do metodo calcularMontanteEstacionamento	
		
		ClienteGaragem clienteGaragem = (ClienteGaragem) cliente;
		int periodo = clienteGaragem.getPeriodo();
		
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
	
	@Override
	public void imprimirPrecos() { //imprime tabela de precos de estacionamento
		System.out.printf("Ate uma semana: %d \n De uma a duas semanas: %f \n De duas a tres semanas: %f \n Tres semanas ou mais: %f \n",
				 precosGaragem[0], precosGaragem[1], precosGaragem[2], precosGaragem[3]);
	}  //fim do metodo imprimeTabelaPrecos
	
	public void imprimeMapa() { //inicio do metodo imprime mapa

		int i, j;
		for(i = 0; i < mapaVagas.length; i++) {
			for(j = 0; j < mapaVagas[i].length; j++) {
				if(mapaVagas[i][j].isVagaOcupada())
					mapaVagas[i][j].imprimirVaga();
			}
		}		
	} //funcao de impressao do andar, por placa de carros
	
} //fim da classe AndarGaragem
