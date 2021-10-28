import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Movements {
    private static String pathMovementsCsv;
    private String organization;
    private double income;
    private double expense;

    public Movements(String pathMovementsCsv) {
        this.pathMovementsCsv = pathMovementsCsv;
    }

    public Movements(String organization, double income, double expense) {
        this.organization = organization;
        this.income = income;
        this.expense = expense;
    }

    public String getOrganization() {
        return organization;
    }

    public double getIncome() {
        return income;
    }

    public double getExpense() {
        return expense;
    }

    public static List<Movements> parseList() {
        List<Movements> movementsList = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(pathMovementsCsv));
            lines.remove(0);
            for (String line : lines) {
                String[] fragment = line.split(",(?!\\d+\\042)");
                if (fragment.length != 8) {
                    System.out.println("Не корректная линия: " + line + "\n");
                    continue;
                }
                String regexDate = "\\s\\d{2}.\\d{2}.\\d{2}\\s";
                Pattern pattern = Pattern.compile(regexDate);
                Matcher matcher = pattern.matcher(fragment[5]);
                if (matcher.find()) {
                    int start = matcher.start();
                    fragment[5] = fragment[5].substring(16, start).trim();
                }

                movementsList.add(new Movements(fragment[5],
                        Double.parseDouble(fragment[6]
                                .replaceAll("\"", "")
                                .replaceAll(",", ".")),
                        Double.parseDouble(fragment[7]
                                .replaceAll("\"", "")
                                .replaceAll(",", "."))));
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return movementsList;
    }

    public static Map<String, Double> associationOrganizations(List<Movements> list) {
        Map<String, Double> mapOrganizations = list.stream()
                .collect(Collectors.groupingBy(Movements::getOrganization,
                        Collectors.summingDouble(Movements::getExpense)));
        for (Map.Entry<String, Double> item : mapOrganizations.entrySet()) {
            System.out.println(item.getKey() + " - " + item.getValue() + " руб.");
        }
        return mapOrganizations;
    }
    public double getExpenseSum() {
        double sumExpense = 0;
        List<Movements> list = parseList();
        Map<String, Double> mapOrganizations = list.stream()
                .collect(Collectors.groupingBy(Movements::getOrganization,
                        Collectors.summingDouble(Movements::getExpense)));
        for (Map.Entry<String, Double> item : mapOrganizations.entrySet()) {
            sumExpense += item.getValue();
        }
        return sumExpense;

    }

    public double getIncomeSum() {
        double sumIncome = 0;
        List<Movements> list = parseList();
        Map<String, Double> mapOrganizations = list.stream()
                .collect(Collectors.groupingBy(Movements::getOrganization,
                        Collectors.summingDouble(Movements::getIncome)));
        for (Map.Entry<String, Double> item : mapOrganizations.entrySet()) {
            sumIncome += item.getValue();
        }
        return sumIncome;
    }
}