package org.europepmc.example.jersey;
 
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/api")
public class HelloWorldService {
 
	@GET
	@Path("/hello/{param}")
	public Response getMsg(@PathParam("param") String msg) {
 	    StringBuilder builder = new StringBuilder("Jersey say: Hello ");
	    builder.append(msg);
	    builder.append(" \nYou seem to be an ");
	    
	    if (AuthUtils.hasRole("ROLE_USER")) {
	        builder.append("*authenticated*");
	    } else {
	        builder.append("anonymous");
	    }
	    builder.append(" user.");
 
		return Response.status(200).entity(builder.toString()).build(); 
	}
	
	@GET
    @Path("/hi/{param}")
    public Response getHiMsg(@PathParam("param") String msg) {
         return this.getMsg(msg);
    }
 
}