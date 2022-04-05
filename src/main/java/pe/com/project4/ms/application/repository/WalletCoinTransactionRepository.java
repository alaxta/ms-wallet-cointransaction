package pe.com.project4.ms.application.repository;

import pe.com.project4.ms.domain.WalletCoinTransaction;
import reactor.core.publisher.Mono;

public interface WalletCoinTransactionRepository {
    Mono<WalletCoinTransaction> save(WalletCoinTransaction walletCoinTransaction);
}
