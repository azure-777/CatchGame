import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

//ゲームパネルクラス
public class GamePanel extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	//レイアウト
	BorderLayout layout = new BorderLayout();
	//コンポネート
	JLabel gameLabel;
	MenuBar menuBar;
	FieldPanel fieldPanel;
	//リスナー
	MyKeyListener myKeyListener;
	//Timer用フィールド
	int max;
	int now;
	int hold;
	Timer timer;

	//コンストラクタ
	GamePanel() {
		//パネルサイズと貼り付け位置の設定はCardLayoutが自動で設定する
		//レイアウトの設定
		this.setLayout(layout);
		//背景の設定
		this.setBackground(Color.yellow);
		//パネルの生成と設置
		menuBar = new MenuBar();
		fieldPanel = new FieldPanel();
		this.add(menuBar, BorderLayout.NORTH);
		this.add(fieldPanel, BorderLayout.CENTER);
		//Timer　引数は各ミリ秒で設定　※ミリ秒1秒の1000分の1（0.001秒）を表すもの。1000ミリ秒が1秒に相当する。
		timer = new Timer(10,this);
		//これだとタイトル画面から10秒計算されてしまう。またなぜ10秒なのか不明。さらにTimerの第一引数の10とminusメソッドの引数1000との関係が不明。
		this.minus(1000);
	}

	//コンポネートの設定
	public void prepareComponents() {
		//ラベルを生成
		gameLabel = new JLabel();
		//ラベルに文字を記入
		gameLabel.setText("ゲーム画面");
		//コンポネートの位置とサイズを指定
		gameLabel.setBounds(100,200,100,30);
		//ラベルをこのパネルに貼る
		this.add(gameLabel);
		//メニューバーとフィールドパネルについての処理
		menuBar.prepareComponents();
		fieldPanel.prepareComponents();
		//リスナーを設置
		myKeyListener = new MyKeyListener(this);
	}

	//Timer:値を1減らすメソッド
	public void minusOne(){
		now -= 1;
	}

	//Timer:値を減らすメソッド
	public void minus(int num){
		hold = now - num;
		this.timer.start();
	}

	//内部クラス(Hが押下されたらタイトルへ)
	private class MyKeyListener implements KeyListener {
		//貼り付け先を保持
		JPanel panel;

		//コンストラクタ
		MyKeyListener(JPanel p){
			super();
			panel = p;
			panel.addKeyListener(this);
		}

		@Override
		public void keyTyped(KeyEvent e) {

		}

		@Override
		public void keyPressed(KeyEvent e) {

		}

		@Override
		public void keyReleased(KeyEvent e) {
			switch(e.getKeyCode()) {
			//Hを押下した場合
			case KeyEvent.VK_H:
				Main.mainWindow.setFrontScreenAndFocus(ScreenMode.TITLE);
				break;
			}

		}
	}

	//Timer
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		if(this.now > this.hold) {
			this.minusOne();
		}else {
			this.timer.stop();
			Main.mainWindow.setFrontScreenAndFocus(ScreenMode.TITLE);
		}
	}

}
