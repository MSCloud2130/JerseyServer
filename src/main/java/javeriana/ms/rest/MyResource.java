package javeriana.ms.rest;

import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import javeriana.ms.rest.model.Paseo;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
@Produces(MediaType.TEXT_PLAIN)
public class MyResource {
	
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    public String getIt() {
        return "H o l a   m u n d o  ! ";
    }
    

    @GET
    @Path("greeting")
    //myresource/greeting?name=Charmander
    public String greeting(@QueryParam(value="name") String name) {
        return "Sss'up "+name;
    }
    
    @GET
    @Path("sumquery")
    public String sumquery(@QueryParam(value="a") int a, @QueryParam(value="b") int b) {
    	int c = a + b;
    	return "Result: "+String.valueOf(c);
    }
    
    @GET
    @Path("sumpath/{a}/{b}")
    public String sumpath(@PathParam(value="a") int a, @PathParam(value="b") int b) {
    	int c = a + b;
    	return "Result: "+String.valueOf(c);
    }
    
//    @GET
//    @Path("/{user}")
//    public String punto3(@PathParam(value="user") String a, @QueryParam(value="name") String b) {
//    	
//    	return "PathParam: "+a+" QueryParam: "+b;
//    }
    
    @GET
    @Path("/{user}")
    @Produces(MediaType.TEXT_HTML)
    public String punto4(@PathParam(value="user") String a, @QueryParam(value="name") String b) {
    	String htm= "<html><head>"
    			+ "<title>Rest Server</title></head>"
    			+ "<body>"
    			+ "<li>PathParam:"+a+"</li>"
    			+ "<li>QueryParam:"+b+"</li>"	
    			+ "</body>"
    			+ "</html>";
    	return htm;
    }
    
    @GET
    @Path("paseo")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Paseo getPaseo() {
    	Paseo paseo = new Paseo();
    	paseo.setOrigen("Bogota");
    	paseo.setDestino("Miami");
    	paseo.setFechaSalida(new Date(System.currentTimeMillis()));
    	return paseo;
    }
    
    
}
