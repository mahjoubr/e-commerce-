package shipping;

class shipping implements options {
    private String methodname;
    private double cost;

    public shipping(String methodname, double cost) {
        this.methodname = methodname;
        this.cost = cost;
    }

    
    public String getmethodname() {
        return methodname;
    }

    
    public double getcost() {
        return cost;
    }
}
