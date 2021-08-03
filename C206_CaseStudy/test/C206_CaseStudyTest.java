import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	// account user
	private user user1;
	private user user2;
	private user user3;
	private user user4;
	private user user5;
	private user user6;

	private ArrayList<user> userList;

	// career
	private career career1;
	private career career2;

	private ArrayList<career> careerList;

	// subject
	private subject subject1;
	private subject subject2;

	private ArrayList<subject> subjectlist;

	private prerequisites prereq1;
	private prerequisites prereq2;

	private ArrayList<prerequisites> prereqList;

	public C206_CaseStudyTest() {
		super();
	}

	private ArrayList<prerequisites> prerequisitesList;

	@Before
	public void setUp() throws Exception {
		// user
		user1 = new user(1, "", "Student", "test1@email.com", "password1"); // user with empty name;
		user2 = new user(2, "Name2", "", "test1@email.com", "password1"); // user with empty role;
		user3 = new user(3, "Name3", "Staff", "", "password1"); // user with empty email;
		user4 = new user(4, "Name4", "Student", "test4@email.com", ""); // user with empty password;
		user5 = new user(5, "Name5", "Student", "test5@email.com", "password5"); // user that has all information
																					// filled;
		user6 = new user(6, "Name6", "Student", "test6@email.com", "password6"); // user that has all information
																					// filled;

		userList = new ArrayList<user>();

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

		prereq1 = new prerequisites(1, 10, "Design", "Adobe", "Design XD");
		prereq2 = new prerequisites(2, 100, "JavaScript", "Programming", "Coding Java");
		prerequisitesList = new ArrayList<prerequisites>();

	}

	@Test
	public void testAddUser() {
		assertNotNull("Test that user list is not null, so that a new item can be added to.", userList);

		CPA_Main.addAccount(userList, user1);
		assertEquals("Test that user list equals to 0 as user 1 did not fill up all required filed", 0,
				userList.size());

		CPA_Main.addAccount(userList, user2);
		assertEquals("Test that user list equals to 0 as user 2 did not fill up all required filed", 0,
				userList.size());

		CPA_Main.addAccount(userList, user3);
		assertEquals("Test that user list equals to 0 as user 3 did not fill up all required filed", 0,
				userList.size());

		CPA_Main.addAccount(userList, user4);
		assertEquals("Test that user list equals to 0 as user 4 did not fill up all required filed", 0,
				userList.size());

		CPA_Main.addAccount(userList, user5);
		assertEquals("Test that user list equals to 1 as user 5 fill up all required filed,thus is added successfully",
				1, userList.size());
		assertSame(user5, userList.get(0));
		// Test that the user just added is as same as the 1st item of the list.

	}

	@Test
	public void testShowUserList() {
		assertNotNull("Test that user list is not null, so that a new item can be added to.", userList);
		String accountList = CPA_Main.showAccount(userList);// currently empty
		String output = "No record of user account found!";// output will be empty
		assertEquals("Test that there is nothing in the user list when print", output, accountList);

		CPA_Main.addAccount(userList, user5);
		CPA_Main.addAccount(userList, user6);
		// 2 valid user are added to the user list.
		String accountList2 = CPA_Main.showAccount(userList);
		String output2 = String.format("%-5s %-10s %-10s %-10s %-10s\n", "ID", "NAME", "ROLE", "EMAIL", "PASSWORD");
		output2 += String.format("%-5d %-10s %-10s %-10s %-10s\n", userList.get(0).getUserid(),
				userList.get(0).getName(), userList.get(0).getRole(), userList.get(0).getemail(),
				userList.get(0).getPassword());
		output2 += String.format("%-5d %-10s %-10s %-10s %-10s\n", userList.get(1).getUserid(),
				userList.get(1).getName(), userList.get(1).getRole(), userList.get(1).getemail(),
				userList.get(1).getPassword());
		assertEquals("Test that the user list are printed correctly with the added users", output2, accountList2);

	}

	@Test
	public void testDeleteUser() {

		CPA_Main.addAccount(userList, user5);
		CPA_Main.addAccount(userList, user6);
		assertNotNull("Test that user list is not null, so that a new item can be delete to.", userList);
		assertEquals("test that the size of the list is 2", 2, userList.size());

		CPA_Main.deleteAccount(userList, 0);
		assertEquals("test that the size of the list is 2 as an invalid id is entered", 2, userList.size());

		CPA_Main.deleteAccount(userList, 5);
		assertEquals("test that the size of the list is 1 after delete one item", 1, userList.size());
		assertSame(user6, userList.get(0));
		// test that after user 5 is deleted the only user left is user 6.

		CPA_Main.deleteAccount(userList, 6);
		assertEquals("test that the size of the list is 0 after delete both user added to the list", 0,
				userList.size());

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
	public void testShowAllCareer() {

		assertNotNull("test if the carrer arraylist is valid to add to", careerList);

		String showCareerEmpty = CPA_Main.showAllCareer(careerList); // currently empty
		String outputEmpty = "No record found"; // output for empty file
		assertEquals("test that the ouput is shown correctly when there is no record in the arraylist", outputEmpty,
				showCareerEmpty);

		CPA_Main.addCareer(careerList, career1);
		CPA_Main.addCareer(careerList, career2);
		// 2 valid user are added to the user list.
		String showCareerList = CPA_Main.showAllCareer(careerList);
		String output = String.format("%-10s %-35s %-100s %-20s \n", "ID", "NAME", "INFORAMTION", "RELAVENT JOB");
		output += String.format("%-10d %-35s %-100s %-20s \n", careerList.get(0).getCareer_id(),
				careerList.get(0).getCareer_name(), careerList.get(0).getCareer_info(),
				careerList.get(0).getCareer_jobs());
		output += String.format("%-10d %-35s %-100s %-20s \n", careerList.get(1).getCareer_id(),
				careerList.get(1).getCareer_name(), careerList.get(1).getCareer_info(),
				careerList.get(1).getCareer_jobs());

		assertEquals("test that the careerList are printed correctly with the added recoreds", output, showCareerList);

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
		String allSubjects2 = CPA_Main.getSubject(subjectlist, subjectid);
		String output = String.format("%-10s %-10s\n", "ID", "SUBJECT");
		output += String.format("%-10s %-10s\n", subjectlist.get(0).getSubjectId(),
				subjectlist.get(0).getSubjectName());
		assertEquals("test if subjectlist prints the newly subject", output, allSubjects2);
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

	@Test
	public void testviewprerequisites() {

		String actuallist = CPA_Main.viewPrerequisites(prerequisitesList);
		String testoutput = "No record found";

		assertEquals("test if arraylist is the same", testoutput, actuallist);

		CPA_Main.addPrerequisites(prerequisitesList, prereq1);

		assertEquals("test if array size is updated", 1, prerequisitesList.size());
	}

	@Test
	public void testAddPrerequisites() {

		prerequisitesList.add(prereq1);
		prerequisitesList.add(prereq2);
		assertEquals("test if size increase after adding", 2, prerequisitesList.size());

		assertEquals("test if arraylist is the same", prereq2, prerequisitesList.get(1));

	}

	@Test
	public void testDeletePrerequisite() {

		CPA_Main.addPrerequisites(prerequisitesList, prereq1);
		assertEquals("test if after adding the list is 1", 1, prerequisitesList.size());

		int idpre = 1;
		CPA_Main.deletePrerequisite(prerequisitesList, idpre);
		assertEquals("test if arraylist goes back to 0 after deletion", 0, prerequisitesList.size());

	}

	@Test
	public void c206_test() {
		// fail("Not yet implemented");
		assertTrue("C206_CaseStudy_SampleTest ", true);
	}

	@After
	public void tearDown() throws Exception {

		// career
		career1 = null;
		career2 = null;
		careerList = null;

	}

}
