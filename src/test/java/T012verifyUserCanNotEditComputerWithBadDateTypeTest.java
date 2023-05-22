import com.pageObjects.AddEditComputerPage;
import com.pageObjects.BaseTest;
import com.pageObjects.MainComputerPage;
import org.testng.annotations.Test;

/**
 * This test verifies user can not edit computer with bad date: bad date format,
 * bad day of Month and bad Month
 *
 * @author aengelhardt
 */
public class T012verifyUserCanNotEditComputerWithBadDateTypeTest extends BaseTest {

	@Test
	public void T012verifyUserCanNotEditComputerWithBadDateType() {

		String name = "ACE";
		String badDay = "1999-04-32";
		String badMonth = "2023-13-04";
		String badFormat = "2023/05/22";

		MainComputerPage mainComputerPage = new MainComputerPage(this.driver);

		AddEditComputerPage editComputerPage = mainComputerPage.verifyComputerDataBaseTitle().editByComputerName(name);

		editComputerPage.verifyEditComputerTitle().setIntroduced(badMonth).setDiscontinued(badDay)
				.saveThisComputerAndStay().verifyEditComputerTitle()
				.verifyIntroducedErrorMessageInvalidValueForMonthOfYear(badMonth, "13")
				.verifyDiscontinuedErrorMessageInvalidValueForDayOfMonth(badDay, "32").clearIntroduced()
				.setIntroduced(badFormat).saveThisComputerAndStay()
				.verifyIntroducedErrorMessageFailedToDecodeDate(badFormat);

	}

}