
public class PassengerEntity
{
    String Passengername,PassengerNumber,Departure,Destination;
    
    public PassengerEntity()
    {
        
    }
    public PassengerEntity(String passengername, String passengerNumber, String departure, String destination) {
        Passengername = passengername;
        PassengerNumber = passengerNumber;
        Departure = departure;
        Destination = destination;
    }

    public String getPassengername() {
        return Passengername;
    }

    public String getPassengerNumber() {
        return PassengerNumber;
    }

    public String getDeparture() {
        return Departure;
    }

    public String getDestination() {
        return Destination;
    }
    
}