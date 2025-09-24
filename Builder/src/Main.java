//client
public class Main {
    public static void main(String[] args) {
        // Build a Gaming Computer
        ComputerBuilder gamingBuilder = new GamingComputerBuilder();
        ComputerDirector director1 = new ComputerDirector(gamingBuilder);
        director1.constructComputer();
        Computer gamingPC = gamingBuilder.getComputer();
        System.out.println(gamingPC);

        // Build an Office Computer
        ComputerBuilder officeBuilder = new OfficeComputerBuilder();
        ComputerDirector director2 = new ComputerDirector(officeBuilder);
        director2.constructComputer();
        Computer officePC = officeBuilder.getComputer();
        System.out.println(officePC);

        }
    }
