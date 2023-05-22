import java.util.Date;

import org.testng.annotations.Test;

import com.pageObjects.AddEditComputerPage;
import com.pageObjects.BaseTest;
import com.pageObjects.MainComputerPage;

/**
 * This test verifies after user fill in fields in Add new computer dialog and
 * clicks cancel, the new information does not apply and not visible in the
 * table
 *
 * @author aengelhardt
 */
public class T009verifyAfterCancelInAddNewComputerDidNotApplyTest extends BaseTest {

	@Test
	public void T009verifyAfterCancelInAddNewComputerDidNotApply() {

		Date date = new Date();
		String newName = "Sony Vaio R";
		String companyName = "Sony";

		MainComputerPage mainComputerPage = new MainComputerPage(this.driver);

		AddEditComputerPage addComputerPage = mainComputerPage.verifyComputerDataBaseTitle()
				.verifyNumberOfComputerFromHeader(574).verifyNumberOfRowsInTable(10).addNewComputer();

		addComputerPage.setComputerName(newName).setIntroduced(date).chooseCompany(companyName).cancel();

		mainComputerPage.verifyComputerDataBaseTitle().verifyNumberOfComputerFromHeader(574)
				.filterByComputerName(newName).verifyNoComputerTitle().verifyNothingToDisplayMessage()
				.verifyNumberOfRowsInTable(0);

	}

}