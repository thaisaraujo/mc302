
public class ClienteAluguel extends Cliente{ //inicio da classe ClienteAluguel

	private boolean seguro;
	private int IDAlugado;
	private int qtdMultas; //cliente alugado eh subclasse de cliente, com numero de multas e id do carro alugado
		
	public ClienteAluguel(String nome, String dataDeNascimento, String CPF,
			int qtdMultas, boolean seguro) { //inicio do metodo construtor
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

	public int getIDAlugado() { //inicio do metodo getIDAlugado
		return IDAlugado;
	} //fim do metodo getIDAlugado

	public void setIDAlugado(int iDAlugado) { //inicio do metod setIDAlugado
		IDAlugado = iDAlugado;
	} //fim do metodo setIDAlugado

	public boolean isSeguro() { //inicio do metodo isSeguro
		return seguro;
	} //fim do metodo isSeguro

	public void setSeguro(boolean seguro) { //inicio do metodo setSeguro
		this.seguro = seguro;
	} //fim do metodo setSeguro
	
	

} //fim da classe ClienteAlugada
