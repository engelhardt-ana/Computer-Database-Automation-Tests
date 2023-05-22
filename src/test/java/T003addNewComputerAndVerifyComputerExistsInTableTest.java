import java.util.Date;

import org.testng.annotations.Test;

import com.pageObjects.AddEditComputerPage;
import com.pageObjects.BaseTest;
import com.pageObjects.MainComputerPage;

/**
 * This test verifies after click on add a new computer button, user redirects
 * to Add new computer page, fill required fields, verifies new computer is
 * visible in the table
 *
 * @author aengelhardt
 */
public class T003addNewComputerAndVerifyComputerExistsInTableTest extends BaseTest {

	@Test
	public void T003addNewComputerAndVerifyComputerExistsInTable() {

		Date date = new Date();
		String newName = "Sony Vaio R";
		String companyName = "Sony";

		MainComputerPage mainComputerPage = new MainComputerPage(this.driver);

		AddEditComputerPage addComputerPage = mainComputerPage.verifyComputerDataBaseTitle()
				.verifyNumberOfComputerFromHeader(574).verifyNumberOfRowsInTable(10).addNewComputer();

		addComputerPage.setComputerName(newName).setIntroduced(date).chooseCompany(companyName).saveThisComputer();

		mainComputerPage.verifyComputerDataBaseTitle().verifyAlertComputerHasBeenAdded(newName)
				.verifyNumberOfComputerFromHeader(575).filterByComputerName(newName).verifyNumberOfRowsInTable(1)
				.verifyComputerNameByRow(newName, 1).verifyIntroducedByComputerName(date, newName)
				.verifyDiscontinuedEmptyByComputerName(newName).verifyCompanyByComputerName(companyName, newName);

	}

}