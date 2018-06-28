package locais;

import gerenciadores.GerenciadorGaragem;
import usuarios.Carro;
import usuarios.ClienteGaragem;

public class AndarGaragem extends Andar {
	
	private Vaga[][] mapaVagas; //matriz de Carros, null para vagas desocupadas
	private int vagasDisponiveis;
	private boolean andarCheio = false;
	
	public AndarGaragem (int linhas, int colunas, int nomeAndar) { //inicio do metodo Construtor
		super(nomeAndar);
		vagasDisponiveis = linhas * colunas;
		mapaVagas = new Vaga[linhas][colunas]; //construtor para AndarGaragem
		for(int i = 0; i < linhas; i++) {
			for(int j = 0; j < colunas; j++) {
				mapaVagas[i][j] = new Vaga();
			}
		}
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
	
	
	
	/*
	 * Metodo estacionarCarro: chama método GerenciadorGaragem para estacionar carro e diminui quantidade de vagas
	 * param: clienteGaragem, linha, colunha, andar
	 * return boolean 
	 */
	public boolean estacionarCarro (ClienteGaragem cliente, char linha, int coluna, int andar) {
		boolean estacionado = GerenciadorGaragem.estacionarCarro(cliente, linha, coluna, andar, mapaVagas); //chama metodo do gerenciador
		if(estacionado) {
			this.diminuiVagas(); //se estacionou, diminui numero de vagas
		}
		return estacionado;
	}
	
	
	/*
	 * Metodo desestacionarCarro: chama método GerenciadorGaragem para desestacionar carro e aumenta quantidade de vagas
	 * param: clienteGaragem
	 * return boolean
	 */
	public Carro desestacionarCarro (ClienteGaragem cliente) {
		Carro desestacionado = GerenciadorGaragem.desestacionarCarro(cliente, mapaVagas);
		this.aumentaVagas(); //retira o carro da vaga e aumenta o numero de vagas disponiveis
		
		return desestacionado;
	}
	
	
	
	/*
	 * Metodo imprimirMapa: mostrar matriz de vaga
	 * param:
	 * reutrn:void 
	 */
	@Override
	public String imprimirMapa() { //inicio do metodo imprime mapa
		String saida = "\n"; // = "Mapa de Vagas" + "\n";
		int i, j;
		for(i = 0; i < mapaVagas.length; i++) {
			for(j = 0; j < mapaVagas[i].length; j++) {
				if(mapaVagas[i][j].isVagaOcupada())
				//	mapaVagas[i][j].imprimirVaga();
				
				saida = saida + mapaVagas[i][j].imprimirVaga();
			}
		}
		
		return saida;
	} //funcao de impressao do andar, por placa de carros
	
}//fim classe AndarGaragem
