package qa.guru.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class LambdaStepsIssueTitleTest {

  public static final String REPOSITORY = "selenide/selenide";
  public static final String ISSUE = "Automation analysis";

  @Test
  public void checkIssueTitleTest() {
    SelenideLogger.addListener("allure", new AllureSelenide());

    step("Открываем главную страницу", () -> {
      open("https://github.com");
    });
    step("Ищем репозиторий " + REPOSITORY, () -> {
      $(".header-search-button").click();
      $("#query-builder-test").setValue(REPOSITORY).pressEnter();
    });
    step("Кликаем по ссылке репозитория " + REPOSITORY, () -> {
      $(linkText(REPOSITORY)).click();
    });
    step("Открываем таб Issues", () -> {
      $("#issues-tab").click();
    });
    step("Проверяем Issue с названием " + ISSUE, () -> {
      $(withText(ISSUE)).should(Condition.exist);
    });
  }
}
