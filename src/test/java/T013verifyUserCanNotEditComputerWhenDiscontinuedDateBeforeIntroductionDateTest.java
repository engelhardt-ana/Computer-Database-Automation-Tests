import com.pageObjects.AddEditComputerPage;
import com.pageObjects.BaseTest;
import com.pageObjects.MainComputerPage;
import org.testng.annotations.Test;

/**
 * This test verifies user can not edit computer with bad date when discontinued
 * date is before introduction date
 *
 * @author aengelhardt
 */
public class T013verifyUserCanNotEditComputerWhenDiscontinuedDateBeforeIntroductionDateTest extends BaseTest {

	@Test
	public void T013verifyUserCanNotEditComputerWhenDiscontinuedDateBeforeIntroductionDate() {

		String name = "ACE";
		String introducedDate = "2023-04-10";
		String discontinuedDate = "2022-04-10";

		MainComputerPage mainComputerPage = new MainComputerPage(this.driver);

		AddEditComputerPage editComputerPage = mainComputerPage.verifyComputerDataBaseTitle().editByComputerName(name);

		editComputerPage.verifyEditComputerTitle().setIntroduced(introducedDate).setDiscontinued(discontinuedDate)
				.saveThisComputerAndStay().verifyEditComputerTitle()
				.verifyDiscontinuedErrorMessageDiscontinuedDateBeforeIntroduction();

	}

}