package homepagetest;

import homepage.FeaturedImage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

public class TestFeaturedImage extends FeaturedImage {

    @Test
    public void testFeaturedImage() throws InterruptedException, IOException, AWTException {
        FeaturedImage fi = PageFactory.initElements(driver, FeaturedImage.class);
        fi.getFeaturedImg();
    }
}
