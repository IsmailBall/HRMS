package kodlamaio.hrms.entities.dtos;


public class JobSeekerSignUpDto {

	private String email;

	private String password;

	private String passwordAgain;
	
	private String firstName;

	private String lastName;

	private String phoneNumber;

	private String nationalId;

	private short birthYear;

	public JobSeekerSignUpDto(String email, String password, String passwordAgain, String firstName, String lastName,
			String phoneNumber, String nationalId, short birthYear) {
		super();
		this.email = email;
		this.password = password;
		this.passwordAgain = passwordAgain;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.nationalId = nationalId;
		this.birthYear = birthYear;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordAgain() {
		return passwordAgain;
	}

	public void setPasswordAgain(String passwordAgain) {
		this.passwordAgain = passwordAgain;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getNationalId() {
		return nationalId;
	}

	public void setNationalId(String nationalId) {
		this.nationalId = nationalId;
	}

	public short getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(short birthYear) {
		this.birthYear = birthYear;
	}
	
	
}
