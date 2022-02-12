package Exercicio3;

import java.util.Scanner;

public class JogoDaVelha {

	private char casas[][] = new char[3][3];
	private static char jogadorUmMarca = 'X';
	private static char jogadorDoisMarca = 'O';
	Scanner scanner = new Scanner(System.in);
	private Marca jogador;
	

	public JogoDaVelha() {

		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {
				casas[i][j] = ' ';
			}
		}
		jogador = Marca.JOGADOR1;
	}

	public void exibir() {
		System.out.println();
		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {
				System.out.print(casas[i][j]);
				if (j < 2) {
					System.out.print("|");
				}
			}
			System.out.println();

		}
	}

	public boolean verificar(int linha, int coluna) {
		if (casas[linha][coluna] == ' ') {
			return true;
		} else {
			return false;
		}
	}

	enum Marca {
		JOGADOR1('X'), JOGADOR2('O');
		public final char marca;

		Marca(char simbolo) {
			marca = simbolo;
		}
	}

	public void registrarJogada(int linha, int coluna, Marca jogador) {
		casas[linha][coluna] = jogador.marca;
	}

	public void jogada() {
		exibir();
		System.out.println();
		System.out.println("Qual a linha para jogada:");
		int linha = scanner.nextInt();
		linha--;

		System.out.println("Qual a coluna para jogada:");
		int coluna = scanner.nextInt();
		System.out.println();
		coluna--;

		boolean vazio;
		vazio = verificar(linha, coluna);

		if (vazio == true) {
			registrarJogada(linha, coluna, jogador);
			trocarJogador();
			System.out.println("_______________________________");
			System.out.println();

		} else {
			System.out.println("Jogada inválida!");
		}

	}

	public void trocarJogador() {
		if (jogador == Marca.JOGADOR1) {
			jogador = Marca.JOGADOR2;
		} else {
			jogador = Marca.JOGADOR1;
		}
	}

	public boolean estado() {
		if (!verificar(1, 1)) {
			if (casas[0][0] == casas[1][1] && casas[1][1] == casas[2][2]) {
				return true;
			}
			if (casas[2][0] == casas[1][1] && casas[1][1] == casas[0][2]) {
				return true;
			}
			if (casas[0][1] == casas[1][1] && casas[1][1] == casas[2][1]) {
				return true;
			}
			if (casas[1][0] == casas[1][1] && casas[1][1] == casas[1][2]) {
				return true;
			}
		}

		if (!verificar(1, 0)) {
			if (casas[0][0] == casas[1][0] && casas[1][0] == casas[2][0]) {
				return true;
			}
		}

		if (!verificar(1, 2)) {
			if (casas[0][2] == casas[1][2] && casas[1][2] == casas[2][2]) {
				return true;
			}
		}

		if (!verificar(0, 1)) {
			if (casas[0][0] == casas[0][1] && casas[0][1] == casas[0][2]) {
				return true;
			}
		}

		if (!verificar(2, 1)) {
			if (casas[2][0] == casas[2][1] && casas[2][1] == casas[2][2]) {
				return true;
			}
		}
		return false;
	}

	public boolean estadoEmpate() {
		int teste = 0;
		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {
				if (casas[i][j] != ' ') {
					teste = teste + 0;
				} else {
					teste = teste + 1;

				}
			}
		}
		if (teste == 0) {
			return true;
		}
		if (teste != 0) {
			return false;
		}
		return false;
	}

	public boolean finalizar() {
		if (estado()) {
			System.out.println("Vitória!");
			System.out.println("Partida encerrada!");
			
			return true;
		} else if (estadoEmpate()) {
			System.out.println("Empate");
			System.out.println("Partida encerrada!");
			
			return true;
		}
		return false;
	}

}
