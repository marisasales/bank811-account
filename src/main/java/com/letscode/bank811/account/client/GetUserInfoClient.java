package com.letscode.bank811.account.client;

import com.letscode.bank811.account.dto.client.UserInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class GetUserInfoClient {

  @Value("${bank811.client.user.url}")
  private String url;

  @Value("${bank811.client.user.uri}")
  private String uri;

  public UserInfo execute(Integer userId) {
    WebClient webClient = WebClient.builder()
        .baseUrl(url)
        .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
        .build();

    return webClient
        .method(HttpMethod.GET)
        .uri(uri, userId)
        .retrieve()
        .bodyToMono(UserInfo.class)
        .block();
  }
}
