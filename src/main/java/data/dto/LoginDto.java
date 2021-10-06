package data.dto;

public class LoginDto {
	//필드
	private String num;
	private String pw;
	private String email;
	private String name;
	private String mobile;
	private String addr;
	private String postcode;
	private String registerDay;
	
	
	//생성자
	public LoginDto(){}
	
	public LoginDto(String pw, String email, String name) {
		super();
		this.pw = pw;
		this.email = email;
		this.name = name;
	}

	public LoginDto(String pw, String email, String name, String mobile, String addr, String postcode) {
		super();
		this.pw = pw;
		this.email = email;
		this.name = name;
		this.mobile = mobile;
		this.addr = addr;
		this.postcode = postcode;
	}
	
	
	//Getter Setter
	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getRegisterDay() {
		return registerDay;
	}

	public void setRegisterDay(String registerDay) {
		this.registerDay = registerDay;
	}

}
