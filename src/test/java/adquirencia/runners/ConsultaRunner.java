package adquirencia.runners;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = "@Getcities",
        features = "src/test/resources/features/consultas.feature",
        glue = {"adquirencia.stepdefinitions.hook",
                "adquirencia.stepdefinitions"
        }
)
public class ConsultaRunner {
}
