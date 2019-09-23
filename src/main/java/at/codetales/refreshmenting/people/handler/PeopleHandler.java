package at.codetales.refreshmenting.people.handler;

import at.codetales.refreshmenting.people.model.Person;
import at.codetales.refreshmenting.people.repository.PeopleRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class PeopleHandler {

  private PeopleRepository repository;

  public PeopleHandler(PeopleRepository peopleRepository) {
    this.repository = peopleRepository;
  }

  public Mono<ServerResponse> listPeople(ServerRequest req) {
    return ServerResponse.ok().body(repository.findAll(), Person.class);
  }
}
