import org.testng.annotations.Test;

import com.pageObjects.AddEditComputerPage;
import com.pageObjects.BaseTest;
import com.pageObjects.MainComputerPage;

/**
 * This test verifies after user click on existing computer, edit page is opened
 * and after delete the existing computer is no longer visible in the table
 *
 * @author aengelhardt
 */
public class T004deleteExistingComputerFromTheTableTest extends BaseTest {

	@Test
	public void T004deleteExistingComputerFromTheTable() {

		String computerName = "ACE";

		MainComputerPage mainComputerPage = new MainComputerPage(this.driver);

		AddEditComputerPage editComputerPage = mainComputerPage.verifyComputerDataBaseTitle()
				.verifyComputerNameByRow(computerName, 1).editByComputerName(computerName);

		editComputerPage.verifyStatusDeleteANewComputerButtonVisible().verifyStatusDeleteANewComputerButtonEnabled()
				.deleteThisComputer();

		mainComputerPage.verifyComputerDataBaseTitle().verifyAlertComputerHasBeenDeleted(computerName)
				.filterByComputerName(computerName).verifyNoComputerTitle().verifyNothingToDisplayMessage()
				.verifyNumberOfRowsInTable(0);

	}

}