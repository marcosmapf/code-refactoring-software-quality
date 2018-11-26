package pkgOperations;

public class Operations {

    public static double highestOf(double v1, double v2) {
    	return v1 > v2? v1: v2;
    }
    
    
    public static double lowestOf(double v1, double v2) {
    	return v1 < v2? v1 : v2;
    }
    
    
    public static double sqrt(double v1) {
        if (v1 >= 0)
            return Math.sqrt(v1);
        else
            throw new IllegalArgumentException("O Valor não pode ser negativo");       
    }
    
    
    public static double divide(double v1, double v2) {
        try {
            return v1 / v2;
        } 
        catch (Exception e) {
            System.out.println("Um erro ocorreu" + e.getMessage());
        }
        throw new IllegalArgumentException("O(s) Valor(es) não pode(m) ser nulo(s)");
    }
    
    
    public static double multiply(double v1, double v2) {
        return v1 * v2;
    }
    
    
    public static double sum(double v1, double v2) {
        return v1 + v2;
    }
}