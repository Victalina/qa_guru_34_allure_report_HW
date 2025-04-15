package qa.guru.allure;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

public class AnnotatedStepsIssueTitleTest {

  public static final String REPOSITORY = "selenide/selenide";
  public static final String ISSUE = "Automation analysis";

  @Test
  public void checkIssueTitleTest(){
    SelenideLogger.addListener("allure", new AllureSelenide());
    WebSteps steps = new WebSteps();

    steps.openMainPage();
    steps.searchForRepository(REPOSITORY);
    steps.clickOnRepositoryLink(REPOSITORY);
    steps.openIssuesTab();
    steps.shouldSeeIssueWithTitle(ISSUE);
  }
}
