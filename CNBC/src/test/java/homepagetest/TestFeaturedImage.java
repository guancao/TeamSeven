package homepagetest;

import homepage.FeaturedImage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import sun.security.smartcardio.SunPCSC;

import java.awt.*;
import java.io.IOException;

public class TestFeaturedImage extends FeaturedImage {

    @Test
    public void testFeaturedImage() throws AWTException, InterruptedException, IOException {
        FeaturedImage fi = PageFactory.initElements(driver, FeaturedImage.class);
        fi.getFeaturedImg();
    }
}
