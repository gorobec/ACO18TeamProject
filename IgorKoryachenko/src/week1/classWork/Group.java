package week1.classWork;

import java.util.Comparator;

public class Group {

    private String name;
    private Student[] students;


    public Group(String name, Student[] students) {
        this.name = name;
        this.students = students;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public void showStudents(){
        System.out.println(name);
        System.out.println();
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i].asString());
        }
    }

    public String asSting(){
        return "Name - " + name /*+ "  Students - " + students.toString()*/;
    }

    public String asStingAll(){
        String str = "Name - " + name + "\n";
        for (int i = 0; i < students.length; i++) {
            str += students[i].asString() + ";\n";
        }
        return str;
    }

    public Student[] addStudent(String name, String surname, int age){
        Student[] newArrStudent = new Student[students.length + 1];
        Student student = new Student(name, surname, age);

        for (int i = 0; i < students.length; i++) {

            if (students[i].equals(student)) {
                System.out.println("Такой студент уже имеется");
                return students;
            }
        }

        for (int i = 0; i < students.length; i++) {
            newArrStudent[i] = students[i];
        }

        newArrStudent[newArrStudent.length - 1] = student;
        return newArrStudent;
    }

    public static Student[] sortByName(Student[] arr) {


        for (int j = 0; j < arr.length; j++) {

            for (int i = j + 1; i < arr.length; i++) {

                if (arr[i].getName().compareTo(arr[j].getName()) < 0) {
                    Student temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }


        }
        return arr;
    }

    public Student[] removeStudentByName(String name){
        Student[] newArr = new Student[students.length - 1];
        int pos = findStudentByName(name);
        System.arraycopy(students,0, newArr, 0, pos);
        System.arraycopy(students, pos + 1, newArr, pos, students.length - pos - 1);

        return newArr;
    }

    public int findStudentByName(String name){
        int pos = -1;
        for (int i = 0; i < students.length; i++) {
            if (name.equals(students[i].getName())){
                System.out.println(students[i].asString());
                pos = i;
                break;
            }
        }
        return pos;
    }

    public  void sort(Comparator comparator) {


        for (int j = 0; j < students.length; j++) {

            for (int i = j + 1; i < students.length; i++) {

                if (comparator.compare(students[i], students[j]) < 0) {
                    Student temp = students[j];
                    students[j] = students[i];
                    students[i] = temp;
                }
            }


        }

    }


    public int searchBinaryByName(String str){
        sortByName(students);
        if(students[0].equals(str))return 0;
        int i = 1;
        int start = 0;
        int end = students.length - 1;
        while (i != 0){
            if(students[i].getName().equals(str)) return i;
            i = (end - start) / 2;
            if (students[i].getName().compareTo(str) > 0){
                start = start / 2 + 1;
            } else end /= 2;
            System.out.println(i);
        }
        return  -1;
    }
    private int isCoincidence(String str, Student[] arr){
        return arr[arr.length/2].getName().compareTo(str);
    }

}

