public class Module
{
    String moduleID;
    double averageMG;

    //creates the module class and uses the string ID
    public Module(String ID){
        this.setModuleID(ID);
    }

    //sets the module ID
    public void setModuleID(String ID)
    {
        this.moduleID = ID;
    }

    //gets the module ID to be used in main
    public String getModuleID()
    {
        return moduleID;
    }

    //sets the average grade for the module
    public void setAverageMG(double grade)
    {
        this.averageMG = grade;
    }

    //gets the average grade of the module for the main
    double getAverageMG()
    {
        return averageMG;
    }
}
