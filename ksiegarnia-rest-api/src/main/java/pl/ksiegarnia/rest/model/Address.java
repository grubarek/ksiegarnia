package pl.ksiegarnia.rest.model;

import java.io.Serializable;

/**
 * Created by pgrubarek on 17.08.15.
 */
public class Address  implements Serializable{

    private static final long serialVersionUID = -2689654376353137228L;

    private Long id;
    private String city;
    private String postCode;
    private String street;
    private Integer houseNumber;
    private Integer apartamentNumber;
    private String phone;


    public Address() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
    }

    public Integer getApartamentNumber() {
        return apartamentNumber;
    }

    public void setApartamentNumber(Integer apartamentNumber) {
        this.apartamentNumber = apartamentNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", postCode='" + postCode + '\'' +
                ", street='" + street + '\'' +
                ", houseNumber=" + houseNumber +
                ", apartamentNumber=" + apartamentNumber +
                ", phone='" + phone + '\'' +
                '}';
    }
}
