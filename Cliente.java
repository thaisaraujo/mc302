
public class Cliente { //cliente estacionamento
	private String nome;
	private String dataDeNascimento;
	private String CPF;
	private int periodoSemanas; //periodo de semanas que vai ficar estacionado
	private String telefone;
	private String endereco;
	private Carro carro; //dados de cliente e atibuto Carro para o carro que lhe pertence
	
	public Cliente(String nome, String dataDeNascimento, String CPF, int periodoSemanas, String telefone, String endereco, Carro carro) {
		this.nome = nome;
		this.dataDeNascimento = dataDeNascimento;
		this.CPF = CPF;
		this.setPeriodoSemanas(periodoSemanas);
		this.telefone = telefone;
		this.endereco = endereco;
		this.carro = carro;
	} //metodo construtor
	
	public String getNome(){
		return nome;
	}
	
	public String getDataDeNascimento(){
		return dataDeNascimento;
	}
	
	public String getCPF() {
		return CPF;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public void imprimirCliente() {
		System.out.println(getCPF());
	}
	
	public void setCarro(Carro carro) {
		this.carro = carro;
	}
	
	public Carro getCarro() {
		return carro;
	}

	public int getPeriodoSemanas() {
		return periodoSemanas;
	}

	public void setPeriodoSemanas(int periodoSemanas) {
		this.periodoSemanas = periodoSemanas;
	}
}
