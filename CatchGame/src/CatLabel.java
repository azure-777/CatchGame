import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

//ネコのラベル
public class CatLabel extends JLabel {
	private static final long serialVersionUID = 1L;
	//フィールド
	Image catImage;
	//ラベルの左上の点のx座標
	int x;
	//ラベルの左上の点のy座標
	int y;
	int xVelocity;
	int yVelocity;
	Timer timer = null;

	//コンストラクタ
	CatLabel(){
		//画像の設定
		catImage = new ImageIcon(getClass().getClassLoader().getResource("sax_cat.png")).getImage();
		//貼り付け先の位置とラベルサイズを設定
		this.setBounds(100,100,catImage.getWidth(null),catImage.getHeight(null));
		//初期設定の座標と速さを決定
		//座標
		x = new java.util.Random().nextInt(Main.mainWindow.mainPanel.getWidth()-this.getWidth());
		y = new java.util.Random().nextInt(Main.mainWindow.mainPanel.getWidth()-this.getWidth());
		//速度
		xVelocity = -5 + new java.util.Random().nextInt(11);
		yVelocity = -5 + new java.util.Random().nextInt(11);
		//位置設定
		this.setLocation(x,y);
	}

	//ネコの動作処理
	public void paint(Graphics g) {
		super.paint(g);
		//ネコ画像の処理
		Graphics2D g2D = (Graphics2D)g;
		if(xVelocity >= 0) {
			g2D.drawImage(catImage, 0, 0, catImage.getWidth(null), catImage.getHeight(null), null);
		}else {
			g2D.drawImage(catImage, catImage.getWidth(null), 0, -catImage.getWidth(null), catImage.getHeight(null), null);
		}
	}
}
