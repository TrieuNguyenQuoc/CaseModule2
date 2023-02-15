

import java.io.Serializable;

public class Room implements Serializable {
    private String employeeCode;
    private String name;
    private int age;
    private String phone;
    private String mail;

    public Room(String soPhong, String name, int age, String phone, String mail) {
        this.employeeCode = soPhong;
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.mail = mail;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
