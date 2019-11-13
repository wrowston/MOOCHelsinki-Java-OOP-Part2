
public class RegistrationPlate {
    // don't change the code which is already given to you

    // ATTENTION: the object variable types are final, meaning that their value cannot be changed!
    private final String regCode;
    private final String country;

    public RegistrationPlate(String country, String regCode) {
        this.regCode = regCode;
        this.country = country;
    }

    public String getRegCode() {
        return regCode;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return country + " " + regCode;
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }

        if (getClass() != object.getClass()) {
            return false;
        }

        RegistrationPlate compared = (RegistrationPlate) object;

        return this.regCode.equals(compared.getRegCode()) && this.country.equals(compared.getCountry());
    }

    public int hashCode() {
        if (this.country == null) {
            return 7;
        }

        return this.regCode.hashCode() + this.country.hashCode();
    }

}
