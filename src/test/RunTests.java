import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by wenjia on 6/14/2017.
 */
@RunWith(Cucumber.class)
@CucumberOptions(plugin={"pretty"}, features={"src/test/features/register_user.feature"})
public class RunTests {
}
