package com.challenge.michelfreitas.challenge.config;

import com.challenge.michelfreitas.challenge.shared.exception.WebServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Configuration
public class WebClientConfig {

    @Autowired
    private Environment env;

    @Bean
    public WebClient webClient(WebClient.Builder builder) {
        String baseUrl = env.getProperty("webclient.wt.base-url");

        return builder
                .baseUrl(baseUrl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .filter(errorResponseFilter())
                .build();
    }

    private ExchangeFilterFunction errorResponseFilter() {
        return ExchangeFilterFunction.ofResponseProcessor(clientResponse -> {
            if (clientResponse.statusCode().is4xxClientError()) {
                return clientResponse.bodyToMono(String.class)
                        .flatMap(errorBody -> Mono.error(new WebServiceException(
                                "Erro WS: Problema no processamento")));
            } else if (clientResponse.statusCode().is5xxServerError()) {
                return clientResponse.bodyToMono(String.class)
                        .flatMap(errorBody -> Mono.error(new WebServiceException(
                                "Erro WS: Tente novamente mais tarde")));
            } else {
                return Mono.just(clientResponse);
            }
        });
    }
}
