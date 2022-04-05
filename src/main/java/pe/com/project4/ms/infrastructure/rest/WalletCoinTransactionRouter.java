package pe.com.project4.ms.infrastructure.rest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class WalletCoinTransactionRouter {
    private static final String WALLET_HOLDERS = "/wallet-bctransactions";

    @Bean
    public RouterFunction<ServerResponse> routes(WalletCoinTransactionHandler walletTransactionHandler) {
        return route(POST(WALLET_HOLDERS).and(accept(APPLICATION_JSON)), walletTransactionHandler::postWalletCoinTransaction);
    }
}