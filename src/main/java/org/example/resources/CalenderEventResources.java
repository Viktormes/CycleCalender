package org.example.resources;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.dto.AddCalenderEventDTO;
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
    public void add(AddCalenderEventDTO calenderEventDTO) {

        if(calenderEventDTO.getTitle() == null || calenderEventDTO.getTitle().isEmpty()) {
            throw new WebApplicationException("CalenderEvent title was not set on request.", 400);
        }
        if(calenderEventDTO.getDescription() == null || calenderEventDTO.getDescription().isEmpty()) {
            throw new WebApplicationException("CalenderEvent description was not set on request.", 400);
        }
        if(calenderEventDTO.getStartDate() == null) {
            throw new WebApplicationException("CalenderEvent start date was not set on request.", 400);
        }
        if(calenderEventDTO.getEndDate() == null) {
            throw new WebApplicationException("CalenderEvent end date was not set on request.", 400);
        }

        CalenderEvent calenderEvent = new CalenderEvent();
        calenderEvent.setTitle(calenderEventDTO.getTitle());
        calenderEvent.setDescription(calenderEventDTO.getDescription());
        calenderEvent.setStartTime(calenderEventDTO.getStartDate());
        calenderEvent.setEndTime(calenderEventDTO.getEndDate());

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
