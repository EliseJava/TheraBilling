package edu.matc.persistence;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.matc.breezeometer.AirQualityResults;
import edu.matc.breezeometer.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

/**
 * This program is testing the BreezoMeter API
 *
 * @author   Elise Strauss
 */
public class BreezeOMeterTest {

    final Logger logger = LogManager.getLogger(this.getClass());

    @Test
    public void testGoogleApiJSON() throws Exception {

        Client client = ClientBuilder.newClient();
        WebTarget target =

        client.target("https://api.breezometer.com/baqi/?" +
                "lat=43.073052&lon=-89.401230&key=4821c06763234d35808978e2da91c82c&fields=breezometer_aqi,random_recommendations,breezometer_description,country_description,dominant_pollutant_description,country_aqi_prefix,country_color,breezometer_color,country_name,country_aqi,dominant_pollutant_canonical_name,dominant_pollutant_text,datetime,pollutants,data_valid");
        //43.07295, -89.38669  Riversdale South Africa

        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

        ObjectMapper mapper = new ObjectMapper();

        AirQualityResults result = mapper.readValue(response, AirQualityResults.class);
        assertEquals("United States", result.getCountryName());
//        These values will change
//        assertEquals("#6EC634", result.getBreezometerColor());
//        assertEquals("Fair air quality", result.getBreezometerDescription());
//        assertEquals("o3", result.getDominantPollutantCanonicalName());
    }

    @Test
    public void testBadResponseJSON() throws Exception {

        Client client = ClientBuilder.newClient();

        //code invalid coordinates
        WebTarget target =
        client.target("https://api.breezometer.com/baqi/?" +
                "lat=123&lon=123&key=4821c06763234d35808978e2da91c82c&fields=breezometer_aqi,random_recommendations,breezometer_description,country_description,dominant_pollutant_description,country_aqi_prefix,country_color,breezometer_color,country_name,country_aqi,dominant_pollutant_canonical_name,dominant_pollutant_text,datetime,pollutants,data_valid");

        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

        logger.info("Response: " + response);

        ObjectMapper mapper = new ObjectMapper();
        Response result = mapper.readValue(response, Response.class);

        assertEquals(false, result.isDataValid());
        assertEquals("Provided location is unsupported.", result.getError().getMessage());

    }
}
