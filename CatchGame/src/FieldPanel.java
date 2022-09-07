import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FieldPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	JLabel gameLabel;
	// コンストラクタ
	public FieldPanel() {
		this.setBackground(Color.orange);
		this.setLayout(null);
		// サイズは自動調整される
	}

	// コンストラクタの後に呼び出す処理
	public void prepareComponents() {
		// コンポネート
		// ラベルの生成
		gameLabel = new JLabel();
		// ラベルに文字を記入
		gameLabel.setText("ゲーム画面");
		// 位置とサイズを指定
		gameLabel.setBounds(0,0,100,30);
		// 縁取り
		gameLabel.setBorder(BorderFactory.createLineBorder(Color.black,3));
		// ラベルをこのパネルにはる
		this.add(gameLabel);
	}

}
