
package Entidades;


public class ClienteAluguel extends Cliente{ //inicio da classe ClienteAluguel

	private boolean seguro;
	private int qtdMultas; 
	private int diarias; 
	//cliente alugado eh subclasse de cliente, com numero de multas, seguro, qtd de dias 
		
	public ClienteAluguel(String nome, String dataDeNascimento, String CPF, int qtdMultas,
			boolean seguro) { //inicio do metodo construtor
		super(nome, dataDeNascimento, CPF);
		this.qtdMultas = qtdMultas;
		this.seguro = seguro;
	} //fim do metodo construtor

	public int getQtdMultas() { //inicio do metodo getQtdMultas
		return qtdMultas;
	} //fim do metodo getQtdMultas
	
	public void setQtdMultas(int qtdMultas) { //inicio do metodo setQtdMultas
		this.qtdMultas = qtdMultas;
	} //fim do metodo setQtdMultas

	public boolean isSeguro() { //inicio do metodo isSeguro
		return seguro;
	} //fim do metodo isSeguro

	public void setSeguro(boolean seguro) { //inicio do metodo setSeguro
		this.seguro = seguro;
	} //fim do metodo setSeguro

	public int getDiarias() {
		return diarias;
	}

	public void setDiarias(int diarias) {
		this.diarias = diarias;
	}
	
	@Override
	public void imprimirCliente() {
		System.out.println("########## Cliente Alguel\nNome: " + getNome() + "\n Data de nascimento: " + getDataDeNascimento() 
		+ "\nCPF :" + getCPF() + "Numero de diarias: " + diarias + "\n");
		
	}
	

} //fim da classe ClienteAlugad
