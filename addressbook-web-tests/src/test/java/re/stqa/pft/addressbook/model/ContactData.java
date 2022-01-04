package re.stqa.pft.addressbook.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.Objects;


@Entity
@Table(name = "addressbook")

public class ContactData {

    @Id
    @Column(name = "id")
    private int id = Integer.MAX_VALUE;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "address")
    @Type(type = "text")
    private String address;

    @Column(name = "home")
    @Type(type = "text")
    private String homePhone;

    @Column(name = "mobile")
    @Type(type = "text")
    private String mobilePhone;

    @Column(name = "work")
    @Type(type = "text")
    private String workPhone;

    @Column(name = "photo")
    @Type(type = "text")
    private String photo;

    @Transient
    private int group;
    @Transient
    private String secondPhone;
    @Transient
    private String email;
    @Transient
    private String email2;
    @Transient
    private String email3;
    @Transient
    private String allPhones;
    @Transient
    private String allEmails;

    public File getPhoto() {
        if (photo != null) {
            return new File(photo);
        } else {
            return null;
        }
    }

    public ContactData withPhoto(File photo) {
        this.photo = photo.getPath();
        return this;
    }

    public String getAllPhones() {
        return allPhones;
    }

    public ContactData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

    public String getAllEmails() {
        return allEmails;
    }

    public ContactData withAllEmails(String allEmails) {
        this.allEmails = allEmails;
        return this;
    }

    public int getId() {
        return id;
    }

    public ContactData withId(int id) {
        this.id = id;
        return this;
    }

    public ContactData withFirstname(String name) {
        this.firstname = name;
        return this;
    }

    public ContactData withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public ContactData withAddress(String address) {
        this.address = address;
        return this;
    }

    public ContactData withHomePhone(String home) {
        this.homePhone = home;
        return this;
    }

    public ContactData withMobilePhone(String mobile) {
        this.mobilePhone = mobile;
        return this;
    }

    public ContactData withWorkPhone(String work) {
        this.workPhone = work;
        return this;
    }

    public ContactData withSecondPhone(String secondphone) {
        this.secondPhone = secondphone;
        return this;
    }

    public ContactData withEmail(String email) {
        this.email = email;
        return this;
    }

    public ContactData withEmail2(String email2) {
        this.email2 = email2;
        return this;
    }

    public ContactData withEmail3(String email3) {
        this.email3 = email3;
        return this;
    }

    public ContactData withGroup(int group) {
        this.group = group;
        return this;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getAddress() {
        return address;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public String getSecondPhone() {
        return secondPhone;
    }

    public String getEmail() {
        return email;
    }

    public String getEmail2() {
        return email2;
    }

    public String getEmail3() {
        return email3;
    }

    public int getGroup() {
        return group;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return id == that.id && Objects.equals(firstname, that.firstname) && Objects.equals(lastname, that.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname);
    }
}