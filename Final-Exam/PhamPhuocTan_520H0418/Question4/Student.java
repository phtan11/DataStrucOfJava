public class Student {
    private String studentID;
    private String fullnName;
    private double cumulativeGPA;
    private String classID;
    private String gender;
    public Student(String studentID, String fullnName, double cumulativeGPA, String classID, String gender) {
        this.setStudentID(studentID);
        this.setFullnName(fullnName);
        this.setCumulativeGPA(cumulativeGPA);
        this.setClassID(classID);
        this.setGender(gender);
    }
    public Student(){
        this.setStudentID("");
        this.setFullnName("");
        this.setCumulativeGPA(0.0);
        this.setClassID("");
        this.setGender("");
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getClassID() {
        return classID;
    }
    public void setClassID(String classID) {
        this.classID = classID;
    }
    public double getCumulativeGPA() {
        return cumulativeGPA;
    }
    public void setCumulativeGPA(double cumulativeGPA) {
        this.cumulativeGPA = cumulativeGPA;
    }
    public String getFullnName() {
        return fullnName;
    }
    public void setFullnName(String fullnName) {
        this.fullnName = fullnName;
    }
    public String getStudentID() {
        return studentID;
    }
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }
    @Override
    public String toString() {
        return "student[" + getStudentID()  + "," + getFullnName() + "," + getCumulativeGPA() + "," + getClassID() + "," + getGender()+"]";
    }
}
