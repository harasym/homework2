package academy.softserve.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import academy.softserve.pages.GoogleImagesSearchResultPage;
import academy.softserve.pages.GooglePropertiesPage;
import academy.softserve.pages.GoogleSearchPage;
import academy.softserve.pages.SearchResultPage;
import academy.softserve.utils.PageJSExecutor;
import academy.softserve.utils.ScreenshotMaker;

public class GoogleSearchTest extends TestRunner {

    private static final String FUNNY_KITTEN_PICTURE = "funny kitten picture";
    private static final String FUNNY_PICTURE = "funny picture";
    GoogleSearchPage searchPage;
    SearchResultPage searchResultpage;
    GooglePropertiesPage propPage;

    @BeforeMethod
    public void turnOffGoogleLiveSearch() throws InterruptedException {
        propPage = new GooglePropertiesPage(driver);
        propPage.openPage();
        propPage.getCheckBox().click();
        PageJSExecutor.scrollPage(0, 800, driver);
        propPage.getSaveButton().click();
    }

    @Test(priority = 0)
    public void test_Google_Page() {
        searchPage = new GoogleSearchPage(driver);
        Assert.assertTrue(searchPage.getLogo().isDisplayed());
        ScreenshotMaker.takeIt(driver);
    }

    @Test
    public void test_search_funny_images_links() throws InterruptedException {
        searchPage = new GoogleSearchPage(driver);
        SearchResultPage searchResultpage = searchPage.googleSearch(FUNNY_PICTURE); //
        searchResultpage.getImagesResults();
        Thread.sleep(2000);
        Assert.assertTrue(searchResultpage.getAllResults().get(0).getText().toLowerCase().contains(FUNNY_PICTURE));
    }

    @Test
    public void test_all_result_search_page() throws InterruptedException {
        searchPage = new GoogleSearchPage(driver);
        SearchResultPage searchResultpage = searchPage.googleSearch(FUNNY_PICTURE); //
        searchResultpage.getImagesResults();
        Thread.sleep(2000);
        Assert.assertTrue(searchResultpage.getAllResults().get(0).getText().toLowerCase().contains(FUNNY_PICTURE));
    }

    @Test
    public void test_images_result_page_searh() {
        searchPage = new GoogleSearchPage(driver);
        SearchResultPage searchResultpage = searchPage.googleSearch(FUNNY_PICTURE);
        GoogleImagesSearchResultPage imagesPage = searchResultpage.getImagesResults();
        Assert.assertTrue(imagesPage.getParticularResults(0, 5).get(0).isDisplayed());
        Assert.assertTrue(imagesPage.getParticularResults(0, 5).get(1).isDisplayed());
        Assert.assertTrue(imagesPage.getParticularResults(0, 5).get(2).isDisplayed());
        Assert.assertTrue(imagesPage.getParticularResults(0, 5).get(3).isDisplayed());
        Assert.assertTrue(imagesPage.getParticularResults(0, 5).get(4).isDisplayed());

    }

    @Test
    public void test_Logo_hiding() {
        searchPage = new GoogleSearchPage(driver);
        Assert.assertTrue(searchPage.getLogo().isDisplayed());
        PageJSExecutor.hideObjects(searchPage.getLogo(), driver);
        Assert.assertFalse(searchPage.getLogo().isDisplayed());
    }

    @Test
    public void test_change_link_color() {
        searchPage = new GoogleSearchPage(driver);
        SearchResultPage searchResultpage = searchPage.googleSearch(FUNNY_KITTEN_PICTURE);
        Assert.assertTrue(
                searchResultpage.getAllResults().get(0).getText().toLowerCase().contains(FUNNY_KITTEN_PICTURE));
        PageJSExecutor.changeObjectColor(searchResultpage.getAllResults().get(0), driver, "green");
        Assert.assertEquals(searchResultpage.getAllResults().get(0).getCssValue("color"), "rgba(0, 128, 0, 1)");
    }

}
