

import java.io.Serializable;

public class Room implements Serializable {
    private String RoomNumber; // số phòng
    private String KindOfRoom; // loại phòng
    private int RoomRates; // giá phòng
    private String Prevention; // phòng chống
    private String RentedRoom; // phòng đã thuê
    private String BusinessRoom; // phòng thương gia
    private String NormalRoom; // phòng thường


    public Room(String soPhong, String loaiPhong, int gia, String phongChong, String daThue) {
        this.RoomNumber = soPhong;
        this.KindOfRoom = loaiPhong;
        this.RoomRates = gia;
        this.Prevention = phongChong;
        this.RentedRoom = daThue;
//        this.BusinessRoom = thuonggia;
//        this.NormalRoom = thuong;
    }

    public String getsoPhong() {
        return RoomNumber;
    }

    public void setsoPhong(String soPhong) {
        this.RoomNumber = soPhong;
    }

    public String getloaiPhong() {
        return KindOfRoom;
    }

    public void setloaiPhong(String loaiPhong) {
        this.KindOfRoom = loaiPhong;
    }

    public int getgia() {
        return RoomRates;
    }

    public void setgai(int gia) {
        this.RoomRates = gia;
    }

    public String getphongChong() {
        return Prevention;
    }

    public void setphongChong(String phongChong) {
        this.Prevention = phongChong;
    }

    public String getdaThue() {
        return RentedRoom;
    }

    public void setdathue(String daThue) {
        this.RentedRoom = daThue;
    }
//    public String getNormalRoom() {
//        return NormalRoom ;
//    }
//
//    public void setNormalRoom(String employeeCode) {
//        this.NormalRoom = employeeCode;
//    }

}
