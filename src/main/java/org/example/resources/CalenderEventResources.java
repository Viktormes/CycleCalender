package org.example.resources;


import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.entity.CalenderEvent;
import org.example.repository.CalenderEventRepository;


import java.util.List;

@Path("/calender-events")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CalenderEventResources {

    @Inject
    CalenderEventRepository calenderEventRepository;

    @GET
    public List<CalenderEvent> getAll() {
        return calenderEventRepository.listAll();
    }

    @POST
    @Transactional
    public void add(CalenderEvent calenderEvent) {
        calenderEventRepository.persist(calenderEvent);
    }
}
