/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loginandsignup;

/**
 *
 * @author johne
 */
public class SharedData {
     private static SharedData instance;
    private String teacher_id;

    private SharedData() {}

    public static SharedData getInstance() {
        if (instance == null) {
            instance = new SharedData();
        }
        return instance;
    }

    public String getTeachersId() {
        return teacher_id;
    }

    public void setTeachersId(String teachersId) {
        this.teacher_id = teachersId;
    }
}
