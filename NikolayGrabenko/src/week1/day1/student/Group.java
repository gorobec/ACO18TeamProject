package week1.day1.student;

import java.util.Comparator;

/**
 * Дописать метод добавить/удалить студента/группу.
 * Для работы с массивом использовать метод System.arrayCopy
 * Добавить методы в класс Группа:
 * - поиск студента по имени
 * - сортировка студентов по имени
 */
public class Group {

    private String name;
    private Student[] students;

    public String getName() {
        return name;
    }

    public Student[] getStudents() {
        return students;
    }

    public Group(String name, Student[] students) {
        this.name = name;
        this.students = students;
    }

    public void showStudents() {

        for (int i = 0; i < students.length; i++) {
            if (students[i] != null)
                System.out.println(String.format("group name - %s , student name - %s", name, students[i].asString()));
            else
                System.out.println("free array cell");
        }

    }

    public String asString() {
        return String.format("Group name - %s", name);
    }

    //home task

    public boolean equals(Group group) {
        return (this.name == group.name);
    }

    public void addStudent(Student student) {
        int studentCounter = 0;
        for (int i = 0; i < students.length; i++) {

            if (students[i] == null) {
                students[i] = student;
                studentCounter++;
                break;
            } else if (student.equals(students[i]))
                break;
        }
        System.out.println(studentCounter + " student was added");
    }

    public void removeStudent(Student student) {
        for (int i = 0; i < students.length; i++) {
            if (students[i].equals(student)) {
                students[i] = null;
                break;
            }
        }
        System.out.println(student.getName() + " " + student.getSurName() + " was removed");
    }

    public Student searchStudentByName(String name) {
        Student studentFromSearch = null;

        for (int i = 0; i < students.length; i++) {

            if (students[i] != null && students[i].getName().equals(name))
                studentFromSearch = students[i];
        }
        return studentFromSearch;
    }

    public void sortStudentsByName() {
        int nullCounter = 0;
        for (int i = 0; i < students.length; i++) {
            for (int j = students.length - 1; j > i; j--) {
                if (students[j] != null && students[j - 1] != null) {
                    if (students[j].getName().compareTo(students[j - 1].getName()) < 0) {
                        Student temp = students[j];
                        students[j] = students[j - 1];
                        students[j - 1] = temp;
                    }
                } else if (students[j] != null || students[j - 1] == null) {
                    continue;
                } else {
                    Student temp = students[j];
                    students[j] = students[students.length - 1 - nullCounter];
                    students[students.length - 1 - nullCounter] = temp;
                    nullCounter++;
                }
            }
        }
    }

    public void sortUsingCompareTo() {
        for (int i = 0; i < students.length; i++) {
            for (int j = students.length - 1; j > i; j--) {
                if (students[i] != null) {
                    if (students[j].compareTo(students[j - 1]) > 0) {
                        Student temp = students[j];
                        students[j] = students[j - 1];
                        students[j - 1] = temp;
                    }
                }
            }
        }
    }


    public void sortByComparator(Comparator comparator) {

//        int[] mas = {45,23,1,3,5,65,34};
        for (int i = 0; i < students.length; i++) {
            for (int j = students.length - 1; j > i; j--) {
                if (students[j] != null) {
                    if (comparator.compare(students[j], students[j - 1]) < 0) {
                        Student temp = students[j];
                        students[j] = students[j - 1];
                        students[j - 1] = temp;
                    }
                }
            }
        }
    }

}


