package backEnd;
import java.math.BigDecimal;
import java.util.ArrayList;

public class Caixa {

	private ArrayList<Item> listaItens;
	private BigDecimal preco;
	private BigDecimal desconto;
	
	public Caixa(ArrayList<Produto> produtos) 
	{
		listaItens = new ArrayList<Item>();
		preco = new BigDecimal("0");
		desconto = new BigDecimal("0");
		
		for(Produto produto : produtos) {
			listaItens.add(new Item(produto));
		}
	}
	
	public void adicionaProduto (String nome) 
	{
		for(int i = 0; i < listaItens.size(); i++) {
			if(listaItens.get(i).getNome().equals(nome)) {
			
				listaItens.get(i).addProduto();
				
			}
		}
	}
	
	public void removeProduto (String nome) 
	{
		for(int i = 0; i < listaItens.size(); i++) {
			if(listaItens.get(i).getNome().equals(nome)) {
			
				listaItens.get(i).rmProduto();
				
			}
		}
	}
	
	public BigDecimal getPreco () 
	{
		preco = new BigDecimal("0");
		for(Item item : listaItens) {
			preco.add(item.getProduto().getValor().multiply(BigDecimal.valueOf(item.getN())));
		}
		return preco;
	}
	
	public BigDecimal getDesconto () 
	{
		desconto = new BigDecimal("0");
		for(Item item : listaItens) {
			
			BigDecimal maiorDesconto = new BigDecimal("0");
			
			if(item.getProduto().getPromocoes() != null) {
			
				for(Promocao promocao : item.getProduto().getPromocoes()) {
				
					if(promocao.getDesconto(item.getN()).compareTo(maiorDesconto) == 1) {
						maiorDesconto = promocao.getDesconto(item.getN());
					}
				}
				desconto.add(maiorDesconto);
			}
			
		}
		return desconto;
	}
	
	public BigDecimal getPrecoTotal() 
	{
		return getPreco().subtract(getDesconto());
	}
	
	public String toString() 
	{
		StringBuilder string = new StringBuilder();
		for(Item item : listaItens) {
			string.append(item.getNome() + ", " +  item.getN() + "\n");
		}
		return string.toString();
	}

}
