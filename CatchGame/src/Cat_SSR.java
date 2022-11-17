import javax.swing.ImageIcon;

//SSRのネコ（ライオン）
public class Cat_SSR extends Animal {
	private static final long serialVersionUID = 1L;

	//設定
	protected void prepareImageAndScoreAndVoice(){
		super.image = new ImageIcon(getClass().getClassLoader().getResource("animal_lion.png")).getImage();
		super.score = 100;
		super.voiceKey = "威嚇";
		super.escapeTime = 150;
	};
}
