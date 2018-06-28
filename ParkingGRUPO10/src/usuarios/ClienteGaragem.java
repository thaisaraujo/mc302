package usuarios;

public class ClienteGaragem extends Cliente {
	private int periodo;

	public ClienteGaragem(String nome, String dataDeNascimento, long CPF, int periodo) {
		super(nome, dataDeNascimento, CPF);
		this.periodo = periodo;
	}
	
	public int getPeriodo() { //inicio do metodo getPeriodoSemanas
		return periodo;
	} //fim do metodo getPeriodoSemanas

	public void setPeriodo(int periodo) { //inicio do metodo setPeriodoSemanas
		this.periodo = periodo;
	} //fim do metodo setPeriodoSemanas

	
	@Override
	public String imprimirCliente() {
		String saida = "Cliente Garagem \nNome: " + getNome() + "\nData de Nascimento: " + getDataDeNascimento() + "\nCPF: " + getCPF() + "\nPlaca do Carro: " 
		+ getCarro().getPlaca() + "\nPeriodo Estacionado: " + periodo + "\n" + this.getCarro().imprimirCarro();
		
		return saida;
				
	//	System.out.println("---------- Cliente Garagem \nNome: " + getNome() + "\n Data de nascimento: " + getDataDeNascimento() 
	//	+ "\nCPF :" + getCPF() + "\nPlaca do carro: " + getCarro().getPlaca() + "\nPeriodo estacionado: " + periodo);
	//	this.getCarro().imprimirCarro();
	
	}
}
