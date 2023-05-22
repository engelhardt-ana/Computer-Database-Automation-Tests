import org.testng.annotations.Test;

import com.pageObjects.BaseTest;
import com.pageObjects.MainComputerPage;

/**
 * This test verifies there is no results when user search by date or company
 * name, when user fill in search with existing name and click Filter By Name
 * button, the results displayed in the table
 *
 * @author aengelhardt
 */
public class T015verifyFilterByNameSearchesComputersByComputerNameTest extends BaseTest {

	@Test
	public void T015verifyFilterByNameSearchesComputersByComputerName() {

		String sonyComputer = "Sony";
		String companyName = "Apple Inc.";
		String date = "01 Jan 1960";

		MainComputerPage mainComputerPage = new MainComputerPage(this.driver);

		mainComputerPage.verifyComputerDataBaseTitle().verifyNumberOfComputerFromHeader(574)
				.verifyNumberOfRowsInTable(10).filterByComputerName(companyName).verifyNothingToDisplayMessage()
				.verifyNoComputerTitle().clearFilterByComputerName().filterByComputerName(sonyComputer)
				.verifyNumberOfComputerFromHeader(8).verifyNumberOfRowsInTable(8).clearFilterByComputerName()
				.filterByComputerName(date).verifyNothingToDisplayMessage().verifyNoComputerTitle();

	}

}