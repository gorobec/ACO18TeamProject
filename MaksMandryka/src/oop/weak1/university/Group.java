package oop.weak1.university;


import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by fmandryka on 21.01.2017.
 */
public class Group {

    private String name;
    private Student[] students;


    public Group(String name, Student[] students) {
        this.name = name;
        this.students = students;
    }

    public Group(String name, int groupQ) {
        this.name = name;
        this.students = new Student[groupQ];
    }

    public boolean addStudent(Student student) {

        try {
            if (isInGroup(student) == -1 && (hasSpace() != -1)) {
                students[hasSpace()] = student;
                return true;

            } else {
                System.out.println("Студент не добавлен, лимит мест в группе заполнен либо такой студент уже в списке добавлена!");
                return false;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            return false;
        }

    }

    public boolean removeStudent(Student student) {

        try {
            int studentPosition = isInGroup(student);
            if (studentPosition != -1) {

                System.arraycopy(students, studentPosition + 1, students, studentPosition, students.length - 1 - studentPosition);
                students[students.length - 1] = null;
                return true;

            } else {
                System.out.println("Студент не найден в списке группы!");
                return false;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            return false;
        }

    }

    public int isInGroup(Student student) throws IllegalArgumentException {
        if (student != null) {

            for (int i = 0; i < students.length; i++) {

                if (students[i] != null && students[i].equals(student)) {
                    return i;
                }
            }
        } else {
            throw new IllegalArgumentException("Студент не должен быть равен null");
        }
        return -1;
    }

    public int hasSpace() {

        for (int i = 0; i < students.length; i++) {

            if (students[i] == null) {
                return i;
            }
        }

        return -1;
    }


    public void setStudents(Student[] students) {
        this.students = students;
    }

    public void setName(String name) {

        this.name = name;
    }

    public Student[] getStudents() {

        return students;
    }

    public String getName() {

        return name;
    }

    public void sortStud() {

        if (students != null) {

            Student buffer;
            for (int i = 0; i < students.length - 1; i++) {
                for (int j = i + 1; j < students.length; j++) {

                    if (students[j] == null) {
                        continue;

                    } else if (students[i] == null || students[i].compareTo(students[j]) > 0) {

                        buffer = students[i];
                        students[i] = students[j];
                        students[j] = buffer;

                    }
                }
            }
        }
    }

    public Student[] findStudByName(String name) {

        Student[] students = getStudents();
        Student[] findStudents = new Student[0];

        for (int i = 0; i < students.length - 1; i++) {
            if (students[i].getName().equals(name)) {
                findStudents = ArrayUtils.addElement(findStudents, students[i]);
            }
        }

        return findStudents;
    }

    public Student findStudBinary(Student student) {

        int start = 0;
        int end = students.length - 1;

        int middle;

        while (end - start != 0) {

            if (end - start != 1) {
                if ((end - start) % 2 != 0) {
                    middle = start + (end + 1 - start) / 2;
                } else {
                    middle = start + (end - start) / 2;
                }

                if (students[middle].compareTo(student) > 0) {
                    end = middle;
                } else {
                    if (students[middle].compareTo(student) < 0) {
                        start = middle;
                    } else {
                        return students[middle];
                    }
                }

            } else {
                if (students[end].compareTo(student) == 0) {
                    return students[end];
                } else if (students[start].compareTo(student) == 0) {
                    return students[start];
                }
            }
        }
        return null;
    }




    @Override
    public boolean equals(Object group) {

        if (group == null) return false;

        if (group instanceof Group) {

            Group gr = (Group) group;
            if (name.equals(gr.getName()) && Arrays.equals(gr.getStudents(), students)) {
                return true;
            }
        }
        return false;
    }


    public void showStudents() {

        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) {
                System.out.printf("Group name = %s, Student - %s\n", name, students[i].asString());
            }
        }

    }

    public void sort(Comparator comp) {

        if (students != null) {

            Student buffer;
            for (int i = 0; i < students.length - 1; i++) {
                for (int j = i + 1; j < students.length && students[j] != null; j++) {

                    if (students[i] == null || comp.compare(students[i], students[j]) > 0) {

                        buffer = students[i];
                        students[i] = students[j];
                        students[j] = buffer;

                    }
                }
            }
        }
    }

}
