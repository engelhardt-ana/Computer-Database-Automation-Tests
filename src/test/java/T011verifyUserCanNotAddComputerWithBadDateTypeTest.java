import org.testng.annotations.Test;

import com.pageObjects.AddEditComputerPage;
import com.pageObjects.BaseTest;
import com.pageObjects.MainComputerPage;

/**
 * This test verifies user can not add computer with bad date: bad date format,
 * bad day of Month and bad Month
 *
 * @author aengelhardt
 */
public class T011verifyUserCanNotAddComputerWithBadDateTypeTest extends BaseTest {

	@Test
	public void T011verifyUserCanNotAddComputerWithBadDateType() {

		String newName = "Sony Vaio R";
		String badDay = "1999-04-32";
		String badMonth = "2023-13-04";
		String badFormat = "2023/05/22";

		MainComputerPage mainComputerPage = new MainComputerPage(this.driver);

		AddEditComputerPage addComputerPage = mainComputerPage.verifyComputerDataBaseTitle().addNewComputer();

		addComputerPage.verifyAddAComputerTitle().setComputerName(newName).setIntroduced(badMonth)
				.setDiscontinued(badDay).saveThisComputerAndStay().verifyAddAComputerTitle()
				.verifyIntroducedErrorMessageInvalidValueForMonthOfYear(badMonth, "13")
				.verifyDiscontinuedErrorMessageInvalidValueForDayOfMonth(badDay, "32").clearIntroduced()
				.setIntroduced(badFormat).saveThisComputerAndStay()
				.verifyIntroducedErrorMessageFailedToDecodeDate(badFormat);

	}

}