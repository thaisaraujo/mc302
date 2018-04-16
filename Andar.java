import java.util.Arrays;

public class Andar {

	private int nomeAndar;
	private int vagasTotais; //guarda numero do andar e numero de vagas totais (numero de carros para alugule eh igual a vagas totais)
	
	public Andar(int linhas, int colunas, int nomeAndar) {
		this.nomeAndar = nomeAndar;
		this.vagasTotais = linhas * colunas;
	}
	
	public int getNomeAndar() {
		return nomeAndar;
	}
		
	public int getVagasTotais() {
		return vagasTotais;
	}
}
