package guru.springframework.springrestclientexamples.services;

import guru.springframework.api.domain.Data;
import guru.springframework.api.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class ApiServiceImpl implements ApiService {

    private final RestTemplate restTemplate;
    private final HttpEntity<User> entity;
    private final String api_url;

    public ApiServiceImpl(RestTemplate restTemplate,@Value("${api.url}") String api_url) {
        this.restTemplate = restTemplate;
        this.api_url = api_url;
        HttpHeaders header = new HttpHeaders();
        header.set("app-id","5fd7fe64f3d9872ded23cf1f");
        entity = new HttpEntity<>(header);
    }

    @Override
    public List<User> getUsers(Integer limit) {
        UriComponentsBuilder componentsBuilder = UriComponentsBuilder
                .fromUriString(api_url)
                .queryParam("limit",limit);

        Data data = restTemplate.exchange(componentsBuilder.toUriString(), HttpMethod.GET,entity,Data.class).getBody();

        return data.getData();
    }

    @Override
    public Flux<User> getUsers(Mono<Integer> limit) {

        return limit.flatMap( lim ->
                     WebClient.create(api_url)
                            .get()
                            .uri(uriBuilder -> uriBuilder.queryParam("limit", lim).build())
                            .accept(MediaType.APPLICATION_JSON)
                            .header("app-id", "5fd7fe64f3d9872ded23cf1f")
                            .exchange()
                            .flatMap(resp -> resp.bodyToMono(Data.class))
            ).flatMapIterable(Data::getData);
    }
}
