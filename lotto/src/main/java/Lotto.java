public class Lotto {
    public static void main(String[] args) {
        Simulation simulation = new Simulation(100);
        for(String result: simulation.getResult()){
            System.out.println("result = " + result);
        }
    }
}
