

public class AndarGaragem extends Andar { //inicio do metodo AndarGaragem

	private Carro[][] mapaCarros; //matriz de Carros, null para vagas desocupadas
	private int vagasDisponiveis;
	private boolean andarCheio = false;
	
	public AndarGaragem (int linhas, int colunas, int nomeAndar) { //inicio do metodo Construtor
		super(nomeAndar);
		vagasDisponiveis = linhas * colunas;
		mapaCarros = new Carro[linhas][colunas]; //construtor para AndarGaragem
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
		for(i = 0; i < mapaCarros.length; i++) {
			for(j = 0; j < mapaCarros[i].length; j++) {
				if(mapaCarros[i][j].getPlaca().equals(placa)) {
					return mapaCarros[i][j]; //percorre linearmente matriz			
				}
			}
		}		
		return null; //funcao de procura carro pela sua placa
	} //fim do metodo buscaCarro
	
	public int[] buscaVagaVazia() { //inicio do metodo buscaVagaVazia
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
	} //fim do metodo buscaVagaVazia
	
	public Carro desestacionaCarroAndar(int[] localizacao) { //inicio do metodo desestacionarCarroAndar
		Carro desestacionado = mapaCarros[localizacao[0]][localizacao[1]];
		mapaCarros[localizacao[0]][localizacao[1]] = null;
		this.aumentaVagas(); //aumenta numero de vagas
		
		return desestacionado; //retira carro da matriz
	} //fim do metodo desestacionarCarroAndar
	
	public void estacionaCarroAndar(Carro carro) { //inicio do metodo estacionarCarroAndar
		int[] lugarVago = new int [2];
		lugarVago = buscaVagaVazia(); //busca uma vaga vazia
		mapaCarros[lugarVago[0]][lugarVago[1]] = carro;
		carro.setLocalizacao(lugarVago);
		carro.setAndarLocalizado(this); //atribui carro a posicao da matriz achada, e atualiza dados do carro para sua localizacao
		
		System.out.printf("Carro %s estacionado no andar %d, na linha %d, coluna %d\n",
				carro.getPlaca(), this.getNomeAndar(), carro.getLocalizacao()[0], carro.getLocalizacao()[1]);
		this.diminuiVagas();
		//adiciona carro na matriz
		
	} //fim do metodo estacionarCarroAndar
	
	
	public void imprimeMapa() { //inicio do metodo imprime mapa

		int i, j;
		for(i = 0; i < mapaCarros.length; i++) {
			for(j = 0; j < mapaCarros[i].length; j++) {
				if(mapaCarros[i][j] != null)
					mapaCarros[i][j].imprimeCarro();
			}
		}		
	} //funcao de impressao do andar, por placa de carros
	
} //fim da classe AndarGaragem
