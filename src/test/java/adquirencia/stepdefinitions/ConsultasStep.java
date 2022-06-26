package adquirencia.stepdefinitions;

import adquirencia.exceptions.AssertionsServices;
import adquirencia.questions.StatusCode;
import adquirencia.task.ConsumeGet;
import adquirencia.task.ConsumeGetkey;
import adquirencia.utils.resource.WebServiceEndPoints;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ConsultasStep {


    @Given("El {} desea consultar las ciudades disponibles")
    public void elUsuarioDeseaConsultarLasCiudadesDisponibles(String actorName) {

        //OnStage.theActorCalled(actorName).describedAs("El usuario ingresa la app");
    }

    @When("El usuario consulta")
    public void elUsuarioConsulta() {

        theActorInTheSpotlight().attemptsTo(
                ConsumeGet.service(
                        WebServiceEndPoints.URI.getUrl()
                ));


    }
    @Then("El servicio debara responder con un status code {int}")
    public void elServicioDebaraResponderConUnStatusCode(int responseCode) {

        theActorInTheSpotlight()
                .should(seeThat(StatusCode.is(responseCode))
                        .orComplainWith(AssertionsServices.class,
                                AssertionsServices.THE_STATUS_CODE_SERVICE_IS_NOT_EXPECTED)
                );

    }


    @Given("El usuario envia la peticion")
    public void elUsuarioEnviaLaPeticion() {
        theActorInTheSpotlight().attemptsTo(
                ConsumeGetkey.service(
                        WebServiceEndPoints.URI.getUrl()
                )
        );
    }

    @When("El usuario ve el response {int}")
    public void elUsuarioVeElResponse(Integer int1) {

    }
    @Then("valida el schema")
    public void validaElSchema() {

    }
}
