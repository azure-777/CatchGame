import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

// ゲームパネルクラス
public class GamePanel extends JPanel{
	private static final long serialVersionUID = 1L;
	//レイアウト
	BorderLayout layout = new BorderLayout();
	//コンポネート
	JLabel gameLabel;
	MenuBar menuBar;
	FieldPanel fieldPanel;
	//リスナー
	MyKeyListener myKeyListener;

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
		//なぜthisを使用するのか？
		this.add(gameLabel);
		//メニューバーとフィールドパネルについての処理
		menuBar.prepareComponents();
		fieldPanel.prepareComponents();
		//リスナーを設置
		myKeyListener = new MyKeyListener(this);
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
			// TODO 自動生成されたメソッド・スタブ
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO 自動生成されたメソッド・スタブ
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

}
