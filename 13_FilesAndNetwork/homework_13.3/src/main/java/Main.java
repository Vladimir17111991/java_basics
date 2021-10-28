public class Main {
    private static final String DATA_FILE = "src/test/resources/movementList.csv";
    public static void main(String[] args) {

        Movements movements = new Movements(DATA_FILE);
        System.out.println("Общий расход составил : " + movements.getExpenseSum());
        System.out.println("Общий доход составил : " + movements.getIncomeSum()+"\n");
        System.out.println("Суммарный расход по организациям: ");
        Movements.associationOrganizations(Movements.parseList());
    }
}
