package DAO_Files;

//Creating a runtime exception method to return a string message during runtime
public class DAOException extends RuntimeException {
    public DAOException(String message) {
        super(message);
    }
    public DAOException(String message, Throwable cause) {
        super(message, cause);
    }
}
