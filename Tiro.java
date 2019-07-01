import javax.swing.ImageIcon;
import br.furb.furbot.ObjetoDoMundoAdapter;
import br.furb.furbot.suporte.LoadImage;

public class Tiro extends ObjetoDoMundoAdapter {
	
	public void balaSubindo() {
		while (!ehFim(ACIMA)) {
			esperar(1);
			andarAcima();
			if (ehFim(ACIMA)) {
				esperar(1);
				removerMe();
			}
		}
	}
	
	@Override
	public ImageIcon buildImage() {
		return LoadImage.getInstance().getIcon("Tiro.png");
	}
	
	@Override
	public void executar() throws Exception {
		while (true) {
			balaSubindo();
		}
	}
}