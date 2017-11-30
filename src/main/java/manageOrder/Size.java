package manageOrder;

public enum Size {
    SMALL,
    MEDIUM,
    LARGE,
    XL;

    public static String[] names() {
        Size[] sizes = values();
        String[] names = new String[sizes.length];

        for (int i = 0; i < sizes.length; i++) {
            names[i] = sizes[i].name();
        }
        return names;
    }
}
