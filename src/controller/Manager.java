package controller;

import model.HardStaff;
import model.Intern;
import model.Staff;
import storage.ReadAndWrite;

import java.util.*;

public class Manager {
    ReadAndWrite readAndWrite = new ReadAndWrite();
    public List<Staff> staff;

    public Manager (List<Staff> staff) {
        this.staff = readAndWrite.readDataFromFile();
    }

    public Scanner scanner = new Scanner(System.in);


    public double averageSalary ( ) { // trung bingf lương
        double totalSalary;
        double averageSalary=0;
        double averageSalary1=0;
        for (Staff staff : staff) {
            if (staff instanceof Intern) {
                averageSalary += ((Intern) staff).salaryPartTime();
            }
            if (staff instanceof Staff) {
                averageSalary1 += ((HardStaff) staff).salaryFullTime();
            }
        }
         totalSalary = (averageSalary+averageSalary1) / staff.size(); // số lượng ptu trong mảng
        return totalSalary;
    }

    public String checkSalaryFullTime ( ) { // lấy danh sách nv full lương thấp hơn bt
        StringBuilder nameEmployeeFullTimes = new StringBuilder();
        for (Staff staff : staff) {
            if (staff instanceof HardStaff) {
                if (((HardStaff) staff).salaryFullTime() < averageSalary()) {
                    nameEmployeeFullTimes.append("\t").append(staff.getName()).append("\n");
                }
            }
        }
        return nameEmployeeFullTimes.toString();
    }

    public double totalSalaryPartTime ( ) { // tính tổng lương thực tập
        double totalSalaryIntern = 0;
        for (Staff employee : staff) {
            if (employee instanceof Intern) {
                totalSalaryIntern += ((Intern) staff).salaryPartTime();
            }
        }
        return totalSalaryIntern;
    }

    public void removeStaffs ( ) {
        System.out.print("Nhập vị trí muốn xóa: ");
        int index = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < staff.size(); i++) {
            if (i == index) {
                staff.remove(i);
            }
        }
    }

    public void sortSalary ( ) {
        staff.sort(new Comparator<Staff>() {
            @Override
            public int compare (Staff o1, Staff o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
    }

    public void editStaff(Staff employee, String id) {
        for (int i = 0; i < staff.size(); i++) {
            if (id.equals(staff.get(i).getStaff())) {
                staff.set(i, employee);
                break;
            }
        }
        readAndWrite.writeToFile(staff);
    }

    public void addStaff (Staff staffs) {
        staff.add(staffs);
        readAndWrite.writeToFile(staff);
    }

    public void display ( ) { // in theo cách thường
        for (Staff staff : staff) {
            System.out.println(staff);
        }
    }
}