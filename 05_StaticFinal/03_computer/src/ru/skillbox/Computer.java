package ru.skillbox;

public class Computer {
    private final String vendor;
    private final String name;
    private Processor processor;
    private Ram ram;
    private HardwareDisk hardwareDisk;
    private Monitor monitor;
    private Keyboard keyboard;

    public Computer(String vendor, String name, Processor processor, Ram ram, HardwareDisk hardwareDisk, Monitor monitor, Keyboard keyboard) {
        this.vendor = vendor;
        this.name = name;
        this.processor = processor;
        this.ram = ram;
        this.hardwareDisk = hardwareDisk;
        this.monitor = monitor;
        this.keyboard = keyboard;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public void setRam(Ram ram) {
        this.ram = ram;
    }

    public void setHardwareDisk(HardwareDisk hardwareDisk) {
        this.hardwareDisk = hardwareDisk;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }

    public void setKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;
    }

    public String getVendor() {
        return vendor;
    }

    public String getName() {
        return name;
    }

    public Processor getProcessor() {
        return processor;
    }

    public Ram getRam() {
        return ram;
    }

    public HardwareDisk getHardwareDisk() {
        return hardwareDisk;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public double allWeightComputer()
    {
        return processor.getWeight()+ram.getWeight()+hardwareDisk.getWeight()+monitor.getWeight()+keyboard.getWeight();
    }
    public String toString()
    {
        return "Производитель компьютера - " + vendor + ", имя компьютера - " + name + "\n" +
                "Общий вес компьютера - " + allWeightComputer() + "\n" + "\n" +
                "Основные характеристики копьютера" + "\n" +

                "ПРОЦЕССОР: " + "\n" +
                "Частота - " + processor.getFreqProcessor() + "\n" +
                "Количество ядер - " + processor.getNumberCores() + "\n" +
                "Производитель - " + processor.getVendor() + "\n" +
                "Вес процессора - " + processor.getWeight() + "\n" + "\n" +

                "ОПЕРАТИВНАЯ ПАМЯТЬ: " + "\n" +
                "Тип памяти - " + ram.getTypeRam() + "\n" +
                "Объём памяти - " + ram.getSizeRam() + "\n" +
                "Вес ОП - " + ram.getWeight() + "\n" + "\n" +

                "НАКОПИТЕЛЬ ИНФОРМАЦИИ: " + "\n" +
                "Тип винчестера - " + hardwareDisk.getTypeHardDisk() + "\n" +
                "Объём памяти - " + hardwareDisk.getMemory() + "\n" +
                "Вес винчестера - " + hardwareDisk.getWeight() + "\n" + "\n" +

                "ЭКРАН: " + "\n" +
                "Диагональ - " + monitor.getDiagonal() + "\n" +
                "Тип экрана - " + monitor.getTypeMonitor() + "\n" +
                "Вес экрана - " + monitor.getWeight() + "\n" + "\n" +

                "КЛАВИАТУРА: " + "\n" +
                "Тип клавиатуры - " + keyboard.getTypeKeyboard() + "\n" +
                "Наличие подсветки - " + keyboard.getBacklightKeyboard() + "\n" +
                "Вес клавиатуры - " + keyboard.getWeight() + "\n";




    }
}
