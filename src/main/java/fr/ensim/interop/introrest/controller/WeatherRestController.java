package fr.ensim.interop.introrest.controller;

import fr.ensim.interop.introrest.model.telegram.Geo;
import fr.ensim.interop.introrest.model.telegram.Meteo;
import org.primefaces.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@RestController
public class WeatherRestController {

    @Value("${telegram.api.url}")
    private String telegramApiUrl;
    @Value("${telegram.api.url.send}")
    private String telegramApiUrlSend;

    private RestTemplate restTemplate;

    @GetMapping("/getWeather")
    public void getWeather(String adresse)
    {
        String uri = "https://api-adresse.data.gouv.fr/search/?q="+adresse;
        RestTemplate restTemplate = new RestTemplate();
        Geo result = restTemplate.getForObject(uri, Geo.class);
        System.out.println("RESULT GEO :"+result.toString());

        //Appeler l'API meteo
        String insee = result.features.get(0).properties.citycode;
        String urimeteo = "https://api.meteo-concept.com/api/forecast/daily?token=c211cedd38c0c4434e5fe0291f3517c1b8cd414477c4ae218e14b99f2fc91011&insee="+insee;
        Meteo resultMeteo = restTemplate.getForObject(urimeteo, Meteo.class);
        System.out.println("RESULT FORECAST : "+resultMeteo.toString());
        String message="Meteo "+adresse+" ("+insee+") : \n";
        for(Meteo.Forecast f: resultMeteo.forecast)
        {
            int month = f.datetime.getMonth()+1;
            message+="Le "+f.datetime.getDate()+"/"+month+" : [ Min :"+f.tmin+"° ] [Max :"+f.tmax+"° ] \n";
        }

        //Envoyer le message
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        JSONObject messageJsonObject = new JSONObject();
        messageJsonObject.put("chat_id", "5456654722");
        messageJsonObject.put("text", message);

        HttpEntity<String> request = new HttpEntity<String>(messageJsonObject.toString(), headers);

        try {
            String messageResultAsJsonStr = restTemplate.postForObject(telegramApiUrlSend, request, String.class);
        } catch (RestClientException e) {
            e.printStackTrace();
        }

    }
}
