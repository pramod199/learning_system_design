package lld.builder_design_pattern;

// it helps to provide sequence of building an object
public class Director {
    StudentBuilder studentBuilder;

    public Director(StudentBuilder studentBuilder) {
        this.studentBuilder = studentBuilder;
    }

    public Student createStudent() {

        if (studentBuilder instanceof EngineeringStudentBuilder) {
            return createEngineeringStudent();
        } else if (studentBuilder instanceof MBAStudentBuilder) {
            return createMBAStudent();
        }
        return null;
    }


    private Student createEngineeringStudent() {

        return studentBuilder.setRollNo(1).setName("sj").setSubjects().build();
    }

    private Student createMBAStudent() {

        return studentBuilder.setRollNo(2).setName("sj").setEmail("mba@gmail.com").setSubjects().build();

    }

}
