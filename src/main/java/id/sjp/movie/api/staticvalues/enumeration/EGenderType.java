package id.sjp.movie.api.staticvalues.enumeration;

public enum EGenderType {
    MALE("M"),
    FEMALE("F");

    private final String name;

    EGenderType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
