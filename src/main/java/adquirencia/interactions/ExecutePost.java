package adquirencia.interactions;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;

public class ExecutePost implements Interaction {

    private final String resource;
    private final String body;

    public ExecutePost(String resource, String body) {
        this.resource = resource;
        this.body = body;
    }




    @Override
    public <T extends Actor> void performAs(T actor) {

        SerenityRest.reset();
        actor.attemptsTo(
                Post.to(resource)
                        .with(request -> request.contentType(
                                ContentType.JSON)
                                .body(body)
                                .relaxedHTTPSValidation()
                                .headers("X-CustIdentType","CC")
                                .headers("X-DigRequest","123456")
                                .headers("X-CustIdentNum","860464268")
                                .headers("X-Channel","Web")
                                .headers("X-Name","Adquirencia")
                                .headers("X-IPAddr","127.0.0.1")
                                .headers("X-RqUID","9f0b5fed-193b-46d1-8d43-18483acdd247")
                                .headers("Content-Type","application/json")
                                .headers("X-IsClient","Active Client")
                                .headers("X-Sync","true")
                                .headers("x-api-key","2XevSnR0NY7b5Y8d6LJjo7U76HyGWIIhmE5Javz7")
                                .headers("X-Journey","Digital")
                                .headers("X-Milestone","Aprobacion"))
        );
    }

    public static ExecutePost service (String resource,String body){

        return Tasks.instrumented(ExecutePost.class,resource,body);
    }
}
