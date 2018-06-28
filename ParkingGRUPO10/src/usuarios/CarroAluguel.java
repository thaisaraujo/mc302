package usuarios;
public class CarroAluguel extends Carro {

	private boolean alugado = false; 
	private int IDAlugado; //id que marca qual o carro no catalogo

	public CarroAluguel(String marca, String modelo, String placa, String cor, double quilometragem, int tipo, int ID) { //inicio do metodo construtor
		super(marca, modelo, placa, cor, quilometragem, tipo);
		this.IDAlugado = ID;
	} //fim do metodo construtor

	public boolean isAlugado() { //inicio do metodo isAlugado
		return alugado;
	} //fim do metodo isAlugado

	public void setAlugado(boolean alugado) { //inicio do metodo setAlugado
		this.alugado = alugado;
	} //fim do metodo setAlugado
	
	public int getIDAlugado() {
		return IDAlugado;
	}
	
	@Override
	public String imprimirCarro() {
		String saida =  "\nPlaca: " + getPlaca() + "\nModelo: " + getModelo() + "\nMarca: " + 
	getMarca() + "\nID: " + IDAlugado + "\nTipo: " + getTipo() + "\n";
		return saida;
		
		//System.out.println("---------- Carro Para Aluguel" + "\nPlaca: " + getPlaca() + "\nMarca: " + getModelo() + "\nMarca: " + getMarca()
		//		+ "ID: " + IDAlugado);
	}
}
