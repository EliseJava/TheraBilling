package edu.matc.persistence;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.matc.breezeometer.AirQualityResults;
import org.junit.jupiter.api.Test;


public class BreezeOMeterTest {
     String test;

    @Test
    public void testGoogleApiJSON() throws Exception {

//        Client client = ClientBuilder.newClient();
//        WebTarget target =
//
//        client.target("https://api.breezometer.com/baqi/?" +
//                "lat=40.7324296&lon=-73.9977264&key=83dcf536a6a34f889d69c2d1ef4334f1&fields=breezometer_aqi,random_recommendations,breezometer_description,country_description,dominant_pollutant_description,country_aqi_prefix,country_color,breezometer_color,country_name,country_aqi,dominant_pollutant_canonical_name,dominant_pollutant_text,datetime,pollutants,data_valid");
       // 43.07295, -89.38669  Riversdale South Africa
//
//        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

        String response = "{\"datetime\": \"2018-03-18T13:00:00\", \"country_name\": \"United States\", \"breezometer_aqi\": 75, \"breezometer_color\": \"#6EC634\", \"breezometer_description\": \"Fair air quality\", \"country_aqi\": 55, \"country_aqi_prefix\": \"\", \"country_color\": \"#FFFF00\", \"country_description\": \"Moderate air quality\", \"data_valid\": true, \"random_recommendations\": {\"children\": \"You should supervise your children in the coming hours and monitor changes in air quality\", \"sport\": \"You can exercise outdoors - but make sure to stay alert to our notifications\", \"health\": \"Exposure to air hazards is dangerous for people with health sensitivities, so it is important to monitor air quality at this time\", \"inside\": \"The amount of pollutants in the air is noticeable, but still there is no danger to your health - It is recommended to continue monitoring changes in the coming hours\", \"outside\": \"It's still OK out there. Just stay alert for notifications about change in air quality\"}, \"dominant_pollutant_canonical_name\": \"o3\", \"dominant_pollutant_description\": \"Ozone\", \"dominant_pollutant_text\": {\"main\": \"The dominant pollutant is ozone (O\\u2083).\", \"effects\": \"Ozone can irritate the airways causing coughing, a burning sensation, wheezing and shortness of breath. Children, people with respiratory or lung and heart diseases, elderly and those who exercise outdoors are particularly vulnerable to ozone exposure.\", \"causes\": \"Ozone is created in a chemical reaction between atmospheric oxygen, nitrogen oxides, organic compounds and sunlight.\"}}";

        ObjectMapper mapper = new ObjectMapper();

        AirQualityResults result = mapper.readValue(response, AirQualityResults.class);
        assertEquals("United States", result.getCountryName());
        assertEquals("#6EC634", result.getBreezometerColor());
        assertEquals("Fair air quality", result.getBreezometerDescription());
        assertEquals("o3", result.getDominantPollutantCanonicalName());
    }
}
