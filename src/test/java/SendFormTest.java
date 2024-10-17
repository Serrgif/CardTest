import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class SendFormTest {
    @Test
    void SendFormTestV1() {
        open("http://localhost:9999");
        SelenideElement form = $("form");
        form.$("[data-test-id=name]").setValue("Сергей Новиков");
        form.$("[data-test-id=phone]").setValue("+79270000000");
        form.$("[data-test-id=agreement]").click();
        form.$("button").click();
        $("[data-test-id=order-success]")
                .shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }
}



