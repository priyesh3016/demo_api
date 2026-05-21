package pojo;

public class GetCourse {
	
	
	private String URL ;
	private String services ;
	private String expertise ;
	private Courses Course ;
	private String instructor ;
	private String Linkedin ;
	
	
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
	public String getServices() {
		return services;
	}
	public void setServices(String services) {
		this.services = services;
	}
	public String getExpertise() {
		return expertise;
	}
	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}
	public Courses getCourse() {
		return Course;
	}
	public void setCourse(Courses course) {
		Course = course;
	}
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	public String getLinkedin() {
		return Linkedin;
	}
	public void setLinkedin(String linkedin) {
		Linkedin = linkedin;
	}


}
