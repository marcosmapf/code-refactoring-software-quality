package temperatureManagerRefactored;

public class Temperature {	
	public static double convertCelsiusToFarenheit(double celsius) {
		return (celsius * 1.8) + 32;
	}
	public static double convertCelsiusToKelvin(double celsius) {
		return celsius + 273.15;
	}	
	public static String classifyTemperature(double celsius) {
		return celsius < 0 ? "NEGATIVA" : celsius == 0 ? "ZERO" : "POSITIVA";
	}	
	public static boolean validateConversionCelsiusToFarenheit(double c, double f) {		
		double farenheit = (c * 1.8) + 32;
		return farenheit == f? true : false;
	}		
}