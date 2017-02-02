package week1day2.task1;

public class Group {
    private String name;
    private Student[] students;

    public Group(String name) {
        this.name = name;
    }

    public Group(Student[] students) {
        this.students = students;
    }

    public Group() {
    }

    public Group(String name, Student[] students) {
        this.name = name;
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    // show all students
    public void showStudents() {
        System.out.println("Group name " + name);
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i].toString());
        }
    }

    // find student by name
    public StringBuilder findStudent(Student[] students, String name) {
        for (int i = 0; i < students.length; i++) {
            if (students[i].getName().equalsIgnoreCase(name)) {
                return new StringBuilder("Found student: " + students[i].getName());
            }
        }
        return new StringBuilder("Student is not found.");
    }
    // age comparator
    public void sortByAge(AgeComparator comparator) {
        for (int i = 0; i < students.length; i++) {
            for (int j = i + 1; j < students.length; j++) {
                if(comparator.compare(students[i], students[j]) > 0){
                    Student temp = students[i];
                    students[i] = students[j];
                    students[j] = temp;
                }
            }
        }
    }

    // mark comparator
    public void sortByMark(MarkComparator comparator){
        for (int i = 0; i < students.length; i++) {
            for (int j = i + 1; j < students.length; j++) {
                if(comparator.compare(students[i], students[j]) > 0){
                    Student temp = students[i];
                    students[i] = students[j];
                    students[j] = temp;
                }
            }
        }
    }

    public void sortByName(StringComparator comparator){
        for (int i = 0; i < students.length; i++) {
            for (int j = i + 1; j < students.length; j++) {
                if(comparator.compare(students[i].getName(), students[j].getName()) > 0){
                    Student temp = students[i];
                    students[i] = students[j];
                    students[j] = temp;
                }
            }
        }
    }
}
