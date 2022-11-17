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
	CatLabel cat02;
	Cat_SSR cat03;
	Cat_SR cat04;
	Cat_Rare cat05;
	Akusyuken cat06;
	Cat_Rare cat07;
	Cat_Rare cat08;
	Cat_Rare cat09;
	Cat_SR cat10;
	//コンストラクタ
	public FieldPanel() {
		this.setBackground(Color.orange);
		this.setLayout(null); //サイズは自動調整される
	}

	//コンストラクタの後に呼び出す処理
	public void prepareComponents() {
		//キャットラベルの生成
		cat01 = new CatLabel();
		cat02 = new CatLabel();
		cat03 = new Cat_SSR();
		cat04 = new Cat_SR();
		cat05 = new Cat_Rare();
		cat06 = new Akusyuken();
		cat07 = new Cat_Rare();
		cat08 = new Cat_Rare();
		cat09 = new Cat_Rare();
		cat10 = new Cat_SR();
		vitalizeCat(cat01);
		vitalizeCat(cat02);
		vitalizeAnimal(cat03);
		vitalizeAnimal(cat04);
		vitalizeAnimal(cat05);
		vitalizeAnimal(cat06);
		vitalizeAnimal(cat07);
		vitalizeAnimal(cat08);
		vitalizeAnimal(cat09);
		vitalizeAnimal(cat10);

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

	//---------------------------------------------
	//ネコにリスナーをつけてからパネルに貼る処理
		public void vitalizeAnimal(Animal a) {
			new DDAListener(a);
			AnimalActionListener animalListener = new AnimalActionListener(a);
			a.timer = new Timer(10,animalListener);
			this.add(a);
			a.timer.start();
		}

		//パネル内でネコを走らせるクラス(内部クラス)
			private class AnimalActionListener implements ActionListener{
				private Animal animal;

				public AnimalActionListener(Animal a) {
					animal = a;
				}

				@Override
				public void actionPerformed(ActionEvent e) {
					if(animal.x > Main.mainWindow.gamePanel.getWidth() - animal.getWidth() || animal.x < 0) {
						animal.xVelocity = animal.xVelocity * (-1);
					}
					animal.x = animal.x + animal.xVelocity;
					if(animal.y > Main.mainWindow.gamePanel.getHeight() - animal.getHeight() || animal.y < 0) {
						animal.yVelocity = animal.yVelocity * (-1);
					}
					animal.y = animal.y + animal.yVelocity;
					animal.setLocation(animal.x,animal.y);
					animal.repaint();

				}

			}

		//マウス操作_ドラッグアンドドロップ（内部クラス）
		private class DDAListener extends MouseAdapter{
			private int dx;
			private int dy;
			private Animal animal;

			//コンストラクタ
			DDAListener(Animal a){
				animal = a;
				animal.addMouseListener(this);
				animal.addMouseMotionListener(this);
			}

			//マウスの長押し処理
			public void mousePressed(MouseEvent e) {
				animal.timer.stop();
				//押さえたところからラベルの左上の差を取っておく
				dx = e.getXOnScreen() - animal.getX();
				dy = e.getYOnScreen() - animal.getY();
			}

			//マウスのドラッグ処理
			public void mouseDragged(MouseEvent e) {
				//マウスの座標からラベルの左上の座標を取得
				int x = e.getXOnScreen() - dx;
				int y = e.getYOnScreen() - dy;
				if(x < Main.mainWindow.gamePanel.getWidth() - animal.getWidth() - 5 && x > 5) { animal.x = x;}
				if(y < Main.mainWindow.gamePanel.getHeight() - animal.getHeight() - 5 && y > 5) { animal.y = y;}
				animal.setLocation(animal.x,animal.y);
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
					Main.mainWindow.gamePanel.menuBar.score += animal.score;
					String str = "SCORE:" + Main.mainWindow.gamePanel.menuBar.score;
					Main.mainWindow.gamePanel.menuBar.scoreLabel.setText(str);
					//不可視化処理
					animal.setVisible(false);
				}else {
					animal.timer.start();
				}
			}

		}


}
