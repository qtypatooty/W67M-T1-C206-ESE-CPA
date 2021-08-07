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
		
		user user1=new user(9999,"admin 1","admin","admin@mail.com","adminPassword");

		ArrayList<user> userList = new ArrayList<user>();
		userList.add(user1);

		// careerList
		career career1 = new career(1, "Architecture and engineering",
				"Design new structures/create aesthetically pleasing and structurally sound environments",
				"Architect, Civil engineer, Landscape architect");
		career career2 = new career(2, "Arts, culture and entertainment",
				"Enriching lives through culture and sharing of arts and self-expression",
				"Singer/songwriter, Music producer, Fashion designer");
		ArrayList<career> careerList = new ArrayList<career>();
		careerList.add(career1);
		careerList.add(career2);

		ArrayList<prerequisites> prerequisitesList = new ArrayList<prerequisites>();

		while (userOption != 0) { // user did not chose exit
			CPA_Main.MainMenu();// Print main menu
			userOption = Helper.readInt("Enter your option: ");
			Helper.line(30, "-");

			if (userOption == 1) { // Manage account
				CPA_Main.accountMenu();// Print sub menu for account management
				int accountOption = Helper.readInt("Enter your option: ");
				Helper.line(30, "-");

				if (accountOption == 1) {
					int userID = Helper.readInt("Enter your id: ");
					String userName = Helper.readString("Enter user name: ");
					String userRole = Helper.readString("Enter user role: ");
					String userEmail = Helper.readString("Enter email: ");
					String userPassword = Helper.readString("Enter user password: ");

					user newUser = new user(userID, userName, userRole, userEmail, userPassword);

					CPA_Main.addAccount(userList, newUser);

				} else if (accountOption == 2) {
					String accountList = CPA_Main.showAccount(userList);
					System.out.println(accountList);
					if (userList.size() > 0) {
						int userID = Helper.readInt("Enter account id: ");
						CPA_Main.deleteAccount(userList, userID);
					}

				} else if (accountOption == 3) {
					String accountList = CPA_Main.showAccount(userList);
					System.out.println(accountList);
				} else if (accountOption == 4) {

				}

			}

			else if (userOption == 2) { // career information

				careerMenu();
				int careerOption = Helper.readInt("Enter option> ");

				if (careerOption == 1) { // view all career

					System.out.println(showAllCareer(careerList));

				} else if (careerOption == 2) { // add new career

					int careerId = Helper.readInt("Enter ID of career> ");
					String careerName = Helper.readString("Enter the name of career> ");
					String careerInfo = Helper.readString("Enter the information of the career (max 100 charcter)> ");
					String careerJob = Helper.readString("Enter jobs> ");

					career newcareer = new career(careerId, careerName, careerInfo, careerJob);

					addCareer(careerList, newcareer);

				} else if (careerOption == 3) { // delete career

					if (careerList.size() < 1) {
						System.out.println("No record found");
					} else {
						System.out.println(showAllCareer(careerList));
						Helper.line(30, "-");

						int careerId = Helper.readInt("ID of career to delete> ");
						deleteCareer(careerList, careerId);
					}

				} else if (careerOption == 4) { // back to main menu

				}

			}

			else if (userOption == 3) { // add new subject
				CPA_Main.SMenu();
				int subjectOptions = Helper.readInt("Enter choice > ");
				switch (subjectOptions) {
				case 1:
					int subjectId = Helper.readInt("Enter subject ID > ");
					String subjectName = Helper.readString("Enter the subject you want to add > ");
					String compulsory = Helper.readString("Compulsory / Elective > ");
					subject newsubject = new subject(subjectId, subjectName, compulsory);

					addSubject(subjectlist, newsubject);
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
				case 4:
					break;
				}
			}

			else if (userOption == 4) { // add new prerequisites
				prerequisitemenu();
				int prechoice = Helper.readInt("Enter your option: ");

				switch (prechoice) {
				case 1:
					String output = viewPrerequisites(prerequisitesList);
					System.out.println(output);

					break;

				case 2:

					int prereqID = Helper.readInt("Enter prerequisite id: ");
					int subjectID = Helper.readInt("Enter subject id: ");
					String relationship = Helper.readString("Enter relationship(s): ");
					String criteria = Helper.readString("Enter criteria: ");
					String description = Helper.readString("Enter description: ");

					prerequisites prereqnew = new prerequisites(prereqID, subjectID, relationship, criteria,
							description);

					addPrerequisites(prerequisitesList, prereqnew);

					break;

				case 3:
					viewPrerequisites(prerequisitesList);
					int prerequisiteID = Helper.readInt("Enter ID of prerequisite you want to delete: ");

					String message = deletePrerequisite(prerequisitesList, prerequisiteID);
					System.out.println(message);

					break;
				case 4:
					break;

				}

			}

			else if (userOption == 0) {
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
		System.out.println("1. Manage account");
		System.out.println("2. Manage career information");
		System.out.println("3. Manage subjects");
		System.out.println("4. Manage prerequisites");
		System.out.println("0. Exit");
		Helper.line(30, "-");

	}

	public static void accountMenu() {

		Helper.line(30, "-");
		System.out.println("CARERR PLANNING APPLICATION - Manage Account");
		Helper.line(30, "-");

		System.out.println("1. Register new user account");
		System.out.println("2. Delete account");
		System.out.println("3. Show all account");
		System.out.println("4. Return back to main menu");
		Helper.line(30, "-");

	}

	public static void SMenu() {

		System.out.println("1. Add subject");
		System.out.println("2. View my subjects");
		System.out.println("3. Delete subject");
		System.out.println("4. Return back to main menu");

	}

	public static void addSubject(ArrayList<subject> subjectlist, subject subject) {
		boolean repeated = false;
		boolean empty = false;

		if (subjectlist.size() != 0) {
			for (int i = 0; i < subjectlist.size(); i++) {
				if (subjectlist.get(i).getSubjectId() == subject.getSubjectId()
						|| subjectlist.get(i).getSubjectName().equalsIgnoreCase(subject.getSubjectName())) {
					repeated = true;

				}
			}

			if (subject.getSubjectId() == 0 || subject.getSubjectName().trim().isEmpty() || subject.getInformation().trim().isEmpty()) {
				empty = true;
			}
		}
		if (repeated == false && empty == false) {
			subjectlist.add(subject);
			System.out.println("Successfully added!");
		} else if (repeated == true) {
			System.out.println("Subject ID / Name can't be added because it has been added before.");
		} else if (empty == true) {
			System.out.println("Please fill in all the required fields.");
		} else if (repeated == true && empty == true) {
			System.out.println("Subject ID is repeated and please fill in the required fields.");
		}
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

	public static void careerMenu() {

		System.out.println("1. View all career");
		System.out.println("2. Add new career");
		System.out.println("3. Delete career");
		System.out.println("4. Return to main menu");
		Helper.line(30, "-");
	}

	public static String retrieveAllCareer(ArrayList<career> careerList) {

		String output = "";

		for (int i = 0; i < careerList.size(); i++) {
			output += String.format("%-10d %-35s %-100s %-20s \n", careerList.get(i).getCareer_id(),
					careerList.get(i).getCareer_name(), careerList.get(i).getCareer_info(),
					careerList.get(i).getCareer_jobs());
		}
		return output;
	}

	public static String showAllCareer(ArrayList<career> careerList) {

		Helper.line(30, "-");
		System.out.println("CAREER LIST");
		Helper.line(30, "-");

		String output = "";

		if (careerList.size() != 0) {
			output += String.format("%-10s %-35s %-100s %-20s \n", "ID", "CAREER GROUP", "GROUP DESCRIPTION",
					"RELAVENT JOB");

			output += retrieveAllCareer(careerList);
		} else {
			output = "No record found";
		}
		return output;
	}

	public static void addCareer(ArrayList<career> careerList, career newCareer) {

		boolean isDuplicate = false;
		boolean isEmpty = false;
		boolean isTooLong = false;

		if (careerList.size() != 0) {
			for (int i = 0; i < careerList.size(); i++) {
				if (careerList.get(i).getCareer_id() == newCareer.getCareer_id()
						|| careerList.get(i).getCareer_name().equalsIgnoreCase(newCareer.getCareer_name())) {
					isDuplicate = true;
				}
			}
			if (newCareer.getCareer_id() == 0 || newCareer.getCareer_name().trim().isEmpty() || newCareer.getCareer_info().trim().isEmpty() || newCareer.getCareer_jobs().trim().isEmpty()) {
				isEmpty = true;
			}
			if (newCareer.getCareer_info().length() > 100) {
				isTooLong = true;
			}
		}

		if (isDuplicate == false && isEmpty == false && isTooLong == false) {
			careerList.add(newCareer);
			System.out.println("New career has been added successfully");
		} else if (isDuplicate == true) {
			System.out.println("Failed! ID or career name exists");
		} else if (isEmpty == true) {
			System.out.println("Failed! All fields needed to be filled in.");
		} else if (isTooLong == true) {
			System.out.println("Failed! Too much information entered");
		}
	}

	public static void deleteCareer(ArrayList<career> careerList, int careerId) {

		String output = "Failed! Undefined career id";

		for (int i = 0; i < careerList.size(); i++) {
			if (careerList.get(i).getCareer_id() == careerId) {
				careerList.remove(i);
				output = "Successful! Career deleted";
				break;
			}
		}

		System.out.println(output);

	}

	public static void addAccount(ArrayList<user> userList, user newUser) {
		String message = "";
		boolean isDuplicate = false;
		boolean isEmpty = false;

		if (newUser.getUserid() != 0 && !newUser.getName().trim().isEmpty() && !newUser.getRole().trim().isEmpty()
				&& !newUser.getemail().trim().isEmpty() && !newUser.getPassword().trim().isEmpty()) {
			isEmpty = false;
			for(int i=0;i<userList.size();i++) {
				if(userList.get(i).getUserid() != newUser.getUserid()) {
					isDuplicate = false;
					
				}else if(userList.get(i).getUserid() == newUser.getUserid()){
					isDuplicate = true;
				}
			}

		} else {
			isEmpty = true;
		}
		
		if(isDuplicate == false && isEmpty == false) {
			userList.add(newUser);
			message="Account has been created";
		}else if(isDuplicate == true && isEmpty == false) {
			message="Duplicate ID entered, registration failed!";
			
		}else {
			message = "You did not fill up all required field, registration failed.";
		}
		System.out.println(message);


	}

	public static String showAccount(ArrayList<user> userList) {

		String table = "";
		if (userList.size() != 0) {
			String tableTitle = String.format("%-5s %-10s %-10s %-10s %-10s\n", "ID", "NAME", "ROLE", "EMAIL",
					"PASSWORD");
			String tableRest = "";
			for (int i = 0; i < userList.size(); i++) {
				tableRest = tableRest + String.format("%-5d %-10s %-10s %-10s %-10s\n", userList.get(i).getUserid(),
						userList.get(i).getName(), userList.get(i).getRole(), userList.get(i).getemail(),
						userList.get(i).getPassword());
			}
			table = tableTitle + tableRest;
		} else {
			table = "No record of user account found!";
		}

		return table;
	}

	public static void deleteAccount(ArrayList<user> userList, int userId) {
		String message = "";

		boolean foundID = false;

		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getUserid() == userId) {
				foundID = true;
				break;
			} else {
				foundID = false;
			}
		}

		if (foundID == false) {
			message = "Invalid ID entered!";
		} else if (foundID == true) {
			for (int i = 0; i < userList.size(); i++) {
				if (userList.get(i).getUserid() == userId) {
					userList.remove(i);
					message = "Account with user ID " + userId + " is successful deleted!";
				}
			}
		}
		System.out.println(message);

	}

	public static void prerequisitemenu() {
		System.out.println("1. View all prerequisites");
		System.out.println("2. Add new prerequisites");
		System.out.println("3. Delete prerequisites");
		System.out.println("4. Return to main menu");
		Helper.line(30, "-");
	}

	public static String viewPrerequisites(ArrayList<prerequisites> prerequisitesList) {

		Helper.line(30, "-");
		System.out.println("PREREQUISITES LIST");
		Helper.line(30, "-");

		String output = "";

		if (prerequisitesList.size() != 0) {
			output += String.format("%-5s %-30s %-30s %-30s %-25s \n", "ID", "PREREQUISITE SUBJECT ID",
					"PREREQUISITE SUBJECT DESCRIPTION", "PREREQUISITE GRADE", "PREREQUISITE CRITERIA DESCRIPTION");

			for (int i = 0; i < prerequisitesList.size(); i++) {
				output += String.format("%-5s %-30s %-30s %-30s %-25s \n",
						prerequisitesList.get(i).getPrerequisitesId(), prerequisitesList.get(i).getsubject_id(),
						prerequisitesList.get(i).getrelationship(), prerequisitesList.get(i).getcriteria(),
						prerequisitesList.get(i).getDescription());
			}
		} else {
			output = "No record found";
		}
		return output;
	}

	public static void addPrerequisites(ArrayList<prerequisites> prerequisitesList, prerequisites newreq) {

		prerequisitesList.add(newreq);

	}

	public static String deletePrerequisite(ArrayList<prerequisites> prerequisitesList, int prerequisiteID) {
		String message = "";

		boolean found = false;

		for (int i = 0; i < prerequisitesList.size(); i++) {
			if (prerequisitesList.get(i).getPrerequisitesId() == prerequisiteID) {
				found = true;
				break;
			} else {
				found = false;
			}
		}

		if (found == false) {
			message = "No prerequisite ID exists";
		} else if (found == true) {
			for (int i = 0; i < prerequisitesList.size(); i++) {
				if (prerequisitesList.get(i).getPrerequisitesId() == prerequisiteID) {
					prerequisitesList.remove(i);
					message = "Successfully deleted!";
				}
			}
		}
		return message;

	}
}
