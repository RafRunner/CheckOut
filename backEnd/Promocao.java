package backEnd;

import java.math.BigDecimal;

public interface Promocao {

	public BigDecimal getDesconto(int nProdutos);
	public String getTipo();
}
