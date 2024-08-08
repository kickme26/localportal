package controllers;
import views.html.*;
import java.util.Arrays;
import java.util.List;
import static play.libs.Scala.asScala;
import play.mvc.Controller;
import play.mvc.*;
import views.html.*;
public class IzDashboard extends Controller{
    List<String> sidemenu = Arrays.asList("Dashboard", "Timesheet", "Search for Expert", "Create Invoice", "Add Employee", "Profile", "Holidays", "Work History");
    public Result dashboard(Http.Request request) {


        // Pass the request to retrieve Messages
        return ok(views.html.dashboard.render(asScala(sidemenu)));
    }

}
