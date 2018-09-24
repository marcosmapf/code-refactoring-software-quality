package pkgPilha;

import javax.swing.*;

public class TestePilha {
	
	private static StackItem stackTop = null;
	
	private static String displayMenuOptions() {
		return "\nMENU DE OPÇÕES\n" + "\n1 - Empilhar Chapas." + "\n2 - Consultar Todas as Chapas."
				+ "\n3 - Desempilhar Chapas." + "\n4 - Remover Todas as Chapas Da Pilha."
				+ "\n5 - Verificar Quantidade de Chapas." + "\n6 - Filtrar Chapas Por Pedido." + "\n7 - Sair";
	}

	private static void displayMessage(String message) {
		JOptionPane.showMessageDialog(null, message, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
	}
	
	private static int getMenuOption() throws Exception {
		return Integer.parseInt(JOptionPane.showInputDialog(displayMenuOptions(), "1"));
	}

	private static void runMenu(int menuOption) {
		switch (menuOption) {
			case 1: stackPlate(); break;
			case 2: consultRegistered(); break;
			case 3: unstackPlate(); break;
			case 4: emptyAll(); break; 
			case 5: countRegistered(); break;
			case 6: filterRegistered(); break;
			case 7: break;
			default: displayMessage("Opção Inválida!");
		}    	
    }
	
	public static boolean isRegistered(int number) {
		StackItem aux = stackTop;
		while (aux != null) {
			if (aux.number == number) {
				displayMessage("Esse número de chapa já foi empilhado.\nFavor verificar!");
				return true;
			}
			aux = aux.next;
		}
		return false;
	}
	
	public static boolean stackNotEmpty() {
		if (stackTop == null) {
			displayMessage("A PILHA está vazia!");
			return false;
		} 
		return true;
	}
	
	private static void registerPlate(int number) {
		StackItem battery = new StackItem();
		battery.number = number;
		battery.value = Double.parseDouble(JOptionPane.showInputDialog("VALOR DA CHAPA", "0"));
		battery.transactionId = Integer.parseInt(JOptionPane.showInputDialog("NÚMERO DO PEDIDO", "0"));
		battery.next = stackTop;
		stackTop = battery;
	}
	
	public static void stackPlate() {	
		int number = Integer.parseInt(JOptionPane.showInputDialog("NÚMERO DA CHAPA", "0"));
		if (!isRegistered(number))
			registerPlate(number);
	}

	public static void consultRegistered() {
		if (stackNotEmpty()) {
			JTextArea output = new JTextArea(6, 35);
			JScrollPane scroll = new JScrollPane(output);
			output.append("NÚMERO\t" + "VALOR\t" + "PEDIDO\n");
			output.append("===============================\n");
			StackItem aux = stackTop;
			while (aux != null) {
				if (aux.next != null) {
					System.out.println("Num: " + aux.number + ", endereço: " + aux.hashCode() + " => " + " Prox => " + aux.next.hashCode() + "\n");
				}				
				output.append(aux.number + "\t" + aux.value + "\t" + aux.transactionId + "\n");
				aux = aux.next;
			}
			JOptionPane.showMessageDialog(null, scroll, "CONSULTAR CHAPAS CADASTRADAS", JOptionPane.INFORMATION_MESSAGE);
		}	
	}
	
	public static void unstackPlate() {
		if (stackNotEmpty()) {
			displayMessage("Número: " + stackTop.number + ", foi removido.");
			stackTop = stackTop.next;
		}		
	}
	
	public static void emptyAll() {
		if (stackNotEmpty()) {
			 stackTop = null;
			 displayMessage("A Pilha foi esvaziada!");
		}		
	}
	
	public static void countRegistered() {
		StackItem aux = stackTop;
		int ammount = 0;
		while (aux != null) {
			aux = aux.next;
			ammount++;
		}
		displayMessage("A Pilha contém: " + ammount + " elementos.");		
	}
	
	public static void filterRegistered() {
		if (stackNotEmpty()) {
			int transactionId = Integer.parseInt(JOptionPane.showInputDialog("NÚMERO DO PEDIDO", "0"));
			JTextArea output = new JTextArea(6, 35);
			JScrollPane scroll = new JScrollPane(output);
			output.append("FILTRO, CHAPAS PARA O PEDIDO NRO: " + transactionId + "\n");
			output.append("NÚMERO\t" + "VALOR\t" + "PEDIDO\n");
			output.append("================================\n");
			StackItem aux = stackTop;
			while (aux != null) {
				if (aux.transactionId == transactionId) {
					output.append(aux.number + "\t" + aux.value + "\t" + aux.transactionId + "\n");
				}
				aux = aux.next;
			}
			JOptionPane.showMessageDialog(null, scroll, "CONSULTAR CHAPAS CADASTRADAS", JOptionPane.INFORMATION_MESSAGE);
		}	
	}
	
	public static void main(String[] args) {
		int menuOption = 0;
		while (menuOption != 7) {
			try {
				menuOption = getMenuOption();
				runMenu(menuOption);
			} 
			catch (Exception e) {
				System.out.println("");
			}
		}
		System.out.println(">>> PROGRAMA FINALIZADO!");
	}
}