package de.dm.gmhelper.data.info;
import java.awt.BorderLayout;

import javax.swing.JTextField;
import javax.swing.JLabel;

public class TextFieldPanel extends InfoPanel {
	
	private static final long serialVersionUID = -834843947527417230L;
	
	private JTextField textField;
	private TextFieldData data;
	private JLabel label;

	private TextFieldPanel() {
		setLayout(new BorderLayout(5, 5));
		
		textField = new JTextField("{text}");
		add(textField, BorderLayout.CENTER);
		
		label = new JLabel("{label}");
		add(label, BorderLayout.WEST);
	}
	
	TextFieldPanel(TextFieldData data) {
		this();
		if (data == null) {
			throw new IllegalArgumentException("data must be not null");
		}
		this.data = data;
		textField.setColumns(data.getColumnlength());
		textField.setText(data.getText());
		label.setText(data.getLabel());
	}
	
	@Override
	public void save() {
		data.setText(textField.getText());
	}

}
