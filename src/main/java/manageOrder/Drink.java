package manageOrder;

public enum  Drink {
    Coca,
    Sprite,
    Pepsi,
    CocaBottle;

    public static String[] names() {
        Drink[] drinks = values();
        String[] names = new String[drinks.length];

        for (int i = 0; i < drinks.length; i++) {
            names[i] = drinks[i].name();
        }
        return names;
    }
}

