package at.codetales.refreshmenting.people.repository;

import at.codetales.refreshmenting.people.model.Person;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleRepository extends ReactiveMongoRepository<Person, Integer> {
}
