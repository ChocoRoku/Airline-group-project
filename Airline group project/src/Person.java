import java.util.*;

public abstract class Person {
 
	 
	private String username;
	private String password;
	private String accountType;

	Person(String username, String password, String accountType){
		this.username = username;
		this.password = password;
		this.accountType = accountType;
	}

	/* This method gets the username
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/* This method gets the password
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	
	/* This method gets the account type
	 * @return the accountType
	 */
	public String getAccountType() {
		return accountType;
	}

}
