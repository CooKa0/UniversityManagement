package university.interfaces;

public interface EventOrganizable extends Organizable, Identifiable {
    void createEvent();
    void modifyEvent();
}