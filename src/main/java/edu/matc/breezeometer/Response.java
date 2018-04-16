package edu.matc.breezeometer;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Response{

	@JsonProperty("data_valid")
	private boolean dataValid;

	@JsonProperty("error")
	private Error error;

	public void setDataValid(boolean dataValid){
		this.dataValid = dataValid;
	}

	public boolean isDataValid(){
		return dataValid;
	}

	public void setError(Error error){
		this.error = error;
	}

	public Error getError(){
		return error;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"data_valid = '" + dataValid + '\'' + 
			",error = '" + error + '\'' + 
			"}";
		}
}