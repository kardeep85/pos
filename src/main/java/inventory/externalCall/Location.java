package inventory.externalCall;


import inventory.model.location.LocationResponse;
import org.apache.commons.codec.binary.Base64;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


public class Location {

    RestTemplate restTemplate;

    public Location(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public ResponseEntity getLocationDetail()
    {
        String authHeader = "Basic" + buildBasicAuth("user","pass");
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization", authHeader);
        HttpEntity httpEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity responseEntity = this.restTemplate.exchange("http://localhost:8080/location",
                HttpMethod.GET, httpEntity,
                new ParameterizedTypeReference<LocationResponse>()
                {});
        return responseEntity;
}

    private String buildBasicAuth(String user, String password){
        String cred = user + ":" +password;
        byte[] plaincread = cred.getBytes();
        byte[] base64cred = Base64.encodeBase64(plaincread);
        return new String(base64cred);
    }
}
