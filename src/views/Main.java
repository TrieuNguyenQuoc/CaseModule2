package views;


import controller.Manager;
import model.HardStaff;
import model.Intern;
import model.Staff;
import storage.ReadAndWrite;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Staff> staffs;
    static {
        try {
            staffs = ReadAndWrite.readDataFromFile();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static Manager manager = new Manager(staffs);

    public static ReadAndWrite demo = new ReadAndWrite();
    public static Scanner input = new Scanner(System.in);
    public static int checkInput;


    public static void main(String[] args) {

        do {
            System.out.println("----------Menu----------");
            System.out.println("""
                            ¦---------------------------------------------------------------¦
                            ¦1. Thêm nhân viên vào danh sách                                ¦
                            ¦2. Hiển thị danh sách nhân viên                                ¦
                            ¦3. Sửa dữ liệu nhân viên                                       ¦
                            ¦4. Xóa nhân viên trong danh sách                               ¦
                            ¦5. Hiển thị trung bình lương tất cả nhân viên công ty          ¦
                            ¦6. Danh sách nhân viên Fulltime lương thấp hơn trung bình      ¦
                            ¦7. Số tiền phải trả cho nhân viên parttime                     ¦
                            ¦8. Bảng lương nhân viên fulltime theo thứ tự từ thấp đến cao   ¦
                            ¦0. Thoát khỏi chương trình                                     ¦
                            ¦---------------------------------------------------------------¦
                            """);
            checkInput = Integer.parseInt(input.nextLine());
            switch (checkInput) {
                case 1 -> {
                    manager.addStaff(addNewStaff());

                }
                case 2 -> {
                    manager.display();
                }
                case 3 -> editStaffs();
                case 4 -> manager.removeStaffs();
                case 5 -> System.out.println("Trung bình lương tất cả nhân viên công ty là : " +
                        manager.averageSalary());
                case 6 -> System.out.println("Danh sách nhân viên Fulltime lương thấp hơn trung bình: " +
                        manager.checkSalaryFullTime());
                case 7 -> System.out.println("Số tiền phải trả cho nhân viên parttime là: " +
                        manager.averageSalary ());
                case 8 -> {
                    System.out.println("Xếp lương nhân viên fulltime theo thứ tự từ thấp đến cao: ");
                    manager.sortSalary();
                }
                case 0 -> System.out.println("Hẹn gặp lại sau.");
                default -> System.out.println("Vui lòng nhập lại!");
            }
        } while (checkInput != 0);
    }


    public static Staff addNewStaff() {
        System.out.println("""
                ¦---------------------------------¦
                ¦    Bạn muốn thêm thành phần nào:¦
                ¦1. nhân viên fulltime            ¦
                ¦2. nhân viên parttime            ¦
                ¦---------------------------------¦
                """);
        checkInput = Integer.parseInt(input.nextLine());
        switch (checkInput) {
            case 1 -> {
                System.out.print("Nhập vào mã nhân viên: ");
                String employeeCode = input.nextLine();
                System.out.print("Nhập vào tên nhân viên: ");
                String name = input.nextLine();
                System.out.print("Nhập vào tuổi: ");
                int age = Integer.parseInt(input.nextLine());
                System.out.print("Nhập vào sđt: ");
                String phone = input.nextLine();
                System.out.print("Nhập vào email: ");
                String email = input.nextLine();
                System.out.print("Nhập vào tiền thưởng: ");
                double bonus = Integer.parseInt(input.nextLine());
                System.out.print("Nhập vào tiền phạt: ");
                double fine = Integer.parseInt(input.nextLine());
                System.out.print("Nhập vào lương cơ bản: ");
                double salary = Integer.parseInt(input.nextLine());
                return new HardStaff(employeeCode, name, age, phone, email, bonus, fine, salary);

            }
            case 2 -> {
                System.out.print("Nhập vào mã nhân viên:");
                String employeeCode = input.nextLine();
                System.out.print("Nhập vào tên nhân viên:");
                String name = input.nextLine();
                System.out.print("Nhập vào tuổi:");
                int age = Integer.parseInt(input.nextLine());
                System.out.print("Nhập vào sđt:");
                String phone = input.nextLine();
                System.out.print("Nhập vào email:");
                String email = input.nextLine();
                System.out.print("Nhập số giờ làm việc:");
                int workingHours = Integer.parseInt(input.nextLine());
                return new Intern(employeeCode, name, age, phone, email, workingHours);
            }
            default -> System.out.println("Xin nhập lại, 1 hoặc 2");
        }
        return null;
    }
    public static void editStaffs() {
        if (staffs.isEmpty()) {
            System.out.println("Danh sách trống!");
        } else {
            String newName;
            int newAge;
            String address;
            String newPhone;
            String newEmail;
            double newHardSalary;
            int newWorkTime;
            Staff staff;
            int bonus;
            int fine;
            System.out.println(" Nhập id muốn sửa: ");
            String id = input.nextLine();
            for (Staff e : staffs) {
                if (id.equals(e.getStaff())) {
                    if (e instanceof HardStaff) {
                        System.out.println("Nhập tên :");
                        newName = input.nextLine();
                        System.out.println("Nhập tuổi: ");
                        newAge = input.nextInt();
                        System.out.println(" Nhập địa chỉ:");
                        address = input.nextLine();
                        System.out.println("SĐT: ");
                        newPhone = input.nextLine();
                        System.out.println("Nhập email: ");
                        newEmail = input.nextLine();
                        System.out.println(" Lương cứng: ");
                        newHardSalary = input.nextInt();
                        System.out.println("bonus: ");
                        bonus = input.nextInt();
                        System.out.println("bonus: ");
                        fine = input.nextInt();
                        staff = new HardStaff(id, newName, newAge, newPhone, newEmail,bonus,fine, newHardSalary);
                        manager.editStaff(staff,id);
                    } else if (e instanceof Intern) {
                        System.out.println("Mời bạn nhập tên nhân viên : ");
                        newName = input.nextLine();
                        System.out.println("Mời bạn nhập tuổi nhân viên : ");
                        newAge = input.nextInt();
                        System.out.println("xin moi bạn nhap so dien thoai");
                        newPhone = input.nextLine();
                        System.out.println("Mời bạn nhập số giờ làm việc : ");
                        newWorkTime = input.nextInt();
                        System.out.println("Mời bạn nhập địa chỉ nhân viên : ");
                        newEmail = input.nextLine();
                        System.out.println("xin moi nhap so gio lam");
                        newWorkTime=input.nextInt();
                        staff = new Intern(id, newName, newAge, newPhone,newEmail,newWorkTime);
                        manager.editStaff(staff, id);
                    }
                }
            }
        }
    }
}