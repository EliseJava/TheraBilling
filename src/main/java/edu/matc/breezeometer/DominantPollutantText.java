package edu.matc.breezeometer;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class DominantPollutantText{

	@JsonProperty("effects")
	private String effects;

	@JsonProperty("causes")
	private String causes;

	@JsonProperty("main")
	private String main;

	public void setEffects(String effects){
		this.effects = effects;
	}

	public String getEffects(){
		return effects;
	}

	public void setCauses(String causes){
		this.causes = causes;
	}

	public String getCauses(){
		return causes;
	}

	public void setMain(String main){
		this.main = main;
	}

	public String getMain(){
		return main;
	}

	@Override
 	public String toString(){
		return 
			"DominantPollutantText{" + 
			"effects = '" + effects + '\'' + 
			",causes = '" + causes + '\'' + 
			",main = '" + main + '\'' + 
			"}";
		}
}