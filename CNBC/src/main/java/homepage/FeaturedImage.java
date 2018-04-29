package homepage;

import base.CommonAPI;
import com.gargoylesoftware.htmlunit.javascript.host.URL;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FeaturedImage extends CommonAPI {

    //get the featured image on homepage
    @FindBy(how=How.CLASS_NAME, using="featured_top")
    WebElement featuredImg;
//    public void getFeaturedImg () throws IOException {
//        String imgSrc = featuredImg.getAttribute("src");
//        URL imageURL = new URL(imgSrc);
//        BufferedImage saveImage = ImageIO.read(imageURL);
//        ImageIO.write(saveImage, "png", new File("homepage-featured-image.png"));
//    }

}
