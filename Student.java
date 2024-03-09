
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Student{
    private String name;
    private Course[] courses;
    private int courseCount;

    public Student(String name) {
        this.name = name;
        this.courses = new Course[5];
        this.courseCount = 0;
    }

    public void addCourse(Course course) {
        if (courseCount < courses.length) {
            courses[courseCount] = course;
            courseCount++;
        } else {
            System.out.println("Maximum number of courses reached.");
        }
    }

    public void displayCourses() {
        System.out.println("Courses for " + name + ":");
        for (int i = 0; i < courseCount; i++) {
            Course course = courses[i];
            System.out.println("Semester: " + course.getSemester());
            System.out.println("Course: " + course.getName());
            System.out.println("Marks: " + course.getMarks());
            System.out.println();
        }
    }

    public static class Course {
        private LocalDate date;
        private String name;
        private int marks;

        public Course(LocalDate date, String name, int marks) {
            this.date = date;
            this.name = name;
            this.marks = marks;
        }

        public LocalDate getDate() {
            return date;
        }

        public String getName() {
            return name;
        }

        public int getMarks() {
            return marks;
        }

        public int getSemester() {
            LocalDate startDate = LocalDate.of(date.getYear(), 1, 1);
            long months = ChronoUnit.MONTHS.between(startDate, date);
            if (months >= 1 && months <= 4) {
                return 1;
            } else if (months >= 5 && months <= 8) {
                return 2;
            } else if (months >= 9 && months <= 12) {
                return 3;
            } else {
                return -1;
            }
        }
    }
}


 class Main{
    public static void main(String[] args) {
        Student student = new Student("John Doe");
        student.addCourse(new Student.Course(LocalDate.of(2022, 5, 1), "Mathematics", 85));
        student.addCourse(new Student.Course(LocalDate.of(2022, 5, 1), "Physics", 90));
        student.displayCourses();
    }
}