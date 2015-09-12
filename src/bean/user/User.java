package bean.user;

public class User {
	private int uuid;
	private String user_email;
	private String user_password_digiest;
	private String remember_digest;
	private String activation_digest;
	private int activated;
	private long activated_at;
	private long updated_at;
	private int clinic_id;

	public int getUuid() {
		return uuid;
	}

	public void setUuid(int uuid) {
		this.uuid = uuid;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_password_digest() {
		return user_password_digiest;
	}

	public void setUser_password_digest(String user_password) {
		this.user_password_digiest = user_password;
	}

	public String getRemember_digest() {
		return remember_digest;
	}

	public void setRemember_digest(String remember_digest) {
		this.remember_digest = remember_digest;
	}

	public String getActivation_digest() {
		return activation_digest;
	}

	public void setActivation_digest(String activation_digest) {
		this.activation_digest = activation_digest;
	}

	public int getActivated() {
		return activated;
	}

	public void setActivated(int activated) {
		this.activated = activated;
	}

	public long getActivated_at() {
		return activated_at;
	}

	public void setActivated_at(long activated_at) {
		this.activated_at = activated_at;
	}

	public long getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(long updated_at) {
		this.updated_at = updated_at;
	}

	public int getClinic_id() {
		return clinic_id;
	}

	public void setClinic_id(int clinic_id) {
		this.clinic_id = clinic_id;
	}

}