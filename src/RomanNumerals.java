public enum RomanNumerals {
    I(1),
    II(2),
    III(3),
    IV(4),
    V(5),
    VI(6),
    VII(7),
    VIII(8),
    IX(9),
    X(10),
    XL(40),
    L(50),
    XC(90),
    C(100);

    int value;

    RomanNumerals(int value) {
        this.value = value;
    }
}
