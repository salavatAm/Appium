package Pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

public class ProfilePage {
    AndroidDriver androidDriver;

    public ProfilePage(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
    }

    public WebElement nextButton(){
        return androidDriver.findElementById("ru.yandex.mail:id/next_button");
    }
    public void clickNextButton() throws InterruptedException {nextButton().click();wait(3000);}

    public WebElement closeButton(){
        return androidDriver.findElementById("ru.yandex.mail:id/close_button");
    }
    public void clickCloseButton()throws InterruptedException{closeButton().click(); wait(3000);}

    public WebElement menuButton(){
        return androidDriver.findElementByAccessibilityId("Open menu");
    }
    public void clickMenuButton()throws InterruptedException{menuButton().click();wait(3000);}

    public WebElement sentButton() {return androidDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[3]");}
    public void clickSentButton()throws InterruptedException{sentButton().click();wait(3000);}

    public WebElement settingsButton(){return androidDriver.findElementByXPath("//android.widget.LinearLayout[14]");}
    public void clickSettingsButton() throws InterruptedException{settingsButton().click();wait(3000);}

    public WebElement logOutButton(){return androidDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[16]/android.widget.RelativeLayout/android.widget.TextView");}
    public void clickLogOutButton() throws InterruptedException{logOutButton().click();wait(3000);}

    public WebElement goToMailButton() {
        return androidDriver.findElementById("ru.yandex.mail:id/go_to_mail_button");
    }
    public void clickGoToMailButton() throws InterruptedException{goToMailButton().click();wait(3000);}


    public void CheckSendedEmail() throws InterruptedException{
        clickMenuButton();
        clickSentButton();
    }
    public void OpenSettings() throws InterruptedException{
        clickMenuButton();
        androidDriver.swipe(300,1700,300,100,500);
        clickSettingsButton();
    }
    public void LogOut() throws InterruptedException {
        androidDriver.swipe(300,1700,300,100,500);
        clickLogOutButton();
    }


    public void wait(int delay) throws InterruptedException {
        synchronized (androidDriver){
            androidDriver.wait(delay);
        }
    }
}
