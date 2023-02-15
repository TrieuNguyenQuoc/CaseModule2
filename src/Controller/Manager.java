package Controller;

import model.Staff;
import model.HardStaff;
import model.Intern;
import model.HardStaff;
import model.Intern;
import model.Staff;

import java.util.*;

public class Manager {
    public List<Staff> staff;

    public Manager(List<Staff> staff) {
        this.staff = staff;
    }
    public void addStaff(Staff staff) {
        staff.add(staff);
    } // thêm đối tượng

    public void display() { // in theo cách thường
        for (Staff staff : staff) {
            System.out.println(staff);
        }
    }

    int index;
    Scanner input = new Scanner(System.in);
    public void editstaff(Staff staff) {
        System.out.print("Nhập vị trí muốn sửa: ");
        index = input.nextInt();
        for (int i = 0; i < staff.size(); i++) {
            if (i == index) {
                staff.set(i, staff);
            }
        }
    }

    public void removestaff() {
        System.out.print("Nhập vị trí muốn xóa: ");
        index = input.nextInt();
        for (int i = 0; i < staff.size(); i++) {
            if (i == index) {
                staff.remove(i);
            }
        }
    }

    public double averageSalary() { // trung bingf lương
        double totalSalary = 0;
        double averageSalary = 0;
        for (Staff staff : staff) {
            if (staff instanceof Intern) {
                totalSalary += ((Intern) staff).salaryPartTime();
            }
            if (staff instanceof Staff) {
                totalSalary += ((HardStaff) staff).salaryFullTime();
            }
        }
        return averageSalary = totalSalary / staff.size(); // số lượng ptu trong mảng
    }

    public String checkSalaryFullTime() { // lấy danh sách nv full lương thấp hơn bt
        StringBuilder nameEmployeeFullTimes = new StringBuilder();
        for (Staff staff : staff) {
            if (staff instanceof HardStaff) {
                if (((HardStaff) staff).salaryFullTime() < averageSalary()) {
                    nameEmployeeFullTimes.append("\t").append(staff.getName()).append("\n");
                }
            }
        } return nameEmployeeFullTimes.toString();
    }

    public double totalSalaryPartTime() { // tính tổng lương thực tập
        double totalSalaryParttime = 0;
        for (Staff employee : staff) {
            if (employee instanceof Intern) {
                totalSalaryParttime += ((Intern) employee).salaryPartTime();
            }
        }
        return totalSalaryParttime;
    }
    public List<HardStaff> sortSalary(){
        List<HardStaff> employeeFullTimes = new ArrayList<>();
        for (Staff staff: staff) {
            if (staff instanceof Staff) {
                employeeFullTimes.add((HardStaff) staff);
            }
        }
        Collections.sort(employeeFullTimes);
        return employeeFullTimes;
    }

    public void editStaff(Staff editEmployee) {
    }

    public void removeStaff() {
    }
}