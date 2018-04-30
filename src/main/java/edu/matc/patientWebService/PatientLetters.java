package edu.matc.patientWebService;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.matc.entity.Patient;
import edu.matc.persistence.GenericDao;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/letters")
public class PatientLetters {
    // The Java method will process HTTP GET requests
    @GET
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("application/json")

    public Response getLetter() throws JsonProcessingException {
        // Return a simple message

        ObjectMapper mapper = new ObjectMapper();
        String jformatoutput = "[";

        GenericDao genericDao = new GenericDao(Patient.class);
        Patient patient = (Patient) genericDao.getById(1);
        //String output = patient.getNotes();

        jformatoutput = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(patient.getFirstName()) + patient.getNotes() + "]";

        //return Response.status(200).entity(output).build();
        return Response.ok(jformatoutput, MediaType.APPLICATION_JSON).build();

    }
}