import org.testng.annotations.Test;

import com.pageObjects.BaseTest;
import com.pageObjects.MainComputerPage;

/**
 * This test verifies the default sorting is ascending by Company name, click on
 * Column Name to sort descending, verifies the values are sorted descending,
 * click on Company Name to sort ascending and verifies company name`s are
 * sorting ascending
 *
 * @author aengelhardt
 */
public class T017verifyCompanyNameSortingColumnTest extends BaseTest {

	@Test
	public void T017verifyCompanyNameSortingColumn() {

		MainComputerPage mainComputerPage = new MainComputerPage(this.driver);

		mainComputerPage.verifyComputerDataBaseTitle().verifyNumberOfComputerFromHeader(574)
				.verifyComputerNameByRow("ACE", 1).verifyComputerNameByRow("AN/FSQ-32", 2)
				.verifyComputerNameByRow("AN/FSQ-7", 3).sortComputerNameColumn()
				.verifyComputerNameByRow("lenovo thinkpad z61p", 1).verifyComputerNameByRow("lenovo thinkpad x61s", 2)
				.verifyComputerNameByRow("lenovo thinkpad x60s", 3).sortComputerNameColumn()
				.verifyComputerNameByRow("ACE", 1).verifyComputerNameByRow("AN/FSQ-32", 2)
				.verifyComputerNameByRow("AN/FSQ-7", 3);

	}

}