package by.htp.belavia;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import by.htp.belavia.steps.StepsOneWay;

public class OneWayTest {
	private StepsOneWay stepsOneWay;

	@BeforeMethod
	public void initStep(){
		 stepsOneWay=new StepsOneWay();
	}
	@Test
	public void Search() {
		stepsOneWay.startSearch();	
		
	}
}
