import java.awt.Color;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class FieldPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	JLabel gameLabel;
	JLayeredPane layeredPane;
	CatPot catPot;
	Animal animal;
	// コンストラクタ
	public FieldPanel() {
		this.setBackground(Color.orange);
		this.setLayout(null);
		// サイズは自動調整される
	}

	// コンストラクタの後に呼び出す処理
	public void prepareComponents() {
//		// コンポネート
//		// ラベルの生成
//		gameLabel = new JLabel();
//		// ラベルに文字を記入
//		gameLabel.setText("ゲーム画面");
//		// 位置とサイズを指定
//		gameLabel.setBounds(0,0,100,30);
//		// 縁取り
//		gameLabel.setBorder(BorderFactory.createLineBorder(Color.black,3));
//		// ラベルをこのパネルにはる
//		this.add(gameLabel);

		//レイヤーペインの追加
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0,0,WIDTH,HEIGHT);
		this.add(layeredPane);

		//ネコポットを配置
		catPot = new CatPot();
		catPot.setLocation(320,380);
		this.layeredPane.add(catPot,JLayeredPane.DEFAULT_LAYER);
	}

	//ホールの上でネコを落とすと消えて得点が加算
	public void mouseReleased(MouseEvent e) {
		int x = e.getXOnScreen();
		int y = e.getYOnScreen();
		int px = (int)catPot.getLocationOnScreen().getX();
		int py = (int)catPot.getLocationOnScreen().getY();
		int ph = catPot.getHeight();
		int pw = catPot.getWidth();

		if((px<x)&&(x<px+pw)&&(py<y)&&(y<py+ph)) {
			animal.setVisible(false);
		}else {
			animal.timer.start();
		}
	}

}
