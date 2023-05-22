import java.util.Date;

import org.testng.annotations.Test;

import com.pageObjects.AddEditComputerPage;
import com.pageObjects.BaseTest;
import com.pageObjects.MainComputerPage;

/**
 * This test verifies editing the existing Ace computer to Ace1 with new
 * introduction date and company, click on save this computer and verify new
 * data is successfully saved in the table
 *
 * @author aengelhardt
 */
public class T002editExistingAceComputerTest extends BaseTest {

	@Test
	public void T002editExistingAceComputer() {

		Date date = new Date();
		String oldName = "ACE";
		String newName = "Ace1";
		String companyName = "Apple Inc.";

		MainComputerPage mainComputerPage = new MainComputerPage(this.driver);

		AddEditComputerPage editComputerPage = mainComputerPage.verifyComputerDataBaseTitle()
				.verifyComputerNameByRow(oldName, 1).verifyIntroducedEmptyByComputerName(oldName)
				.verifyDiscontinuedEmptyByComputerName(oldName).verifyCompanyByComputerName("-", oldName)
				.editByComputerName(oldName);

		editComputerPage.verifyComputerName(oldName).clearComputerName().setComputerName(newName).setIntroduced(date)
				.chooseCompany(companyName).saveThisComputer();

		mainComputerPage.verifyComputerDataBaseTitle().verifyAlertComputerHasBeenUpdated(newName)
				.verifyComputerNameByRow(newName, 1).verifyIntroducedByComputerName(date, newName)
				.verifyDiscontinuedEmptyByComputerName(newName).verifyCompanyByComputerName(companyName, newName);

	}

}