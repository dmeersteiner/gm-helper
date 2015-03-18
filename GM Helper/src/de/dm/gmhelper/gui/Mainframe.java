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
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import de.dm.gmhelper.gui.dataaccess.PnlDataAccess;

public class Mainframe extends JFrame {

	private JPanel contentPane;
	private PnlConsole pnlConsole;
	
	private final RedoRollAction redoRollAction = new RedoRollAction();
	private JToolBar utilityBar;
	
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
		setBounds(100, 100, 900, 600);
		{
			//All Menus
			JMenuBar menuBar = new JMenuBar();
			setJMenuBar(menuBar);			
			{
				//Utility Menu
				JMenu mnUtility = new JMenu("Utility");
				menuBar.add(mnUtility);
				
				JCheckBoxMenuItem chckbxmntmShowUtilityBar = new JCheckBoxMenuItem("Show Utility Bar");
				chckbxmntmShowUtilityBar.setSelected(true);
				chckbxmntmShowUtilityBar.addChangeListener(new ChangeListener() {
					public void stateChanged(ChangeEvent e) {
						utilityBar.setVisible(chckbxmntmShowUtilityBar.isSelected());
					}
				});
				mnUtility.add(chckbxmntmShowUtilityBar);
				mnUtility.addSeparator();
				
				JMenuItem mntmDoLastRoll = new JMenuItem("Do last roll again");
				mntmDoLastRoll.setAction(redoRollAction);
				mntmDoLastRoll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_MASK));
				mnUtility.add(mntmDoLastRoll);
				contentPane = new JPanel();
				contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
				contentPane.setLayout(new BorderLayout(0, 0));
				setContentPane(contentPane);
				
				utilityBar = new JToolBar();
				utilityBar.setFloatable(false);
				getContentPane().add(utilityBar, BorderLayout.NORTH);
				
				JButton btnDoLastRoll = new JButton("Do Last Roll Again");
				btnDoLastRoll.setAction(redoRollAction);
				utilityBar.add(btnDoLastRoll);
			}
		}
		JSplitPane splMain = new JSplitPane();
		splMain.setDividerSize(5);
		splMain.setBorder(UIManager.getBorder("SplitPane.border"));
		splMain.setResizeWeight(0.75);
		splMain.setContinuousLayout(true);
		contentPane.add(splMain, BorderLayout.CENTER);
		
		JSplitPane splWorking = new JSplitPane();
		splWorking.setDividerSize(5);
		splWorking.setResizeWeight(0.25);
		splWorking.setBorder(null);
		splMain.setLeftComponent(splWorking);
		
		
		
		JLabel lblTodoEditwindow = new JLabel("TODO: Editwindow");
		splWorking.setRightComponent(lblTodoEditwindow);
		
		PnlDataAccess pnlDataAccess = new PnlDataAccess();
		splWorking.setLeftComponent(pnlDataAccess);
		
		JSplitPane splNotes = new JSplitPane();
		splNotes.setDividerSize(5);
		splNotes.setBorder(null);
		splNotes.setResizeWeight(0.25);
		splNotes.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splMain.setRightComponent(splNotes);
		
		pnlConsole = new PnlConsole();
		pnlConsole.setInputDoubleClickAccessEnabled(true);
		splNotes.setLeftComponent(pnlConsole);
		
		PnlFastNotesPane pnlFastNotesPane = new PnlFastNotesPane();
		splNotes.setRightComponent(pnlFastNotesPane);
		
		JPanel pnlStatus = new JPanel();
		contentPane.add(pnlStatus, BorderLayout.SOUTH);
	}

	private class RedoRollAction extends AbstractAction {
		public RedoRollAction() {
			putValue(NAME, "Repeat Last Roll");
			putValue(SHORT_DESCRIPTION, "Repeats the last entered command of the Dice Roller in the top right corner");
		}
		public void actionPerformed(ActionEvent e) {
			pnlConsole.doLastCommand();
		}
	}
}
