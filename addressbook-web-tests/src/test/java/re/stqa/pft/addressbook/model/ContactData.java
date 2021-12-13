package re.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
    private final String name;
    private final String lastname;
    private final String address;
    private final String mobile;
    private final String email;
    private String group;


    public ContactData(String name, String lastname, String address, String mobile, String email, String group) {
        this.name = name;
        this.lastname = lastname;
        this.address = address;
        this.mobile = mobile;
        this.email = email;
        this.group = group;
    }


    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getAddress() {
        return address;
    }

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }

    public String getGroup() {
        return group;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}