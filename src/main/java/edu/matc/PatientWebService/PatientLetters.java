package edu.matc.PatientWebService;

import edu.matc.entity.Patient;
import edu.matc.persistence.GenericDao;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/letter")
public class PatientLetters {
    // The Java method will process HTTP GET requests
    @GET
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("text/plain")
    public Response getLetter() {
        // Return a simple message

        GenericDao genericDao = new GenericDao(Patient.class);
        Patient patient = (Patient)genericDao.getById(1);
        String output = patient.getNotes();
        return Response.status(200).entity(output).build();
    }

}
