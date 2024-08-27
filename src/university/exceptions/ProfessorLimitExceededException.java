package university.exceptions;

public class ProfessorLimitExceededException extends Exception {
    public ProfessorLimitExceededException(String message) {
        super(message);
    }
}