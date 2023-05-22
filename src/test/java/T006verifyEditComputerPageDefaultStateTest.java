import org.testng.annotations.Test;

import com.pageObjects.AddEditComputerPage;
import com.pageObjects.BaseTest;
import com.pageObjects.MainComputerPage;

/**
 * This test verifies the default state of Computers Edit Computer Page
 *
 * @author aengelhardt
 */
public class T006verifyEditComputerPageDefaultStateTest extends BaseTest {

	@Test
	public void T006verifyEditComputerPageDefaultState() {

		String computerName = "ACE";

		MainComputerPage mainComputerPage = new MainComputerPage(this.driver);

		AddEditComputerPage editComputerPage = mainComputerPage.verifyComputerDataBaseTitle()
				.editByComputerName(computerName);

		editComputerPage.verifyEditComputerTitle().verifyStatusComputerNameInputVisible()
				.verifyStatusComputerNameInputEnabled().verifyStatusIntroducedInputVisible()
				.verifyStatusIntroducedInputEnabled().verifyStatusDiscontinuedInputVisible()
				.verifyStatusDiscontinuedInputEnabled().verifyStatusCompanyComboVisible()
				.verifyStatusCompanyComboEnabled().verifyStatusCreateThisComputerButtonVisible()
				.verifyStatusCreateThisComputerButtonEnabled().verifyStatusCancelButtonVisible()
				.verifyStatusCancelEnabled().verifyStatusDeleteANewComputerButtonVisible()
				.verifyStatusDeleteANewComputerButtonEnabled();

	}

}