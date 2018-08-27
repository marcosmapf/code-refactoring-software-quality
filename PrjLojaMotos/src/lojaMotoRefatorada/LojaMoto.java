package lojaMotoRefatorada;

import javax.swing.JOptionPane;

public class LojaMoto {
		
	private static void showMotorcicleData(Motorcicle motorcicle) {
		JOptionPane.showMessageDialog(null,
			"\nNome: " + motorcicle.name +
			"\nCilindrada: " + motorcicle.engineDisplacement +
			"\nCor: " + motorcicle.color, 
			"Dados da Moto", 
			JOptionPane.CLOSED_OPTION
		);
	}
	 
	private static String requestMotorcicleName() {
		String name = JOptionPane.showInputDialog(
				"Informe a marca (acione [CANCELAR] para sair): "
		);
		return name;
	}
	
	private static Motorcicle motorcicleFactory(String name) {
		return	name.equalsIgnoreCase("Honda") ? new Honda() :
				name.equalsIgnoreCase("Yamaha") ? new Yamaha() : 
				name.equalsIgnoreCase("Suzuki") ? new Suzuki() : 
				null;		
	}
	
	private static void showDataOrError(Motorcicle motorcicle) {
		if (motorcicle != null) 
			showMotorcicleData(motorcicle);
		else {
			JOptionPane.showMessageDialog(null, 
					"Somente disponíveis na loja: Honda, Yamaha e Suzuki",
					"Mensagem do programa", 
					JOptionPane.CLOSED_OPTION
			);			
		}
	}
	
	public static void main(String[] args) {
		while (true) {
			try {				
				String name = requestMotorcicleName();
				Motorcicle motorcicle = motorcicleFactory(name);
				showDataOrError(motorcicle);
			}
			catch (Exception e) {
				break;
			}
		}
		System.out.println("\nPROGRAMA FINALIZADO\n");
	}
}