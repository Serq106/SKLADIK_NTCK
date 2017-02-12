package by.ntck.sten.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Sklad_Kladovshik")
public class Kladovshik {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
		
	@Column(name = "login")
	@Size(min = 2, message="assa")
	private String login;
	
	@Column(name = "password")
	@Size(min = 2, message="assa")
	private String password;
	
	@ManyToMany(mappedBy = "kladovshik")	
	private List<Sklad> sklad;
	

	
	public Kladovshik() {
		
		this.id = 0;
		this.login = "";
		this.password = "";
		this.sklad = null;
	}
	public List<Sklad> getSklad() {
		return sklad;
	}
	public void setSklad(List<Sklad> sklad) {
		this.sklad = sklad;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getPassword() {
		return "*******";
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Kladovshik [id=");
		builder.append(id);
		builder.append(", login=");
		builder.append(login);
		builder.append(", password=");
		builder.append(password);
		builder.append("]");
		return builder.toString();
	}
}
