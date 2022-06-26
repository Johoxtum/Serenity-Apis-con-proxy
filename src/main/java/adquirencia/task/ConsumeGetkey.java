package adquirencia.task;

import adquirencia.interactions.ExecuteGet;
import adquirencia.interactions.ExecuteGetkey;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class ConsumeGetkey implements Task{

    private final String resource;

    public ConsumeGetkey(String resource) {
        this.resource = resource;
    }

    public static ConsumeGetkey service(String resource) {
        return Tasks.instrumented(ConsumeGetkey.class, resource);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(ExecuteGetkey.service(resource));
    }
}
