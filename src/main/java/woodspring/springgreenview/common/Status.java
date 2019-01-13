package woodspring.springgreenview.common;

public enum Status {
	ACTIVE("ACTIVE"),
	UPDATE("UPDATE"),
	DISABLE("DISABLE");
	
	private String state;

	Status(String state) {
        this.state = state;
    }

    public String state() {
        return state;
    }

}
