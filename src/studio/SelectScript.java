package studio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class SelectScript implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent evt) {

		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setAcceptAllFileFilterUsed(false);
		FileNameExtensionFilter filter = new FileNameExtensionFilter("TEST", "test");
		fileChooser.addChoosableFileFilter(filter);

		int value = fileChooser.showOpenDialog(null);

		if (value == JFileChooser.APPROVE_OPTION)
			UserCaseImpl.tname.setText(fileChooser.getSelectedFile().getAbsolutePath());
		else
			UserCaseImpl.tname.setText("the user cancelled the operation");

	}
}
