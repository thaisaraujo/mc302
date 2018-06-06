
public class ClienteGaragem extends Cliente {
	
	private int periodo;

	public ClienteGaragem(String nome, String dataDeNascimento, String CPF) {
		super(nome, dataDeNascimento, CPF);
		// TODO Auto-generated constructor stub
	}
	
	public int getPeriodo() { //inicio do metodo getPeriodoSemanas
		return periodo;
	} //fim do metodo getPeriodoSemanas

	public void setPeriodo(int periodo) { //inicio do metodo setPeriodoSemanas
		this.periodo = periodo;
	} //fim do metodo setPeriodoSemanas

	@Override
	public void imprimirCliente() {
		System.out.println("########## Cliente Garagem\nNome: " + getNome() + "\n Data de nascimento: " + getDataDeNascimento() 
		+ "\nCPF :" + getCPF() + "\nPlaca do carro: " + this.getCarro().getPlaca() + "Periodo estacionado: " + periodo);
		
	}

}
