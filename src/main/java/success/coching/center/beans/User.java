package success.coching.center.beans;


import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="user")
public class User {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)	
	private int id;
	
	@Column(name="firstname")
	private String firstname;
	@Column(name="lastname")
	private String lastname;
	@Column(name="fathername")
	private String fathername;
	@Column(name="email")
	private String email;
	@Column(name="mobile")
	private String mobile;
	@Column(name="password")
	private String password;
	@Column(name="village")
	private String village;
	@Column(name="post")
	private String post;
	@Column(name="pin")
	private String pin;
	@Column(name="city")
	private String city;
	@Column(name="state")
	private String state;
	@Column(name="country")
	private String country;

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="user_role", joinColumns = @JoinColumn(name="user_id"), inverseJoinColumns = @JoinColumn(name="role_id"))
	private Set<Role> roles;
	
	
	
}
