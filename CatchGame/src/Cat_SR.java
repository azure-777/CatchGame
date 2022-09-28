import javax.swing.ImageIcon;

//SRのネコ（ギターねこ）
public class Cat_SR extends Animal {
	private static final long serialVersionUID = 1L;

	//設定
	protected void prepareImageAndScoreAndVoice(){
		super.image = new ImageIcon(getClass().getClassLoader().getResource("animal_music_band_guitar.png")).getImage();
		super.score = 50;
		super.voiceKey = "ニャー";
		super.escapeTime = 200;
	};
}
