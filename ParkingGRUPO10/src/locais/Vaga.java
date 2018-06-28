package locais;

import usuarios.Carro;
import usuarios.ClienteGaragem;

public class Vaga { //inicio da classe vaga
	private boolean vagaOcupada; //boleano que marcase vaga esta ocupada
	private Carro carroEstacionado;
	private ClienteGaragem donoCarro; //atributos dono do carro e seu automovel
	
	public Vaga() { //inicio do metodo Vaga
		setVagaOcupada(false);
	} //construtor de vaga
	
	public void ocuparVaga(ClienteGaragem cliente) { //inicio do metodo ocuparVaga
		carroEstacionado = cliente.getCarro(); 
		donoCarro = cliente;
		vagaOcupada = true;
	} //fim do metodo ocupar vaga
	
	public void desocuparVaga() { //inicio do metodo desocuparVaga

		vagaOcupada = false;
		carroEstacionado = null;
		donoCarro = null; //
		
	} //fim do metodo desocuparVaga
	
	public String imprimirVaga() { //inicio do metodo imprimir Vaga
		String saida = carroEstacionado.imprimirCarro();
		return saida;
	//	carroEstacionado.imprimirCarro();
	} //fim do metodo imprimirVaga
	
	public boolean isVagaOcupada() { //inicio do metodo isVagaOcupada
		return vagaOcupada;
	} //fim do metodo isVagaOcupada

	public void setVagaOcupada(boolean vagaOcupada) { //inicio do metodo setVagaOcupada
		this.vagaOcupada = vagaOcupada;
	} //fim do metodo setVagaOcupada

	public Carro getCarro() { //inicio do metodo getCarro
		return carroEstacionado;
	} //fim do metodo getCarro
	
	public ClienteGaragem getCliente() { //inicio do metodo getCliente
		return donoCarro;
	} //fim do metodo getCliente
	
	public void setCarro(Carro novoCarro) { //inicio do metodo setCarro
		carroEstacionado = novoCarro;
	} //fim do metodo setCarro
	
	public void setCliente(ClienteGaragem novoCliente) { //inicio do metodo setCliente
		donoCarro = novoCliente;
	} //fim do metodo setCliente
} //fim da classe Vaga
