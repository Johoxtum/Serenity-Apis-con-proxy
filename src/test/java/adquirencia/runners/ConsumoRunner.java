package adquirencia.runners;

import adquirencia.utils.exceldata.BeforeSuite;
import adquirencia.utils.exceldata.DataToFeature;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.runner.RunWith;

import java.io.IOException;

@RunWith(CustomRunner.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = "@motores",
        features = "src/test/resources/features/consumo.feature",
        glue = {"adquirencia.stepdefinitions.hook",
                "adquirencia.stepdefinitions"
        }
)
public class ConsumoRunner {

        @BeforeSuite
        public static void test() throws IOException , InvalidFormatException{

                DataToFeature.overrideFeatureFiles("./src/test/resources/features/consumo.feature");
        }
}
