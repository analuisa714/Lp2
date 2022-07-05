public enum menuOption {
    zero_balance(1), credito_balance(1), debito_balance(1), end(1);
    
    private final int value;

    menuOption(int valueOption) {
        value = valueOption;
    }

    public int getValue() {
        return value;
    }
}