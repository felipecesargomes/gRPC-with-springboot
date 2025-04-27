package com.felipe.sec02;

import com.felipe.models.sec02.PersonOuterClass.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProtoDemo {

    // Logger para exibir informações no console
    private static final Logger log = LoggerFactory.getLogger(ProtoDemo.class);

    public static void main(String[] args) {

        // Cria a primeira instância de Person
        var person1 = createPerson();

        // Cria outra instância com os mesmos valores
        var person2 = createPerson();

        // Compara as duas instâncias
        log.info("equals {}", person1.equals(person2)); // Verifica se os objetos são iguais
        log.info("== {}", (person1 == person2)); // Verifica se são a mesma referência

        // Verifica se o objeto é imutável
        // Cria outra instância com valores diferentes
        var person3 = person1.toBuilder().setName("mike").build();
        log.info("person3: {}", person3);

        // Compara novamente
        log.info("equals {}", person1.equals(person3)); // Verifica se os objetos são iguais
        log.info("== {}", (person1 == person3)); // Verifica se são a mesma referência

        // Testa a remoção de valores (definindo como vazio)
        var person4 = person1.toBuilder().clearName().build();
        log.info("person4: {}", person4); // Exibe o objeto com o nome limpo
    }

    // Método auxiliar para criar uma instância de Person
    private static Person createPerson() {
        return Person.newBuilder()
                     .setName("sam") // Define o nome como "sam"
                     .setAge(12)     // Define a idade como 12
                     .build();       // Constrói o objeto Person
    }

}