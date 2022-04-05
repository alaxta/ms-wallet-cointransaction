package pe.com.project4.ms.infrastructure.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import pe.com.project4.ms.infrastructure.event.SendMoneyEvent;
import pe.com.project4.ms.infrastructure.producer.WalletCoinTransactionKafkaProducer;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class WalletCoinTransactionHandler {

    private final WalletCoinTransactionKafkaProducer walletCoinTransactionKafkaProducer;

    public Mono<ServerResponse> postWalletCoinTransaction(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(SendMoneyEvent.class)
                .map(sendMoneyEvent -> {
                    walletCoinTransactionKafkaProducer.sendMessage(sendMoneyEvent);
                    return sendMoneyEvent;
                }).then(ServerResponse.noContent().build());
    }
}
