package backEnd;

public enum EPromocoes {

	LEVE_X_PAGUE_Y("LeveXPagueY", 1, "leve\\ \\d+\\ pague\\ \\d+"),
	PAGUE_X_POR_Y("PagueXPorY", 2 ,"\\d+\\ por\\ \\d+");
	
	private String nome;
	private int id;
	private String regex;
	
	EPromocoes(String nome, int id, String regex)
	{
		this.nome = nome;
		this.id = id;
		this.regex = regex;
	}
	
	public String getNome()
	{
		return nome;
	}
	
	public int getId()
	{
		return id;
	}
	
	public String getRegex()
	{
		return regex;
	}
}
