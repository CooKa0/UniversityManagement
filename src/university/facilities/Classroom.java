package university.facilities;

public class Classroom {
    private String roomNumber;
    private int capacity;

    public Classroom(String roomNumber, int capacity) {
        this.roomNumber = roomNumber;
        this.capacity = capacity;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getClassroomInfo() {
        return "Room Number: " + roomNumber + ", Capacity: " + capacity;
    }
}