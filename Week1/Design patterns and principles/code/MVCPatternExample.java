// Model Class

class Student {

    private String name;

    private String id;

    private String grade;



    public Student(String name, String id, String grade) {

        this.name = name;

        this.id = id;

        this.grade = grade;

    }



    // Getters and Setters

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getGrade() { return grade; }

    public void setGrade(String grade) { this.grade = grade; }

}



// View Class

class StudentView {

    public void displayStudentDetails(String name, String id, String grade) {

        System.out.println("Student Details:");

        System.out.println("Name: " + name);

        System.out.println("ID: " + id);

        System.out.println("Grade: " + grade);

    }

}



// Controller Class

class StudentController {

    private Student model;

    private StudentView view;



    public StudentController(Student model, StudentView view) {

        this.model = model;

        this.view = view;

    }



    public void updateView() {

        view.displayStudentDetails(model.getName(), model.getId(), model.getGrade());

    }



    public void setStudentName(String name) { model.setName(name); }

    public void setStudentId(String id) { model.setId(id); }

    public void setStudentGrade(String grade) { model.setGrade(grade); }

}



// Main Class to Test MVC

public class MVCPatternExample {

    public static void main(String[] args) {

        Student student = new Student("Tushant", "101", "A");

        StudentView view = new StudentView();

        StudentController controller = new StudentController(student, view);



        controller.updateView(); // Display original data



        controller.setStudentName("Tushant Suryawanshi");

        controller.setStudentGrade("A+");



        controller.updateView(); // Display updated data

    }

}