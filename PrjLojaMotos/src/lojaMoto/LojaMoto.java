package lojaMoto;

import javax.swing.JOptionPane;

public class LojaMoto {

	public static void main(String[] args) {
		while (true) {
			try {
				String name = JOptionPane.showInputDialog(
					"Informe a marca (acione [CANCELAR] para sair): "
				);
				
				if (name.equalsIgnoreCase("Honda")) {
					Honda motorcicle = new Honda();
					JOptionPane.showMessageDialog(null,
						"\nNome: " + motorcicle.name +
						"\nCilindrada: " + motorcicle.engineDisplacement +
						"\nCor: " + motorcicle.color, 
						"Dados da Moto", 
						JOptionPane.CLOSED_OPTION
					);
				}
				else if (name.equalsIgnoreCase("Yamaha")) {
					Yamaha motorcicle = new Yamaha();
					JOptionPane.showMessageDialog(null,
						"\nNome: " + motorcicle.name +
						"\nCilindrada: " + motorcicle.engineDisplacement +
						"\nCor: " + motorcicle.color, 
						"Dados da Moto", 
						JOptionPane.CLOSED_OPTION
					);					
				}
				else if (name.equalsIgnoreCase("Suzuki")){
					Suzuki motorcicle = new Suzuki();
					JOptionPane.showMessageDialog(null,
						"\nNome: " + motorcicle.name +
						"\nCilindrada: " + motorcicle.engineDisplacement +
						"\nCor: " + motorcicle.color, 
						"Dados da Moto", 
						JOptionPane.CLOSED_OPTION
					);					
				}
				else { 
					JOptionPane.showMessageDialog(null, 
						"Somente disponíveis na loja: Honda Yamaha e Suzuki",
						"Mensagem do programa", 
						JOptionPane.CLOSED_OPTION
					);
				}
			}
			catch (Exception e) {
				break;
			}
		}
	}
}
