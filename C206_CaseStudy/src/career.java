
public class career {
	
	private int career_id;
	private String career_name;
	private String career_info;
	
	public career(int career_id, String career_name, String career_info) {
		super();
		this.career_id = career_id;
		this.career_name = career_name;
		this.career_info = career_info;
	}

	public int getCareer_id() {
		return career_id;
	}

	public void setCareer_id(int career_id) {
		this.career_id = career_id;
	}

	public String getCareer_name() {
		return career_name;
	}

	public void setCareer_name(String career_name) {
		this.career_name = career_name;
	}

	public String getCareer_info() {
		return career_info;
	}

	public void setCareer_info(String career_info) {
		this.career_info = career_info;
	}

}
