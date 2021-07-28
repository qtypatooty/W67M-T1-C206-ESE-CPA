public class pathway {
	private int pathway_id;
	private int cluster_id;
	private int career_id;

	public pathway(int pathway_id, int cluster_id, int career_id) {
		this.pathway_id = pathway_id;
		this.cluster_id = cluster_id;
		this.career_id = career_id;
	}

	public int getPathwayId() {
		return pathway_id;
	}

}