public class Update
{
    String Drivername,ContactNumber,CarName,Price;

    public Update(String drivername, String contactNumber, String carName, String price) {
        Drivername = drivername;
        ContactNumber = contactNumber;
        CarName = carName;
        Price = price;
    }

    public String getDrivername() {
        return Drivername;
    }

    public void setDrivername(String drivername) {
        Drivername = drivername;
    }

    public String getContactNumber() {
        return ContactNumber;
    }

    public void setContactNumber(String contactNumber) {
        ContactNumber = contactNumber;
    }

    public String getCarName() {
        return CarName;
    }

    public void setCarName(String carName) {
        CarName = carName;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }


}
