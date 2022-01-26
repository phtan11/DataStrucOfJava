public class User{
    private int userID;
    private String userName;
    private int age;
    private String gender;
    private String job;
    public User(){
        this.userID =0;
        this.userName ="";
        this.age = 0;
        this.gender = "";
        this.job = "";
    }
    public User(int userID, String userName, int age, String gender, String job) {
        this.userID = userID;
        this.userName = userName;
        this.age = age;
        this.gender = gender;
        this.job = job;
    }
    public int getUserID() {
        return userID;
    }
    public void setUserID(int userID) {
        this.userID = userID;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getJob() {
        return job;
    }
    public void setJob(String job) {
        this.job = job;
    }
    @Override
    public String toString() {
        return "User[" + getUserID() + "," + getUserName() + "," + getAge() + "," + getGender() + "," + getJob() + "]";
    }
}