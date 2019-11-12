package dad.javafx.geofx.client;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Languages {
	private String code;
	private String name;
	@JsonProperty ("native")
	private String nativE;
	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNativE() {
		return nativE;
	}

	public void setNativE(String nativE) {
		this.nativE = nativE;
	}
	
}
