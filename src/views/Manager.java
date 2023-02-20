package views;

import model.Staff;
import model.HardStaff;
import model.Intern;

import java.util.*;

public class Manager {
    public List<Staff> staff;

    public Manager(List<Staff> staff) {
        this.staff = staff;
    }
    public void aadStaff(Staff staff) {
        staff.add();
    } // thêm đối tượng

    public void display() { // in theo cách thường
        for (Staff staff : staff) {
            System.out.println(staff);
        }
    }

    int index;
    Scanner input = new Scanner(System.in);
    public void editStaff(Staff staff) {
        System.out.print("Nhập vị trí muốn sửa: ");
        index = input.nextInt();
        for (int i = 0; i < staff.size(); i++) {
            if (i == index) {
                staff.set(i);
            }
        }
    }

    public double averageSalary() { // trung bingf lương
        double totalSalary = 0;
        for (Staff staff : staff) {
            if (staff instanceof Intern) {
                totalSalary += ((Intern) staff).salaryPartTime();
            }
            if (staff instanceof HardStaff) {
                totalSalary += ((Intern) staff).salaryHardStaff();
            }
        }
        return totalSalary / staff.size(); // số lượng ptu trong mảng
    }

    public String checkSalaryHardStaff() { // lấy danh sách nv full lương thấp hơn bt
        StringBuilder nameHardStaff = new StringBuilder();
        for (Staff staff : staff) {
            if (staff instanceof HardStaff) {
                if (((HardStaff) staff).salaryFullTime() < averageSalary()) {
                }
            }
        } return nameHardStaff .toString();
    }

//    public String totalSalaryIntern() { // tính tổng lương part
//        double totalSalaryHardStaff  = 0;
//        for (Staff staff : staff) {
//            if (staff instanceof Intern) {
//                totalSalaryHardStaff  += ((Intern) staff).salaryPartTime();
//            }
//        }
////        return totalSalaryIntern();
//    }
    public List<HardStaff> sortSalary(){
        List<HardStaff> staffsHardStaff  = new ArrayList<>();
        for (Staff staff: staff) {
            if (staff instanceof HardStaff) {
                HardStaff .add();
            }
        }
        List<HardStaff> HardStaff = null;
        Collections.sort(HardStaff );
        return HardStaff ;
    }

    public void editStaff(Object editStaff) {
    }

    public String totalSalaryIntern ( ) {
        return null;
    }

    public void addStaff(Staff aadStaff) {

    }
}

