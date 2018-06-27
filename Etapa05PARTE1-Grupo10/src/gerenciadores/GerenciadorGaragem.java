package gerenciadores;

import locais.Vaga;
import usuarios.Carro;
import usuarios.ClienteGaragem;

public class GerenciadorGaragem {
	
	/*
	 * Metodo static estacionarCarro: responsável por estacionar carro
	 * param: clienteGaragem, linha, coluna, andar, matriz de Vagas
	 * return: boolean
	 */
	public static boolean estacionarCarro (ClienteGaragem cliente, char linha, int coluna, int andar, Vaga[][] mapaVagas) {
		if(!mapaVagas[(int)linha - 65][coluna].isVagaOcupada()) {
			mapaVagas[(int)linha - 65][coluna].ocuparVaga(cliente); //converte caractere da linha para um inteiro via tabela ASCII
			int[] lugarOcupado = new int [2];
			lugarOcupado[0] = (int)linha - 65;
			lugarOcupado[1] = coluna; //atribui a localizacao da vaga do carro
			cliente.getCarro().setLocalizacao(lugarOcupado); //seta localizacao do carro no objeto em questao
			cliente.getCarro().setAndarLocalizado(andar); //atribui carro a posicao da matriz achada, e atualiza dados do carro para sua localizacao
			
			return true;
		}else {
			return false;
		}
	}
	
	
	
	/*
	 * Metodo static desestacionarCarro: responsável por retirar o carro da Garagem
	 * param: clienteGaragem, , matriz de Vagas
	 * return carro desestacionado
	 */
	public static Carro desestacionarCarro (ClienteGaragem cliente, Vaga[][] mapaVagas) {
		Carro desestacionado = cliente.getCarro();  
		
		mapaVagas[desestacionado.getLocalizacao()[0]][desestacionado.getLocalizacao()[1]].desocuparVaga(); //invoca metodo de Vaga para desocupar o espaco
		
		return desestacionado;
	}	
}
