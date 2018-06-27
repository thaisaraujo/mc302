package usuarios;

public class EnumSeguro {
	public enum Seguro{
		SIM, NAO;
	}

	public static final EnumSeguro SIM = null;
	
	private Seguro seguro;
	
	EnumSeguro(Seguro seguro) {
		this.seguro = seguro;
	}

	public Seguro getSeguro() { //inicio metodo getSeguro
		return seguro;
	}//fim metodo getSeguro

}
