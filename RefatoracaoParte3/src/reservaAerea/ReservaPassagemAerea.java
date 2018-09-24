package reservaAerea;

import javax.swing.*;

public class ReservaPassagemAerea {
	static int opcao, opcao1, opcao2;
	static String sopcao;
	static int flights[];
	static String flightOrigins[];
	static String flightDestinations[];
	static int locations[];
	static String flightData = "";
	
	private static void insertFlightData() {
		flights = new int[3];
		flightOrigins = new String[3];
		flightDestinations = new String[3];
		locations = new int[3];
		flights[0] = 1;
		flightOrigins[0] = "BHTE";
		flightDestinations[0] = "SÃO PAULO";
		locations[0] = 20;
		flightData = flightData + "\n" + flights[0] + "\t"
				+ flightOrigins[0] + "\t" + flightDestinations[0] + "\t" + locations[0];
		flights[1] = 2;
		flightOrigins[1] = "SÃO PAULO";
		flightDestinations[1] = "CURITIBA";
		locations[1] = 25;
		flightData = flightData + "\n" + flights[1] + "\t"
				+ flightOrigins[1] + "\t" + flightDestinations[1] + "\t" + locations[1];
		flights[2] = 3;
		flightOrigins[2] = "CURITIBA";
		flightDestinations[2] = "JOINVILLE";
		locations[2] = 15;
		flightData = flightData + "\n" + flights[2] + "\t"
				+ flightOrigins[2] + "\t" + flightDestinations[2] + "\t" + locations[2];		
	}
	public static void main(String[] args) {
		
		
		int resposta = JOptionPane.showConfirmDialog(null, "Deseja verificar dados?", "Confirmação do programa",
				JOptionPane.YES_NO_OPTION);
		if (resposta == JOptionPane.YES_OPTION) {
			JTextArea saida = new JTextArea(10, 40);
			saida.setText("Nro\tOrigem\tDestino\tPassageiros");
			saida.append(flightData);
			JScrollPane scroll = new JScrollPane(saida);
			JOptionPane.showMessageDialog(null, scroll, "Dados dos vôos: ", JOptionPane.INFORMATION_MESSAGE);
		}
		// MENU GERAL
		while (true) {
			try {
				// MENU GERAL
				opcao1 = Integer.parseInt(
						JOptionPane.showInputDialog("OPÇÕES\n\n" + "1 - Consulta\n2 - Reservar\n3 - Finalizar\n\n"));
				if (opcao1 == 1) {
					// MENU CONSULTAR
					while (true) {
						try {
							// MENU CONSULTAR
							opcao2 = Integer.parseInt(JOptionPane.showInputDialog("CONSULTAR VÔOS \n\n"
									+ "1 - Por  número  do  vôo\n2 - Por  Origem\n3 - Por Destino\n4 - Consulta Geral\n5 - Voltar\n\n"));
							if (opcao2 == 1) {
								opcao = Integer.parseInt(JOptionPane.showInputDialog(
										"CONSULTAR VÔO POR NÚMERO DO VÔO\n\n" + "Informe o número do vôo"));
								if (opcao < 1 || opcao > 3) {
									JOptionPane.showMessageDialog(null, "Número do vôo Inexistente");
								} else {
									for (int variavelFor = 0; variavelFor <= 2; variavelFor++) {
										if (flights[variavelFor] == (opcao)) {
											String resultado = "Vôo: " + flights[variavelFor] + "\n" + "Origem: "
													+ flightOrigins[variavelFor] + "\n" + "Destino: " + flightDestinations[variavelFor]
													+ "\n" + "Lugares: " + locations[variavelFor];
											JOptionPane.showMessageDialog(null, resultado);
										} // FIM DO IF
											// Não excluir esse código -
											// verificação origem
											// Autor: Pangrácio - 12/11/2015
											// if (voo[variavelFor] ==
											// (opcao-1)) {
											// String resultado = "Vôo:
											// "+voo[variavelFor] + "\n" +
											// "Origem: "+origem[variavelFor] +
											// "\n" + "Destino:
											// "+destino[variavelFor] + "\n" +
											// "Lugares: "+lugares[variavelFor];
											// JOptionPane.showMessageDialog(null,
											// resultado);
											// } // FIM DO IF
									} // FIM DA ITERAÇÃO FOR VARIAVELFOR
								} // FIM DO ELSE
							} // FIM DA OPÇÃO 1
							if (opcao2 == 2) {
								sopcao = JOptionPane
										.showInputDialog("CONSULTAR VÔO POR ORIGEM DO VÔO\n\n" + "Informe a origem");
								Boolean verOrigem = true;
								verOrigem = verVPO(sopcao);
								if (verOrigem == false) {
									JOptionPane.showMessageDialog(null, "Origem não cadastrada no programa. Verifique",
											"Mensagem do Sistema", JOptionPane.INFORMATION_MESSAGE);
								} else {
									for (int variavelFor = 0; variavelFor <= 2; variavelFor++) {
										if (flightOrigins[variavelFor].equalsIgnoreCase(sopcao)) {
											String resultado = "Vôo: " + flights[variavelFor] + "\n" + "Origem: "
													+ flightOrigins[variavelFor] + "\n" + "Destino: " + flightDestinations[variavelFor]
													+ "\n" + "Lugares: " + locations[variavelFor];
											JOptionPane.showMessageDialog(null, resultado);
										} // FIM DO IF
									} // FIM DA ITERAÇÃO FOR VARIAVELFOR
								} // FIM DO ELSE IF
							}
							if (opcao2 == 3) {
								sopcao = JOptionPane
										.showInputDialog("CONSULTAR VÔO POR DESTINO DO VÔO\n\n" + "Informe a origem");
								Boolean verDestino = true;
								verDestino = verVPD(sopcao);
								if (verDestino == false) {
									JOptionPane.showMessageDialog(null, "Origem não cadastrada no programa. Verifique",
											"Mensagem do Sistema", JOptionPane.INFORMATION_MESSAGE);
								} else {
									for (int variavelFor = 0; variavelFor <= 2; variavelFor++) {
										if (flightDestinations[variavelFor].equalsIgnoreCase(sopcao)) {
											String resultado = "Vôo: " + flights[variavelFor] + "\n" + "Origem: "
													+ flightOrigins[variavelFor] + "\n" + "Destino: " + flightDestinations[variavelFor]
													+ "\n" + "Lugares: " + locations[variavelFor];
											JOptionPane.showMessageDialog(null, resultado);
										} // FIM DO IF
									} // FIM DA ITERAÇÃO FOR VARIAVELFOR
								} // FIM DO ELSE IF
							}
							if (opcao2 == 4) {
								JTextArea saida = new JTextArea(10, 40);
								saida.setText("Nro\tOrigem\tDestino\tPassageiros");
								saida.append(flightData);
								JScrollPane scroll = new JScrollPane(saida);
								JOptionPane.showMessageDialog(null, scroll, "Dados dos vôos: ",
										JOptionPane.INFORMATION_MESSAGE);
							}
							if (opcao2 == 5) {
								break;
							}
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null,
									"\nTecla cancelar foi acionada\nou um erro inesperado ocorreu. \nO programa será finalizado");
							break;
						}
					} // while Consultar
				} // fim opcao 1
				if (opcao1 == 2) {
					JOptionPane.showMessageDialog(null, "OPÇÃO 2 - RESERVA \nOpção em desenvolvimento ...");
				}
				if (opcao1 == 3) {
					break;
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,
						"\nTecla cancelar foi acionada\nou um erro inesperado ocorreu. \nO programa será finalizado");
				break;
			}
		} // while geral
		System.out.println("\n\nPROGRAMA FINALIZADO!");
	}
	// main
	// VERIFICA SE HÁ VÔO PARA A ORIGEM INFORMADA PELO USUÁRIO
	// OU SEJA: VERVPO (VERIFICA VÔO POR ORIGEM) O PARÂMETRO
	// ARGS É O NOME DA CIDADE DE ORIGEM. ENTENDEU?

	private static Boolean verVPO(String args) {
		for (int variavelFor = 0; variavelFor <= 2; variavelFor++) {
			if (flightOrigins[variavelFor].equalsIgnoreCase(sopcao)) {
				return true;
			}
		}
		return false;
	}
	// VERIFICA SE HÁ VÔO PARA O DESTINO INFORMADO PELO USUÁRIO
	// OU SEJA: VERVPD (VERIFICA VÔO POR DESTINO) O PARÂMETRO
	// ARGS É O NOME DA CIDADE DE DESTINO. ENTENDEU?

	private static Boolean verVPD(String args) {
		for (int variavelFor = 0; variavelFor <= 2; variavelFor++) {
			if (flightDestinations[variavelFor].equalsIgnoreCase(sopcao)) {
				return true;
			}
		}
		return false;
	}
} // class