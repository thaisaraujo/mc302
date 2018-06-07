package Entidades;


public abstract class Cliente { //inicio da classe Cliente
	private String nome;
	private String dataDeNascimento;
	private String CPF;
	private Carro carro; 
	//dados de cliente e atibuto Carro para o carro que lhe pertence
	
	public Cliente(String nome, String dataDeNascimento, String CPF) {
		//inicio do metodo construtor
		this.nome = nome;
		this.dataDeNascimento = dataDeNascimento;
		this.CPF = CPF;

		System.out.println("Cliente " + nome + " criado ");
	} //fim do metodo construtor
	
	public String getNome(){ //inicio do metodo getNome
		return nome;
	} //fim do metodo getNome
	
	public String getDataDeNascimento(){ //inicio do metodo getDataDeNascimento
		return dataDeNascimento;
	} //fim de getDataDeNascimento
	
	public String getCPF() { //inicio do metodo getCPF
		return CPF;
	} //fim de getCPF
	
			
	public void setCarro(Carro carro) { //inicio do metodo setCarro
		this.carro = carro;
	} //fim do metodo setCarro
	
	public Carro getCarro() { //inicio do metodo getCarro
		return carro;
	} //fim do metodo getCarro
	
	public boolean calcularIdade(String dataDeNascimento) {
		String ano = dataDeNascimento.substring(7, 10); //String contém os caracteres referente ao ano
		int anoValido;
		
		anoValido = Integer.parseInt(ano); //Conveter String ano para int 
		
		if(2018 - anoValido >= 18) {
			return true;
		}else {
			return false;
		}
		
		
	}
	
	//Classe Abstract
	public abstract void imprimirCliente();
	
	
} //fim da classe Cliente
