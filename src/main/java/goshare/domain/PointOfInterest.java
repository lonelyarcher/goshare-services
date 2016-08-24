package goshare.domain;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection="locations")
public class PointOfInterest {
	
	@Id
	private String id;
	
	@Indexed
	private Point position;
	
	private PType type;
	
	private String name;
	
	private String desc;
	
	private List<Poster> comments;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Point getPosition() {
		return position;
	}
	public void setPosition(Point position) {
		this.position = position;
	}
	
	
}
