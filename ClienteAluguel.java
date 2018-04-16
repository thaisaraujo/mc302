
public class ClienteAluguel extends Cliente{

	private int qtdMultas;
	private int qtdCarrosAlugados;
		
	public ClienteAluguel(String nome, String dataDeNascimento, String CPF, int periodo,
			String telefone, String endereco, int qtdMultas, int qtdCarrosAlugados, Carro carro) {
		super(nome, dataDeNascimento, CPF, periodo, telefone, endereco, carro);
		this.qtdMultas = qtdMultas;
		this.qtdCarrosAlugados = qtdCarrosAlugados;
	}
	
	public int getQtdMultas() {
		return qtdMultas;
	}
	
	public int getQtdCarrosAlugados() {
		return qtdCarrosAlugados;
	}
	
	public void setQtdMultas(int qtdMultas) {
		this.qtdMultas = qtdMultas;
	}
	
	public void setQtdCarrosAlugados(int qtdCarrosAlugados) {
		this.qtdCarrosAlugados = qtdCarrosAlugados;
	}
}
