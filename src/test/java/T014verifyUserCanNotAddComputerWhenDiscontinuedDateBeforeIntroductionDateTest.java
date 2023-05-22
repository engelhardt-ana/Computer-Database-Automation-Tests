import com.pageObjects.AddEditComputerPage;
import com.pageObjects.BaseTest;
import com.pageObjects.MainComputerPage;
import org.testng.annotations.Test;

/**
 * This test verifies user can not add computer with bad date when discontinued
 * date is before introduction date
 *
 * @author aengelhardt
 */
public class T014verifyUserCanNotAddComputerWhenDiscontinuedDateBeforeIntroductionDateTest extends BaseTest {

	@Test
	public void T014verifyUserCanNotAddComputerWhenDiscontinuedDateBeforeIntroductionDate() {

		String newName = "Sony Vaio R";
		String introducedDate = "2023-04-10";
		String discontinuedDate = "2022-04-10";

		MainComputerPage mainComputerPage = new MainComputerPage(this.driver);

		AddEditComputerPage addComputerPage = mainComputerPage.verifyComputerDataBaseTitle().addNewComputer();

		addComputerPage.verifyAddAComputerTitle().setComputerName(newName).setIntroduced(introducedDate)
				.setDiscontinued(discontinuedDate).saveThisComputerAndStay().verifyAddAComputerTitle()
				.verifyDiscontinuedErrorMessageDiscontinuedDateBeforeIntroduction();

	}

}