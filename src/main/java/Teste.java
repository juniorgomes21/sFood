import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Teste {

    public static void main(String[] args) {
        boolean hor = false;
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        DateFormat df = DateFormat.getDateInstance(DateFormat.FULL);

        int horas = LocalTime.now().getHour();
        System.out.println("-------------------------");
        System.out.println(horas);
        System.out.println("-------------------------");

//        DateTimeFormatter;
//
//        new SimpleDateForm
//        at("HH").format(Calendar.getInstance().getTime());
//            System.out.println(SimpleDateFormat);
//        (1 < 1) ? System.out.println("-------------------------") : System.out.println("##################");
        if(horas == 22){
            System.out.println("dentro do if");
        } else {
            System.out.println("fora do if");
            System.out.println("fora do if");
            
        }
    }
}
