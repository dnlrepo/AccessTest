import org.testng.annotations.Test;
import testSite.pages.CountryPage.CountryPage;
import testSite.pages.Home.HomePage;
import testSite.pages.MainPage.Countries;

public class MainFlow extends BaseTestClass {

    HomePage home = HomePage.getHomePage();
    Countries countries = Countries.getMainPage();
    CountryPage cPage = CountryPage.getCountryPage();

    @Test
    public void testMethod() {
       home.goToCountries();
       countries.searchBarCheck();
       countries.checkBoxCheck();
       countries.singleCountryCheck();
       cPage.setStatus();
       home.assertFinalResults();
    }

}

