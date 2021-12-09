package Pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

public class SettingsPage {
    AndroidDriver androidDriver;

    public SettingsPage(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
    }
    public WebElement switchTheme(){return androidDriver.findElementByXPath("//android.widget.TextView(Theme)");}
    public void clickSwitchTheme()throws InterruptedException{switchTheme().click();wait(3000);}

    public WebElement backButton(){return androidDriver.findElementByAccessibilityId("Navigate up");}
    public void clickBackButton()throws InterruptedException{backButton().click();wait(3000);}

    public WebElement darkTheme(){return androidDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.TextView[2]");}
    public void clickDarkTheme() throws InterruptedException{darkTheme().click();wait(3000);}

    public WebElement lightTheme(){return androidDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.TextView[1]");}
    public void clickLightTheme() throws InterruptedException {lightTheme().click();wait(3000);}


    public void ChooseDarkTheme()throws InterruptedException{
        clickSwitchTheme();
        clickDarkTheme();
    }
    public void ChooseLightTheme()throws InterruptedException{
        clickSwitchTheme();
        clickLightTheme();
    }

    public void wait(int delay) throws InterruptedException {
        synchronized (androidDriver){
            androidDriver.wait(delay);
        }
    }
}
