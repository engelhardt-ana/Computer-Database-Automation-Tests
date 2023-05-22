import com.pageObjects.AddEditComputerPage;
import com.pageObjects.BaseTest;
import com.pageObjects.MainComputerPage;
import org.testng.annotations.Test;

/**
 * This test verifies after user click on Computer database title from Add and
 * Edit computer pages, user is redirected to the Main Page
 *
 * @author aengelhardt
 */
public class T016verifyUserRedirectsOnMainPageAfterClickingOnComputerDatabaseTitleTest extends BaseTest {

	@Test
	public void T016verifyUserRedirectsOnMainPageAfterClickingOnComputerDatabaseTitle() {

		MainComputerPage mainComputerPage = new MainComputerPage(this.driver);

		AddEditComputerPage addEditComputerPage = mainComputerPage.verifyComputerDataBaseTitle().addNewComputer();

		addEditComputerPage.verifyAddAComputerTitle().clickOnComputerDatabase();

		mainComputerPage.verifyNumberOfComputerFromHeader(574).editByComputerName("ACE");

		addEditComputerPage.verifyEditComputerTitle().clickOnComputerDatabase();

		mainComputerPage.verifyNumberOfComputerFromHeader(574);

	}

}