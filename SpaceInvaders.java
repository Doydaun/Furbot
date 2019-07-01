import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;

public class SpaceInvaders extends Furbot {

	public void criarNave() {
		Nave nave = new Nave();
		adicionarObjetoNoMundoXY(nave, 0, 0);
	}
	public void vetorCriarAsteroids1() {
		Asteroides vetorAsteroide[] = new Asteroides[5];
		int x = 2, y = 1;
		for (int cont = 0; cont < vetorAsteroide.length; cont++) {
			vetorAsteroide[cont] = new Asteroides();	
			adicionarObjetoNoMundoXY(vetorAsteroide[cont], x, y);
			x++;
//			if (x == 7) {
//				y++;
//				x = 2;
//			}		
		}
	}
	public void vetorCriarAsteroids2() {
		Asteroide2 vetorAsteroide[] = new Asteroide2[5];
		int x = 2, y = 2;
		for (int cont = 0; cont < vetorAsteroide.length; cont++) {
			vetorAsteroide[cont] = new Asteroide2();	
			adicionarObjetoNoMundoXY(vetorAsteroide[cont], x, y);
			x++;		
		}
	}
	public void vetorCriarAsteroids3() {
		Asteroide3 vetorAsteroide[] = new Asteroide3[5];
		int x = 2, y = 3;
		for (int cont = 0; cont < vetorAsteroide.length; cont++) {
			vetorAsteroide[cont] = new Asteroide3();	
			adicionarObjetoNoMundoXY(vetorAsteroide[cont], x, y);
			x++;		
		}
	}
	public void vetorCriarAsteroids4() {
		Asteroide4 vetorAsteroide[] = new Asteroide4[5];
		int x = 2, y = 4;
		for (int cont = 0; cont < vetorAsteroide.length; cont++) {
			vetorAsteroide[cont] = new Asteroide4();	
			adicionarObjetoNoMundoXY(vetorAsteroide[cont], x, y);
			x++;		
		}
	}
	
	public void usarTecla() {
		boolean pause = true;
		int tecla = getUltimaTeclaPress();
			switch (tecla) {
			case TECLADIREITA:
				andarDireita();
				break;
			case TECLAESQUERDA:
				andarEsquerda();
				break;
			case TECLAESPACO:
				Tiro tiro = new Tiro();
				adicionarObjetoNoMundoXY(tiro, getX(), getY()-1);
				esperar(1);
				break;
			case 80:
				diga(pause);
				pause = false;
				diga(pause);
				break;
		}
	}
	
	public static void main(String[] args) {
			MundoVisual.iniciar("SpaceInvaders.xml");
	}
	
	public void inteligencia() throws Exception {
		
		limparConsole();
		vetorCriarAsteroids1();
		vetorCriarAsteroids2();
		vetorCriarAsteroids3();
		vetorCriarAsteroids4();
		criarNave();
		while (true) {
			usarTecla();
		}
	}
}