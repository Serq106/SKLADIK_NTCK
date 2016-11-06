package by.ntck.sten.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Sklad_User")
public class User {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int id;

	@Column(name = "login")
	private String login;

	@Column(name = "department_id")
	private int department_id;
	
	@Column(name = "fullname")
	private String fullname;

	@Column(name = "lastname")
	private String lastname;
	
	@Column(name = "firstname")
	private String firstname;

	@Column(name = "otchestvo")
	private String otchestvo;
	
	@Column(name = "job")
	private String job;
	
	@Column(name = "section_id")
	private int section_id;
	
	@Column(name = "user_status")
	private String user_status;
	
	@Column(name = "boss")
	private int boss;
	
	@Column(name = "t_number") 
	private int t_number;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "user_id", nullable = false)
	private Kladovshik kladovshik;
	
	public Kladovshik getKladovshik() {
		return kladovshik;
	}

	public void setKladovshik(Kladovshik kladovshik) {
		this.kladovshik = kladovshik;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [id=");
		builder.append(id);
		builder.append(", login=");
		builder.append(login);
		builder.append(", department_id=");
		builder.append(department_id);
		builder.append(", fullname=");
		builder.append(fullname);
		builder.append(", lastname=");
		builder.append(lastname);
		builder.append(", firstname=");
		builder.append(firstname);
		builder.append(", otchestvo=");
		builder.append(otchestvo);
		builder.append(", job=");
		builder.append(job);
		builder.append(", section_id=");
		builder.append(section_id);
		builder.append(", user_status=");
		builder.append(user_status);
		builder.append(", boss=");
		builder.append(boss);
		builder.append(", t_number=");
		builder.append(t_number);
		builder.append(", kladovshik=");
		builder.append(kladovshik);
		builder.append("]");
		return builder.toString();
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public int getDepartment_id() {
		return department_id;
	}
	
	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}
	
	public String getFullname() {
		return fullname;
	}
	
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getOtchestvo() {
		return otchestvo;
	}
	
	public void setOtchestvo(String otchestvo) {
		this.otchestvo = otchestvo;
	}
	
	public String getJob() {
		return job;
	}
	
	public void setJob(String job) {
		this.job = job;
	}
	
	public int getSection_id() {
		return section_id;
	}
	
	public void setSection_id(int section_id) {
		this.section_id = section_id;
	}
	
	public String getUser_status() {
		return user_status;
	}
	
	public void setUser_status(String user_status) {
		this.user_status = user_status;
	}
	
	public int getBoss() {
		return boss;
	}
	
	public void setBoss(int boss) {
		this.boss = boss;
	}
	
	public int getT_number() {
		return t_number;
	}
	
	public void setT_number(int t_number) {
		this.t_number = t_number;
	}
}
