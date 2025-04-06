package br.edu.lab5.ex2;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private Integer idPerson;
    private String namePerson;
    private Integer agePerson;
    private List<Email> nameEmail;
}
