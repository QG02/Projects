package Source_Files;


public enum Gender {

    //Define what the enum values correspond to
    //Female --> 1 in the database
    FEMALE(1),
    //Male --> 2 in the database
    MALE(2);

    private final int description;

    //Matches the description with the value
    private Gender(int d){
        description = d;
    }
}
