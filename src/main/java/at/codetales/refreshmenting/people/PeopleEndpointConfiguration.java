package at.codetales.refreshmenting.people;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import at.codetales.refreshmenting.people.handler.PeopleHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class PeopleEndpointConfiguration {

  @Bean
  RouterFunction<ServerResponse> peopleRoutes(PeopleHandler handler) {
    return route(GET("/"), handler::listPeople)
      .andRoute(GET("/people"), handler::listPeople);
  }
}
