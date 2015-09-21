package bean.user;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;

import bean.user.data.Company;

@Entity
@Table(name = "tbl_user")
public class User {
	@Id
	@GeneratedValue(generator = "idGenerator")
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	@Column(name = "id",nullable=false)
	private String uuid;
	
	@Column(nullable=false)
	private String user_email;
	@Column(name = "user_password_digest")
	private String user_password_digiest;
	@Column(name = "remember_digest")
	private String remember_digest;
	@Column(name = "activation_digest")
	private String activation_digest;
	@Column(name = "activated")
	private int activated;
	@Column(name = "activated_at")
	private long activated_at;
	
	private java.util.Date updated_at ;
	
	private java.util.Date create_at;
	
	 /**
     * @OneToOne：一对一关联
      * cascade：级联,它可以有有五个值可选,分别是：
      * CascadeType.PERSIST：级联新建
      * CascadeType.REMOVE : 级联删除
      * CascadeType.REFRESH：级联刷新
      * CascadeType.MERGE  ： 级联更新
      * CascadeType.ALL    ： 以上全部四项
      * 
      * cid：Person所映射的表中的一个字段
      */
	@OneToOne(fetch = FetchType.LAZY,mappedBy="user")
	private Company company;
	
	
//	private String company_id;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
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

	public java.util.Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(java.util.Date updated_at) {
		this.updated_at = updated_at;
	}
//
//	public String getCompany_id() {
//		return company_id;
//	}
//
//	public void setCompany_id(String company_id) {
//		this.company_id = company_id;
//	}

	public java.util.Date getCreate_at() {
		return create_at;
	}

	public void setCreate_at(java.util.Date create_at) {
		this.create_at = create_at;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
		company.setUser(this);
	}

}
