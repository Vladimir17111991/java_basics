public class PhysicalPerson extends Client {

 public void put(double amountToPut) {
 super.put(amountToPut);
 }
 public void take(double amountToTake) {
  super.take(amountToTake);
 }

 @Override
 public void info() {
  System.out.println("Денег на счете " + getAmount());
 }
}
