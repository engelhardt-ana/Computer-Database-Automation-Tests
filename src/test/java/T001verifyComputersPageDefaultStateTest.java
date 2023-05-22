import org.testng.annotations.Test;

import com.pageObjects.BaseTest;
import com.pageObjects.MainComputerPage;

/**
 * This test verifies the default state of Computers Main page
 * 
 * @author aengelhardt
 */
public class T001verifyComputersPageDefaultStateTest extends BaseTest {

	@Test
	public void T001verifyComputersPageDefaultState() {

		MainComputerPage mainComputerPage = new MainComputerPage(this.driver);

		mainComputerPage.verifyComputerDataBaseTitle().verifyNumberOfComputerFromHeader(574)
				.verifyStatusSearchboxVisible().verifyStatusSearchboxEnabled().verifyStatusFilterByNameVisible()
				.verifyStatusFilterByNameEnabled().verifyStatusAddANewComputerButtonVisible()
				.verifyStatusAddANewComputerButtonEnabled().verifyComputerNameColumn().verifyIntroducedColumn()
				.verifyDiscontinuedColumn().verifyCompanyColumn().verifyNumberOfRowsInTable(10)
				.verifyPaginationInformation(1, 10, 574).verifyNextArrowVisible().verifyPreviousArrowVisible();

	}

}