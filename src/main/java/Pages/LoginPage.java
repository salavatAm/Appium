package Pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class LoginPage {
    AndroidDriver androidDriver;
    public LoginPage(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
    }

    public WebElement yandexLogin(){
        return androidDriver.findElementById("ru.yandex.mail:id/list_yandex");
    }
    public WebElement loginTextField(){
        return androidDriver.findElementById("ru.yandex.mail:id/edit_login");
    }
    public WebElement nextButton(){
        return androidDriver.findElementById("ru.yandex.mail:id/button_next");
    }
    public WebElement passwordField(){
        return androidDriver.findElementById("ru.yandex.mail:id/edit_password");
    }
    public WebElement closeButton(){
        return androidDriver.findElementById("ru.yandex.mail:id/close_button");
    }
    public WebElement goToEmailBitton(){return  androidDriver.findElementById("ru.yandex.mail:id/go_to_mail_button");}

    public void ChooseYandexLogin() throws InterruptedException {
        yandexLogin().click();
        wait(3000);
    }
    public void inputLogin(String login) throws InterruptedException {
        loginTextField().sendKeys(login);
        clickNextButton();
    }
    public void inputPassword(String password) throws InterruptedException{
        passwordField().sendKeys(password);
        clickNextButton();
        androidDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        clickGoToEmailButton();
    }
    public void clickNextButton() throws InterruptedException {nextButton().click();wait(3000);}
    public void clickCloseButton() throws InterruptedException{closeButton().click();wait(3000);}
    public void clickGoToEmailButton() throws InterruptedException{goToEmailBitton().click();wait(3000);}
    public void wait(int delay) throws InterruptedException {
        synchronized (androidDriver){
            androidDriver.wait(delay);
        }
    }
}
