package ru.vagapov.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import ru.vagapov.spring.entity.User;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;


@SpringBootApplication
public class Main {

    static RestTemplate restTemplate = new RestTemplate();
    static final String URL = "http://94.198.50.185:7081/api/users";


    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        ResponseEntity<String> forEntity = restTemplate.getForEntity(URL, String.class);
        List <String> cookies = forEntity.getHeaders().get("Set-Cookie").stream().toList();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Cookie",cookies.stream().collect(Collectors.joining(";")));
        HttpEntity<User> userHttpEntity = new HttpEntity<>(new User(3L,"James","Brown", (byte) 22),headers);
        System.out.println(( restTemplate.exchange(URL, HttpMethod.POST, userHttpEntity, String.class)).getBody());
        HttpEntity<User> userHttpEntity1 = new HttpEntity<>(new User(3L, "Thomas", "Shelby", (byte) 22),headers);
        System.out.println((restTemplate.exchange(URL, HttpMethod.PUT, userHttpEntity, String.class).getBody()));
        System.out.println(restTemplate.exchange(URL+"/"+userHttpEntity1.getBody().getId(),HttpMethod.DELETE,userHttpEntity1,String.class).getBody());
    }
}
