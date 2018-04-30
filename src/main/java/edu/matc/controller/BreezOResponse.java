package edu.matc.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.matc.breezeometer.AirQualityResults;
import edu.matc.breezeometer.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.Properties;

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
        ServletContext context      = getServletContext();
        Properties properties       = (Properties) context.getAttribute("theraProperties");

        String lati  = request.getParameter("lat");
        String longi = request.getParameter("long");

        Client client = ClientBuilder.newClient();


        WebTarget target =
                client.target("https://api.breezometer.com/baqi/?" +
                "lat=" + lati + "&lon=" + longi + "&key=4821c06763234d35808978e2da91c82c&fields=breezometer_aqi,random_recommendations,breezometer_description,country_aqi_prefix,country_color,breezometer_color,country_name,country_aqi,country_description,dominant_pollutant_canonical_name,dominant_pollutant_description,dominant_pollutant_text,datetime,pollutants,data_valid");

        String webResponse = target.request(MediaType.APPLICATION_JSON).get(String.class);

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