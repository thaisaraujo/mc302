
public class Cliente { //inicio da classe Cliente
	private String nome;
	private String dataDeNascimento;
	private String CPF;
	private int periodoSemanas; //periodo de semanas que vai ficar estacionado
	private String telefone;
	private String endereco;
	private Carro carro; //dados de cliente e atibuto Carro para o carro que lhe pertence
	
	public Cliente(String nome, String dataDeNascimento, String CPF, int periodoSemanas, String telefone, String endereco) {
		//inicio do metodo construtor
		this.nome = nome;
		this.dataDeNascimento = dataDeNascimento;
		this.CPF = CPF;
		this.periodoSemanas = periodoSemanas;
		this.telefone = telefone;
		this.endereco = endereco; 
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
	
	public String getTelefone() { //inicio do metodo getTelefone
		return telefone;
	} //fim do metodo getTelefon
	
	public String getEndereco() { //inicio do metodo getEndereco
		return endereco;
	} //fim do metodo getEndereco
	
	public void setTelefone(String telefone) { //inicio do metodo setTelefon
		this.telefone = telefone;
	} //fim do metodo setTelefone
	
	public void setEndereco(String endereco) { //inicio do metodo setEndecero
		this.endereco = endereco;
	} //fim do metodo setEndereco
		
	public void setCarro(Carro carro) { //inicio do metodo setCarro
		this.carro = carro;
	} //fim do metodo setCarro
	
	public Carro getCarro() { //inicio do metodo getCarro
		return carro;
	} //fim do metodo getCarro

	public int getPeriodoSemanas() { //inicio do metodo getPeriodoSemanas
		return periodoSemanas;
	} //fim do metodo getPeriodoSemanas

	public void setPeriodoSemanas(int periodoSemanas) { //inicio do metodo setPeriodoSemanas
		this.periodoSemanas = periodoSemanas;
	} //fim do metodo setPeriodoSemanas
	
	public void imprimirCliente(){
		System.out.println("Nome: " + nome + "\n Data de nascimento: " + dataDeNascimento + "\nCPF :" + CPF +
				"\nTelefone: " + telefone + "\nPlaca do carro: " + this.getCarro().getPlaca());
	}
} //fim da classe Cliente
