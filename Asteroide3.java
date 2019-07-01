import javax.swing.ImageIcon;
import br.furb.furbot.Direcao;
import br.furb.furbot.ObjetoDoMundoAdapter;
import br.furb.furbot.suporte.LoadImage;

public class Asteroide3 extends ObjetoDoMundoAdapter {
	
	private void andar(Direcao direcao) {
		switch (direcao) {
		case DIREITA:
			andarDireita();
			break;
		case ESQUERDA:
			andarEsquerda();
			break;
		case ABAIXO:
			andarAbaixo();
			break;
		default:
			break;	
		}
	}
	
	private Direcao mudarDirecao (Direcao direcao) {
		switch (direcao) {
		case DIREITA:
			direcao = ESQUERDA;
			break;
		case ESQUERDA:
			direcao = DIREITA;
			break;
		default:
			break;
		}
		return direcao;
	}
	
	public ImageIcon buildImage() {
		return LoadImage.getInstance().getIcon("Asteroide3.png");
	}
	
	@Override
	public void executar() throws Exception {
		Direcao direcao = DIREITA;
		int cont = 2;
		while (true) {
			if (cont < 5) {
				esperar(1);
				andar(direcao);
				cont++;
			} else {
				if (!ehFim(ABAIXO)) {
					esperar(1);
					andar(ABAIXO);
					direcao = mudarDirecao(direcao);
					if (cont == 5) {
						cont = 0;
					}
				}
				if (ehObjetoDoMundoTipo("Tiro", AQUIMESMO)) {
					removerMe();
				}
			}
		}
	}
}