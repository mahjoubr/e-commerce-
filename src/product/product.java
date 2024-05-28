package product;

public class product {
    
        private static int idcpt = 1;
        private int id;
        private String name;
        private String category;
        private double price;
    
        public product(String name, String category, double price) {
            this.id = idcpt++;
            this.name = name;
            this.category = category;
            this.price = price;
        }
    
        public int getid() {
            return id;
        }
    
        public String getname() {
            return name;
        }
    
        public String getcategory() {
            return category;
        }
    
        public double getprice() {
            return price;
        }
    }
    

