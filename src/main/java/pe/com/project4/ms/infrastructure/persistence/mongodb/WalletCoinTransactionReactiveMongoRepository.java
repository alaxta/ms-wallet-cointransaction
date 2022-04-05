package pe.com.project4.ms.infrastructure.persistence.mongodb;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pe.com.project4.ms.application.repository.WalletCoinTransactionRepository;
import pe.com.project4.ms.domain.WalletCoinTransaction;
import pe.com.project4.ms.infrastructure.persistence.model.WalletCoinTransactionDao;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class WalletCoinTransactionReactiveMongoRepository implements WalletCoinTransactionRepository {

    private final IWalletCoinTransactionReactiveMongoRepository walletCoinTransactionReactiveMongoRepository;

    @Override
    public Mono<WalletCoinTransaction> save(WalletCoinTransaction walletTransaction) {
        return walletCoinTransactionReactiveMongoRepository.save(new WalletCoinTransactionDao(walletTransaction))
                .map(WalletCoinTransactionDao::toWalletCoinTransaction);
    }

}
