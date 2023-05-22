import org.testng.annotations.Test;

import com.pageObjects.AddEditComputerPage;
import com.pageObjects.BaseTest;
import com.pageObjects.MainComputerPage;

/**
 * This test verifies user can not add computer without any information and
 * company name empty field. After user confirms, there is an error message on
 * the right side of Company name field "Failed to refine type : Predicate
 * isEmpty() did not fail."
 *
 * @author aengelhardt
 */
public class T008verifyUserCanNotAddComputerWithoutComputerNameTest extends BaseTest {

	@Test
	public void T008verifyUserCanNotAddComputerWithoutComputerName() {

		MainComputerPage mainComputerPage = new MainComputerPage(this.driver);

		AddEditComputerPage addComputerPage = mainComputerPage.verifyComputerDataBaseTitle().addNewComputer();

		addComputerPage.verifyAddAComputerTitle().clearComputerName().saveThisComputerAndStay()
				.verifyComputerNameErrorMessageFailedToRefineType().verifyAddAComputerTitle();

	}

}