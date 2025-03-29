package lld.builder_design_pattern;

import java.util.List;

public class Student {
    private String name;
    private int rollNo;
    private String address;
    private String phoneNo;
    private String email;
    private List<String> subjects;

    public Student(StudentBuilder studentBuilder) { // constructor has String builder now.
        this.name = studentBuilder.name;
        this.rollNo = studentBuilder.rollNo;
        this.address = studentBuilder.address;
        this.phoneNo = studentBuilder.phoneNo;
        this.email = studentBuilder.email;
        this.subjects = studentBuilder.subject;
    }


    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Roll No: " + rollNo);
        System.out.println("Address: " + address);
        System.out.println("Phone No: " + phoneNo);
        System.out.println("Email: " + email);
    }
}
