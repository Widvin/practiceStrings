import by.gsu.pms.Employee;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;


public class Runner {
    public static void main(String[] args) throws FileNotFoundException {

        FileReader file = new FileReader("src/pr3Strings.txt");
        Scanner scanner = new Scanner(file);

        double dailyRate = Double.parseDouble(scanner.nextLine().split("=")[1]);
        int[] indices = Arrays.stream(scanner
                .nextLine()
                .split("=")[1]
                .split(";"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Employee[] employees = new Employee[indices.length];

        for (int i=0; i < indices.length; i++){
            String account = scanner.nextLine().split("=")[1];
            int transport = Integer.parseInt(scanner.nextLine().split("=")[1]);
            int days = Integer.parseInt(scanner.nextLine().split("=")[1]);

            employees[i] = new Employee(account, transport, days);
        }

        Arrays.sort(employees, Comparator.comparing(Employee::get_total).reversed());

        for(Employee employee: employees){
            employee.show();
        }

    }
}
