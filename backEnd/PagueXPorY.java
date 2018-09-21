package backEnd;

import java.math.BigDecimal;

public class PagueXPorY implements Promocao {

	private BigDecimal valorUnitario;
	private int y;
	private BigDecimal x;

	public PagueXPorY(BigDecimal valorUnitario, BigDecimal x, int y) 
	{
		this.valorUnitario = valorUnitario;
		this.y = y;
		this.x = x;
	}

	@Override
	public BigDecimal getDesconto(int nProdutos) 
	{
		int vezesDesconto = nProdutos / y;
		return (valorUnitario.multiply(BigDecimal.valueOf(y)).subtract(x)).multiply(BigDecimal.valueOf(vezesDesconto));
	}

	@Override
	public String getTipo() 
	{
		return "PagueXPorY";
	}
	
	@Override
	public String toString()
	{
		return "tipo: " + getTipo()
				+ "\nquantidade ativação: " + y
				+ "\nvalor desconto: " + x + "\n";
	}
	
	@Override
	public void setValorUnitario(BigDecimal valorUnitario) 
	{
		this.valorUnitario = valorUnitario;
		
	}

	@Override
	public int getQuantidadeAtivacao() 
	{
		return y;
	}

	@Override
	public BigDecimal getValorDesconto() 
	{
		return x;
	}
}
