package gerenciadores;

import usuarios.CarroAluguel;
import usuarios.ClienteAluguel;

public class GerenciadorAluguel { //inicio da classe GerenciadorAluguel
	
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
	
	public static CarroAluguel retornarCarro (ClienteAluguel cliente, CarroAluguel[] carrosAluguel) { 
		CarroAluguel carroRetornado = carrosAluguel[((CarroAluguel) cliente.getCarro()).getIDAlugado()]; 
		carroRetornado.setAlugado(false); //seta o carro como disponivel via seu id no vetor de carros para aluguel de AndarAluguel
		
		cliente.setCarro(null);
		
		return carroRetornado;
		
	}
} //fim da classe GerenciadorAluguel
