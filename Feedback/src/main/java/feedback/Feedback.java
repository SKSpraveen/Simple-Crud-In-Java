package feedback;

public class Feedback {

	private int id;
	private String name;
	private String email;
	private String comment;
	
	public Feedback(int id, String name, String email, String comment) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.comment = comment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
