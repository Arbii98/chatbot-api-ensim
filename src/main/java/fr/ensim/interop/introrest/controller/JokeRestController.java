package fr.ensim.interop.introrest.controller;

import fr.ensim.interop.introrest.model.telegram.Joke;
import org.primefaces.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Random;

@RestController
public class JokeRestController {

    @Value("${telegram.api.url}")
    private String telegramApiUrl;
    @Value("${telegram.api.url.send}")
    private String telegramApiUrlSend;

    private ArrayList<Joke> jokes = new ArrayList<Joke>();
    private RestTemplate restTemplate;

    public JokeRestController()
    {
        jokes.add(new Joke(1,"Titre 1","Qu’est-ce que le livre de mathématiques dit au conseiller d’orientation?\n" +
                "J’ai tellement de problèmes.",0));
        jokes.add(new Joke(2,"Titre 2","Si une horloge sonne 13 fois, quelle heure est-il?\n" +
                "Il est l’heure d’acheter une nouvelle horloge!",0));
        jokes.add(new Joke(3,"Titre 3","Quelle est la couleur préférée d’un chat?\n" +
                "Le rrrrrouge.",0));
        jokes.add(new Joke(4,"Titre 4","Pourquoi un ordinateur voudrait-il se gratter?\n" +
                "Parce qu’il a des puces!",0));
        jokes.add(new Joke(5,"Titre 5","Quel bonbon est toujours blasé?\n" +
                "Le choco-las",0));
        jokes.add(new Joke(6,"Titre 6","Quel est le type de blague préféré d’une tomate?\n" +
                "Celles bien juteuses!",0));

        restTemplate = new RestTemplate();
    }

    @GetMapping("/getRandomJoke")
    public Joke getRandomJoke()
    {
        int random = new Random().nextInt(jokes.size());
        return jokes.get(random);
    }

    public void sendJoke()
    {
        Joke joke = getRandomJoke();
        System.out.println("Joke : "+joke);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        JSONObject messageJsonObject = new JSONObject();
        messageJsonObject.put("chat_id", "5456654722");
        messageJsonObject.put("text", joke.getTexte());

        HttpEntity<String> request = new HttpEntity<String>(messageJsonObject.toString(), headers);

        try {
            String messageResultAsJsonStr = restTemplate.postForObject(telegramApiUrlSend, request, String.class);
        } catch (RestClientException e) {
            e.printStackTrace();
        }
    }

}
