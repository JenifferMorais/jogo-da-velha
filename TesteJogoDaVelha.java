package Exercicio3;
import java.util.Scanner;
public class TesteJogoDaVelha {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		JogoDaVelha jogo = new JogoDaVelha();
		
		String jogada; 
		Boolean b;
		System.out.println("Iniciar jogada?");
		jogada = scanner.next();

		b = jogada.matches("(?i)sim");
		
		while(b) {
			jogo.jogada();
			if(jogo.finalizar()) {
				b=false;
			}else {
			System.out.println("Proximo jogador:");
			}
		}
		
	}

}
