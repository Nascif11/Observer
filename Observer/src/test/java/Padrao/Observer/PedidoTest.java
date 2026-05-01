package Padrao.Observer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PedidoTest {

    @Test
    void deveNotificarUmCliente() {
        Pedido pedido = new Pedido(1, "Em preparo");
        Cliente cliente = new Cliente("Lucas");

        cliente.acompanharPedido(pedido);

        pedido.atualizarStatus("Saiu para entrega");

        assertEquals(
                "Lucas, seu pedido foi atualizado: Pedido{numero=1, status='Saiu para entrega'}",
                cliente.getUltimaNotificacao()
        );
    }

    @Test
    void deveNotificarMultiplosClientes() {
        Pedido pedido = new Pedido(2, "Em preparo");

        Cliente cliente1 = new Cliente("Lucas");
        Cliente cliente2 = new Cliente("Maria");

        cliente1.acompanharPedido(pedido);
        cliente2.acompanharPedido(pedido);

        pedido.atualizarStatus("Entregue");

        assertEquals(
                "Lucas, seu pedido foi atualizado: Pedido{numero=2, status='Entregue'}",
                cliente1.getUltimaNotificacao()
        );

        assertEquals(
                "Maria, seu pedido foi atualizado: Pedido{numero=2, status='Entregue'}",
                cliente2.getUltimaNotificacao()
        );
    }

    @Test
    void naoDeveNotificarClienteNaoInscrito() {
        Pedido pedido = new Pedido(3, "Em preparo");

        Cliente cliente = new Cliente("Lucas");

        pedido.atualizarStatus("Cancelado");

        assertNull(cliente.getUltimaNotificacao());
    }
}