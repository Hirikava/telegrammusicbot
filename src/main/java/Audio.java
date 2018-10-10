import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class Audio {

    private static WebDriver driver;
    private String path = "src/main/resources/audioFiles";
    private String name;

    public Audio(String link) {
        browserSetup();
        download(link);
    }

    private void browserSetup(){
        System.setProperty("webdriver.chrome.driver", "/home/artem/IdeaProjects/Bot/telegrammusicbot/src/main/resources/drivers/chromedriver");
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", path);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        cap.setCapability(ChromeOptions.CAPABILITY, options);
        driver = new ChromeDriver(cap);
    }

    private void download(String link) {
        String downloadPage = "https://tomp3.pro/" + link.replaceAll("(:/+|\\.|/|\\?|=)","-");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(downloadPage);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        WebElement button = driver.findElement(By.cssSelector("li.v-dl-mp3"));
        button.click();
        WebElement dynamicElement = (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[class$='ready']")));
        WebElement downloadButton = driver.findElement(By.cssSelector("li.media-parent"));
        downloadButton.click();
        File papka = new File(path+"/newpapaka");
        papka.mkdir();
        FindAudio();
        while (isDownloading(name));
        driver.quit();
    }

    //Проверка загружен ли файл
    private boolean isDownloading(String file) {
        File folder = new File(path);
        File[] audiofiles = folder.listFiles();
        while(!Arrays.asList(audiofiles).contains(file)) {
            audiofiles = folder.listFiles();
        }
        return true;
    }

    private void FindAudio() {
        File folder = new File(path);
        String downloadFile = null;
        File[] audiofiles = folder.listFiles();
        while (downloadFile == null){
            audiofiles = folder.listFiles();
            for (File audio: audiofiles) {
                if (audio.getName().endsWith("crdownload")) {
                    downloadFile = audio.getName();
                    break;
                }
            }
        }
        name = downloadFile.substring(0, downloadFile.length()-10);
    }

    public String getPath() {
        return path;
    }

    public String getName() {
        return name;
    }
}
