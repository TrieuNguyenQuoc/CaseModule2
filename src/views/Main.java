package views;

import controller.Manager;
import model.Staff;
import model.HardStaff;
import model.Intern;
import storage.ReadAndWrite;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<Staff> Staff;

    static {
        try {
            Staff = ReadAndWrite.readDataFromFile();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static Manager manager = new Manager(Staff);
    public static ReadAndWrite demo = new ReadAndWrite();
    public static Scanner input = new Scanner(System.in);
    public static int checkInput;


    public static void main(String[] args) {
        do {
            System.out.println("~~~~~~~~~~~~~~~Menu~~~~~~~~~~~~~~~");
            System.out.print("""
                           ¦---------------------------------------------------------------¦
                           ¦1. Thêm nhân viên vào danh sách                                ¦
                           ¦ 2. Hiển thị danh sách nhân viên                               ¦
                           ¦ 3. Sửa dữ liệu nhân viên                                      ¦
                           ¦ 4. Xóa nhân viên trong danh sách                              ¦
                           ¦ 5. Hiển thị trung bình lương tất cả nhân viên công ty         ¦
                           ¦ 6. Danh sách nhân viên Fulltime lương thấp hơn trung bình     ¦
                           ¦ 7. Số tiền phải trả cho nhân viên parttime                    ¦
                           ¦ 0. Thoát khỏi chương trình                                    ¦
                            
                            """);

            checkInput = Integer.parseInt(input.nextLine());
            switch (checkInput) {
                case 1 -> {
                    manager.addStaff(addNewStaff());
                    demo.writeToFile (Staff);
                }
                case 2 -> {
                    List<Staff> list = demo.readDataFromFile();
                    for (Staff demo2: list) {
                        System.out.println(demo2);
                    }
                }


//                case 3 -> manager.editStaff(editStaff());

                case 4 -> manager.removeStaff();
                case 5 -> System.out.println("Trung bình lương lương công ty trả cho nhân viên là : " +
                        manager.averageSalary());
                case 6 -> System.out.println("Danh sách nhân viên thực tập lương thấp hơn trung bình: " +
                        manager.checkSalaryFullTime());
                case 7 -> System.out.println("Số tiền công ty trả cho nhân viên cứng là: " +
                        manager.totalSalaryPartTime());
                case 0 -> System.out.println("Hẹn gặp lại sau.");
                default -> System.out.println("Vui lòng nhập lại!");
            }
        } while (checkInput != 0);
    }
    public static model.Staff addNewStaff() {
        System.out.println("""
             ¦~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~¦       
             ¦        Bạn muốn thêm ai vào công ty:  ¦  
             ¦   1. nhân viên cứng                   ¦  
             ¦   2. nhân viên thực tập               ¦ 
             ¦~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~¦   
        """);
        checkInput = Integer.parseInt(input.nextLine());
        switch (checkInput) {
            String staff = null;
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
                double salary = Integer.parseInt(input.nextLine());
                System.out.print("Nhập vào lương cơ bản: ");
                HardStaff staff1 = new HardStaff(staff1, name, age, phone, email, bonus, fine, salary);
                return staff1;
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
//                Intern intern = new Intern(staff, name, age, phone, email, workingHours);
//                return intern;
            }
            default -> System.out.println("nhập lại, 1 hoặc 2");
        }
        return null;
    }
    public static Staff editStaffe() {
        System.out.println("""
              ¦~~~~~~~~~~~~~~~~~~~~~~~~~~~~~¦        
              ¦     Bạn muốn sửa mục nào:   ¦   
              ¦  1. nhân viên cứng          ¦   
              ¦  2. nhân viên thực tập      ¦
              ¦~~~~~~~~~~~~~~~~~~~~~~~~~~~~~¦  
        """);
        checkInput = Integer.parseInt(input.nextLine());
        switch (checkInput) {
            case 1 -> {
                System.out.print("Nhập mã nhân viên:");
                String newEmployeeCode = input.nextLine();
                System.out.print("Nhập tên nhân viên:");
                String newName = input.nextLine();
                System.out.print("Nhập tuổi:");
                int newAge = Integer.parseInt(input.nextLine());
                System.out.print("Nhập sđt:");
                String newPhone = input.nextLine();
                System.out.print("Nhập email:");
                String newEmail = input.nextLine();
                System.out.print("Nhập tiền thưởng:");
                double Newbonus = Integer.parseInt(input.nextLine());
                System.out.print("Nhập tiền phạt:");
                double Newfine = Integer.parseInt(input.nextLine());
                System.out.print("Nhập lương của nhân viên:");
                double newSalary = Integer.parseInt(input.nextLine());
                return new HardStaff(newEmployeeCode, newName, newAge, newPhone, newEmail,Newbonus, Newfine, newSalary);
            }
            case 2 -> {
                System.out.print("Nhập mã nhân viên: ");
                String newStaff = input.nextLine();
                System.out.print("Nhập tên nhân viên : ");
                String newName = input.nextLine();
                System.out.print("Nhập tuổi: ");
                int newAge = Integer.parseInt(input.nextLine());
                System.out.print("Nhập sđt: ");
                String newPhone = input.nextLine();
                System.out.print("Nhập email: ");
                String newEmail = input.nextLine();
                System.out.print("Nhập số giờ làm việc của nhân viên:");
                int NewWorkingHours = Integer.parseInt(input.nextLine());
                return new Intern(newStaff, newName, newAge, newPhone, newEmail, NewWorkingHours);
            }
            default -> System.out.println("Nhập lại, 1 hoặc 2");
        }
        return null;
    }
}