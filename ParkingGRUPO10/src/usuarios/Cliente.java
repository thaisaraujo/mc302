package usuarios;

public abstract class Cliente {
	private String nome;
	private String dataDeNascimento;
	private long CPF;
	private Carro carro; 
	//dados de cliente e atibuto Carro para o carro que lhe pertence
	
	public Cliente(String nome, String dataDeNascimento, long CPF) {
		//inicio do metodo construtor
		this.nome = nome;
		this.dataDeNascimento = dataDeNascimento;
		this.CPF = CPF;
	} //fim do metodo construtor
	
	public String getNome(){ //inicio do metodo getNome
		return nome;
	} //fim do metodo getNome
	
	public String getDataDeNascimento(){ //inicio do metodo getDataDeNascimento
		return dataDeNascimento;
	} //fim de getDataDeNascimento
	
	public long getCPF() { //inicio do metodo getCPF
		return CPF;
	} //fim de getCPF
	
			
	public void setCarro(Carro carro) { //inicio do metodo setCarro
		this.carro = carro;
	} //fim do metodo setCarro
	
	public Carro getCarro() { //inicio do metodo getCarro
		return carro;
	} //fim do metodo getCarro
	
	public boolean calcularIdade(String dataDeNascimento) {
		String ano = dataDeNascimento.substring(7, 10); //String cont�m os caracteres referente ao ano
		int anoValido;
		
		anoValido = Integer.parseInt(ano); //Conveter String ano para int 
		
		if(2018 - anoValido >= 18) {
			return true;
		}else {
			return false;
		}
		
		
	}
	
	//Classe Abstract
	public abstract String imprimirCliente();
	
	
} //fim da classe Cliente