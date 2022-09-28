import javax.swing.ImageIcon;

//通常得点のネコ（サックスねこ）
public class Cat_Normal extends Animal {
	private static final long serialVersionUID = 1L;

	//設定
	protected void prepareImageAndScoreAndVoice(){
		super.image = new ImageIcon(getClass().getClassLoader().getResource("sax_cat.png")).getImage();
		super.score = 5;
		super.voiceKey = "ニャー";
	};
}