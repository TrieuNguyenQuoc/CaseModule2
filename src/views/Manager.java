package views;

import model.Staff;
import model.HardStaff;
import model.Intern;

import java.util.*;

public class Manager {
    public List<Staff> employees;

    public Manager(List<Staff> employees) {
        this.employees = employees;
    }
    public void addEmployee(Staff employee) {
        employees.add(employee);
    } // thêm đối tượng

    public void display() { // in theo cách thường
        for (Staff staff : employees) {
            System.out.println(staff);
        }
    }

    int index;
    Scanner input = new Scanner(System.in);
    public void editEmployee(Staff staff) {
        System.out.print("Nhập vị trí muốn sửa: ");
        index = input.nextInt();
        for (int i = 0; i < employees.size(); i++) {
            if (i == index) {
                employees.set(i, staff);
            }
        }
    }

    public void removeEmployee() {
        System.out.print("Nhập vị trí muốn xóa: ");
        index = input.nextInt();
        for (int i = 0; i < employees.size(); i++) {
            if (i == index) {
                employees.remove(i);
            }
        }
    }

    public double averageSalary() { // trung bingf lương
        double totalSalary = 0;
        double averageSalary = 0;
        for (Staff employee : employees) {
            if (employee instanceof Intern) {
                totalSalary += ((Intern) employee).salaryPartTime();
            }
            if (employee instanceof HardStaff) {
                totalSalary += ((Intern) employee).salaryHardStaff();
            }
        }
        return averageSalary = totalSalary / employees.size(); // số lượng ptu trong mảng
    }

    public String checkSalaryHardStaff() { // lấy danh sách nv full lương thấp hơn bt
        StringBuilder nameEmployeeFullTimes = new StringBuilder();
        for (Staff employee : employees) {
            if (employee instanceof HardStaff) {
                if (((HardStaff) employee).salaryFullTime() < averageSalary()) {
                    nameEmployeeFullTimes.append("\t").append(employee.getName()).append("\n");
                }
            }
        } return nameEmployeeFullTimes.toString();
    }

    public double totalSalaryPartTime() { // tính tổng lương part
        double totalSalaryParttime = 0;
        for (Staff employee : employees) {
            if (employee instanceof Intern) {
                totalSalaryParttime += ((Intern) employee).salaryPartTime();
            }
        }
        return totalSalaryParttime;
    }
    public List<HardStaff> sortSalary(){
        List<HardStaff> employeeFullTimes = new ArrayList<>();
        for (Staff staff: employees) {
            if (staff instanceof HardStaff) {
                employeeFullTimes.add((HardStaff) staff);
            }
        }
        Collections.sort(employeeFullTimes);
        return employeeFullTimes;
    }

    public void editStaff(Object editStaff) {
    }

    public void removeStaff() {
    }

    public String totalSalaryIntern() {
        return null;
    }

    public void addStaff(Staff aadStaff) {

    }
}

