package string;

public class Ipv4String {
    public static void main(String[] args) {
        generateIpv4Address("1234");
    }

    private static void generateIpv4Address(String s) {
        generateIpv4AddressR(0,s,0,"");
    }

    private static void generateIpv4AddressR(int i, String s, int count,String out) {

        if(count == 3) System.out.println(out);

        for (int j = i;j<3;j++) {
            generateIpv4AddressR(j+1,s.substring(j+1),count+1,s.substring(0,j+1));
        }

    }

}
