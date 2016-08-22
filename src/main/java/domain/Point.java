package domain;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="locations")
public class Point {
	
	@Id
	private String id;
	
	private double longitude;
	
	private double latitude;
	
	private PType type;
	
	private List<Poster> comments;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public PType getType() {
		return type;
	}
	public void setType(PType type) {
		this.type = type;
	}
	public List<Poster> getComments() {
		return comments;
	}
	public void setComments(List<Poster> comments) {
		this.comments = comments;
	}
	
	
}
