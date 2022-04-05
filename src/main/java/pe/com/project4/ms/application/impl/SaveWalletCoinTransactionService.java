package pe.com.project4.ms.application.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.com.project4.ms.application.SaveWalletCoinTransactionUseCase;
import pe.com.project4.ms.application.repository.WalletCoinTransactionRepository;
import pe.com.project4.ms.domain.WalletCoinTransaction;
import pe.com.project4.ms.infrastructure.event.SendMoneyEvent;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Slf4j
public class SaveWalletCoinTransactionService implements SaveWalletCoinTransactionUseCase {

    private final WalletCoinTransactionRepository walletCoinTransactionRepository;

    @Override
    public Mono<WalletCoinTransaction> save(SendMoneyEvent sendMoneyEvent) {
        return walletCoinTransactionRepository.save(sendMoneyEvent.toWalletTransaction());
    }

}
