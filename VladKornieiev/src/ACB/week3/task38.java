package ACB.week3;

/*
Верхний регистр.

Напишите программу, которая позволяет пользователю ввести в консоли строку,
переводит первый символ слов в верхний регистр и результат выводит в консол

Вход:
иван васильеви

Выход:
Иван Васильевич
*/
public class task38 {

    public static void main(String[] args) {
        String str = "иван васильевич";
        System.out.println(toUpperCaseFirstLetter(str));
    }

    public static String toUpperCaseFirstLetter(String input){
        String[] arr = input.split(" ");
        String output = "";
        for (int i = 0; i < arr.length ; i++) {
            arr[i] = arr[i].substring(0, 1).toUpperCase() + arr[i].substring(1);
            output += arr[i] + " ";
        }
        return output;
    }

}


