public class Home {
    private int squareFt;
    private String address;
    private String city;
    private String state;
    private int zipCode;
    private String modelName;
    private String saleStatus;

    // Constructor
    public Home(int squareFt, String address, String city, String state, 
                int zipCode, String modelName, String saleStatus) {
        this.squareFt = squareFt;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.modelName = modelName;
        this.saleStatus = saleStatus;
    }

    // Getters and setters
    public void setSaleStatus(String status) throws IllegalArgumentException {
        if (!status.equalsIgnoreCase("sold") && 
            !status.equalsIgnoreCase("available") && 
            !status.equalsIgnoreCase("under contract")) {
            throw new IllegalArgumentException("Invalid sale status");
        }
        this.saleStatus = status;
    }

    @Override
    public String toString() {
        return String.format("Model: %s\nAddress: %s\nCity: %s, %s %d\n" +
                           "Square Feet: %d\nStatus: %s\n",
                           modelName, address, city, state, zipCode, 
                           squareFt, saleStatus);
    }
} 