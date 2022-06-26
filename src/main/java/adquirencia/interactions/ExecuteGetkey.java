package adquirencia.interactions;

import adquirencia.exceptions.ErrorServicesException;
import adquirencia.models.TestData;
import io.restassured.RestAssured;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;
import org.apache.http.HttpStatus;

import static adquirencia.utils.Constant.Constants.EXCEPTION_ERROR_CONSUMPTION_SERVICE;
import static io.restassured.http.ContentType.JSON;

public class ExecuteGetkey implements Interaction {

    private final String resource;

    public ExecuteGetkey(String resource) {
        this.resource = resource;
    }

    public static ExecuteGetkey service(String resource) {
        return Tasks.instrumented(ExecuteGetkey.class, resource);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        SerenityRest.reset();

        actor.attemptsTo(
                Get.resource(resource)
                        .with(request -> request.
                                params(TestData.getData())
                                .relaxedHTTPSValidation()
                                .headers("X-RqUID","bc8876e9-d61b-4504-be31-7f99f91217e9")
                                .headers("X-Channel","Oficina")
                                .headers("X-CompanyId","001")
                                .headers("X-CustIdentType","CC")
                                .headers("X-CustIdentNum","52805999")
                                .headers("X-IPAddr","0.0.0.0")
                                .headers("X-Name","Banca Movil")
                                .headers("X-TerminalId","1234")
                                .headers("Content-Type","application/json")
                                .headers("X-Api-Key","uGTRR0b1R96HW9zyPb8hh3PhmiYufJyb4OS6WO1r")
                                .headers("X-DeviceId","device3D").log().all()
                        )
        );

        if(SerenityRest.lastResponse().statusCode() != HttpStatus.SC_OK){
            throw new ErrorServicesException(EXCEPTION_ERROR_CONSUMPTION_SERVICE);
        }

    }
}
