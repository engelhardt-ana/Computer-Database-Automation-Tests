import java.util.Date;

import org.testng.annotations.Test;

import com.pageObjects.AddEditComputerPage;
import com.pageObjects.BaseTest;
import com.pageObjects.MainComputerPage;

/**
 * This test verifies after user fill in fields in Edit computer dialog and
 * clicks cancel, the new information does not apply and not visible in the
 * table
 *
 * @author aengelhardt
 */
public class T010verifyAfterCancelInEditComputerDidNotApplyTest extends BaseTest {

	@Test
	public void T010verifyAfterCancelInEditComputerDidNotApply() {

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
				.chooseCompany(companyName).cancel();

		mainComputerPage.verifyComputerDataBaseTitle().verifyComputerNameByRow(oldName, 1)
				.verifyIntroducedEmptyByComputerName(oldName).verifyDiscontinuedEmptyByComputerName(oldName)
				.verifyCompanyByComputerName("-", oldName);

	}

}