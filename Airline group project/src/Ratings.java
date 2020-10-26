public class Ratings {
	
	private String comment;
	private int stars;
	private String user;
	
	Ratings(String comment, int stars, String user) {
		this.comment = comment;
		this.stars = stars;
		this.user = user;
	}
	
	/* This method views the comment
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}
	
	/* This method views the stars
	 * @return the stars
	 */
	public int getStars() {
		return stars;
	}
	
	/* This method views the user
	 * @return the user
	 */
	public String getUsers() {
		return user;
	}
	
	/* This method sets the comment
	 * @param comment the comment
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	/* This method sets the stars
	 * @param stars the number of stars
	 */
	public void setStars(int stars) {
		this.stars = stars;
	}
	
	@Override
	public String toString() {
		return "Ratings [user= " + user + ", stars =" + stars + ", comment= " + comment + "]";
	}
	
}
 