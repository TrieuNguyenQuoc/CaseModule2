import java.util.Scanner;

public class Login {
    private Scanner scanner;
    private String username;
    private int password;
    private Object managerLecturers;

    public boolean loGinUserName(){
        System.out.println("xin mời nhập tên đang nhập");
        String username1=scanner.nextLine();
        if (username1.equalsIgnoreCase(username)){
            return true;
        }else return false;
    }public boolean loginPassword(){
        System.out.println("nhập mật khẩu");
        int password1=scanner.nextInt();
        if (password1==password){
            return true;
        }else return false;
    }public void checkLogin(){
        if (loGinUserName()&&loginPassword()){
            boolean equals;
            if (managerLecturers.equals(1)) equals = true;
            else equals = false;
        }else {
            System.out.println("xin mời đăng nhập lại");
            checkLogin();
        }
    }
}
