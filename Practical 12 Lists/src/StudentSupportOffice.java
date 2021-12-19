import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentSupportOffice
{
    //these are the lists that will contain the instances of the classes students, modules and grades
    public static List<Student> students = new ArrayList<Student>();
    public static List<Module> modules = new ArrayList<Module>();
    public static List<Grade> grades = new ArrayList<Grade>();

    public static void main(String[] args)
    {
        menu();
    }

    //this function is designed to be a basic menu system is designed to give a basic user input so they can add
    //students to a course or module
    public static void menu()
    {
        //these are the only modules that this code will create using module ID
        modules.add(new Module("CIS2344"));
        modules.add(new Module("CIS2360"));
        modules.add(new Module("CIM2130"));

        //this scanner variable is made to detect and help store a user input in the terminal
        Scanner userInput = new Scanner(System.in);
        boolean menuLoop = true;

        //this loop is designed to the user can select an option of which they would like to do or see.
        while (menuLoop == true)
        {
            //will be used to work out what the user wishes to do
            System.out.println("Type a number for the option you wish below:\n");
            System.out.println("1 - Add a new student\n");
            System.out.println("2 - List students\n");
            System.out.println("3 - Enter a students grades for a module\n");
            System.out.println("4 - Find out the average grades of a student\n");
            System.out.println("5 - Find out the average grades of a module\n");
            System.out.println("6 - Remove a grade for a student in a specific module\n");
            System.out.println("7 - Exit\n");
            int selection = userInput.nextInt();
            System.out.println("\n");

            //these ifs will go to a certain function to do the task that the user entered above
            if (selection == 1)
            {
                newStudent();
            }
            else if (selection == 2)
            {
                listStudent();
            }
            else if (selection == 3)
            {
                createGrade();
            }
            else if (selection == 4)
            {
                studentAverage();
            }
            else if (selection == 5)
            {
                moduleAverage();
            }
            else if (selection == 6)
            {
                gradeRemoval();
            }
            else if (selection == 7)
            {
                System.exit(0);
            }

        }
    }

    //this procedure is used to create a new instance of the student class and have it saved in the student list
    public static void newStudent()
    {
        System.out.println("Enter the new student ID \n");
        Scanner userInput = new Scanner(System.in);
        int studentID = userInput.nextInt();
        students.add(new Student(studentID));
        System.out.println("\n");
    }

    //this will list the student IDs in order of their appearance in the array
    public static void listStudent()
    {
        for (int i = 0;i < students.size();i++)
        {
            System.out.println(students.get(i).getStudentID() + "\n");
        }
    }

    //this procedure is made to create a new instance of the grades class that will store a students grade for a module
    public static void createGrade()
    {
        int modPosition = selectModule();
        int studentID = findStudent();
        boolean gradeChecker = false;
        int gradePosition = 0;

        //this part of the program will check to see if the student already has a grade for a module, so it can just
        //change that instead
        for (int i = 0;i<grades.size();i++)
        {
            if (grades.get(i).getModule() == modules.get(modPosition).getModuleID())
            {
                if (grades.get(i).getStudent() == students.get(studentID).getStudentID()){
                    gradeChecker = true;
                    gradePosition = i;
                }
            }
        }

        boolean scoreChecker = true;
        int scoreInput = 0;

        //this will check to see if the inputted score is less than or equal to 100 as it refers to a percentage
        while (scoreChecker == true)
        {
            System.out.println("What is the students score out of 100: \n");
            Scanner checkInput = new Scanner(System.in);
            scoreInput = checkInput.nextInt();
            if (scoreInput <= 100)
            {
                scoreChecker = false;
            }
        }

        //this creates a new element to the list if the grade doesn't exist for that user for that module
        if (gradeChecker = false)
        {
            grades.add(new Grade());
            gradePosition = grades.size() - 1;
        }

        //these three lines add the elements to the element in the list
        grades.get(gradePosition).setModule(modules.get(modPosition).getModuleID());
        grades.get(gradePosition).setStudent(students.get(studentID).getStudentID());
        grades.get(gradePosition).setScore(scoreInput);
    }

    //this function selects the module that user wants to use
    static int selectModule()
    {
        boolean checker = true;
        Scanner checkInput = new Scanner(System.in);
        int moduleInput = 0;
        while (checker == true)
        {
            System.out.println("Select the number next to the module the student is on:\n");
            for (int i = 0;i<modules.size();i++){
                System.out.println(String.valueOf(i) + " - " + modules.get(i) + "\n");
            }
            moduleInput = checkInput.nextInt();
            if (moduleInput < modules.size())
            {
                checker = false;
            }
        }
        return moduleInput;
    }

    //this function finds the student that user wants to use
    static int findStudent()
    {
        int studentPosition = 0;
        boolean checker = true;
        Scanner checkInput = new Scanner(System.in);
        while (checker == true)
        {
            System.out.println("Type the student ID number in:\n");
            int studentInput = checkInput.nextInt();
            for (int i = 0; i < students.size(); i++)
            {
                if ((students.get(i)).getStudentID() == studentInput)
                {
                    studentPosition = i;
                    checker = false;
                }
            }
            System.out.println("\n");
        }
        return studentPosition;
    }

    //this helps calculate and give the average to for individual students, making sure its up to date
    public static void studentAverage()
    {
        int studentPos = findStudent();
        double studentGrade = 0;
        double count = 0;
        for (int i = 0;i < grades.size();i++)
        {
            if (grades.get(i).getStudent() == students.get(studentPos).getStudentID())
            {
                studentGrade += grades.get(i).getScore();
                count += 1.0f;
            }
        }
        studentGrade = studentGrade/count;
        students.get(studentPos).setAverageGrade(studentGrade);
        System.out.println(students.get(studentPos).getAverageGrade() + " is their average grade across all modules. \n");
    }

    //this calculates the average for a select module and save it into the module class.
    public static void moduleAverage()
    {
        int modulePos = selectModule();
        double moduleGrade = 0;
        double count = 0;
        for (int i = 0;i < grades.size();i++)
        {
            if (grades.get(i).getModule() == modules.get(modulePos).getModuleID())
            {
                moduleGrade = moduleGrade + grades.get(i).getScore();
                count = count + 1;
            }
        }
        moduleGrade = moduleGrade/count;
        modules.get(modulePos).setAverageMG(moduleGrade);
        System.out.println(modules.get(modulePos).getAverageMG() + " is the average grade across all students. \n");
    }

    //this will delete a instance of a particular grade using the student ID and module ID
    public static void gradeRemoval()
    {
        boolean check = true;
        int gradesPos = -1;

        while (check == true)
        {
            int studentPos = findStudent();
            int modulePos = selectModule();

            for (int i = 0;i<grades.size();i++)
            {
                if (grades.get(i).getModule() == modules.get(modulePos).getModuleID())
                {
                    if (grades.get(i).getStudent() == students.get(studentPos).getStudentID())
                    {
                        gradesPos = i;
                    }
                }
            }

            if (gradesPos >= 0)
            {
                check = false;
            }
        }

        grades.remove(gradesPos);
    }
}