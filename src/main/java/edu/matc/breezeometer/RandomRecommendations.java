package edu.matc.breezeometer;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class RandomRecommendations {

	@JsonProperty("children")
	private String children;

	@JsonProperty("outside")
	private String outside;

	@JsonProperty("health")
	private String health;

	@JsonProperty("inside")
	private String inside;

	@JsonProperty("sport")
	private String sport;

	public void setChildren(String children){
		this.children = children;
	}

	public String getChildren(){
		return children;
	}

	public void setOutside(String outside){
		this.outside = outside;
	}

	public String getOutside(){
		return outside;
	}

	public void setHealth(String health){
		this.health = health;
	}

	public String getHealth(){
		return health;
	}

	public void setInside(String inside){
		this.inside = inside;
	}

	public String getInside(){
		return inside;
	}

	public void setSport(String sport){
		this.sport = sport;
	}

	public String getSport(){
		return sport;
	}

	@Override
 	public String toString(){
		return 
			"RandomRecommendations{" + 
			"children = '" + children + '\'' + 
			",outside = '" + outside + '\'' + 
			",health = '" + health + '\'' + 
			",inside = '" + inside + '\'' + 
			",sport = '" + sport + '\'' + 
			"}";
		}
}