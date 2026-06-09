package interpreter;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PedidoTest {

    @Test
    void deveCalcularTotalConta() {
        Pedido pedido = new Pedido();
        pedido.setValorLanche(20.0);
        pedido.setValorAdicionais(5.0);
        
        assertEquals(25.0, pedido.calcularTotalConta());
    }

    @Test
    void deveCalcularTotalPromocaoMetadeDoPreco() {
        Pedido pedido = new Pedido();
        pedido.setValorLanche(20.0);
        pedido.setValorAdicionais(10.0);
        
        // Avaliação: 20 + 10 = 30 / 2 = 15
        assertEquals(15.0, pedido.calcularTotalPromocao());
    }
}