package lld.facade;

public class FacadePattern {

    public static void main(String[] args) {

        ComputerFacade computer = new ComputerFacade();
        computer.startComputer();
    }
}