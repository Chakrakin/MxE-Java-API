package at.codetales.refreshmenting;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

import java.util.Optional;

@Configuration
@EnableReactiveMongoRepositories
public class MongoDbConfiguration extends AbstractReactiveMongoConfiguration {

  @Value("${spring.data.mongodb.host}")
  private String mongoHost;
  @Value("${spring.data.mongodb.port}")
  private String mongoPort;
  @Value("${spring.data.mongodb.database}")
  private String mongoDB;

  @Bean
  public MongoClient reactiveMongoClient() {
    return MongoClients.create("mongodb://"+
      Optional.of(System.getenv("MONGODB_HOST")).orElse(mongoHost)+
      ":"+
      Integer.parseInt(Optional.of(System.getenv("MONGODB_PORT")).orElse(mongoPort)));
  }

  @Override
  protected String getDatabaseName() {
    return Optional.of(System.getenv("MONGODB_DBNAME")).orElse(mongoDB);
  }

  @Bean
  public ReactiveMongoTemplate reactiveMongoTemplate() {
    return new ReactiveMongoTemplate(reactiveMongoClient(), getDatabaseName());
  }
}
