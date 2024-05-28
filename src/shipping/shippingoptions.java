package shipping;

import java.util.ArrayList;

class shippingops {
    private ArrayList<options> options;

    public shippingops() {
        options = new ArrayList<>();
        // the primary options i choosed 
        options.add(new shipping("Standard Shipping", 7.0));
        options.add(new shipping("Express Shipping", 13.0));
        options.add(new shipping("Next Day Delivery", 16.0));
    }

    // getting all the options available
    public ArrayList<options> getalloptions() {
        return options;
    }

    // displaying the options available
    public void displayoptions() {
        System.out.println("Available Options:");
        for (options option : options) {
            System.out.println(option.getmethodname() + " - TND" + option.getcost());
        }
    }
}