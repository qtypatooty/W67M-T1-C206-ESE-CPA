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
				int careerId = Helper.readInt("Enter ID of career: ");
				String careerName = Helper.readString("Enter the name of career: ");
				String careerInfo = Helper.readString("Enter the information of the career: ");

				if (careerId != 0 && !careerName.isEmpty() && !careerInfo.isEmpty()) {
					career newCareer = new career(careerId, careerName, careerInfo);
					System.out.println("New career has been added successfully");
				} else {
					System.out.println();
				}

				break;
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
					String deleteSubjectName = Helper.readString("Enter subject you would like to delete > ");
					String subjectdetails = CPA_Main.getSubject(subjectlist, deleteSubjectName);
					for (int i = 0; i < subjectlist.size(); i++) {
						subject s = subjectlist.get(i);
						System.out.println(s.getSubjectName());
						if (deleteSubjectName == s.getSubjectName()) {
							subjectdetails = s.getSubjectName();
						}
					}
					if (subjectdetails.isEmpty() == false) {
						System.out.println(subjectdetails);
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
						System.out.println("That subject does not exist!");
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
		System.out.println("3. Add new career information");
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
		output += String.format("%-10s\n", "LIST OF SUBJECTS");
		for (int i = 0; i < subjectlist.size(); i++) {
			output += String.format("%-10s\n", subjectlist.get(i).getSubjectName());
		}
		return output;
	}

	public static boolean removeSubject(ArrayList<subject> subjectlist, String subjectname) {

		for (int i = 0; i < subjectlist.size(); i++) {
			if (subjectlist.get(i).getSubjectName() == subjectname) {
				subjectlist.remove(i);
				return true;
			}

		}
		return false;
	}

	public static String getSubject(ArrayList<subject> subjectlist, String subjectname) {
		String output = "";

		for (int i = 0; i < subjectlist.size(); i++) {
			subject s = subjectlist.get(i);
			if (s.getSubjectName() == subjectname) {
				output += String.format("%-10s\n", "Subject");
				output += String.format("%-10s\n", s.getSubjectName());
				break;
			}
		}

		System.out.println(output);

		return output;
	}

}
