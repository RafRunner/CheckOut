package leitorDeDados;

public enum ERegex {

	LEVE_X_PAGUE_Y("leve\\ \\d+\\ pague\\ \\d+"),
	PAGUE_X_POR_Y("\\d+\\ por\\ \\d+"),
	ID("(?<=id:\\ )\\d+(?=\\|)"),
	NOME("(?<=descricao: )[^\\|]+(?=\\|)"),
	VALOR_UNITARIO("(?<=valor: )\\d+\\.\\d{0,2}"),
	ID_PROMOCAO("(?<=promocao: )\\-*\\d+(?=\\|)");
	
	private String regex;
	
	ERegex(String regex)
	{
		this.regex = regex;
	}
	
	public String getRegex()
	{
		return regex;
	}
}
