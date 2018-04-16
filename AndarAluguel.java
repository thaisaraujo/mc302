
public class AndarAluguel extends Andar {
	
	private boolean aluguelDisponivel = true;
	private int carrosParaAluguel;
	private int limiteMultas;
	private double taxaMultas; //aumenta valor do preco por taxaMultas de numero de multas do cliente ultrapassa limiteMultas
	
	public AndarAluguel(int linhas, int colunas, int nomeAndar,  int limiteMultas, double taxaMultas) {
		super(linhas, colunas, nomeAndar);
		this.carrosParaAluguel = this.getVagasTotais();
		this.limiteMultas = limiteMultas;
		this.taxaMultas = taxaMultas;
	}
	
	public boolean getAluguelDisponivel() {
		return aluguelDisponivel;
	}
	
	public void checaAluguelDisponivel() {
		if(carrosParaAluguel == 0)
			aluguelDisponivel = false;
	}

	public int getLimiteMultas() {
		return limiteMultas;
	}

	public void setLimiteMultas(int limiteMultas) {
		this.limiteMultas = limiteMultas;
	}

	public double getTaxaMultas() {
		return taxaMultas;
	}

	public void setTaxaMultas(double taxaMultas) {
		this.taxaMultas = taxaMultas;
	}
	
	public void diminuiCarrosParaAluguel() {
		carrosParaAluguel --;
	}
	
	public void aumentaCarrosParaAluguel() {
		carrosParaAluguel --;
	}
}
