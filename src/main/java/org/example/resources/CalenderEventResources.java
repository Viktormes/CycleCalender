package org.example.resources;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;
import org.example.dto.AddCalenderEventDTO;
import org.example.entity.CalenderEvent;
import org.example.repository.CalenderEventRepository;
import org.example.services.CalenderEventService;

import java.util.List;

@Path("/calender-events")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CalenderEventResources {

    @Inject
    CalenderEventService calenderEventService;

    @GET
    public List<CalenderEvent> getAll() {
        return calenderEventService.getAllCalenderEvents();
    }

    @GET
    @Path("/{id}")
    public CalenderEvent get(@PathParam("id") Long id) {
       return calenderEventService.getCalenderEventById(id);
    }

    @POST
    @Transactional
    public Response add(AddCalenderEventDTO calenderEventDTO) {
        CalenderEvent calenderEvent = calenderEventService.addCalenderEvent(calenderEventDTO);
        UriBuilder uriBuilder = UriBuilder.fromResource(CalenderEventResources.class).path(calenderEvent.getId().toString());
        return Response.created(uriBuilder.build()).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response update(@PathParam("id") Long id, AddCalenderEventDTO calenderEventDTO) {
        CalenderEvent calenderEvent = calenderEventService.updateCalenderEvent(id, calenderEventDTO);
        return Response.ok(calenderEvent).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    @Produces(MediaType.TEXT_PLAIN)
    public Response delete(@PathParam("id") Long id) {

        CalenderEvent calenderEvent = calenderEventService.getCalenderEventById(id);
        calenderEventService.removeCalenderEvent(calenderEvent.getId());
        return Response.ok("Deleted Calender event with id: " + id).build();
    }
}
