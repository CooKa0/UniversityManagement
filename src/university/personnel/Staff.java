package university.personnel;

public class Staff {
    private String name;
    private String position;

    public Staff(String name, String position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getStaffDetails() {
        return "Staff: " + name + ", Position: " + position;
    }
}