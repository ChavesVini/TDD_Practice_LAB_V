package br.edu.lab5.ex2;

import java.util.ArrayList;
import java.util.List;

public class PersonDAO {
    public void save(Person person) {
        List<String> errors = isValidToInclude(person);
        if (errors.isEmpty()) {
            System.out.println(person.getNamePerson());
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
                String[] dominioLadoEsquerdo = partesEmails[0].split("\\.");
                if (partesEmails.length != 2) {
                    isValidToIncludeList.add("E-mail incorreto");
                } else if (partesEmails[0].isBlank() || 
                           partesEmails[0].isEmpty() 
                          ) {
                    isValidToIncludeList.add("E-mail incorreto");
                } else if (!partesEmails[1].contains(".") || (dominio.length != 2)) {
                    isValidToIncludeList.add("E-mail incorreto");
                } else if (partesEmails[0].isEmpty() ||
                           partesEmails[0].isBlank() ||
                           dominio[0].isEmpty() ||   
                           dominio[0].isBlank() || 
                           dominio[1].isEmpty() ||  
                           dominio[1].isBlank()  
                          ) {
                    isValidToIncludeList.add("E-mail incorreto");
                }
            }
        }
        return isValidToIncludeList;
    }
}