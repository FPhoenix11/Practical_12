public class Grade
{
    String module;
    int student;
    double score;

    //gets the module for the main class
    String getModule()
    {
        return this.module;
    }

    //gets the student for the main class
    int getStudent()
    {
        return this.student;
    }

    //gets the score for the main class
    double getScore()
    {
        return this.score;
    }

    //sets the module variable
    void setModule(String mod)
    {
        this.module = mod;
    }

    //sets the student variable
    void setStudent(int stu)
    {
        this.student = stu;
    }

    //sets the score variable
    void setScore(double mark)
    {
        this.score = mark;
    }
}
