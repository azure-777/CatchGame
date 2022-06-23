import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

// タイトルパネルのクラス
public class TitlePanel extends JPanel {
	private static final long serialVersionUID = 1L;

	// コンポネート
	JLabel titleLabel;

	// コンストラクタ
	public TitlePanel() {
		// パネルサイズと貼り付け位置の設定はCardLayoutが自動で設定する

		// レイアウトの設定
		this.setLayout(null);
		// 背景の設定
		this.setBackground(Color.red);
	}

	// コンポネートの設定
	public void prepareComponents() {
		// ラベルを生成
		titleLabel = new JLabel();
		// ①ラベルに文字を記入
		titleLabel.setText("タイトル画面");
		// ②コンポネートの位置とサイズを指定
		titleLabel.setBounds(100,0,100,30);
		// ラベルをこのパネルに貼る
		/*
		  なぜthisを使用するのか？
		  そもそもthisは自身のインスタンスを指す
		  この場合、JLabelクラスのインスタンスに①と②の内容を追加しているのか？
		 */
		this.add(titleLabel);

	}

}
