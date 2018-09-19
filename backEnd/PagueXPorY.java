package backEnd;

public class PagueXPorY implements Promocao {

	private double valorUnitario;
	private int y;
	private double x;

	public PagueXPorY(double valorUnitario, double x, int y) 
	{
		this.valorUnitario = valorUnitario;
		this.y = y;
		this.x = x;
	}

	@Override
	public double getDesconto(int nProdutos) 
	{
		int vezesDesconto = nProdutos / y;
		return vezesDesconto * ((valorUnitario * y) - x);
	}

	@Override
	public Promocao getTipo() 
	{
		return this;
	}

}
