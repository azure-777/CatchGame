import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

// ゲームパネル
public class GamePanel extends JPanel{
	private static final long serialVersionUID = 1L;

	// コンポネート
	JLabel gameLabel;

	// コンストラクタ
	public GamePanel() {
		// パネルサイズと貼り付け位置の設定はCardLayoutが自動で設定する

		// レイアウトの設定
		this.setLayout(null);
		// 背景の設定
		this.setBackground(Color.yellow);
	}

	// コンポネートの設定
	public void prepareComponents() {
		// ラベルを生成
		gameLabel = new JLabel();
		// ラベルに文字を記入
		gameLabel.setText("ゲーム画面");
		// コンポネートの位置とサイズを指定
		gameLabel.setBounds(100,200,100,30);
		// ラベルをこのパネルに貼る
		// ？なぜthisを使用するのか？
		this.add(gameLabel);

	}

}
