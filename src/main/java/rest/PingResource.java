package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;

@Path("serverstatus")
public class PingResource {

  private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
  
  @Context
  private UriInfo context;
  
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public void getServerStatus(@Suspended final AsyncResponse ar) {
    ExecutorService es = Executors.newSingleThreadExecutor();
      es.submit(new Runnable() {
      @Override
      public void run() {
        try {
          Thread.sleep(2000);  //Simulate a long running process
        } catch (InterruptedException ex) {
          Logger.getLogger(PingResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        ar.resume("{\"msg\":\"Make me return server status from all servers\"}");
        es.shutdown();
      }
    });
  }
  
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("solution")
  public void getServerStatus2(@Suspended final AsyncResponse ar) throws Exception {
    List<String> res = parallel.ParallelPinger.getStatusFromAllServers();  
    ar.resume("{\"status\":\""+gson.toJson(res)+"\"}");
  }
    
}
