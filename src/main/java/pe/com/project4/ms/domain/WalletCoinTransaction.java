package pe.com.project4.ms.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WalletCoinTransaction {
    private String id;
    private String walletAccountSenderId;
    private String walletAccountReceiverId;
    private BigDecimal amount;
    private String modePayment;
    private String codeTransfer;
    private LocalDateTime occurredAt;
    private WalletCoinTransactionType walletTransactionType;
}
