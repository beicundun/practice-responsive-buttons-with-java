package gui_box_test;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GridBagLayoutTest implements ComponentListener {
	private JFrame frame;
	private Container frameInner;
	private ArrayList<JButton> buttonList;
	private int fontSizeL = 20;
	private int fontSizeM = 16;
	private int fontSizeS = 12;
	private Iterator<JButton> it;
	
	/**
	 * コンストラクタ
	 */
	public GridBagLayoutTest() {
		// コンポーネントを配置するフレームなどを生成
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameInner = frame.getContentPane();
		
		// 全ボタンを格納するためのリストを生成
		buttonList = new ArrayList<JButton>();
		
		// ナビ
		JPanel navPane = new JPanel();
		GridBagLayout gbLayout = new GridBagLayout();
		navPane.setLayout(gbLayout);
		frameInner.add(navPane);
		GridBagConstraints gbc = new GridBagConstraints();
		// 
		gbc.fill = GridBagConstraints.BOTH;
		// 余白の扱いの設定
		// https://www.javadrive.jp/tutorial/gridbaglayout/index5.html
		gbc.weightx = 1.0d;
		gbc.weighty = 1.0d;
		// ボタン間の余白
		gbc.insets = new Insets(2, 2, 2, 2);
		
		// ボタン1
		JButton button1 = new JButton("ボタン1");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbLayout.setConstraints(button1, gbc);
		navPane.add(button1);
		buttonList.add(button1);
		
		// ボタン2
		JButton button2 = new JButton("ボタン2");
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbLayout.setConstraints(button2, gbc);
		navPane.add(button2);
		buttonList.add(button2);
		
		// ボタン3
		JButton button3 = new JButton("ボタン3");
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		gbLayout.setConstraints(button3, gbc);
		navPane.add(button3);
		buttonList.add(button3);
		
		// ボタン4
		JButton button4 = new JButton("ボタン4");
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 2;
		gbLayout.setConstraints(button4, gbc);
		navPane.add(button4);
		buttonList.add(button4);
		
		// ボタン5
		JButton button5 = new JButton("ボタン5");
		gbc.gridx = 3;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		gbLayout.setConstraints(button5, gbc);
		navPane.add(button5);
		buttonList.add(button5);
		
		// ボタン6
		JButton button6 = new JButton("ボタン6");
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbLayout.setConstraints(button6, gbc);
		navPane.add(button6);
		buttonList.add(button6);
		
		// ボタン7
		JButton button7 = new JButton("ボタン7");
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		gbLayout.setConstraints(button7, gbc);
		navPane.add(button7);
		buttonList.add(button7);
		
		// ボタン8
		JButton button8 = new JButton("ボタン8");
		gbc.gridx = 3;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.gridheight = 2;
		gbLayout.setConstraints(button8, gbc);
		navPane.add(button8);
		buttonList.add(button8);
		
		// ボタン9
		JButton button9 = new JButton("ボタン9");
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		gbLayout.setConstraints(button9, gbc);
		navPane.add(button9);
		buttonList.add(button9);
		
		// ボタン10
		JButton button10 = new JButton("ボタン10");
		gbc.gridx = 2;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		gbLayout.setConstraints(button10, gbc);
		navPane.add(button10);
		buttonList.add(button10);
		
		// ボタン11
		JButton button11 = new JButton("ボタン11");
		gbc.gridx = 4;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbLayout.setConstraints(button11, gbc);
		navPane.add(button11);
		buttonList.add(button11);
		
		frame.pack();
		
		// ボタンを一括処理するためのイテレータを取得
		it = buttonList.iterator();
		// フレームリサイズ時のイベントハンドラを設定
		frame.addComponentListener(this);
	}
	
	/**
	 * 全ボタンの文字サイズを変更
	 * @param size
	 */
	public void setButtonFontSize(int size) {
		it = buttonList.iterator();
		while(it.hasNext()) {
			JButton button = it.next();
			button.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, size));
		}
	}

	@Override
	public void componentHidden(ComponentEvent event) {
		
	}
	
	@Override
	public void componentMoved(ComponentEvent event) {
		
	}
	
	@Override
	/**
	 * フレームリサイズ時の処理
	 */
	public void componentResized(ComponentEvent event) {
		// フレームの縦横サイズを取得
		JFrame frame = (JFrame)event.getSource();
		int width = frame.getWidth();
		int height = frame.getHeight();
		
		// フレームのサイズに応じて文字サイズを変更
		if (width > 1280) {
			this.setButtonFontSize(this.fontSizeL);
		}
		else if (width > 720) {
			this.setButtonFontSize(this.fontSizeM);
		}
		else {
			this.setButtonFontSize(this.fontSizeS);
		}
		
		System.out.println("リサイズ");
		System.out.printf("width:%d height:%d", width, height);
	}
	
	@Override
	public void componentShown(ComponentEvent event) {
		
	}
	
	public static void main(String[] args) {
		GridBagLayoutTest gbl = new GridBagLayoutTest();
		gbl.frame.setVisible(true);
	}
}
