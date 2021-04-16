package com.example.sse.demosse.controler;

import com.example.sse.demosse.entity.Payload;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ClientSseController {
  protected final ArrayList<Payload> payloads = new ArrayList<>();


  @PostMapping(path = "/payload", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public Mono<Payload> sendPayload(@RequestBody Payload payload) {
    payloads.add(payload);
    return Mono.just(payload);
  }


  @GetMapping(path = "/clientSse", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  public Flux<List<Payload>> clientSse() {
    return Flux.interval(Duration.ofSeconds(1))
      .map(sequence -> payloads);
  }
}
