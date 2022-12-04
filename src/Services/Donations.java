package Services;

public class Donations extends serviceProduct{
    @Override
    public void createForm(String service) {
        System.out.println("   "+service+"DonationsServices ");
        System.out.println("Donations Amount:");
        System.out.println("(1) 100:");
        System.out.println("(2) 200:");
        System.out.println("(3) 300:");
        System.out.println("(4) Others:");
    }
}

