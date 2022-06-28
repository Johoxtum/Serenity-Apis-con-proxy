package adquirencia.stepdefinitions;

import adquirencia.models.TestData;
import adquirencia.task.ConsumePost;
import adquirencia.task.Create;
import adquirencia.task.Load;
import adquirencia.utils.resource.WebServiceEndPoints;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ConsumoStep {

    @Given("Se cargan los datos necesarios")
    public void seCarganLosDatosNecesarios(List<Map<String,String>> client) {

        theActorInTheSpotlight().wasAbleTo(
               // Load.testData(client.get(0))
        );
    }


    @When("Se envian el Post")
    public void seEnvianElPost() {

        theActorInTheSpotlight().attemptsTo(
                Create.messageBody("singleuser.json", TestData.getData())
        );
        theActorInTheSpotlight().attemptsTo(
                ConsumePost.service(WebServiceEndPoints.URI.getUrl())
        );

    }
    @Then("Se valida el Schema y el status code {int}")
    public void seValidaElSchemaYElStatusCode(Integer int1) {

    }
}
