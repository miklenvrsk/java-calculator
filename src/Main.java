import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws CustomException {
        int a;
        int b;
        int res;
        String[] roman = {"","I","II","III","IV","V","VI","VII","VIII","IX","X","L","C"};
        List<String> romanList = new ArrayList<>(Arrays.asList(roman));
        Scanner in = new Scanner(System.in);
        System.out.print("Ввидите выражение: ");
        String calk = in.nextLine();
        String [] strArray = calk.split(" ");
        if(strArray.length==3){
            if(isNumber(strArray[0])&&isNumber(strArray[2])){
                a = Integer.parseInt(strArray[0]);
                b = Integer.parseInt(strArray[2]);

                if(a>10||b>10){
                    throw new CustomException("Неправельнный ввод");

                }
                switch (strArray[1]){
                    case "+": res = a+b;
                        break;
                    case "-": res = a-b;
                        break;
                    case "/": res = a/b;
                        break;
                    case "*": res = a*b;
                        break;
                    default:
                        throw new CustomException("Неправельнный ввод");

                }
                System.out.print(res);

            }else if(romanList.contains(strArray[0])&&romanList.contains(strArray[2])){

                a = convectorRomeToInt(roman,strArray[0])+1;
                b = convectorRomeToInt(roman,strArray[2])+1;
                switch (strArray[1]){
                    case "+": res = a+b;
                        break;
                    case "-": res = a-b;
                        break;
                    case "/": res = a/b;
                        break;
                    case "*": res = a*b;
                        break;
                    default:
                        throw new CustomException("Неправельнный ввод");

                }
                System.out.print(convectorIntToRome(roman,res));

            } else{
                throw new CustomException("Неправельнный ввод");
            }

        }else{
            throw new CustomException("Неправельнный ввод");
        }


    }
    public static boolean isNumber(String a){
        try {
            int value = Integer.parseInt(a);
            return true;
        }catch (Exception e){

        }


        return false;
    }
    public static int convectorRomeToInt(String[]roman,String chart){
        for(int i = 0; i<roman.length; i++){
            if (Objects.equals(roman[i], chart)){
                return i-1;
            }
        }
        return 0;
    }
    public static String convectorIntToRome(String[]roman,int res) throws CustomException {
        for(int i = 0; i<roman.length; i++){
            if (i==res-1&&res<=10){
                return roman[i+1];
            } else if (res>10&&res<40) {
                return roman[10].repeat(res/10)+roman[res%10];

            } else if(res>=40 && res<50){
                return roman[10]+roman[11]+roman[res%10];
            } else if(res>=50 && res<90){
                return roman[11]+roman[10].repeat(res/10-5)+roman[res%10];
            } else if(res>=90&&res<100){
                return roman[10]+roman[12]+roman[res%10];
            } else if(res==100){
                return roman[12];
            } else if (res<1){
                throw new CustomException("В римских цифрах нет чисел меньше единицы");
            }
        }
        return "";
    }
}

class CustomException extends Exception {
    public CustomException(String message) {
        super(message);
    }
}