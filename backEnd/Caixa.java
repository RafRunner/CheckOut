package backEnd;
import java.util.ArrayList;

public class Caixa {

	private ArrayList<Item> listaItens;
	private double preco;
	private double desconto;
	
	public Caixa(ArrayList<Produto> produtos) 
	{
		listaItens = new ArrayList<Item>();
		
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
	
	public double getPreco () 
	{
		preco = 0;
		for(Item item : listaItens) {
			preco += item.getProduto().getValor() * item.getN();
		}
		return preco;
	}
	
	public double getDesconto () 
	{
		desconto = 0;
		for(Item item : listaItens) {
			
			double maiorDesconto = 0;
			
			if(item.getProduto().getPromocoes() != null) {
			
				for(Promocao promocao : item.getProduto().getPromocoes()) {
				
					if(promocao.getDesconto(item.getN()) > maiorDesconto) {
						maiorDesconto = promocao.getDesconto(item.getN());
					}
				}
				desconto += maiorDesconto;
			}
			
		}
		return desconto;
	}
	
	public double getPrecoTotal() 
	{
		return getPreco() - getDesconto();
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
