package CollectionsAndSets;

public class Person {
    private String name;
    private String surname;
    private String passport;

    public Person(String name, String surname, String passport) {
        this.name = name;
        this.surname = surname;
        this.passport = passport;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurrame() {
        return surname;
    }

    public void setSurrame(String surrame) {
        this.surname = surrame;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public void changePassportNumber(String passport) {
        if (passport != null && !passport.isBlank()) {
            this.passport = passport;
        }
    }
}
