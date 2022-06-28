package adquirencia.task;


import adquirencia.utils.templates.MergeFrom;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import java.util.Map;

import static adquirencia.utils.Constant.Constants.BODY;
import static adquirencia.utils.Constant.Constants.PATH_TEMPLATE;

public class Create implements Task {
    private final String template;
    private final Map<String, String> clientData;
    public Create(String template, Map<String, String> clientData) {
        this.template = template;
        this.clientData = clientData;
    }

    public static Create messageBody(String template, Map<String, Object> clientData) {
        return Tasks.instrumented(Create.class, template, clientData);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String templatePath = String.format(PATH_TEMPLATE, template);
        String body = MergeFrom.template(templatePath).withFieldsFrom(clientData);
        actor.remember(BODY, body);
    }
}
