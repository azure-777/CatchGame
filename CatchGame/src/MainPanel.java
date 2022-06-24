import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class MainPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	// 定数フィールド
	Color backgroundColor = Color.green;
	// コンポネート
	CatLabel catLabel;
	// リスナー
	MykeyListener mykeyListener;

	// コンストラクタ
	public MainPanel() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	//
	public void prepareComponents() {}

	//ネコの制御(内部クラス)
	private class MykeyListener implements KeyListener{
		// 貼りつけ先を保持
		MainPanel panel;

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
		public void KeyReleased(KeyEvent e) {
			// do nothing
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// insert code
		}
	}
}
