package com.day01.ioprogramming.advancedproblems.mergetwoCSVfiles;

public class Student {

        String id, name, age, marks, grade;

        public Student(String id, String name, String age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }

        public void addMarksAndGrade(String marks, String grade) {
            this.marks = marks;
            this.grade = grade;
        }

        @Override
        public String toString() {
            return id + "," + name + "," + age + "," + marks + "," + grade;
        }

}
