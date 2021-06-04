package HomeworkFour;

public class UserInformation {



    String emailCreate = "emailSeleniumQa"+getRandomIntegerBetweenRange(1, 3333) +"@mail.com";


    public String getEmailCreate() {
        return emailCreate;
    }

    public static Integer getRandomIntegerBetweenRange(int min, int max){
        int x = (int) ((Math.random()*((max-min)+1))+min);
        return x;
    }



}
