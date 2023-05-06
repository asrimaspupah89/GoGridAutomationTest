package StepDefinitions;

import Driver.Driver;
import io.cucumber.java.After;

public class afterSteps {
		@After
		public void close_window() {

//			Driver.getInstance().close();
			Driver.deleteInstance();
		}
	
}