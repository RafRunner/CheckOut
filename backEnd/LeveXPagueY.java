package backEnd;

public class LeveXPagueY implements Promocao {

	private double valorUnitario;
	private int x, y;
	
	public LeveXPagueY(double valorUnitario, int x, int y) 
	{
		this.valorUnitario = valorUnitario;
		this.x = x;
		this.y = y;
	}

	@Override
	public double getDesconto(int nProdutos) 
	{
		int vezesDesconto = nProdutos / x;
		return vezesDesconto * valorUnitario * (x - y);
	}

	@Override
	public Promocao getTipo() 
	{
		return this;
	}
}
