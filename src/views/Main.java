package views;

//import Controller.Manager;

import model.HardStaff;
import model.Intern;
import model.Staff;
import storage.ReadAndWrite;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<Staff> employees;
    private static List<Staff> staff;

    static {
        try {
            employees = ReadAndWrite.readDataFromFile();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static Manager manager = new Manager(employees);
    public static ReadAndWrite demo = new ReadAndWrite();
    public static Scanner input = new Scanner(System.in);
    public static int checkInput;


    public static void main(String[] args) {
        do {
            System.out.println("----------Menu----------");
            System.out.println("""
                            ¦~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~¦
                            ¦1. Thêm nhân viên vào danh sách                                ¦
                            ¦2. Hiển thị danh sách nhân viên                                ¦
                            ¦3. Sửa dữ liệu nhân viên                                       ¦
                            ¦4. Xóa nhân viên trong danh sách                               ¦
                            ¦5. Hiển thị trung bình lương tất cả nhân viên công ty          ¦
                            ¦6. Danh sách nhân viên Fulltime lương thấp hơn trung bình      ¦
                            ¦7. Số tiền phải trả cho nhân viên parttime                     ¦
                            ¦8. Bảng lương nhân viên fulltime theo thứ tự từ thấp đến cao   ¦
                            ¦9. số nhân viên hiện có của công ty                            ¦
                            ¦0. Thoát khỏi chương trình                                     ¦
                            ¦~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~¦
                            """);
            checkInput = Integer.parseInt(input.nextLine());
            switch (checkInput) {
                case 1 -> {
                    manager.addStaff(addNewEmployee());
                    demo.writeToFile (staff);
                }
                case 2 -> {
                    List<Staff> list = demo.readDataFromFile();
                    for (Staff demo: list) {
                        System.out.println(demo);
                    }
                }


                case 3 -> manager.editStaff(editStaff());
                case 4 -> manager.removeStaff();
                case 5 -> System.out.println("Trung bình lương tất cả nhân viên công ty là : " +
                        manager.averageSalary());
                case 6 -> System.out.println("Danh sách nhân viên Fulltime lương thấp hơn trung bình: " +
                        manager.checkSalaryHardStaff());
                case 7 -> System.out.println("Số tiền phải trả cho nhân viên parttime là: " +
                        manager.totalSalaryIntern());
                case 8 -> System.out.println("Xếp lương nhân viên fulltime theo thứ tự từ thấp đến cao: " +
                        manager.sortSalary());
                case 0 -> System.out.println("Hẹn gặp lại sau.");
                default -> System.out.println("Vui lòng nhập lại!");
            }
        } while (checkInput != 0);
    }

    private static Object editStaff() {

        return null;
    }

    public static Staff addNewEmployee() {
        System.out.println("""
                ¦~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~¦
                ¦    Bạn muốn thêm thành phần nào:¦
                ¦1. nhân viên fulltime            ¦
                ¦2. nhân viên parttime            ¦
                ¦~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~¦
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
    public static Staff editEmployee() {
        System.out.println("""
                ¦~~~~~~~~~~~~~~~~~~~~~~~~~~~~¦
                ¦Bạn muốn sửa thành phần nào:¦
                ¦1. nhân viên fulltime       ¦
                ¦2. nhân viên parttime       ¦
                ¦~~~~~~~~~~~~~~~~~~~~~~~~~~~~¦
                """);

        checkInput = Integer.parseInt(input.nextLine());
        switch (checkInput) {
            case 1 -> {
                System.out.print("Nhập vào mã nhân viên mới:");
                String newEmployeeCode = input.nextLine();
                System.out.print("Nhập vào tên nhân viên mới:");
                String newName = input.nextLine();
                System.out.print("Nhập vào tuổi:");
                int newAge = Integer.parseInt(input.nextLine());
                System.out.print("Nhập vào sđt mới:");
                String newPhone = input.nextLine();
                System.out.print("Nhập vào email mới:");
                String newEmail = input.nextLine();
                System.out.print("Nhập vào tiền thưởng mới:");
                double Newbonus = Integer.parseInt(input.nextLine());
                System.out.print("Nhập vào tiền phạt mới:");
                double Newfine = Integer.parseInt(input.nextLine());
                System.out.print("Nhập vào lương cơ bản của nhân viên mới:");
                double newSalary = Integer.parseInt(input.nextLine());
                return new HardStaff(newEmployeeCode, newName, newAge, newPhone, newEmail,Newbonus, Newfine, newSalary);
            }
            case 2 -> {
                System.out.print("Nhập vào mã nhân viên mới: ");
                String newEmployeeCode = input.nextLine();
                System.out.print("Nhập vào tên nhân viên mới: ");
                String newName = input.nextLine();
                System.out.print("Nhập vào tuổi: ");
                int newAge = Integer.parseInt(input.nextLine());
                System.out.print("Nhập vào sđt mới: ");
                String newPhone = input.nextLine();
                System.out.print("Nhập vào email mới: ");
                String newEmail = input.nextLine();
                System.out.print("Nhập số giờ làm việc mới:");
                int NewWorkingHours = Integer.parseInt(input.nextLine());
                return new Intern(newEmployeeCode, newName, newAge, newPhone, newEmail, NewWorkingHours);
            }
            default -> System.out.println("Xin nhập lại, 1 hoặc 2");
        }
        return null;
    }
}