package org.example.resources;


import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.entity.CalenderEvent;
import org.example.repository.CalenderEventRepository;


import java.util.List;
import java.util.logging.Logger;

@Path("/calender-events")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CalenderEventResources {

    private Logger log;

    @Inject
    CalenderEventRepository calenderEventRepository;

    @GET
    public List<CalenderEvent> getAll() {
        return calenderEventRepository.listAll();
    }

    @POST
    @Transactional
    public void add(CalenderEvent calenderEvent) {

        if(calenderEvent.getTitle() == null || calenderEvent.getTitle().isEmpty()) {
            throw new WebApplicationException("CalenderEvent title was not set on request.", 400);
        }

        calenderEventRepository.persist(calenderEvent);
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void delete(@PathParam("id") String id) {

        if(id == null || id.isEmpty()) {
            throw new WebApplicationException("Id was not set on request.", 400);
        }

        calenderEventRepository.deleteById(Long.valueOf(id));
    }
}
