package pkgRefatoracaoParte1;

import java.util.Scanner;
import java.util.Calendar;

public class Refatoracao {

	static Calendar calendar;
	static Scanner userInput = new Scanner(System.in);

	private static double getMonthlyPayment() {
		System.out.println("\nInforme o valor da mensalidade: ");
		double monthlyPayment = userInput.nextDouble();
		return monthlyPayment;	
	}
	
	private static int getReferenceMonth() {
		System.out.println("Informe o mês de referência: ");
		int month = userInput.nextInt();
		return month;
	}	
	
	private static double calculateFinalPayment(int referenceMonth, int currentMonth, double monthlyPayment) {		
		return referenceMonth < currentMonth? monthlyPayment * 1.10 : monthlyPayment;		
	}
	
	private static void printPaymentData(int referenceMonth, int currentMonth, double monthlyPayment, double finalMonthlyPayment) {
		System.out.printf("RESULTADO"
				+ "\nMês Atual: %d"
				+ "\nReferência: %d"
				+ "\nMensalidade: %.2f"
				+ "\nNova mensalidade: %.2f \n", 
				currentMonth, referenceMonth, monthlyPayment, finalMonthlyPayment
		);		
	}
	
	private static void generatePayment() {		
		double monthlyPayment = getMonthlyPayment();
		int referenceMonth = getReferenceMonth();
		
		calendar = Calendar.getInstance();		
		int currentMonth = calendar.get(Calendar.MONTH) + 1;
		
		double finalMonthlyPayment = calculateFinalPayment(referenceMonth, currentMonth, monthlyPayment);
		printPaymentData(referenceMonth, currentMonth, monthlyPayment, finalMonthlyPayment);
	}
		
	public static void main(String[] args) {
		int requests = 3;		
		for (int i = 0; i < requests; i++)			
			generatePayment();		
	}
}