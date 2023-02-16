package model;

import java.io.Serializable;

    public class Staff implements Serializable {
        private String Staff;
        private String Name;
        private int Age;
        private String Phone;
        private String Email;

        public Staff(String staff, String name, int age, String phone, String email) {
            this.Staff = staff;
            this.Name = name;
            this.Age = age;
            this.Phone = phone;
            this.Email = email;
        }

        public String getStaff() {
            return Staff;
        }

        public void setStaff(String staff) {
            Staff = staff;
        }

        public String getName() {
            return Name;
        }

        public void setName(String name) {
            Name = name;
        }

        public int getAge() {
            return Age;
        }

        public void setAge(int age) {
            Age = age;
        }

        public String getPhone() {
            return Phone;
        }

        public void setPhone(String phone) {
            Phone = phone;
        }

        public String getEmail() {
            return Email;
        }

        public void setEmail(String email) {
            Email = email;
        }

        public static void add(model.Staff staff) {
        }

        public double size() {
            return 0;
        }

        public void set(double i, Staff staff) {

        }
    }

