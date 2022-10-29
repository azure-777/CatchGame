import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class FieldPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	JLabel gameLabel;
	JLayeredPane layeredPane;
	CatPot catPot;
	CatLabel cat01;
	//コンストラクタ
	public FieldPanel() {
		this.setBackground(Color.orange);
		this.setLayout(null); //サイズは自動調整される
	}

	//コンストラクタの後に呼び出す処理
	public void prepareComponents() {
		//キャットラベルの生成
		cat01 = new CatLabel();
		vitalizeCat(cat01);
//		gameLabel = new JLabel();
//		//ラベルに文字を記入
//		gameLabel.setText("ゲーム画面");
//		//位置とサイズを指定
//		gameLabel.setBounds(100,200,100,30);
//		//縁取り
//		gameLabel.setBorder(BorderFactory.createLineBorder(Color.black,3));
//		//ラベルをこのパネルにはる
//		this.add(gameLabel);

		//レイヤーペインの追加
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0,0,WIDTH,HEIGHT);
		this.add(layeredPane);

		//ネコポットを配置
		catPot = new CatPot();
		catPot.setLocation(320,380);
		this.layeredPane.add(catPot,JLayeredPane.DEFAULT_LAYER);
		this.add(catPot);
	}

	//ネコにリスナーをつけてからパネルに貼る処理
	public void vitalizeCat(CatLabel c) {
		new DDListener(c);
		CatActionListener catListener = new CatActionListener(c);
		c.timer = new Timer(10,catListener);
		this.add(c);
		c.timer.start();
	}

	//パネル内でネコを走らせるクラス(内部クラス)
		private class CatActionListener implements ActionListener{
			private CatLabel cat;

			public CatActionListener(CatLabel c) {
				cat = c;
			}

			@Override
			public void actionPerformed(ActionEvent e) {
				if(cat.x > Main.mainWindow.gamePanel.getWidth() - cat.getWidth() || cat.x < 0) {
					cat.xVelocity = cat.xVelocity * (-1);
				}
				cat.x = cat.x + cat.xVelocity;
				if(cat.y > Main.mainWindow.gamePanel.getHeight() - cat.getHeight() || cat.y < 0) {
					cat.yVelocity = cat.yVelocity * (-1);
				}
				cat.y = cat.y + cat.yVelocity;
				cat.setLocation(cat.x,cat.y);
				cat.repaint();

			}

		}

	//マウス操作_ドラッグアンドドロップ（内部クラス）
	private class DDListener extends MouseAdapter{
		private int dx;
		private int dy;
		private CatLabel cat;

		//コンストラクタ
		DDListener(CatLabel c){
			cat = c;
			cat.addMouseListener(this);
			cat.addMouseMotionListener(this);
		}

		//マウスの長押し処理
		public void mousePressed(MouseEvent e) {
			cat.timer.stop();
			//押さえたところからラベルの左上の差を取っておく
			dx = e.getXOnScreen() - cat.getX();
			dy = e.getYOnScreen() - cat.getY();
		}

		//マウスのドラッグ処理
		public void mouseDragged(MouseEvent e) {
			//マウスの座標からラベルの左上の座標を取得
			int x = e.getXOnScreen() - dx;
			int y = e.getYOnScreen() - dy;
			if(x < Main.mainWindow.gamePanel.getWidth() - cat.getWidth() - 5 && x > 5) { cat.x = x;}
			if(y < Main.mainWindow.gamePanel.getHeight() - cat.getHeight() - 5 && y > 5) { cat.y = y;}
			cat.setLocation(cat.x,cat.y);
		}

		//マウスのクリック処理
		public void mouseClicked(MouseEvent e) {
			if(e.getClickCount() >= 2) {
				//ダブルクリック
				Main.mainWindow.gamePanel.remove(e.getComponent());
				repaint();
			}
		}

		//ホールの上でネコを落とすと消えて得点が加算
		public void mouseReleased(MouseEvent e) {
			int x = e.getXOnScreen();
			int y = e.getYOnScreen();
			int px = (int)catPot.getLocationOnScreen().getX();
			int py = (int)catPot.getLocationOnScreen().getY();
			int ph = catPot.getHeight();
			int pw = catPot.getWidth();

			if((px<x)&&(x<px+pw)&&(py<y)&&(y<py+ph)) {
				//スコア計算
				Main.mainWindow.gamePanel.menuBar.score += cat.score;
				String str = "SCORE:" + Main.mainWindow.gamePanel.menuBar.score;
				Main.mainWindow.gamePanel.menuBar.scoreLabel.setText(str);
				//不可視化処理
				cat.setVisible(false);
			}else {
				cat.timer.start();
			}
		}

	}

}
