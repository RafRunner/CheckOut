package bancoDeDados;

import java.math.BigDecimal;

import dominio.Caixa;

//Essa classe deve ser usada no lugar de dominio.Caixa para interagir mais facilmente com o Banco de Dados
public class CaixaDAO {

	private Caixa caixa;
	
	public CaixaDAO(Caixa caixa) 
	{
		this.caixa = caixa;
	}
	
	public CaixaDAO()
	{
		this.caixa = new Caixa();
	}

	public void adicionaProduto (int id, int quantidade) 
	{	
		caixa.adicionaProduto(ProdutoDAO.getProduto(id), quantidade);
	}
	
	public void removeProduto (int id, int quantidade) 
	{
		caixa.removeProduto(ProdutoDAO.getProduto(id), quantidade);
	}
	
	public void limparCaixa()
	{
		this.caixa = new Caixa();
	}
	
	public BigDecimal getPreco() 
	{
		return caixa.getPreco();
	}
	
	public BigDecimal getDesconto () 
	{
		return caixa.getDesconto();
	}
	
	public BigDecimal getPrecoTotal() 
	{
		return caixa.getPreco().subtract(caixa.getDesconto());
	}
	
	public String toString() 
	{
		return caixa.toString();
	}
}
