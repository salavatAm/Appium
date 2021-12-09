import Pages.LoginPage;
import Pages.ProfilePage;
import Pages.SettingsPage;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class MainTest {
    private AndroidDriver driver;
    LoginPage loginPage;
    ProfilePage profilePage;
    SettingsPage settingsPage;
    @BeforeMethod
    public void setUp() throws MalformedURLException {
        Inspector inspector = new Inspector("/Users/salavatamingaliev/Documents/5semestr/TEST/AndroidYandexTest/apkpure.com.apk","ru.yandex.mail", "ru.yandex.mail.ui.LoginActivity" );
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),inspector.capabilities);
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        settingsPage = new SettingsPage(driver);
    }
    @Test
    public void Test() throws InterruptedException {
         wait(3000);
         //выбор способа входа
         loginPage.ChooseYandexLogin();
         //ввод логина
         loginPage.inputLogin("salavatamingaliev");
         //ввод пароля
         loginPage.inputPassword("220300sa");
         //        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //просмотр отправленных сообщений
        profilePage.CheckSendedEmail();
        //открытие ноастроек
        profilePage.OpenSettings();
        //выбор темы
        settingsPage.ChooseDarkTheme();
        settingsPage.ChooseLightTheme();
        //выход в боковое меню
        settingsPage.clickBackButton();
        //выход из аккаунта
        profilePage.LogOut();
    }

    public void wait(int delay) throws InterruptedException {
        synchronized (driver){
            driver.wait(delay);
        }
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
