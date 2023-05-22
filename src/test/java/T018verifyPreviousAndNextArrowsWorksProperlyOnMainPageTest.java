import com.pageObjects.BaseTest;
import com.pageObjects.MainComputerPage;
import org.testng.annotations.Test;

/**
 * This test verifies values in the pagination and values on the page are
 * changing when user click on previous and next arrows
 *
 * @author aengelhardt
 */
public class T018verifyPreviousAndNextArrowsWorksProperlyOnMainPageTest extends BaseTest {

	@Test
	public void T018verifyPreviousAndNextArrowsWorksProperlyOnMainPage() {

		MainComputerPage mainComputerPage = new MainComputerPage(this.driver);

		mainComputerPage.verifyComputerDataBaseTitle().verifyNumberOfComputerFromHeader(574)
				.verifyComputerNameByRow("ACE", 1).verifyPaginationInformation(1, 10, 574).verifyNextArrowVisible()
				.verifyPreviousArrowVisible().verifyNextArrowVisible().verifyNumberOfRowsInTable(574)
				.verifyComputerNameByRow("ASCI White", 1).verifyPaginationInformation(11, 20, 574)
				.verifyPreviousArrowVisible().verifyPaginationInformation(1, 10, 574).verifyComputerNameByRow("ACE", 1);

	}

}