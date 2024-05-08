package org.example.resources;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;
import org.example.dto.UserDTO;
import org.example.entity.User;
import org.example.services.UserService;


@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {


    @Inject
    UserService userService;

    @GET
    @Path("/{id}")
    public Response getUserById(@PathParam("id") Long id) {

        User user = userService.getUser(id);
        return Response.ok(user).build();
    }

    @POST
    @Transactional
    public Response addUser(UserDTO userDTO) {

        User user = userService.addUser(userDTO);
        UriBuilder builder = UriBuilder.fromResource(UserResource.class).path(user.getId().toString());
        return Response.created(builder.build()).build();
    }




}
