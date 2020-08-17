public class calculator {
        static String font_Arabic[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        public static String[] font_Roman = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        public static void main(String[] args)  {
            //System.out.println(convertToRoman(99));
            // Вводить суда
            String text = ("7 * 7");
            String string_a = stringA(text);
            String string_b = stringB(text);
            //проверка типов
            boolean cheak_string = cheak_string(string_a) && cheak_string(string_b);
            boolean cheak_int = cheak_int(string_a) && cheak_int(string_b);
            // сама проверка
            if( (!cheak_string) && (!cheak_int) ){
                throw new NumberFormatException("Типы данных должны совпадать");
            }

            char Arifm_operator = arifm_oper(text);
            int int_A = to_Arabic(string_a);
            int int_B = to_Arabic(string_b);
            int calc = 0;
            //Для вывода результата в разных форматах
            if(cheak_int){
                calc = calc(Arifm_operator, int_A, int_B);
                System.out.println(calc);
            }
           else if(cheak_string){
                calc = calc(Arifm_operator, int_A, int_B);
                String toRoman = convertToRoman(calc);
                System.out.println(toRoman);
            }
        }
        //Вернет позицую знака в вырожении, используется в "string_A"
        //и "string_B" для выделения параметров до знака и после знака
        static int Return_I(String text) {
//возвращает позицию знаков: + - / *
            char c;
            for (int i = 0; i < text.length(); i++) {
                c = text.charAt(i);
                switch (c) {
                    case '+':
                        return i;
                    case '-':
                        return i;
                    case '*':
                        return i;
                    case '/':
                        return i;
                }
            }
            return 0;
        }
        //Вернет параметр выражения до знака, удалит лишний пробел
        //значение возвращает в "string"
        static String stringA(String text) {
            String t = "";
            t = text.substring(0, Return_I(text));
            t = t.trim();
            return t;
        }
        //Вернет параметр выражения после знака, удалит лишний пробел
        //значение возвращает в "string"
        static String stringB(String text) {
            String t = "";
            t = text.substring(Return_I(text) + 1);
            t = t.trim();
            return t;
        }
        //Преобразует возвращаемое значение из "stringA" и "stringB"
        //в числовой формат "int"
        static int to_Arabic(String string_n) {
            int position = 0;
            int rez = 0;

            for (int i = 0; i < font_Roman.length; i++) {
                if (font_Roman[i].equals(string_n)) {
                    position += i;
                }
                if (font_Arabic[i].equals(string_n)) {
                    int rezult = 0;
                    return Integer.parseInt(string_n);
                }
            }
            // если position > 0 то имеем дело с римскими
            if (position > 0) {
                int rezult;
                for (int i = 0; i < font_Arabic.length; i++) {
                    return rezult = Integer.parseInt(font_Arabic[position]);
                }
            }

            throw new NumberFormatException("Не верный формат данных");
        }
        static int sum(int a, int b) {
            return a + b;
        }
        static int sub(int a, int b) {
            return a - b;
        }
        static int mult(int a, int b) {
            return a * b;
        }
        static int del(int a, int b) {
            return Math.round(a / b);
        }
        //возвращает оператор используемый в выражении "+-*/"
        static char arifm_oper(String text) {
            char c;
            for (int i = 0; i < text.length(); i++) {
                c = text.charAt(i);
                switch (c) {
                    case '+':
                        return c;
                    case '-':
                        return c;
                    case '*':
                        return c;
                    case '/':
                        return c;
                }
                if(c == '%'){
                    throw new NumberFormatException("Операция не предусмотренна");
                }
            }

            return 0;
        }
        //вернет значение выражения в зависимости от оператора в выражении
        static int calc(char Arifm_operator, int a, int b) {
            switch (Arifm_operator) {
                case '+':
                    return sum(a, b);
                case '-':
                    return sub(a, b);
                case '*':
                    return mult(a, b);
                case '/':
                    return del(a, b);
            }
            return 0;
        }
        //Переводит результат в римские цифры
        static String convertToRoman(int input) {
            String s ="";
            while (input >= 100) {
                s += "C";
                input -= 100;
            }
            while (input >= 90) {
                s += "XC";
                input -= 90;
            }
            while (input >= 50) {
                s += "L";
                input -= 50;
            }
            while (input >= 40) {
                s += "XL";
                input -= 40;
            }
            while (input >= 10) {
                s += "X";
                input -= 10;
            }
            while (input >= 9) {
                s += "IX";
                input -= 9;
            }
            while (input >= 5) {
                s += "V";
                input -= 5;
            }
            while (input >= 4) {
                s += "IV";
                input -= 4;
            }
            while (input >= 1) {
                s += "I";
                input -= 1;
            }
            return s;
        }
        //вернет флаг сравнения типов стринг
        //сравнивает с font_Roman
        static boolean cheak_string(String string){
            boolean flag = false;
                for(int i = 0; i < font_Roman.length; i++){
                    if (string.equals(font_Roman[i])){flag = true;}
                }
            return flag;
        }
        //вернет флаг сравнения типов инт
        //сравниает с font_Arabic
        static boolean cheak_int(String string){
            boolean flag = false;
            for(int i = 0; i < font_Arabic.length; i++){
                if (string.equals(font_Arabic[i])){flag = true;}
            }
            return flag;
        }
}