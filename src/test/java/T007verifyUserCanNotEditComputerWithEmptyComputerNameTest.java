import com.pageObjects.AddEditComputerPage;
import com.pageObjects.BaseTest;
import com.pageObjects.MainComputerPage;
import org.testng.annotations.Test;

/**
 * This test verifies user can not edit computer name to empty string. After
 * user clears computer name and confirms, there is an error message on the
 * right side of Company name field "Failed to refine type : Predicate isEmpty()
 * did not fail."
 *
 * @author aengelhardt
 */
public class T007verifyUserCanNotEditComputerWithEmptyComputerNameTest extends BaseTest {

	@Test
	public void T007verifyUserCanNotEditComputerWithEmptyComputerName() {

		String computerName = "ACE";

		MainComputerPage mainComputerPage = new MainComputerPage(this.driver);

		AddEditComputerPage editComputerPage = mainComputerPage.verifyComputerDataBaseTitle()
				.editByComputerName(computerName);

		editComputerPage.verifyEditComputerTitle().clearComputerName().saveThisComputerAndStay()
				.verifyComputerNameErrorMessageFailedToRefineType().verifyEditComputerTitle();

	}

}