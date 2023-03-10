package model;

    public class Intern extends Staff {
        private int workingHours;

        public Intern(String employeeCode, String name, int age, String phone, String email, int workingHours) {
            super(employeeCode, name, age, phone, email);
            this.workingHours = workingHours;
        }

        public int getWorkingHours() {
            return workingHours;
        }

        public double salaryPartTime() {
            return getWorkingHours()*100;
        }

        @Override
        public String toString() {
            return "Nhân viên Parttime: [ " +
                    ", Mã nhân viên: " + getStaff() +
                    ", Tên: " + getName() +
                    ", Tuổi: " + getAge() +
                    ", Điện thoại: " + getPhone() +
                    ", Email: " + getEmail() +
                    ", Số giờ làm: " + workingHours +
                    ']' + "\n";
        }
    }

