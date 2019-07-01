import java.util.Random;
import javax.swing.ImageIcon;
import br.furb.furbot.Direcao;
import br.furb.furbot.ObjetoDoMundoAdapter;
import br.furb.furbot.suporte.LoadImage;

public class Nave extends ObjetoDoMundoAdapter {
	
	public void tiroAleatorio() {
		Random numeroAleatorio = new Random();
		int aleatorio;
		aleatorio = numeroAleatorio.nextInt(5);
		TiroNave tiroNave = new TiroNave();
		while (true) {
			switch (aleatorio) {
			case 1:
				break;
			case 2:
				esperar(1);
				adicionarObjetoNoMundoXY(tiroNave, getX(), getY()+1);
				break;
			case 3:
				break;
			}
			break;
		}	
	}

	private void andar(Direcao direcao) {
		switch (direcao) {
		case DIREITA:
			andarDireita();
			break;
		case ESQUERDA:
			andarEsquerda();
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

	@Override
	public ImageIcon buildImage() {	
		return LoadImage.getInstance().getIcon("Nave.png");
	}

	@Override
	public void executar() throws Exception {
		Direcao direcao = DIREITA;
		while (true) {
			if (!ehFim(direcao)) {
				tiroAleatorio();
				esperar(1);
				andar(direcao);
			}else {
				direcao = mudarDirecao(direcao);
			}
		}
	}
}