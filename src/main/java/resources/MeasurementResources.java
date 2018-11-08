package resources;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.JsonObject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import commons.Measurement;
import commons.MeasurementLogic;

@Stateless
@Path("/measurement")
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class MeasurementResources {

    @Inject
    MeasurementLogic measurementLogic;


//    @GET
//    public JsonArray findAll() {
//        JsonArrayBuilder list = Json.createArrayBuilder();
//        List<Measurement> all = this.measurementLogic.findAll();
//        all.stream().map(m -> m.toJson().forEach(list::add));
//        return list.build();
//    }

    @GET
    @Path("/{id}")
    public JsonObject findById(@PathParam("id") Long id) {
        Measurement measurement = this.measurementLogic.findById(id);
        return measurement.toJson();
    }


    @POST
    public Response save(@Valid Measurement measurement) {
        this.measurementLogic.create(measurement);
        return Response.ok().build();
    }


    @GET
    @Path("/test")
    public String test() {
        return "<h1>Hello World</h1>";
    }


    @POST
    @Path("/createMock")
    public void createMock() {
        this.measurementLogic.createWithParams("kameramann_test", 100, 2, "2018-11-07 14:20");
    }
}
