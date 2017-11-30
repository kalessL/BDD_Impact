package manageOrder;

public enum Crust {
    CLASSIC,
    GLUTEN_FREE,
    CHEESE,
    THIN;

    public static String[] names() {
        Crust[] crusts = values();
        String[] names = new String[crusts.length];

        for (int i = 0; i < crusts.length; i++) {
            names[i] = crusts[i].name();
        }
        return names;
    }
}
