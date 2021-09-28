package ru.skillbox;

public class Main {

    public static void main(String[] args) {
        Processor processor = new Processor(2500,8,"Radeon",342.9);
        Ram ram = new Ram("DOS",32,120.4);
        HardwareDisk hardwareDisk = new HardwareDisk(TypeHardDisk.HDD,1024,890.6);
        Monitor monitor = new Monitor(24,TypeMonitor.IPS,3570.2);
        Keyboard keyboard = new Keyboard("Membrane",BacklightKeyboard.YES,1190.4);
        Computer computer = new Computer("DELUX","M-3212",processor,ram,hardwareDisk,monitor,keyboard);
        System.out.println(computer);
    }
}
