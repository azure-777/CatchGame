import javax.swing.ImageIcon;

//通常得点のネコ（サックスねこ）
public class Cat_Normal extends Animal {
	private static final long serialVersionUID = 1L;

	//コンストラクタのオーバーライド
		Cat_Normal(){
			super();
			super.xVelocity = 0;
			super.yVelocity = 0;
		}

	//設定
	protected void prepareImageAndScoreAndVoice(){
		super.image = new ImageIcon(getClass().getClassLoader().getResource("sax_cat.png")).getImage();
		super.score = 3;
		super.voiceKey = "ニャー";
	};
}