import org.testng.annotations.Test;

import com.pageObjects.AddEditComputerPage;
import com.pageObjects.BaseTest;
import com.pageObjects.MainComputerPage;

/**
 * This test verifies the default state of Computers Add Computer Page
 *
 * @author aengelhardt
 */
public class T005verifyAddNewComputerPageDefaultStateTest extends BaseTest {

	@Test
	public void T005verifyAddNewComputerPageDefaultState() {

		MainComputerPage mainComputerPage = new MainComputerPage(this.driver);

		AddEditComputerPage addComputerPage = mainComputerPage.verifyComputerDataBaseTitle()
				.verifyNumberOfComputerFromHeader(574).verifyNumberOfRowsInTable(10).addNewComputer();

		addComputerPage.verifyAddAComputerTitle().verifyStatusComputerNameInputVisible()
				.verifyStatusComputerNameInputEnabled().verifyStatusIntroducedInputVisible()
				.verifyStatusIntroducedInputEnabled().verifyStatusDiscontinuedInputVisible()
				.verifyStatusDiscontinuedInputEnabled().verifyStatusCompanyComboVisible()
				.verifyStatusCompanyComboEnabled().verifyStatusCreateThisComputerButtonVisible()
				.verifyStatusCreateThisComputerButtonEnabled().verifyStatusCancelButtonVisible()
				.verifyStatusCancelEnabled();

	}

}