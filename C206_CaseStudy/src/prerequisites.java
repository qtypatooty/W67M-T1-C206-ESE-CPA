public class prerequisites {
	private int prerequisites_id;
	private int subject_id;
	private String relationships;
	private String criteria;
	private String description;

	public prerequisites(int prerequisites_id, int subject_id, String relationships, String criteria, String description) {
		this.prerequisites_id = prerequisites_id;
		this.subject_id = subject_id;
		this.relationships = relationships;
		this.criteria = criteria;
		this.description = description;
	}

	public int getPrerequisitesId() {
		return prerequisites_id;
	}
	
	public int getsubject_id() {
		return subject_id;
	}
	
	public String getrelationship() {
		return relationships;
	}
	
	public String getcriteria() {
		return criteria;
	}
	
	public String getDescription() {
		return description;
	}

	public void setPrerequisites_id(int prerequisites_id) {
		this.prerequisites_id = prerequisites_id;
	}

	public void setSubject_id(int subject_id) {
		this.subject_id = subject_id;
	}

	public void setRelationships(String relationships) {
		this.relationships = relationships;
	}

	public void setCriteria(String criteria) {
		this.criteria = criteria;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	

}