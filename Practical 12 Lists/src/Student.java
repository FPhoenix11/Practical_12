public class Student
{
    int studentID;
    double averageGrade;

    //when called, it will get the student ID and set it
    public Student(Integer ID)
    {
        this.setStudentID(ID);
    }

    //sets the student ID
    public void setStudentID(Integer ID)
    {
        this.studentID = ID;
    }

    //returns the student ID to be used by the main
    int getStudentID()
    {
        return this.studentID;
    }

    //sets the average grade
    public void setAverageGrade(double avScore)
    {
        this.averageGrade = avScore;
    }

    //returns the average grade to be used by the main
    double getAverageGrade()
    {
        return this.averageGrade;
    }
}
