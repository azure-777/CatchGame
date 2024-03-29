import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuBar extends JPanel {
	private static final long serialVersionUID = 1L;
	//コンポネート
	JButton homeButton;
	JLabel homeLabel;
	JLabel scoreLabel;
	HomeButtonListener homeButtonListener;
	int score; //FieldPanelのスコア計算用変数
	JLabel timeLimitLabel;
	//JProgressBar timeLimitBar;

	//コンストラクタ
	public MenuBar() {
		//パネルサイズと貼り付け位置の設定は不要
		//ただし幅は自動調整されるがこの命令は必須
		this.setPreferredSize(new Dimension(100,40));
		this.setBackground(Color.red);
		this.setLayout(null);
	}

	//コンストラクタ後の処理
	public void prepareComponents() {
		//ホームボタン
		homeButton = new JButton();
		homeButton.setBounds(5,5,80,30);
		homeButton.setText("HOME");
		homeButton.setFocusable(false);
		homeButtonListener = new HomeButtonListener();
		homeButton.addActionListener(homeButtonListener);

		//ホームラベル
		homeLabel = new JLabel(" ←'H'click ");
		homeLabel.setBounds(85,5,80,30);
		homeLabel.setBorder(BorderFactory.createEtchedBorder(3,Color.black,Color.black));

		//スコアラベル
		scoreLabel = new JLabel("SCORE:0");
		scoreLabel.setBounds(680,5,80,30);

		//制限時間ラベル(JLabel)-文字列のみ設定
		timeLimitLabel = new JLabel("君は10秒で何点とれるかな？");
		timeLimitLabel.setBounds(265,5,300,30);
		timeLimitLabel.setFont(new Font("MV Boil",Font.BOLD,22));

		//設置
		this.add(homeButton);
		this.add(homeLabel);
		this.add(scoreLabel);
		this.add(timeLimitLabel);
		//this.add(timeLimitBar);

		}

	//内部クラス(ホームボタン用リスナー)
	private class HomeButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			//タイトルにもどる
			Main.mainWindow.setFrontScreenAndFocus(ScreenMode.TITLE);
		}

	}
}
