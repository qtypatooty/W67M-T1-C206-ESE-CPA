public class subject {
	private int subject_id;
	private String subject_name;
	private String information;

	public subject(int subject_id, String subject_name, String information) {
		this.subject_id = subject_id;
		this.subject_name = subject_name;
		this.information = information;
	}

	public int getSubjectId() {
		return subject_id;
	}

	public String getSubjectName() {
		return subject_name;
	}
}
