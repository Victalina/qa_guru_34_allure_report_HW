package qa.guru.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SelenideIssueTitleTest {
  @Test
  public void checkIssueTitleTest() {
    SelenideLogger.addListener("allure", new AllureSelenide());

    open("https://github.com");
    $(".header-search-button").click();
    $("#query-builder-test").setValue("selenide").pressEnter();

    $(linkText("selenide/selenide")).click();
    $("#issues-tab").click();
    $(withText("Automation analysis")).should(Condition.exist);

  }
}
