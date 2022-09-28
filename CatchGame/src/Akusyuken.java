import javax.swing.ImageIcon;

//握手券
public class Akusyuken  extends Animal {
	private static final long serialVersionUID = 1L;

	//設定
	protected void prepareImageAndScoreAndVoice(){
		super.image = new ImageIcon(getClass().getClassLoader().getResource("idol_akusyuken.png")).getImage();
		super.score = 500;
		super.voiceKey = "チャリン";
		super.escapeTime = 100;
	};
}
