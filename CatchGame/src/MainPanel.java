import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	// 定数フィールド
	Color backgroundColor = Color.green;
	// コンポネート
	CatLabel catLabel;
	JLabel mainLabel;
	// リスナー
	MykeyListener mykeyListener;

	// コンストラクタ
	public MainPanel() {
		// レイアウトの設定
		this.setLayout(null);
		// 背景の色
		this.setBackground(backgroundColor);
	}

	// コンポネートの処理
	public void prepareComponents() {
		// 各ラベル生成
		catLabel = new CatLabel();
		mainLabel = new JLabel();
		// メインラベルに文字を記載？
		mainLabel.setText("");
		// メインラベルの位置とサイズを指定
		mainLabel.setBounds(100,200,100,30);
		// 各ラベルを対象パネルに貼る
		this.add(catLabel);
		this.add(mainLabel);
		mykeyListener = new MykeyListener(this);
	}

	//ネコの制御(内部クラス)
	private class MykeyListener implements KeyListener{
		// 貼りつけ先を保持
		MainPanel panel;
		// コンストラクタ
		MykeyListener(MainPanel p){
		super();
		panel = p;
		p.addKeyListener(this);
	    }

		@Override
		public void keyTyped(KeyEvent e) {
			// do nothing
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// do nothing
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// 壁にぶつかったら止まる処理
			switch(e.getKeyCode()) {
			// 上を押した場合かつ
			case KeyEvent.VK_UP:
				// Y座標が0より大きい場合 → 画面の一番上より上の場合
				if(catLabel.getY() > 0) {
					// Y軸にマイナス5をした場所に設置
					catLabel.setLocation(catLabel.getX(),catLabel.getY()-5);
				}
				break;

			// 下を押した場合かつ
			case KeyEvent.VK_DOWN:
				// Y座標がパネルの位置より下な場合 → 画面の一番下より下の場合
				// catLabel.catImage.getHeight(null) 左記のnullは何を指している？？
				if(catLabel.getY() + catLabel.catImage.getHeight(null) < panel.getHeight()) {
					// Y軸にプラス5をした場所に設置
					catLabel.setLocation(catLabel.getX(),catLabel.getY()+5);
				}
				break;

			// 左を押した場合かつ
			case KeyEvent.VK_LEFT:
				// X座標が0より大きい場合 → 画面の一番左より左の場合
				if(catLabel.getX() > 0) {
					// X軸にマイナス5をした場所に設置
					catLabel.setLocation(catLabel.getX()-5,catLabel.getY());
				}
				break;

			// 右を押した場合かつ
			case KeyEvent.VK_RIGHT:
				// X座標がパネルの位置より右な場合 → 画面の一番右より右の場合
				// catLabel.catImage.getWidth(null) 左記のnullは何を指している？？
				if(catLabel.getX() + catLabel.catImage.getWidth(null) < panel.getWidth()) {
					// X軸にプラス5をした場所に設置
					catLabel.setLocation(catLabel.getX()+5,catLabel.getY());
				}
				break;

			// Enterを押した場合
			case KeyEvent.VK_ENTER:
				if(backgroundColor == Color.green) {
					backgroundColor = Color.blue;
					panel.setBackground(backgroundColor);
				}else if(backgroundColor == Color.blue) {
					backgroundColor = Color.green;
					panel.setBackground(backgroundColor);
				}
				break;
			}
		}
	}
}
