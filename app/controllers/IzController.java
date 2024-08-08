package controllers;

import models.LoginDetails;
import play.data.FormFactory;
import play.i18n.MessagesApi;
import play.mvc.*;

import javax.inject.Inject;
import play.data.Form;
import views.html.*;
import java.util.Arrays;
import java.util.List;
import static play.libs.Scala.asScala;

public class IzController extends Controller {

    @Inject
    FormFactory formFactory;

    @Inject
    MessagesApi messagesApi;
   
    List<String> sidemenu = Arrays.asList("Dashboard", "Timesheet", "Search for Expert", "Create Invoice", "Add Employee", "Profile", "Holidays", "Work History");

    // Display the login form
    public Result login(Http.Request request) {
        Form<LoginDetails> loginForm = formFactory.form(LoginDetails.class);
        // Pass the request to retrieve Messages
        return ok(views.html.izlogin.render(loginForm, request, messagesApi.preferred(request)));
    }
    public Result home(Http.Request request) {
        Form<LoginDetails> loginForm = formFactory.form(LoginDetails.class).bindFromRequest(request);
        // Pass the request to retrieve Messages
        LoginDetails loginDetails = loginForm.get();
        String name = loginDetails.getName();
        String pass = loginDetails.getPassword();
        return ok(views.html.home.render(name, pass, asScala(sidemenu)));
    }
    // Handle form submission
    public Result loginSubmit(Http.Request request) {
        Form<LoginDetails> loginForm = formFactory.form(LoginDetails.class).bindFromRequest(request);
       
        if (loginForm.hasErrors()) {
            // If there are errors, re-render the login form with errors
            return badRequest(views.html.izlogin.render(loginForm, request, messagesApi.preferred(request)));
        } else {
            // If the form is valid, get the login details
            LoginDetails loginDetails = loginForm.get();
            // Pass the login details to another view
            return ok(views.html.home.render(loginDetails.getName(), loginDetails.getPassword(), asScala(sidemenu)));
        }
    }
}
