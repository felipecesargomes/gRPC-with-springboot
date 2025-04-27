package com.felipe.sec01;

import com.felipe.models.sec01.PersonOuterClass.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleProtoDemo {

    // Logger para exibir informações no console
    private static final Logger log = LoggerFactory.getLogger(SimpleProtoDemo.class);

    public static void main(String[] args) {
        // Cria uma instância de Person usando o builder gerado pelo Protobuf
        var person = Person.newBuilder()
                           .setName("sam") // Define o nome como "sam"
                           .setAge(12)     // Define a idade como 12
                           .build();       // Constrói o objeto Person
        // Exibe as informações do objeto Person no log
        log.info("{}", person);
    }

}