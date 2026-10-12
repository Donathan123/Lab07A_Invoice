/**
 * Address holds the name and mailing address of the customer
 * that an Invoice is billed to.
 */
public class Address
{
    private String name;
    private String street;
    private String city;
    private String state;
    private String zip;

    public Address(String name, String street, String city, String state, String zip)
    {
        this.name = name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public String getName() { return name; }
    public String getStreet() { return street; }
    public String getCity() { return city; }
    public String getState() { return state; }
    public String getZip() { return zip; }

    public void setName(String name) { this.name = name; }
    public void setStreet(String street) { this.street = street; }
    public void setCity(String city) { this.city = city; }
    public void setState(String state) { this.state = state; }
    public void setZip(String zip) { this.zip = zip; }

    /**
     * @return the address formatted as a 3 line mailing label
     */
    public String format()
    {
        return name + "\n" + street + "\n" + city + ", " + state + " " + zip;
    }

    @Override
    public String toString()
    {
        return format();
    }
}
