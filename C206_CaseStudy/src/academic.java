
public class academic {
	private int cluster_id;
	private String cluster_name;

	public academic(int cluster_id, String cluster_name) {
		this.cluster_id = cluster_id;
		this.cluster_name = cluster_name;
	}

	public int getClusterId() {
		return cluster_id;
	}

	public String getClusterName() {
		return cluster_name;
	}
}