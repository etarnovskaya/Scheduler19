import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WikiTest extends TestBase{

  @Test
  public  void  testAppOpened(){
    System.out.println("App opened");

  }

  @Test
  public void  searchWiki() throws InterruptedException {
    Thread.sleep(5000);
if(isElementPresent(By.id("fragment_onboarding_skip_button"))) {
  skipSplash();
}
    openSearchActivity();
    typeText(By.id("search_src_text"), "Appium");
Thread.sleep(5000);
    String articleTitle = getElementText(By.id("page_list_item_title"));

    Assert.assertTrue(articleTitle.toLowerCase().contains("appium"));
  }

}
