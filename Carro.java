
public class Carro {
	
	private String marca;
	private String modelo;
	private String placa;
	private String chassi;
	private String cor;
	private String combustivel;
	private int ano;
	private String renavam;
	private String quilometragem; //dados do carro
	private AndarGaragem andarLocalizado;
	private int[] localizacao; //dados de carro, com objetos para o andar que esta estacionado e vetor de suas coordenadas
	
	public Carro (String marca, String modelo, String placa, String chassi, String cor, String combustivel, int ano, String renavam, String quilometragem) {
		this.marca = marca;
		this.modelo = modelo;
		this.placa = placa;
		this.chassi = chassi;
		this.cor = cor;
		this.combustivel = combustivel;
		this.ano = ano;
		this.renavam = renavam;
		this.quilometragem = quilometragem;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public String getModelo(){
		return modelo;
	}
	
	public String getPlaca() {
		return placa;
	}
	
	public String getChassi() {
		return chassi;
	}
	
	public String getCor() {
		return cor;
	}
	
	public String getCombustivel() {
		return combustivel;
	}
	
	public int getAno() {
		return ano;
	}
	
	public String getRenavam() {
		return renavam;
	}
	
	public String getQuilometragem() {
		return quilometragem;
	}
	
	public void imprimeCarro() {
		System.out.printf("%s  ", getPlaca());
	}

	public AndarGaragem getAndarLocalizado() {
		return andarLocalizado;
	}

	public void setAndarLocalizado(AndarGaragem andarLocalizado) {
		this.andarLocalizado = andarLocalizado;
	}

	public int[] getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(int[] localizacao) {
		this.localizacao = localizacao;
	}
}
