public class HoneyOrder {

    private String type;
    private int pounds;
    private double pricePerPound;

    // No-argument constructor
    public HoneyOrder() {
        this.type = "";
        this.pounds = 0;
        this.pricePerPound = 0.0;
    }

    // Parameterized constructor
    public HoneyOrder(String type, int pounds) {
        setType(type);
        setPounds(pounds);
        calculatePricePerPound();
    }

    // Getter for type
    public String getType() {
        return type;
    }

    // Setter for type
    public void setType(String type) {
        this.type = type;
    }

    // Getter for pounds
    public int getPounds() {
        return pounds;
    }

    // Setter for pounds with input validation
    public void setPounds(int pounds) {
        if (pounds < 1) {
            this.pounds = 0;
        } else {
            this.pounds = pounds;
        }
    }

    // Getter for pricePerPound
    public double getPricePerPound() {
        return pricePerPound;
    }

    // Calculate the price per pound based on the type and quantity
    private void calculatePricePerPound() {
        switch (type) {
            case "Orange Blossom":
                pricePerPound = (pounds >= 36) ? 1.15 : 1.25;
                break;
            case "Wildflower":
                pricePerPound = (pounds >= 36) ? 1.05 : 1.10;
                break;
            case "Clover":
                pricePerPound = (pounds >= 36) ? 0.97 : 1.00;
                break;
        }
    }

    // Calculate the number of 6lb bottles needed
    public int getNum6lbBottles() {
        return pounds / 6;
    }

    // Calculate the number of 3lb bottles needed
    public int getNum3lbBottles() {
        return (pounds % 6) / 3;
    }

    // Calculate the number of 1lb bottles needed
    public int getNum1lbBottles() {
        return (pounds % 6) % 3;
    }

    // Calculate the total price of the order
    public double getTotalPrice() {
        return pounds * pricePerPound;
    }

}