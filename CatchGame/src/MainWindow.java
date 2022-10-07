import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

//メインウィンドウのクラス
public class MainWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	//フィールド
	ScreenMode screenMode = ScreenMode.GAME;
	//定数
	final int WIDTH = 800;
	final int HEIGHT = 600;
	//レイアウト
	CardLayout layout = new CardLayout();
	//コンポネート
	TitlePanel titlePanel;
	GamePanel gamePanel;
	MainPanel mainPanel;

	//コンストラクタ
	MainWindow(){
		//ウィンドウのタイトル
		this.setTitle("CatchGame");

		//ウィンドウの処理
		//×ボタンを押下した際にプログラムが終了する
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//画面のサイズ変更を不可能にする
		this.setResizable(false);
		//背景色
		this.getContentPane().setBackground(Color.green);
		//レイアウトを紙芝居風に設定
		this.setLayout(layout);
		//サイズ設定
		this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		//自動サイズ調整
		this.pack();
		//起動時のスクリーンの位置を中央に設定
		this.setLocationRelativeTo(null);
	}

	//パネルを準備するメソッド
	public void preparePanels() {
		//TitlePanelをMainWindowに追加
		titlePanel = new TitlePanel();
		//GamePanelをMainWindowに追加
		this.add(titlePanel,"タイトル画面");
		gamePanel = new GamePanel();
		this.add(gamePanel,"ゲーム画面");
		//MainPanelをMainWindowに追加
		mainPanel = new MainPanel();
		this.add(mainPanel,"メイン画面");
		//Windowのサイズを自動変更
		this.pack();
	}

	//コンポネートを準備するメソッド
	public void prepareComponents() {
		titlePanel.prepareComponents();
		gamePanel.prepareComponents();
		mainPanel.prepareComponents();
	}

	//スクリーンモードを切り替える
	public void setFrontScreenAndFocus(ScreenMode s) {
		screenMode = s;
		//表示される画面の設定
		switch(screenMode) {
		case TITLE:
			layout.show(this.getContentPane(),"タイトル画面");
			titlePanel.requestFocus();
			break;
		case GAME:
			layout.show(this.getContentPane(),"ゲーム画面");
			gamePanel.requestFocus();
			break;
		case MAIN:
			layout.show(this.getContentPane(),"メイン画面");
			mainPanel.requestFocus();
			break;
		}

	}

}
