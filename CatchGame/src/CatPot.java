import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class CatPot extends JLabel {
	private static final long serialVersionUID = 1L;
	//フィールド
	ImageIcon image;

	//コンストラクタ
	public CatPot() {
		image = new ImageIcon(getClass().getClassLoader().getResource("space_blackhole2.png"));
		this.setSize(150,150);
		this.setIcon(image);
		this.setText("DROP");
		this.setHorizontalTextPosition(CENTER);
		this.setVerticalTextPosition(TOP);
	}

}
