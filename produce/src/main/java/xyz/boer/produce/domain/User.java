package xyz.boer.produce.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author boer
 */
@Data
@NoArgsConstructor
public class User {
    private Long id;
    private String name;
    private Integer age;

    public User(String name, Integer age) {
        this.name = name;
        this.age =  age;
    }
}
