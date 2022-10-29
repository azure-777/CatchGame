import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

//タイトルパネルのクラス
public class TitlePanel extends JPanel {
	private static final long serialVersionUID = 1L;

	//フィールド
	JLabel titleLabel;
	JLabel title;
	JLabel start;
	JLabel exit;
	JLabel select;
	JLabel message;
	Menu checkMenu = Menu.START;
	Border border = BorderFactory.createLineBorder(Color.BLACK,2);
	MykeyListener mykeyListener;

	//列挙型
	public enum Menu{
		START,
		EXIT
	}

	//コンストラクタ
	public TitlePanel() {
		//パネルサイズと貼り付け位置の設定はCardLayoutが自動で設定する
		//レイアウトの設定
		this.setLayout(null);
		//背景の設定
		this.setBackground(Color.cyan);
	}

	//コンポネートの設定
	public void prepareComponents() {
		//ラベルを生成
		titleLabel = new JLabel();
		//①ラベルに文字を記入
		titleLabel.setText("タイトル画面");
		//②コンポネートの位置とサイズを指定
		titleLabel.setBounds(100,10,100,30);
		//ラベルをこのパネルに貼る
		this.add(titleLabel);

		//タイトルロゴを作成
		//タイトルロゴを作成するためにJLabelのインスタンスを生成してtitle変数に代入
		title = new JLabel();
		//タイトルロゴの設定
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setVerticalAlignment(SwingConstants.BOTTOM);
		title.setText("CAT");
		title.setHorizontalTextPosition(JLabel.CENTER);
		title.setVerticalTextPosition(SwingConstants.BOTTOM);
		title.setBounds(90,10,600,350);
		title.setBorder(border); //解決できない場合は削除でおk

		//タイトルの選択肢作成
		//START選択肢
		start = new JLabel();
		start.setText("START");
		start.setFont(new Font("MV boli",Font.BOLD,40));
		start.setHorizontalTextPosition(JLabel.CENTER);
		start.setVerticalTextPosition(JLabel.BOTTOM);
		start.setBounds(330,400,150,40);

		//EXIT選択肢
		exit = new JLabel();
		exit.setText("EXIT");
		exit.setFont(new Font("MV boli",Font.BOLD,40));
		exit.setHorizontalTextPosition(JLabel.CENTER);
		exit.setVerticalTextPosition(JLabel.BOTTOM);
		exit.setBounds(350,450,150,40);

		//選択肢アイコン
		select = new JLabel();
		select.setBackground(Color.blue);
		select.setOpaque(true);
		select.setBounds(280,400,40,40);
		select.setBorder(border); //解決できない場合は削除でおk

		//説明
		message = new JLabel();
		message.setHorizontalAlignment(SwingConstants.CENTER);
		message.setText("選択：↑↓  決定：SPACE");
		message.setHorizontalTextPosition(JLabel.CENTER);
		message.setVerticalTextPosition(JLabel.CENTER);
		message.setBounds(249,517,300,30);
		message.setBorder(border); //見栄えが悪い場合は削除

		//配置
		this.setLayout(null);
		this.add(title);
		this.add(start);
		this.add(exit);
		this.add(select);
		this.add(message);

		//リスナーの設定
		mykeyListener = new MykeyListener(this);
	}

	//選択の制御(内部クラス)
		private class MykeyListener implements KeyListener{
			//貼りつけ先を保持
			TitlePanel panel;

			//コンストラクタ
			MykeyListener(TitlePanel p){
			super();
			panel = p;
			panel.addKeyListener(this);
		    }

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

			}
			@Override
			public void keyPressed(KeyEvent e) {
				switch(e.getKeyCode()) {
				//下を押した場合かつ
				case KeyEvent.VK_DOWN:
					//checkMenu変数の値とMenu.STARTで取得した値が同値の場合
					if(checkMenu == Menu.START) {
						//選択肢をY軸にプラス50をした場所に移動
						select.setLocation(select.getX(),select.getY()+50);
						checkMenu = Menu.EXIT;
					}
					break;

				//上を押した場合かつ
				case KeyEvent.VK_UP:
					//checkMenu変数の値とMenu.EXITで取得した値が同値の場合
					if(checkMenu == Menu.EXIT) {
						//選択肢をY軸にマイナス50をした場所に移動
						select.setLocation(select.getX(),select.getY()-50);
						checkMenu = Menu.START;
					}
					break;

				//スペースキーを押した場合かつ
				case KeyEvent.VK_SPACE:
					//checkMenu変数の値とMenu.STARTで取得した値が同値の場合
					if(checkMenu == Menu.START) {
						//ゲームが開始する（＝画面切り替えメソッドが呼び出される）
						Main.mainWindow.setFrontScreenAndFocus(ScreenMode.GAME);
						//切り替えと同時にタイマーが始動 ※20秒設定
						GamePanel g = new GamePanel();
						g.minus(2000);
					// checkMenu変数の値とMenu.EXITで取得した値が同値の場合
					}else if(checkMenu == Menu.EXIT) {
						//ゲームが終了する（＝プログラムの終了）
						System.exit(0);
					}
					break;
				}
			}
		}
}
