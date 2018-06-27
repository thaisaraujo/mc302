package gerenciadores;

import usuarios.CarroAluguel;
import usuarios.ClienteAluguel;

public class GerenciadorAluguel { //inicio da classe GerenciadorAluguel
	
	
	/*
	 * Metodo alugarCarro: procurar um carro disponível para alugar
	 * param: clienteAluguel, vetor de carrosAluguel
	 * return: CarroAluguel se disponível, null caso contrátio
	 */
	public static CarroAluguel alugarCarro (ClienteAluguel cliente, CarroAluguel[] carrosAluguel) {
		for(CarroAluguel carroTemp: carrosAluguel) {
			if(!carroTemp.isAlugado()) { //acha um carro nao alugado
				cliente.setCarro(carroTemp); //seta este carro para o cliente
				carroTemp.setAlugado(true); //carro marcado como alugado
				return carroTemp;
			}
		}
		
		return null;
	}
	
	
	
	/*
	 * Metodo retornarCarro: seta carro no vetor, informar que o carro foi devolvido
	 * param: ClienteAluguel, vetor de carrosAluguel
	 * return: CarroAluguel que foi devolvido pelo cliente
	 */
	public static CarroAluguel retornarCarro (ClienteAluguel cliente, CarroAluguel[] carrosAluguel) { 
		CarroAluguel carroRetornado = carrosAluguel[((CarroAluguel) cliente.getCarro()).getIDAlugado()]; 
		carroRetornado.setAlugado(false); //seta o carro como disponivel via seu id no vetor de carros para aluguel de AndarAluguel
		
		cliente.setCarro(null);
		
		return carroRetornado;
		
	}
} //fim da classe GerenciadorAluguel
