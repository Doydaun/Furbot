import javax.swing.ImageIcon;
import br.furb.furbot.ObjetoDoMundoAdapter;
import br.furb.furbot.suporte.LoadImage;

public class TiroNave extends ObjetoDoMundoAdapter {
	
	public void balaDescendo() {
		while (!ehFim(ABAIXO)) {
			esperar(1);
			andarAbaixo();
			if (ehFim(ABAIXO)) {
				esperar(1);
				removerMe();
			}
		}
	}
	
	

	@Override
	public ImageIcon buildImage() {

		return LoadImage.getInstance().getIcon("Tironave.png");
	}

	@Override
	public void executar() throws Exception {
			while (true) {
				balaDescendo();
			}

	}

}
