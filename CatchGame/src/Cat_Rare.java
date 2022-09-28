import javax.swing.ImageIcon;

//Rのネコ（合唱ねこ）
public class Cat_Rare extends Animal {
	private static final long serialVersionUID = 1L;

	//設定
	protected void prepareImageAndScoreAndVoice(){
		super.image = new ImageIcon(getClass().getClassLoader().getResource("gassyou_neko.png")).getImage();
		super.score = 15;
		super.voiceKey = "ニャー";
		super.escapeTime = 500;
	};
}
