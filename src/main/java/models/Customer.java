package models;


public class Customer {

    private int id;
    private String name;
    private String phone;
    private String typePref;
    private String breedPref;

    public Customer(String name, String phone, String typePref, String breedPref){
        this.name = name;
        this.phone = phone;
        this.typePref = typePref;
        this.breedPref = breedPref;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTypePref() {
        return typePref;
    }

    public void setTypePref(String typePref) {
        this.typePref = typePref;
    }

    public String getBreedPref() {
        return breedPref;
    }

    public void setBreedPref(String breedPref) {
        this.breedPref = breedPref;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (id != customer.id) return false;
        if (name != null ? !name.equals(customer.name) : customer.name != null) return false;
        if (phone != null ? !phone.equals(customer.phone) : customer.phone != null) return false;
        if (typePref != null ? !typePref.equals(customer.typePref) : customer.typePref != null) return false;
        return breedPref != null ? breedPref.equals(customer.breedPref) : customer.breedPref == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (typePref != null ? typePref.hashCode() : 0);
        result = 31 * result + (breedPref != null ? breedPref.hashCode() : 0);
        return result;
    }
}
