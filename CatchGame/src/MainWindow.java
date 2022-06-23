import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MainWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	// フィールド
	ScreenMode screenMode =ScreenMode.TITLE;
	// 定数
	final int WIDTH = 800; // フレームの幅
	final int HEIGHT = 600; // フレームの高さ
	// レイアウト
	CardLayout layout = new CardLayout();
	// コンポネート
	TitlePanel titlePanel;
	GamePanel gamePanel;

	// コンストラクタ
	MainWindow(){
		/*
		   コンストラクタ内でのthisの意味は？
		 */

		// ウィンドウ左上のアイコンとタイトル
		this.setTitle("タイトル");
		ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource(""));
		this.setIconImage(icon.getImage());

		// ウィンドウの処理
		// ×ボタンを押下した際にプログラムが終了する
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// 画面のサイズ変更を不可能にする
		this.setResizable(false);
		// 背景色
		this.getContentPane().setBackground(Color.green);
		// レイアウトを紙芝居風に設定
		this.setLayout(layout);
		// サイズ設定
		this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		// 自動サイズ調整
		this.pack();
		// 起動時のスクリーンの位置を中央に設定
		this.setLocationRelativeTo(null);
	}

	// パネルを準備するメソッド
	public void preparePanels() {
		titlePanel = new TitlePanel();
		// 下記thisはTitlePanelクラスのインスタンスを指す？
		this.add(titlePanel,"タイトル画面");
		gamePanel = new GamePanel();
		// 下記thisはGamePanelクラスのインスタンスを指す？
		this.add(gamePanel,"ゲーム画面");
		this.pack();
	}

	// コンポネートを準備するメソッド
	public void prepareComponents() {
		titlePanel.prepareComponents();
		gamePanel.prepareComponents();
	}

	// スクリーンモードを切り替える
	public void setFrontScreenAndFoucus(ScreenMode s) {
		screenMode = s;
		// 表示される画面の設定
		switch(screenMode) {
		case TITLE:
			layout.show(this.getContentPane(),"タイトル画面");
			titlePanel.requestFocus();
			break;
		case GAME:
			layout.show(this.getContentPane(),"ゲーム画面");
			gamePanel.requestFocus();
			break;
		}

	}

}
