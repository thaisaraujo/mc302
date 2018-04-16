

public class AndarGaragem extends Andar {

	private Carro[][] mapaCarros; //matriz de Carros, null para vagas desocupadas
	private int vagasDisponiveis;
	private boolean andarCheio = false;
	
	public AndarGaragem (int linhas, int colunas, int nomeAndar) {
		super(linhas, colunas, nomeAndar);
		vagasDisponiveis = linhas * colunas;
		mapaCarros = new Carro[linhas][colunas]; //construtor para AndarGaragem
	}
	
	public void checaCheio() {
		if(vagasDisponiveis == 0)
			andarCheio = true;
	}
	
	public boolean getAndarCheio() {
		return andarCheio;
	}
	
	public int getVagasDisponiveis() {
		return vagasDisponiveis;
	}

	
	public void aumentaVagas() {
		vagasDisponiveis++;
	}
	
	public void diminuiVagas() {
		vagasDisponiveis--;
	}
	
	public Carro buscaCarro(String placa) {
		int i = 0, j = 0;
		for(i = 0; i < mapaCarros.length; i++) {
			for(j = 0; j < mapaCarros[i].length; j++) {
				if(mapaCarros[i][j].getPlaca().equals(placa)) {
					return mapaCarros[i][j];
				}
			}
		}		
		return null; //funcao de procura carro pela sua placa
	}
	
	public int[] buscaVagaVazia() {
		int local [] = new int[2];
		int i = 0, j = 0;
		for(i = 0; i < mapaCarros.length; i++) {
			for(j = 0; j < mapaCarros[i].length; j++) {
				if(mapaCarros[i][j] == null) {
					local[0] = i; local[1] = j;
					return local;
				}
			}
		}		
		return local; //funcao de busca vaga vazia percorrendo matriz linearmente
	}
	
	public Carro desestacionaCarroAndar(String placa, int[] localizacao) {
		Carro desestacionado = mapaCarros[localizacao[0]][localizacao[1]];
		mapaCarros[localizacao[0]][localizacao[1]] = null;
		this.aumentaVagas();
		
		return desestacionado; //retira carro da matriz
	}
	
	public void estacionaCarroAndar(Carro carro) {
		int[] lugarVago = new int [2];
		lugarVago = buscaVagaVazia();
		mapaCarros[lugarVago[0]][lugarVago[1]] = carro;
		carro.setLocalizacao(lugarVago);
		carro.setAndarLocalizado(this);
		
		this.diminuiVagas(); //adiciona carro na matriz
		
	}
	
	public void imprimeMapa() {
		int i, j;
		for(i = 0; i < mapaCarros.length; i++) {
			for(j = 0; j < mapaCarros[i].length; j++) {
				if(mapaCarros[i][j] != null)
					mapaCarros[i][j].imprimeCarro();
			}
		}		
	} //funcao de impressao do andar, por placa de carros
	
}
