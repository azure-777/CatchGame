import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

// タイトルパネルのクラス
public class TitlePanel extends JPanel {
	private static final long serialVersionUID = 1L;

	// コンポネート
	JLabel titleLabel;
	JLabel title;
	JLabel start;
	JLabel exit;
	JLabel select;
	JLabel message;
	Menu checkMenu = Menu.START;
	MykeyListener mykeyListener;

	// 列挙型
	public enum Menu{
		START,
		EXIT
	}

	// コンストラクタ
	public TitlePanel() {
		// パネルサイズと貼り付け位置の設定はCardLayoutが自動で設定する
		// レイアウトの設定
		this.setLayout(null);
		// 背景の設定 前色：red
		this.setBackground(Color.cyan);
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

		// タイトルロゴを作成
		// タイトルロゴを作成するためにJLabelのインスタンスを生成してtitle変数に代入
		title = new JLabel();
		// タイトルロゴの設定
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setVerticalAlignment(SwingConstants.BOTTOM);
		title.setText("CAT");
		title.setHorizontalTextPosition(JLabel.CENTER);
		title.setVerticalTextPosition(SwingConstants.BOTTOM);
		title.setBounds(90,0,600,350);
		title.setBorder(border); //解決できない場合は削除でおk

		// タイトルの選択肢作成
		// START選択肢
		start = new JLabel();
		start.setText("START");
		start.setFont(new Font("MV boli",Font.BOLD,40));
		start.setHorizontalTextPosition(JLabel.CENTER);
		start.setVerticalTextPosition(JLabel.BOTTOM);
		start.setBounds(330,400,150,40);
		start.setBorder(border); //解決できない場合は削除でおk

		// EXIT選択肢
		exit = new JLabel();
		exit.setText("exit");
		exit.setFont(new Font("MV boli",Font.BOLD,40));
		exit.setHorizontalTextPosition(JLabel.CENTER);
		exit.setVerticalTextPosition(JLabel.BOTTOM);
		exit.setBounds(350,450,110,40);
		exit.setBorder(border); //解決できない場合は削除でおk

		// 選択肢アイコン

	}

	//選択の制御(内部クラス)
		private class MykeyListener implements KeyListener{}
}
