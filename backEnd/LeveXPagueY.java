package backEnd;

import java.math.BigDecimal;

public class LeveXPagueY implements Promocao {

	private BigDecimal valorUnitario;
	private int x, y;
	
	public LeveXPagueY(BigDecimal valorUnitario, int x, int y) 
	{
		this.valorUnitario = valorUnitario;
		this.x = x;
		this.y = y;
	}

	@Override
	public BigDecimal getDesconto(int nProdutos) 
	{
		int vezesDesconto = nProdutos / x;
		return valorUnitario.multiply(BigDecimal.valueOf(vezesDesconto)).multiply(BigDecimal.valueOf((x - y)));
	}

	@Override
	public String getTipo() 
	{
		return "LeveXPagueY";
	}
	
	public String toString()
	{
		return "tipo: " + getTipo()
				+ "\nquantidade ativação: " + x
				+ "\nvalor desconto: " + y + "\n";
	}
}
