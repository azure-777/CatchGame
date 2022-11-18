import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
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
		timer = new Timer(10,this);
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

	//ゲームリセットメソッド
	public void resetGame() {
		this.fieldPanel.removeAll();
		this.fieldPanel.prepareComponents();
		menuBar.scoreLabel = new JLabel("SCORE:0");
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

	//タイマー
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		if(this.now > this.hold) {
			this.minusOne();
		}else {
			this.timer.stop();
			Main.mainWindow.setFrontScreenAndFocus(ScreenMode.TITLE);
			//結果表示
			JFrame resultScoreFrame = new JFrame();
	        JLabel resultScoreLabel = new JLabel("SCORE:" + Main.mainWindow.gamePanel.menuBar.score);
	        resultScoreFrame.setLayout(new FlowLayout());
	        resultScoreFrame.setBounds(500, 300, 400, 100);
	        resultScoreFrame.add(resultScoreLabel);
	        resultScoreFrame.setVisible(true);
		}
	}

}
