package com.zensar.webservice.hello;
import java.time.LocalDate;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



@Path("/hello")
public class HelloService 
{
@GET
@Produces(MediaType.TEXT_HTML)
  public String sayPlainHello() 
  {
	  return"Welcome to Zensar hello service";
  }
@Path("/html")  //subpath
@GET
@Produces(MediaType.TEXT_HTML)
public String sayHtmlHello() 
{
	return"<h1>welcome to zensar</h1>";
}
@Path("/xml")
@GET
@Produces(MediaType.TEXT_XML)
public String sayXmlHello() {
	
	return "<?xml version='1.0'?><hello>Hello Jersey</hello>";
}
@GET
@Path("/{nm}")
@Produces("text/plain")
public String sayHelloWebService(@PathParam("nm")String name) {
	return "Dear" +name+ "Welcome to zensar Service";
	
}
@GET
@Path("res/{nm}")
@Produces("text/plain")
public Response sayHelloUser(@PathParam("nm")String name)
{
   Response res= Response.status(200).entity("Dear" +name+ "Welcome to zensar Service").build();
	return res;
	
}
@GET
@Path("res/{nm}/{dd}/{mm}/{yy}")
@Produces("text/plain")
public Response sayHappyBirthday(@PathParam("nm")String name,@PathParam("dd") int day,@PathParam("mm")int month,@PathParam("yy") int year)
{
  LocalDate birthDate=LocalDate.of(1997, 10, 30);
  Response res= Response.status(200).entity("Dear" +name+ "Happy B'day on" +birthDate+ " Welcome to zensar Service").build();
	return res;
	
}
}
