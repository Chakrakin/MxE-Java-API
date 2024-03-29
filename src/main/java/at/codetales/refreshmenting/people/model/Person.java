package at.codetales.refreshmenting.people.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Builder
@Data
public class Person {
  @Id
  private Integer id;
  private String name;
}
