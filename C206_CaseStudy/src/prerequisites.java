public class prerequisites {
	private int prerequisites_id;
	private int subject_id;
	private String description;

	public prerequisites(int prerequisites_id, int subject_id) {
		this.prerequisites_id = prerequisites_id;
		this.subject_id = subject_id;
	}

	public int getPrerequisitesId() {
		return prerequisites_id;
	}

}