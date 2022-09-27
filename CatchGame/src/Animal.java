import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.Timer;

/*
 * 動物抽象クラス
 * 捕獲時の画像、スコア、鳴き声をサブクラスで指定する
 */

public abstract class Animal extends JLabel {
	private static final long serialVersionUID = 1L;
	//100*100の画像
	Image image;
	//捕獲時の得点
	int score;
	//捕獲時の鳴き声のkey
	String voiceKey;
	//各個体の制御
	Timer timer = null;
	//時間経過で消える制御
	int escapeTime = 500;
	//座標と速度
	int x;
	int y;
	int xVelocity;
	int yVelocity;

	//コンストラクタ
	public Animal(){
		//座標
		x = new java.util.Random().nextInt(680);
		y = new java.util.Random().nextInt(300);
		//速度
		do {
		xVelocity = -5 + new java.util.Random().nextInt(11);
		yVelocity = -5 + new java.util.Random().nextInt(11);
		}while(xVelocity == 0 || yVelocity == 0);
		this.prepareImageAndScoreAndVoice();
		//貼り付け先の位置とラベルサイズを設定
		this.setBounds(x,y,image.getWidth(null),image.getHeight(null));
	}

	//設定(抽象メソッド)
	protected abstract void prepareImageAndScoreAndVoice();

	//画像の動作処理
	public void paint(Graphics g) {
		super.paint(g);
		//画像の処理
		Graphics2D g2D = (Graphics2D)g;
		if(xVelocity >= 0) {
			g2D.drawImage(image, 0, 0, image.getWidth(null), image.getHeight(null), null);
		}else {
			g2D.drawImage(image, image.getWidth(null), 0, -image.getWidth(null), image.getHeight(null), null);
		}
	}

}
