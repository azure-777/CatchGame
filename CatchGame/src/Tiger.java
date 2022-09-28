import javax.swing.ImageIcon;

//トラ
public class Tiger extends Animal {
	private static final long serialVersionUID = 1L;

	//設定
	protected void prepareImageAndScoreAndVoice(){
		super.image = new ImageIcon(getClass().getClassLoader().getResource("animal_unpyou.png")).getImage();
		super.score = 200;
		super.voiceKey = "威嚇";
		super.escapeTime = 100;
	};
}
