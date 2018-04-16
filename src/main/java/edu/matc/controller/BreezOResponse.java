package edu.matc.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.matc.breezeometer.AirQualityResults;
import edu.matc.breezeometer.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;

/**
 * Servlet to call the BreezoMeter Web Service and display the air quality
 * for a specific lat and long
 *
 * @author Elise Strauss
 */
@WebServlet(
        urlPatterns = {"/breezoResponse"}
)

public class BreezOResponse extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final Logger logger = LogManager.getLogger(this.getClass());

//        String lati  = request.getParameter("lat");
//        String longi = request.getParameter("long");
//
//        Client client = ClientBuilder.newClient();
//
//          //43.07295   -89.38669  Riversdale South Africa
//          //39.904200  116.407396 Beijing China
//          //-36.848460 174.763332 Auckland, NZ
//          //3649a759d3994e03bc68af58cb82854e new
//          //83dcf536a6a34f889d69c2d1ef4334f1 old
//        WebTarget target =
//                client.target("https://api.breezometer.com/baqi/?" +
//                "lat=" + lati + "&lon=" + longi + "&key=83dcf536a6a34f889d69c2d1ef4334f1&fields=breezometer_aqi,random_recommendations,breezometer_description,country_aqi_prefix,country_color,breezometer_color,country_name,country_aqi,country_description,dominant_pollutant_canonical_name,dominant_pollutant_description,dominant_pollutant_text,datetime,pollutants,data_valid");
//
//        String webResponse = target.request(MediaType.APPLICATION_JSON).get(String.class);
        String webResponse = "{\"datetime\": \"2018-03-18T13:00:00\", \"country_name\": \"United States\", \"breezometer_aqi\": 75, \"breezometer_color\": \"#6EC634\", \"breezometer_description\": \"Fair air quality\", \"country_aqi\": 55, \"country_aqi_prefix\": \"\", \"country_color\": \"#FFFF00\", \"country_description\": \"Moderate air quality\", \"data_valid\": true, \"random_recommendations\": {\"children\": \"You should supervise your children in the coming hours and monitor changes in air quality\", \"sport\": \"You can exercise outdoors - but make sure to stay alert to our notifications\", \"health\": \"Exposure to air hazards is dangerous for people with health sensitivities, so it is important to monitor air quality at this time\", \"inside\": \"The amount of pollutants in the air is noticeable, but still there is no danger to your health - It is recommended to continue monitoring changes in the coming hours\", \"outside\": \"It's still OK out there. Just stay alert for notifications about change in air quality\"}, \"dominant_pollutant_canonical_name\": \"o3\", \"dominant_pollutant_description\": \"Ozone\", \"dominant_pollutant_text\": {\"main\": \"The dominant pollutant is ozone (O\\u2083).\", \"effects\": \"Ozone can irritate the airways causing coughing, a burning sensation, wheezing and shortness of breath. Children, people with respiratory or lung and heart diseases, elderly and those who exercise outdoors are particularly vulnerable to ozone exposure.\", \"causes\": \"Ozone is created in a chemical reaction between atmospheric oxygen, nitrogen oxides, organic compounds and sunlight.\"}}";

        logger.info("webResponse..." + webResponse.toString() + " " + webResponse.length());

        int testResponse = webResponse.length();
        ObjectMapper mapper = new ObjectMapper();

        if (testResponse < 100) {
            Response result = mapper.readValue(webResponse, Response.class);

            request.setAttribute("error", result.getError().getMessage());
            request.setAttribute("datavalid", result.isDataValid());
        } else {
            AirQualityResults airResult = mapper.readValue(webResponse, AirQualityResults.class);
            request.setAttribute("datavalid", true);
            request.setAttribute("country", airResult.getCountryName());
            request.setAttribute("color",                   airResult.getBreezometerColor());
            request.setAttribute("description", airResult.getBreezometerDescription());
            request.setAttribute("pollutant", airResult.getDominantPollutantCanonicalName());
            request.setAttribute("pollutiondescription", airResult.getDominantPollutantDescription());
            request.setAttribute("breezedescription", airResult.getBreezometerDescription());
            request.setAttribute("countrydescription",      airResult.getCountryDescription());
            request.setAttribute("children", airResult.getRandomRecommendations().getChildren());
            request.setAttribute("health", airResult.getRandomRecommendations().getHealth());
            request.setAttribute("inside", airResult.getRandomRecommendations().getInside());
            request.setAttribute("outside", airResult.getRandomRecommendations().getOutside());
            request.setAttribute("sport", airResult.getRandomRecommendations().getSport());
            request.setAttribute("causes", airResult.getDominantPollutantText().getCauses());
            request.setAttribute("effects", airResult.getDominantPollutantText().getEffects());
            request.setAttribute("main", airResult.getDominantPollutantText().getMain());
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/breezoDisplay.jsp");
        dispatcher.forward(request, response);
    }
}