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

        public String getName() {
            return Name;
        }

        public int getAge() {
            return Age;
        }

        public String getPhone() {
            return Phone;
        }

        public String getEmail() {
            return Email;
        }

        public static void add() {
        }

        public double size() {
            return 0;
        }

        public void set(double i) {

        }
    }

