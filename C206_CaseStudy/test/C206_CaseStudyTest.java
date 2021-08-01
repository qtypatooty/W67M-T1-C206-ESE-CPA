import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {

	// career
	private career career1;
	private career career2;

	private ArrayList<career> careerList;

	// subject
	private subject subject1;
	private subject subject2;

	private ArrayList<subject> subjectlist;

	public C206_CaseStudyTest() {
		super();
	}
	
	private ArrayList<prerequisites> prerequisitesList;

	@Before
	public void setUp() throws Exception {

		// career
		career1 = new career(1, "Architecture and engineering",
				"Design new structures/create aesthetically pleasing and structurally sound environments",
				"Architect, Civil engineer, Landscape architect");
		career2 = new career(2, "Arts, culture and entertainment",
				"Enriching lives through culture and sharing of arts and self-expression",
				"Singer/songwriter, Music producer, Fashion designer");

		careerList = new ArrayList<career>();

		// subject
		subject1 = new subject(1, "English", "Compulsory");
		subject2 = new subject(2, "Mathematics", "Compulsory");
		subjectlist = new ArrayList<subject>();

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
		assertEquals("test if the id input is same as the id of item", id1, career1.getCareer_id());

		assertEquals("test if the size of the list is 0 after one item being deleted", 0, careerList.size());

	}

	@Test
	public void testViewSubjects() {

		assertNotNull("test if the subject arraylist is valid to add to", subjectlist);
		int subjectid = 1;
		String allSubjects = CPA_Main.getSubject(subjectlist, subjectid);
		String testOutput = "";
		assertEquals("test View Subjects", testOutput, allSubjects);

		CPA_Main.addSubject(subjectlist, subject1);
		CPA_Main.addSubject(subjectlist, subject2);
		assertEquals("test if size of subjectlist is 2 when two items are added", 2, subjectlist.size());

	}

	@Test
	public void testAddSubjects() {

		assertNotNull("test if the subject arraylist is valid to add to", subjectlist);

		CPA_Main.addSubject(subjectlist, subject1);
		assertEquals("test if the subject arraylist size is 1 when one subject is added", 1, subjectlist.size());

		assertSame("test that subject just added is the same as 1st item in the list", subject1, subjectlist.get(0));

		CPA_Main.addSubject(subjectlist, subject2);
		assertEquals("test if the subject arraylist size is 2 when another subject is added", 2, subjectlist.size());

		assertSame("test if the newly added subject is same as the 2nd item in the list", subject2, subjectlist.get(1));
	}

	@Test
	public void testDeleteSubject() {

		assertNotNull("test if the subject arraylist is valid", subjectlist);

		CPA_Main.addSubject(subjectlist, subject1);
		assertEquals("test that the starting size of the list is 1", 1, subjectlist.size());

		int subjectid1 = 1;
		CPA_Main.removeSubject(subjectlist, subjectid1);
		assertEquals("test if the id input is same as the subject's id", subjectid1, subject1.getSubjectId());

		assertEquals("test if the size of the list is 0 after it is deleted", 0, subjectlist.size());

	}

	@After
	public void tearDown() throws Exception {
		
		//career
		career1 = null;
		career2 = null;
		careerList = null;
		
	}
	
	
	@Test
	public void testviewprerequisites() {
		assertNotNull("test if arraylist is empty", prerequisitesList);
	
		assertEquals("test if arraylist is the same", CPA_Main.viewPrerequisites(prerequisitesList), prerequisitesList);
	
		CPA_Main.addPrerequisites(prerequisitesList, 1, 10, "IT", "Basic Programming", "Advanced programming");
		
		assertEquals("test if array size is updated", 1, prerequisitesList.size());
	}
	
	@Test
	public void testAddPrerequisites() {

		CPA_Main.addPrerequisites(prerequisitesList, 1, 10, "Design", "Adobe", "Design XD");
		assertEquals("test if size increase after adding", 1, prerequisitesList.size());

		assertEquals("test if arraylist is the same", CPA_Main.viewPrerequisites(prerequisitesList), prerequisitesList);

		
	}
	
	@Test
	public void testDeletePrerequisite() {

		CPA_Main.addPrerequisites(prerequisitesList, 1, 10, "Design", "Adobe", "Design XD");
		assertEquals("test if after adding the list is 1", 1, subjectlist.size());

		int idpre = 1;
		CPA_Main.deletePrerequisite(prerequisitesList, idpre);
		assertEquals("test if arraylist goes back to 0 after deletion", 0, subjectlist.size());

	}
	

	@Test
	public void c206_test() {
		// fail("Not yet implemented");
		assertTrue("C206_CaseStudy_SampleTest ", true);
	}

}
