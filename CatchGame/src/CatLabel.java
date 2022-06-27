import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

//ネコのラベル
public class CatLabel extends JLabel {
	private static final long serialVersionUID = 1L;

	// フィールド
	Image catImage;

	// コンストラクタ
	CatLabel(){
		// 画像の設定
		catImage = new ImageIcon(getClass().getClassLoader().getResource("sax_cat.png")).getImage();
		// 貼り付け先の位置とラベルサイズを設定
		this.setBounds(100,100,catImage.getWidth(null),catImage.getHeight(null));
	}

	public void paint(Graphics g) {
		super.paint(g);
		// ネコの画像を使用
		Graphics2D g2D = (Graphics2D)g;
		g2D.drawImage(catImage, 0, 0, catImage.getWidth(null), catImage.getHeight(null), null);
	}
}
