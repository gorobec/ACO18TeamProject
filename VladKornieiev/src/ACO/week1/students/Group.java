package ACO.week1.students;

import ACO.week1.students.comparators.ByNameComparator;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by v21k on 24.01.17.
 */

public class Group {
    private String name;
    private Student[] students;

    public Group(String name, Student[] students) {
        this.name = name;
        this.students = students;
    }

    public void showStudents() {
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }

    public String getName() {
        return name;
    }

    // homework after this line

    public void addStudent(Student student) {

        // validation if we have this student already
        for (Student st : students) {
            if (st.equals(student)) {
                System.out.println("Already in a group!");
                return;
            }
        }

        if (student != null) {
            int updatedSize = students.length;
            Student[] tempStudents = new Student[updatedSize + 1];
            System.arraycopy(students, 0, tempStudents, 0, updatedSize);
            tempStudents[updatedSize] = student;
            students = tempStudents;
            System.out.println("Done, student added");
            return;
        }
        System.out.println("Input parameter is null.");

    }

    public void removeLastStudent() {
        if (students.length >= 1) {
            int updatedSize = students.length - 1;
            Student[] tempStudents = new Student[updatedSize];
            System.arraycopy(students, 0, tempStudents, 0, updatedSize);
            students = tempStudents;
            System.out.println("Done removing");
            return;
        }
        System.out.println("No students in group");
    }

    public void removeStudentByName(String name) {
        for (int i = 0; i < students.length; i++) {
            if (name.equals(students[i].getName())) {
                // if found, replace this student with the last, the last -> null.
                students[i] = students[students.length - 1];
                students[students.length - 1] = null;

                //creating new array(smaller) without last element (which is null in <students> array now)
                int updatedSize = students.length;
                Student[] tempStudents = new Student[updatedSize - 1];
                System.arraycopy(students, 0, tempStudents, 0, updatedSize - 1);
                students = tempStudents;
                System.out.printf("Done, student %s at index %d deleted\n", name, i);
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public void searchStudentByName(String name) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null && students[i].getName().equals(name)) {
                System.out.printf("Found: %s at index: %d\n", students[i].toString(), i);
                return;
            }
        }
        System.out.println("Not found.\n");
    }

    public boolean searchStudentByNameBinary(String name) {
        sort(new ByNameComparator());
        int low = 0;
        int high = students.length;
        boolean found = false;

        while (!found) {
            int mid = low + (high - low) / 2;
            if (high == low){
                return false;
            } else if (students[mid].getName().compareTo(name) == 0) {
                return true;
            } else if (students[mid].getName().compareTo(name) < 0) {
                low = mid + 1;
            } else if (students[mid].getName().compareTo(name) > 0) {
                high = mid - 1;
            }
        }
        return false;
    }

    // bubble sort
    public void sortByName() {
        int j = 0;
        Student tmp;
        boolean sorted = false;

        while (!sorted) {
            sorted = true;
            j++;
            for (int i = 0; i < students.length - j; i++) {
                if (students[i].getName().compareTo(students[i + 1].getName()) > 0) {
                    swap(i);
                    sorted = false;
                }

            }
        }
    }

    // equals() and sortByNameComparable() added

    public void sortByNameComparable() {
        Arrays.sort(students);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Group group = (Group) o;

        if (!name.equals(group.name)) return false;

        // check every student in a group, if not the same -> return false
        for (int i = 0; i < students.length; i++) {
            if (students.length != group.students.length || !students[i].equals(group.students[i])) {
                return false;
            }
        }
        return true;
    }

    // sort with comparator

    public void sort(Comparator comparator) {
        int j = 0;
        boolean sorted = false;

        while (!sorted) {
            sorted = true;
            j++;
            for (int i = 0; i < students.length - j; i++) {
                if (comparator.compare(students[i], students[i + 1]) > 0) {
                    swap(i);
                    sorted = false;
                }

            }
        }
    }

    private void swap(int i) {
        Student tmp;
        tmp = students[i];
        students[i] = students[i + 1];
        students[i + 1] = tmp;
    }
}
