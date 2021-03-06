package lab4;

import static org.testng.Assert.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import lab4.Employee;

public class EmployeeTest {

    @Test(expectedExceptions = IllegalArgumentException.class, dataProvider = "testIdNegativeDataProvider")
    public void testIdNegative(String id,int  Salary, int Experience, int Age){
        Employee obj = new Employee.Builder().setId(id).setSalary( Salary).setExperience(Experience).setAge(Age).build();
        assertEquals(obj.getId(),id);
    }

    @DataProvider
    public Object[][] testIdNegativeDataProvider(){
        return new Object[][] {{"Employee-1",1500,5,25}};
    }

    @Test(dataProvider = "testIdPositiveDataProvider")
    public void testIdPositive(String id,int  Salary, int Experience, int Age){
        Employee obj = new Employee.Builder().setId(id).setSalary( Salary).setExperience(Experience).setAge(Age).build();
        assertEquals(obj.getId(),id);
    }

    @DataProvider
    public Object[][] testIdPositiveDataProvider(){
        return new Object[][] {{"Employee_1",1500,5,25}};
    }


    @Test(expectedExceptions = IllegalArgumentException.class, dataProvider = "testAgeNegativeDataProvider")
    public void testAgeNegative(int  Salary, int Experience, int Age){
        Employee obj = new Employee.Builder().setSalary( Salary).setExperience(Experience).setAge(Age).build();
        assertEquals(obj.getAge(),Age);
    }

    @DataProvider
    public Object[][] testAgeNegativeDataProvider(){
        return new Object[][] {{1300,3,16}};
    }

    @Test(dataProvider = "testAgePositiveDataProvider")
    public void testAgePositive(int  Salary, int Experience, int Age){
        Employee obj = new Employee.Builder().setSalary( Salary).setExperience(Experience).setAge(Age).build();
        assertEquals(obj.getAge(),Age);
    }

    @DataProvider
    public Object[][] testAgePositiveDataProvider(){
        return new Object[][] {{1600,3,23}};
    }

    @Test(dataProvider = "testSurnamePositiveDataProvider")
    public void testSurnamePositive(String Surname,int  Salary, int Experience, int Age){
        Employee obj = new Employee.Builder().setSurname(Surname).setSalary( Salary).setExperience(Experience).setAge(Age).build();
        assertEquals(obj.getSurname(),Surname);
    }

    @DataProvider
    public Object[][] testSurnamePositiveDataProvider(){
        return new Object[][] {{"Petrenko",1600,3,23}};
    }

    @Test(dataProvider = "testNamePositiveDataProvider")
    public void testNamePositive(String Name,int  Salary, int Experience, int Age){
        Employee obj = new Employee.Builder().setName(Name).setSalary( Salary).setExperience(Experience).setAge(Age).build();
        assertEquals(obj.getName(),Name);
    }

    @DataProvider
    public Object[][] testNamePositiveDataProvider(){
        return new Object[][] {{"Petro",1600,3,23}};
    }

    @Test(dataProvider = "testLastnamePositiveDataProvider")
    public void testLastnamePositive(String Lastname,int  Salary, int Experience, int Age){
        Employee obj = new Employee.Builder().setLastname(Lastname).setSalary( Salary).setExperience(Experience).setAge(Age).build();
        assertEquals(obj.getLastname(),Lastname);
    }

    @DataProvider
    public Object[][] testLastnamePositiveDataProvider(){
        return new Object[][] {{"Petrovych",1600,3,23}};
    }


    @Test(dataProvider = "testSalaryPositiveDataProvider")
    public void testSalaryPositive(int Salary, int Experience, int Age){
        Employee obj = new Employee.Builder().setSalary( Salary).setExperience(Experience).setAge(Age).build();
        assertEquals(obj.getSalary(), Salary);
    }

    @DataProvider
    public Object[][] testSalaryPositiveDataProvider(){
        return new Object[][] {{1600,3,23}};
    }

    @Test(expectedExceptions = IllegalArgumentException.class,dataProvider = "testSalaryNegativeDataProvider")
    public void testSalaryNegative(int Salary, int Experience, int Age){
        Employee obj = new Employee.Builder().setSalary( Salary).setExperience(Experience).setAge(Age).build();
        assertEquals(obj.getSalary(), Salary);
    }

    @DataProvider
    public Object[][] testSalaryNegativeDataProvider(){
        return new Object[][] {{300,3,23}};
    }

}
