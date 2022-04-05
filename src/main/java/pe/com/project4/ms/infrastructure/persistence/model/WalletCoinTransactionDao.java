package pe.com.project4.ms.infrastructure.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import pe.com.project4.ms.domain.WalletCoinTransaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("walletBCTransactions")
public class WalletCoinTransactionDao {
    @Id
    private String id;
    private String walletAccountSenderId;
    private String walletAccountReceiverId;
    private String modePayment;
    private String codeTransfer;
    private BigDecimal amount;
    private LocalDateTime occurredAt;


    public WalletCoinTransactionDao(WalletCoinTransaction walletCoinTransaction) {
        id = walletCoinTransaction.getId();
        walletAccountSenderId = walletCoinTransaction.getWalletAccountSenderId();
        amount = walletCoinTransaction.getAmount();
        modePayment = walletCoinTransaction.getModePayment();
        codeTransfer = walletCoinTransaction.getCodeTransfer();
        occurredAt = walletCoinTransaction.getOccurredAt();
    }

    public WalletCoinTransaction toWalletCoinTransaction() {
        WalletCoinTransaction walletTransaction = new WalletCoinTransaction();
        walletTransaction.setWalletAccountSenderId(walletAccountSenderId);
        walletTransaction.setWalletAccountReceiverId(walletAccountReceiverId);
        walletTransaction.setAmount(amount);
        walletTransaction.setModePayment(modePayment);
        walletTransaction.setCodeTransfer(codeTransfer);
        walletTransaction.setOccurredAt(occurredAt);
        return walletTransaction;
    }

}
