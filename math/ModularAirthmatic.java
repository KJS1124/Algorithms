/**
 * @author KJS1124
 */
public class ModularAirthmatic {

    int mod = 0;

    public ModularAirthmatic(int mod) {
        this.mod = mod;
    }

    public int add(int a, int b) {
        return (a % mod + b % mod) % mod;
    }

    public int subtract(int a, int b) {
        return ((a % mod - b % mod) + mod) mod;
    }

    public int multiply(int a, int b) {
        return (a % mod * b % mod) % mod;
    }

    public int divide(int a, int b) {
        return (a % mod / inversemod(b)) % mod;
    }

}
