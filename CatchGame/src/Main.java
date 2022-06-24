
// ウィンドウを出力するクラス
public class Main {
	static MainWindow mainWindow;
	public static void main(String[] args) {
		// ウィンドウのみを生成する
		mainWindow = new MainWindow();
		// ペインに貼るパネルのみを生成
		mainWindow.preparePanels();
		// その他のコンポネートを生成
		mainWindow.prepareComponents();
		// 起動後、最初に表示させる画面を設定
		mainWindow.setFrontScreenAndFoucus(ScreenMode.TITLE);
		// ウィンドウを可視化
		mainWindow.setVisible(true);

	}

}
