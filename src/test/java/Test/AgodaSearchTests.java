package Test;

import Pages.AgodaMainPage;
import Pages.AgodaSearchResultPage;
import driver.DriverFactory;


public class AgodaSearchTests {

    private AgodaMainPage mainPage;
    private AgodaSearchResultPage searchResultPage;

    @BeforeEach
    public void setup() {
        DriverFactory.setupDriver();
        mainPage = new AgodaMainPage();
        searchResultPage = new AgodaSearchResultPage();
    }

    @Test
    public void AWTC004_FilterTest() {
        mainPage.navigateToAgoda();
        mainPage.performSearch("Antalya");

        searchResultPage.selectDates("1 Temmuz", "6 Temmuz");
        searchResultPage.selectGuestCount(2, 1, 6);

        // 7. Search butonuna tıklanır. (AWTC 005-7)
        searchResultPage.clickSearchSubmit();

        // BEKLENEN SONUÇ: FiltreleButtonlip search butonuna tıklandıktan sonra uygun oteller gözükmeli.
        assertTrue(searchResultPage.areHotelsDisplayed(), "Arama sonuçları gözükmüyor.");
    }

    @AfterEach
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
