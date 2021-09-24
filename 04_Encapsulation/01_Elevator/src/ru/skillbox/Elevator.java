package ru.skillbox;
public class Elevator {
    private int currentFloor = 1;
    private int minFloor;
    private int maxFloor;
    public Elevator(int minFloor, int maxFloor)
    {
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
    }
    public int getCurrentFloor()
    {
        return currentFloor;
    }

    public void moveDown()
    {
        currentFloor = (currentFloor > minFloor) ? currentFloor - 1 : currentFloor;
    }
    public void moveUp()
    {
        currentFloor = (currentFloor < maxFloor) ? currentFloor + 1 : currentFloor;
    }
    public void move(int floor)
    {
        if(floor >= minFloor && floor <= maxFloor) {
            while (true) {
                System.out.println("Текущий этаж: " + getCurrentFloor());
                if (floor > currentFloor) {
                    moveUp();
                }
                if (floor < currentFloor) {
                    moveDown();
                }
                if (currentFloor == floor) {
                    System.out.println("Текущий этаж: " + getCurrentFloor());
                    System.out.println("Лифт находится на введеном вами этаже");
                    break;
                }
            }
        }
        else
        {
            System.out.println("Некорректно введен этаж!" + "\n" +
                    "Необходимо ввести этаж в диапазоне от " + minFloor + " до " + maxFloor);
        }
    }
}



