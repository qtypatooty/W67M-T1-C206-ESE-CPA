import java.util.ArrayList;

public class CPA_Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		subject subject1 = new subject(1, "English", "Compulsory");
		subject subject2 = new subject(2, "Mathematics", "Compulsory");
		subject subject3 = new subject(3, "Science", "Compulsory");
		subject subject4 = new subject(4, "Chinese", "Compulsory");
		subject subject5 = new subject(5, "Social Studies", "Compulsory");
		ArrayList<subject> subjectlist = new ArrayList<subject>();
		subjectlist.add(subject1);
		subjectlist.add(subject2);
		subjectlist.add(subject3);
		subjectlist.add(subject4);
		subjectlist.add(subject5);
		int userOption = -1;

		ArrayList<user> userList = new ArrayList<user>();

		// careerList
		career career1 = new career(1, "Architecture and engineering",
				"People in the architecture and planning fields are responsible for designing new structures or creating aesthetically pleasing, practical and structurally sound environments.",
				"Architect, Civil engineer, Landscape architect, Sustainable designer, Biomedical engineer");
		career career2 = new career(2, "Arts, culture and entertainment",
				"This career field is dedicated to enriching people's lives through culture and the sharing of arts and self-expression.",
				"Singer/songwriter, Music producer, Art curator, Animator/video game designer, Filmmaker, Graphic designer, Fashion designer, Photographer");
		ArrayList<career> careerList = new ArrayList<career>();
		careerList.add(career1);
		careerList.add(career2);

		while (userOption != 0) { // user did not chose exit
			CPA_Main.MainMenu();// Print main menu
			userOption = Helper.readInt("Enter your option: ");
			Helper.line(30, "-");

			if (userOption == 1) { // add new user account
				int userID = Helper.readInt("Enter your id: ");
				String userName = Helper.readString("Enter user name: ");
				String userRole = Helper.readString("Enter user role: ");
				String userEmail = Helper.readString("Enter email: ");
				String userPassword = Helper.readString("Enter user password: ");

				user newUser = new user(userID, userName, userRole, userEmail, userPassword);

				if (newUser.getUserid() != 0 && !newUser.getName().isEmpty() && !newUser.getRole().isEmpty()
						&& !newUser.getemail().isEmpty() && !newUser.getPassword().isEmpty()) {
					userList.add(newUser);
					System.out.println("Account has been created");

				} else {
					System.out.println("You did not fill up all required field, add acount failed.");
				}
			}

			else if (userOption == 2) { // add new academic cluster

			}

			else if (userOption == 3) { // add new career information

				careerMenu();
				int careerOption = Helper.readInt("Enter option> ");

				if (careerOption == 1) { // view all career

					System.out.println(showAllCareer(careerList));

				} else if (careerOption == 2) { // add new career

					int careerId = Helper.readInt("Enter ID of career> ");
					String careerName = Helper.readString("Enter the name of career> ");
					String careerInfo = Helper.readString("Enter the information of the career> ");
					String careerJob = Helper.readString("Enter jobs> ");

					career newcareer = new career(careerId, careerName, careerInfo, careerJob);

					addCareer(careerList, newcareer);

				} else if (careerOption == 3) { // delete career

					if (careerList.size() < 1) {
						System.out.println("No record");
					} else {
						System.out.println(showAllCareer(careerList));
						Helper.line(30, "-");

						int careerId = Helper.readInt("ID of career to delete> ");
						deleteCareer(careerList, careerId);
					}

				} else if (careerOption == 4) { // back to main menu

				}

			}

			else if (userOption == 4) { // add new subject
				CPA_Main.SMenu();
				int subjectOptions = Helper.readInt("Enter choice > ");
				switch (subjectOptions) {
				case 1:
					int subjectId = Helper.readInt("Enter subject ID > ");
					String subjectName = Helper.readString("Enter the subject you want to add > ");
					String compulsory = Helper.readString("Compulsory / Elective");
					subject newsubject = new subject(subjectId, subjectName, compulsory);
					boolean result = CPA_Main.addSubject(subjectlist, newsubject);
					if (result == true) {
						System.out.println("Subject added!");
					} else {
						System.out.println("Subject not added!");
					}
					break;
				case 2:
					String allsubjects = CPA_Main.subjectListToString(subjectlist);
					System.out.println(allsubjects);
					break;
				case 3:
					System.out.println(subjectListToString(subjectlist));
					int deleteSubjectName = Helper.readInt("Enter subject's ID you would like to delete > ");
					String subjectdetails = CPA_Main.getSubject(subjectlist, deleteSubjectName);
					if (!subjectdetails.isEmpty()) {
						char toDelete = Helper.readChar("Do you wish to delete this subject?(y/n) > ");
						switch (toDelete) {
						case 'y':
							boolean deleted = CPA_Main.removeSubject(subjectlist, deleteSubjectName);
							if (deleted == true) {
								System.out.println(
										String.format("Subject %s was deleted successfully.", deleteSubjectName));
							} else {
								System.out.println("Something went wrong, subject was not deleted.");
							}
						case 'n':
							break;
						}

					} else {
						System.out.println("That subject ID does not exist!");
					}
					break;
				case 5:
					break;
				}
			} else if (userOption == 4) { // add new subject

			}

			else if (userOption == 5) { // add new pathway

			}

			else if (userOption == 6) { // add new career information

			}

			else if (userOption == 7) { // show all user
				if (userList.size() > 0) {
					for (int i = 0; i < userList.size(); i++) {
						System.out.println("User no. " + i);
						userList.get(i).showAlluser();
						Helper.line(30, "-");
					}

				} else {
					System.out.println("There is no user in the account list.");

				}
			} else if (userOption == 0) {
				System.out.println("Goodbye!");

			} else {
				System.out.println("Invalid option");
			}
		}

	}

	public static void MainMenu() {

		Helper.line(30, "-");
		System.out.println("CARERR PLANNING APPLICATION - MAIN");
		Helper.line(30, "-");

		// can add on if needed
		System.out.println("1. Add new user account");
		System.out.println("2. Add new academic cluster");
		System.out.println("3. Manage career information");
		System.out.println("4. Manage subjects");
		System.out.println("5. Add new prerequisites");
		System.out.println("6. Add new pathway");
		System.out.println("7. Show all user");
		System.out.println("8. Show all academic cluster");
		System.out.println("0. Exit");
		Helper.line(30, "-");

	}

	public static void SMenu() {

		System.out.println("1. Add subject");
		System.out.println("2. View my subjects");
		System.out.println("3. Delete subject");
		System.out.println("4. Search subjects");
		System.out.println("5. Return back to main menu");

	}

	public static boolean addSubject(ArrayList<subject> subjectlist, subject subject) {

		if (subject.getSubjectName() != null) {
			if (!subject.getSubjectName().isEmpty()) {
				subjectlist.add(subject);
				return true;
			}
		}
		return false;
	}

	public static String subjectListToString(ArrayList<subject> subjectlist) {

		String output = "";
		output += String.format("%-10s %-10s\n", "ID", "SUBJECT");
		for (int i = 0; i < subjectlist.size(); i++) {
			output += String.format("%-10d %-10s\n", subjectlist.get(i).getSubjectId(),
					subjectlist.get(i).getSubjectName());
		}
		return output;
	}

	public static boolean removeSubject(ArrayList<subject> subjectlist, int subjectid) {

		for (int i = 0; i < subjectlist.size(); i++) {
			if (subjectlist.get(i).getSubjectId() == subjectid) {
				subjectlist.remove(i);
				return true;
			}

		}
		return false;
	}

	public static String getSubject(ArrayList<subject> subjectlist, int subjectid) {
		String output = "";

		for (int i = 0; i < subjectlist.size(); i++) {
			subject s = subjectlist.get(i);
			if (s.getSubjectId() == subjectid) {
				output += String.format("%-10s %-10s\n", "ID", "SUBJECT");
				output += String.format("%-10d %-10s\n", s.getSubjectId(), s.getSubjectName());
				break;
			}
		}

		System.out.println(output);

		return output;
	}

	private static void careerMenu() {

		System.out.println("1. View all career");
		System.out.println("2. Add new career");
		System.out.println("3. Delete career");
		System.out.println("4. Return to main menu");
		Helper.line(30, "-");
	}

	public static String showAllCareer(ArrayList<career> careerList) {

		Helper.line(30, "-");
		System.out.println("CAREER LIST");
		Helper.line(30, "-");

		String output = String.format("%-10s %-20s %-40s %-20s \n", "ID", "NAME", "INFORAMTION", "RELAVENT JOB");

		for (int i = 0; i < careerList.size(); i++) {
			output += String.format("%-10d %-20s %-40s %-20s \n", careerList.get(i).getCareer_id(),
					careerList.get(i).getCareer_name(), careerList.get(i).getCareer_info(),
					careerList.get(i).getCareer_jobs());
		}
		return output;
	}

	public static void addCareer(ArrayList<career> careerList, career newCareer) {

		for (int i = 0; i < careerList.size(); i++) {
			if (careerList.get(i).getCareer_id() == newCareer.getCareer_id()
					|| careerList.get(i).getCareer_name() == newCareer.getCareer_name()) {
				// duplicate of id or name
				System.out.println("Failed! ID or career name exists");
				break;
			} else {
				// no duplicate, no empty field
				if (newCareer.getCareer_id() != 0 && !newCareer.getCareer_name().isEmpty()
						&& !newCareer.getCareer_info().isEmpty() && !newCareer.getCareer_jobs().isEmpty()) { // no empty
																												// field
					careerList.add(newCareer);
					System.out.println("New career has been added successfully");
					break;
				} else { // no duplicate and no
					// no duplicate but get empty field
					System.out.println("Failed! All fields needed to be filled in.");
					break;
				}
			}
		}
	}

	public static void deleteCareer(ArrayList<career> careerList, int careerId) {

		String output = "Failed! Undefined career id";

		for (int i = 0; i < careerList.size(); i++) {
			if (careerList.get(i).getCareer_id() == careerId) {
				careerList.remove(i);
				output = "Successful! Career deleted";
//				System.out.println("Successful! Career deleted");
				break;
			}
		}

		System.out.println(output);

	}

}
