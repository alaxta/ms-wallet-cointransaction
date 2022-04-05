package pe.com.project4.ms.application;

import pe.com.project4.ms.domain.WalletCoinTransaction;
import pe.com.project4.ms.infrastructure.event.SendMoneyEvent;
import reactor.core.publisher.Mono;

public interface SaveWalletCoinTransactionUseCase {
    Mono<WalletCoinTransaction> save(SendMoneyEvent sendMoneyEvent);
}
