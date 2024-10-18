import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class SendFormTest {
    @Test
    void sendFormTestV1() {
        open("http://localhost:9999");
        SelenideElement form = $("form");
        form.$("[data-test-id='name'] input").setValue("Сергей Новиков");
        form.$("[data-test-id='phone'] input").setValue("+79270000000");
        form.$("[data-test-id='agreement']").click();
        form.$("button").click();
        $("[data-test-id='order-success']")
                .shouldHave(exactText("  Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }

    @Test
    void sendFormTestV2() {
        open("http://localhost:9999");
        SelenideElement form = $("form");
        form.$("[data-test-id='name'] input").setValue("Сергей");
        form.$("[data-test-id='phone'] input").setValue("+79270000000");
        form.$("[data-test-id='agreement']").click();
        form.$("button").click();
        $("[data-test-id='order-success']")
                .shouldHave(exactText("  Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }

    @Test
    void sendFormTestV3() {
        open("http://localhost:9999");
        SelenideElement form = $("form");
        form.$("[data-test-id='name'] input").setValue("Сергей Новиков-Новиков");
        form.$("[data-test-id='phone'] input").setValue("+79270000000");
        form.$("[data-test-id='agreement']").click();
        form.$("button").click();
        $("[data-test-id='order-success']")
                .shouldHave(exactText("  Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }

    @Test
    void sendFormTestV4() {
        open("http://localhost:9999");
        SelenideElement form = $("form");
        form.$("[data-test-id='name'] input").setValue("Sergei");
        form.$("[data-test-id='phone'] input").setValue("+79270000000");
        form.$("[data-test-id='agreement']").click();
        form.$("button").click();
        $("[data-test-id='name'].input_invalid .input__sub")
                .shouldHave(exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));
    }

    @Test
    void sendFormTestV5() {
        open("http://localhost:9999");
        SelenideElement form = $("form");
        form.$("[data-test-id='name'] input").setValue("Сергей Новиков");
        form.$("[data-test-id='phone'] input").setValue("+792700000");
        form.$("[data-test-id='agreement']").click();
        form.$("button").click();
        $("[data-test-id='phone'].input_invalid .input__sub")
                .shouldHave(exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
    }

    @Test
    void sendFormTestV6() {
        open("http://localhost:9999");
        SelenideElement form = $("form");
        form.$("[data-test-id='name'] input").setValue("");
        form.$("[data-test-id='phone'] input").setValue("+792700000");
        form.$("[data-test-id='agreement']").click();
        form.$("button").click();
        $("[data-test-id='name'].input_invalid .input__sub")
                .shouldHave(exactText("Поле обязательно для заполнения"));
    }

    @Test
    void sendFormTestV7() {
        open("http://localhost:9999");
        SelenideElement form = $("form");
        form.$("[data-test-id='name'] input").setValue("Сергей Новиков");
        form.$("[data-test-id='phone'] input").setValue("");
        form.$("[data-test-id='agreement']").click();
        form.$("button").click();
        $("[data-test-id='phone'].input_invalid .input__sub")
                .shouldHave(exactText("Поле обязательно для заполнения"));
    }
    @Test
    void sendFormTestV8() {
        open("http://localhost:9999");

        SelenideElement form = $("form");
        form.$("[data-test-id='name'] input").setValue("Сергей Новиков");
        form.$("[data-test-id='phone'] input").setValue("+79965003434");
        form.$("button").click();
        $("[data-test-id='agreement'].input_invalid .checkbox__text")
                .shouldHave(exactText("Я соглашаюсь с условиями обработки и использования моих персональных данных и разрешаю сделать запрос в бюро кредитных историй"));
    }

}



