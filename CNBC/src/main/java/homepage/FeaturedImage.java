package homepage;

import base.CommonAPI;
import com.gargoylesoftware.htmlunit.javascript.host.URL;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FeaturedImage extends CommonAPI {

    //get the featured image on homepage
//    @FindBy(how=How.XPATH, using="#featured_top > div > span > a > img")
//    @FindBy(how=How.XPATH, using=".//*[@id='featured_top']/div/span/a/img")
    @FindBy(how=How.CLASS_NAME, using="featured_top")
    WebElement featuredImg;
    public void getFeaturedImg () throws IOException, AWTException, InterruptedException {
        saveImage(featuredImg);
        takeScreenShot();
//        try {
//            String imgSrc = featuredImg.getAttribute("src");
//            System.out.println(imgSrc);
//            URL imageURL = new URL(imgSrc);
//            BufferedImage saveImage = ImageIO.read(imageURL);
//            ImageIO.write(saveImage, "png", new File("homepage-featured-image.png"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    public void saveImage(WebElement imageElement) throws IOException, InterruptedException, AWTException {
        //Right click on Image using contextClick() method.
        Actions action= new Actions(driver);
        action.contextClick(imageElement).build().perform();

        //To perform press Ctrl + v keyboard button action.
        action.sendKeys(Keys.CONTROL, "v").build().perform();

        Thread.sleep(3000);
        Robot robot = new Robot();
        // To press E key.
        robot.keyPress(KeyEvent.VK_E);
        // To press : key.
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_SEMICOLON);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        // To press \ key.
        robot.keyPress(KeyEvent.VK_BACK_SLASH);
        // To press "test" key one by one.
        robot.keyPress(KeyEvent.VK_T);
        robot.keyPress(KeyEvent.VK_E);
        robot.keyPress(KeyEvent.VK_S);
        robot.keyPress(KeyEvent.VK_T);
        // To press Save button.
        robot.keyPress(KeyEvent.VK_ENTER);
    }

}
