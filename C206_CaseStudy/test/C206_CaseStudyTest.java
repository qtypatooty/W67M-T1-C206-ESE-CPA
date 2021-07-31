import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	
	// career
	private career career1;
	private career career2;
	
	private ArrayList<career> careerList;
	
	public C206_CaseStudyTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		
		//career
		career1 = new career(1, "Architecture and engineering",
				"Design new structures/create aesthetically pleasing and structurally sound environments",
				"Architect, Civil engineer, Landscape architect");
		career2 = new career(2, "Arts, culture and entertainment",
				"Enriching lives through culture and sharing of arts and self-expression",
				"Singer/songwriter, Music producer, Fashion designer");
		
		careerList = new ArrayList<career>();
		
		
	}
	
	@Test
	public void testRetrieveAllCareer() {
		
		assertNotNull("test if the carrer arraylist is valid to add to", careerList);

		String allCareer = CPA_Main.retrieveAllCareer(careerList);
		String testOutput = "";
		assertEquals("test the ViewAllCareer", testOutput, allCareer);

		CPA_Main.addCareer(careerList, career1);
		CPA_Main.addCareer(careerList, career2);
		assertEquals("test if size of carrerList is 2 when two item is added", 2, careerList.size());

	}
	
	@Test
	public void testAddCareer() {
		
		assertNotNull("test if the career arraylist is valid to add to", careerList);

		CPA_Main.addCareer(careerList, career1);
		assertEquals("test if the career arraylist size is 1 when one item is added", 1, careerList.size());

		assertSame("test that carrer just added id same as 1st item of the list", career1, careerList.get(0));

		CPA_Main.addCareer(careerList, career2);
		assertEquals("test if the career arraylist size is 2 when another item is added", 2, careerList.size());
		
		assertSame("test if the new added item is same as the 2nd item of the list", career2, careerList.get(1));
		
	}
	
	@Test
	public void testDeleteCareer() {
		
		assertNotNull("test if the career arraylust is valid", careerList);
		
		CPA_Main.addCareer(careerList, career1);
		assertEquals("test that the inital size of the list is 1", 1, careerList.size());
		
		int id1 = 1;
		CPA_Main.deleteCareer(careerList, id1);
		assertEquals("test if the id input is same as the id of item",id1, career1.getCareer_id());
		
		assertEquals("test if the size of the list is 0 after one item being deleted", 0, careerList.size());
		
	}
	
	
	
	
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}

}
