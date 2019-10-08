package CatalystAssessment;

public class Coin {

    public static Coin[] possibleCoins = {
            new Coin(1),
            new Coin(2),
            new Coin(5),
            new Coin(10),
            new Coin(20),
            new Coin(50),
            new Coin(100),
            new Coin(200) };
    int value;
    public Coin(int value)
    {
        this.value = value;
    }
}
