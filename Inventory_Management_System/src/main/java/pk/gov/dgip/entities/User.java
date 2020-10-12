package pk.gov.dgip.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "User.findByNameAndPassword", query = "SELECT u FROM User u WHERE u.username=:username and u.password=:password")
@Table(name = "Users")
public class User implements Comparator<User> {

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String username, String password, String contactNo, String email, LocalDate dateCreation,
			Boolean isActive) {
		super();
		this.username = username;
		this.password = password;
		this.contactNo = contactNo;
		this.email = email;
		this.dateCreation = dateCreation;
		this.isActive = isActive;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(length = 45)
	private String username;
	@Column(length = 45)
	private String password;
	@Column(length = 45)
	private String fullname;
	@Column(length = 45)
	private String contactNo;
	@OneToOne(cascade = CascadeType.MERGE)
	private Address address;
	@Column(length = 45)
	private String email;
	private LocalDate dateCreation;
	private Boolean isActive;

	@ManyToMany
	List<Role> roles = new ArrayList<>();

	@OneToMany
	private List<Item> items;

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles2) {
		this.roles = roles2;
	}

	public long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(LocalDate localDate) {
		this.dateCreation = localDate;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public static Comparator<User> UserNameComparator = new Comparator<User>() {
		public int compare(User u1, User u2) {
			String user1 = u1.getFullname();
			String user2 = u2.getFullname();
			return user1.compareTo(user2);
		}

	};

	@Override
	public int compare(User o1, User o2) {
		// TODO Auto-generated method stub
		return 0;
	}
}
