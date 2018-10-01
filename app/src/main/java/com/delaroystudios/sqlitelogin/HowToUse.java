package com.delaroystudios.sqlitelogin;

import java.util.ArrayList;

public class HowToUse {

    public void test() {

/*

        //ประกาศ Class   RoomDB roomDB = new RoomDB(context ของ Activity,ปี,เดือน,วัน,ค่าสูงสุดของแต่ละห้อง กรณีสร้างห้องแบบอัตโนมัติ);
        RoomDB roomDB = new RoomDB(this.ACTIVITY,"2018","09","20",10);

        - เปลี่ยนจำนวนคนในห้อง roomDB.changeCapacity(เวลา(ชั่วโมง),เวลา(นาที),จำนวนคนที่ต้องการ);
        roomDB.changeCapacity(8,30,20);

        - จองห้อง roomDB.booking(เวลา(ชั่วโมง),เวลา(นาที),ชื่อ,เบอร์โทร,ประเภทการตรวจ(อิงเป็นไอดี)); ส่งค่ากลับมาเป็น จริงหรือเท็จ
        Boolean bool = roomDB.booking(8,30,"ชัยวิวัฒน์","09XXXXXXXX",0);

        - เช็คว่าห้องว่างหรือไม่? roomDB.isSpace(เวลา(ชั่วโมง),เวลา(นาที)); ส่งค่ากลับมาเป็น จริงหรือเท็จ
        Boolean bool = roomDB.isSpace(8,30);

        - ดูข้อมูลห้องใดห้องนึง ค้นจากเวลา
        RoomDB.Room room = roomDB.infoRoom(8,30);

        Integer integer = room.getHOUR();         เวลา(ชั่วโมง)           ส่งค่ากลับมาเป็น ตัวเลข
        Integer integer = room.getMINUTE();       เวลา(นาที)             ส่งค่ากลับมาเป็น ตัวเลข
        Integer integer = room.getCURRENT();      จำนวนคนในห้อง          ส่งค่ากลับมาเป็น ตัวเลข
        Integer integer = room.getCAPACITY();     จำนวนคนสูงสุดของห้อง     ส่งค่ากลับมาเป็น ตัวเลข

        - ดูรายชื่อห้องทั้งหมด
        ArrayList<RoomDB.Room> listRoom = roomDB.asAllRoom();               // ส่งค่ากลับมาเป็น ArrayList ของ RoomDB.Room

        - ดูรายชื่อห้องทั้งหมด ค้นจากเวลาชื่อ
        ArrayList<RoomDB.Room> listRoom = roomDB.asName("ชัยวิวัฒน์");          // ส่งค่ากลับมาเป็น ArrayList ของ RoomDB.Room

        - ดูรายชื่อห้องทั้งหมด ค้นจากเวลาเบอร์โทร
        ArrayList<RoomDB.Room> listRoom = roomDB.asPhone("09XXXXXXXX");     // ส่งค่ากลับมาเป็น ArrayList ของ RoomDB.Room

        - ดูรายชื่อห้องทั้งหมด ประเภทการตรวจ
        ArrayList<RoomDB.Room> listRoom = roomDB.asCategory(0);             // ส่งค่ากลับมาเป็น ArrayList ของ RoomDB.Room

        Integer integer = listRoom.get(0).getHOUR();         เวลา(ชั่วโมง)           ส่งค่ากลับมาเป็น ตัวเลข
        Integer integer = listRoom.get(0).getMINUTE();       เวลา(นาที)             ส่งค่ากลับมาเป็น ตัวเลข
        Integer integer = listRoom.get(0).getCURRENT();      จำนวนคนในห้อง          ส่งค่ากลับมาเป็น ตัวเลข
        Integer integer = listRoom.get(0).getCAPACITY();     จำนวนคนสูงสุดของห้อง     ส่งค่ากลับมาเป็น ตัวเลข

          - ดูรายชื่อคนที่จองทั้งหมด
        ArrayList<RoomDB.Person> listPerson = roomDB.asAllPerson();               // ส่งค่ากลับมาเป็น ArrayList ของ RoomDB.Person

         - ดูรายชื่อคนที่จองห้องทั้งหมด ค้นจากเวลาห้อง
        ArrayList<RoomDB.Person> listPerson = roomDB.asRoom(8,30);              // ส่งค่ากลับมาเป็น ArrayList ของ RoomDB.Person

        String string = listPerson.get(0).getNAME();              ชื่อ                          ส่งค่ากลับมาเป็น ตัวอักษร
        String string = listPerson.get(0).getPHONE();             เบอร์โทร                     ส่งค่ากลับมาเป็น ตัวอักษร
        Integer integer = listPerson.get(0).getCATEGORY();        ประเภทการตรวจ(อิงเป็นไอดี)     ส่งค่ากลับมาเป็น ตัวเลข


*/




    }

}
