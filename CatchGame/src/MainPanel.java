import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MainPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	//定数フィールド
	Color backgroundColor = Color.BLACK;
	//コンポネート
	CatLabel catLabel;
	JLabel mainLabel;
	CatLabel cat01;
	CatLabel cat02;

	//コンストラクタ
	public MainPanel() {
		//レイアウトの設定
		this.setLayout(null);
		//背景の色
		this.setBackground(backgroundColor);
	}

	//コンポネートの処理
	public void prepareComponents() {
		//各ラベル生成
		catLabel = new CatLabel();
		mainLabel = new JLabel();
		cat01 = new CatLabel();
		vitalizeCat(cat01);
		cat02 = new CatLabel();
		vitalizeCat(cat02);
		//メインラベルに文字を記載？
		mainLabel.setText("");
		//メインラベルの位置とサイズを指定
		mainLabel.setBounds(100,200,100,30);
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
			if(cat.x > Main.mainWindow.mainPanel.getWidth() - cat.getWidth() || cat.x < 0) {
				cat.xVelocity = cat.xVelocity * (-1);
			}
			cat.x = cat.x + cat.xVelocity;
			if(cat.y > Main.mainWindow.mainPanel.getHeight() - cat.getHeight() || cat.y < 0) {
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
			int y = e.getXOnScreen() - dy;
			if(x < Main.mainWindow.mainPanel.getWidth() - cat.getWidth() - 5 && x > 5) { cat.x = x;}
			if(y < Main.mainWindow.mainPanel.getHeight() - cat.getHeight() - 5 && y > 5) { cat.y = y;}
			cat.setLocation(cat.x,cat.y);
		}

		//マウスのクリック処理
		public void mouseClicked(MouseEvent e) {
			if(e.getClickCount() >= 2) {
				//ダブルクリック
				Main.mainWindow.mainPanel.remove(e.getComponent());
				repaint();
			}
		}

		//マウスをはなした時の処理
		public void mouseReleased(MouseEvent e) {
			cat.timer.start();
		}

	}


}
