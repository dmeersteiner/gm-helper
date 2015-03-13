package de.dm.gmhelper.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.border.EtchedBorder;

import de.dm.dr2.gui.PnlConsole;
import de.dm.gmhelper.gui.notes.PnlFastNotesPane;

import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;
import javax.swing.JEditorPane;
import javax.swing.JTabbedPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.UIManager;

public class Mainframe extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mainframe frame = new Mainframe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Mainframe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JSplitPane splMain = new JSplitPane();
		splMain.setDividerSize(3);
		splMain.setBorder(UIManager.getBorder("SplitPane.border"));
		splMain.setResizeWeight(0.75);
		splMain.setContinuousLayout(true);
		contentPane.add(splMain, BorderLayout.CENTER);
		
		JSplitPane splWorking = new JSplitPane();
		splWorking.setDividerSize(3);
		splWorking.setResizeWeight(0.25);
		splWorking.setBorder(null);
		splMain.setLeftComponent(splWorking);
		
		JSplitPane splNotes = new JSplitPane();
		splNotes.setDividerSize(3);
		splNotes.setBorder(null);
		splNotes.setResizeWeight(0.25);
		splNotes.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splMain.setRightComponent(splNotes);
		
		PnlConsole pnlConsole = new PnlConsole();
		splNotes.setLeftComponent(pnlConsole);
		
		PnlFastNotesPane pnlFastNotesPane = new PnlFastNotesPane();
		splNotes.setRightComponent(pnlFastNotesPane);
		
		JPanel pnlStatus = new JPanel();
		contentPane.add(pnlStatus, BorderLayout.SOUTH);
	}

}
