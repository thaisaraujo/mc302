
public class CarroAluguel extends Carro { //inicio da classe CarroAluguel
	
	private boolean alugado = false; 

	public CarroAluguel(String marca, String modelo, String placa, String cor, double quilometragem, int ID) { //inicio do metodo construtor
		super(marca, modelo, placa, cor, quilometragem);
	} //fim do metodo construtor

	public boolean isAlugado() { //inicio do metodo isAlugado
		return alugado;
	} //fim do metodo isAlugado

	public void setAlugado(boolean alugado) { //inicio do metodo setAlugado
		this.alugado = alugado;
	} //fim do metodo setAlugado

} //fim da classe CarroAluguel
