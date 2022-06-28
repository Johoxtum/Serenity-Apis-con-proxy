package adquirencia.task;

import adquirencia.interactions.ExecuteGetkey;
import adquirencia.interactions.ExecutePost;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import static adquirencia.utils.Constant.Constants.BODY;

public class ConsumePost implements Task {

    private final String resource;

    public ConsumePost (String resource) {
        this.resource = resource;
    }

    public static ConsumePost service(String resource) {
        return Tasks.instrumented(ConsumePost.class, resource);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        String body = actor.recall(BODY).toString();
        actor.attemptsTo(ExecutePost.service(resource,body));
    }

}
