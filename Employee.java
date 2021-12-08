package lab4;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.*;
import java.util.Set;

public class Employee {

    @Size(min = 4, message = "ID must be more than 3 character")
    @Pattern(regexp = "[a-z]+_[1-9]+|[a-z]+_[1-9][0-9]+", message = "Id new Employee must consist of letter LowerCase, than symbol '_' and number (for example, 'Employee_1' is correct id)")
    private String id;

    @Size(min = 4, message = "Surname must be more than 3character")
    @Pattern(regexp = "[A-Z][a-z]+", message = "Surname must consists only from letter, and first letter must be UpperCase")
    private String Surname;

    @Size(min = 3, message = "Name must be more than 2 character")
    @Pattern(regexp = "[A-Z][a-z]+", message = "Name must consists only from letter, and first letter must be UpperCase")
    private String Name;

    @Size(min = 6, message = "Lastname must be more than 5 character")
    @Pattern(regexp = "[A-Z][a-z]+", message = "Lastname must consists only from letter, and first letter must be UpperCase")
    private String Lastname;

    @Min(value = 18, message = "Age cannot be less than 18")
    @Max(value = 60, message = "Age cannot be more than 60")
    private int age;

    @Min(value = 500, message = "Salary must be more than 500")
    @Max(value = 20000, message = "Salary cannot be more than 30000")
    private int salary;


   @Min(value = 1, message = "Experience must be more or equal 1 year")
    private int experience;


    public String getId() {
        return id;
    }

    public String getSurname() {
        return Surname;
    }

    public String getName() {
        return Name;
    }

    public String getLastname() {
        return Lastname;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }

    public int getExperience() {
        return experience;
    }

    public static class Builder{

        private Employee person;

        public Builder(){
            person = new Employee();
        }

        public Builder setId(String id){
            person.id = id;
            return this;
        }

        public Builder setSurname(String Surname){
            person.Surname = Surname;
            return this;
        }

        public Builder setName(String name){

            person.Name = name;
            return this;
        }

        public Builder setLastname(String lastname){
            person.Lastname = lastname;
            return this;
        }

        public Builder setAge(int age){
            person.age = age;
            return this;
        }

        public Builder setSalary(int salary){
            person.salary = salary;
            return this;
        }

        public Builder setExperience(int experience){
            person.experience = experience;
            return this;
        }

        public Employee build(){
            validate(person);
            return person;
        }
    }

    private static void validate(Employee Employee) throws IllegalArgumentException {

        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();


        Set<ConstraintViolation<Employee>> check = validator.validate(Employee);

        StringBuilder sb = new StringBuilder();

        for(ConstraintViolation<Employee> i : check){
            sb.append("Error value "+i.getInvalidValue() + " because " + i.getMessage());
            sb.append("\n");
        }

        if(sb.length() > 0){
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public static void main(String args[]){
        try {
            Employee Employee = new Employee.Builder()
                    .setId("Employee_1")
                    .setSurname("Vasylko")
                    .setName("Vasyl")
                    .setLastname("Vasylovych")
                    .setAge(33)
                    .setSalary(600)
                    .setExperience(6)
                    .build();
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

}
