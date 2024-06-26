package br.com.fiap.pos.soat3.pedido.application.usecases.pedido;

import br.com.fiap.pos.soat3.pedido.application.gateways.PedidoGateway;
import br.com.fiap.pos.soat3.pedido.application.usecases.pedido.AtualizaStatusPedidoInteractor;
import br.com.fiap.pos.soat3.pedido.domain.entity.ItemPedido;
import br.com.fiap.pos.soat3.pedido.domain.entity.Pedido;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AtualizaStatusPedidoInteractorTest {

    @Mock
    private PedidoGateway gateway;

    @InjectMocks
    private AtualizaStatusPedidoInteractor useCase;

    @Test
    void givenCorrectData_whenAtualizaStatusPedido_shouldReturnPedidoModel() {
        Pedido expected = new Pedido(
               1l,
                new ArrayList<ItemPedido>()
        );
        when(gateway.atualizaStatusPedido(
                1L,
               "GERADO"
        )).thenReturn(expected);

        Pedido current = useCase.atualizaStatusPedido(
                1L,
                "GERADO"
        );

        assertEquals(expected, current);
    }
}
