package br.edu.lab5.ex2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PersonDAO {
    private static final String emailIncorrect = "E-mail incorreto";

    public void save(Person person) {
        List<String> errors = isValidToInclude(person);
        if (errors.isEmpty()) {
            System.out.println("Pessoa salva com sucesso!");
        } else {
            for (String error : errors) {
                System.out.println(error);
            }
        }
    }

    public List<String> isValidToInclude(Person person) {
        List<String> isValidToIncludeList = new ArrayList<String>();
        if (!(person.getNamePerson().contains(" ")) && (!(person.getNamePerson().contains(".*\\d.*")))) {
            isValidToIncludeList.add("Nome incorreto");
        }
        if ((person.getAgePerson() <= 1) || (person.getAgePerson() >= 200)) {
            isValidToIncludeList.add("Idade incorreta");
        }   
        if (person.getNameEmail().isEmpty()) {
            isValidToIncludeList.add("Precisa ter um e-mail");

        } else if (!(person.getNameEmail().isEmpty())) {
            for (Email emails : person.getNameEmail()) {
                String[] partesEmails = emails.getNameEmail().split("@");
                String[] dominio = partesEmails[1].split("\\.");
                if (!partesEmails[1].contains(".") ||
                    partesEmails.length != 2 || 
                    partesEmails[0].isEmpty() ||
                    partesEmails[0].isBlank() ||
                    dominio.length < 1 ||
                    dominio[1].isBlank() ||                 
                    partesEmails[0].isEmpty() ||   
                    partesEmails[0].isBlank() || 
                    partesEmails[1].isEmpty() ||  
                    partesEmails[1].isBlank()  
                    ) {
                    isValidToIncludeList.add(emailIncorrect);
                }
            }
        }
        return isValidToIncludeList;
    }
}