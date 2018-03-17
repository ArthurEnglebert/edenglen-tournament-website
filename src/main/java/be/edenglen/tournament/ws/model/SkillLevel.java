package be.edenglen.tournament.ws.model;

public enum SkillLevel {
    C30_5("C30.5"),
    C30_4("C30.4"),
    C30_3("C30.3"),
    C30_2("C30.2"),
    C30_1("C30.1"),
    C30("C30"),

    C15_5("C15.5"),
    C15_4("C15.4"),
    C15_3("C15.3"),
    C15_2("C15.2"),
    C15_1("C15.1"),
    C15("C15"),

    B_PLUS_4("B+4/6"),
    B_PLUS_2("B+2/6"),
    B0("B0"),
    B_MINUS_2("B-2/6"),
    B_MINUS_4("B-4/6"),
    B_MINUS_15("B-15"),
    B_MINUS_15_1("B-15.1"),
    B_MINUS_15_2("B-15.2"),
    B_MINUS_15_4("B-15.4"),

    A("A");

    private String representation;

    private SkillLevel(String representation) {
        this.representation = representation;
    }

    public String getRepresentation() {
        return representation;
    }
}
