package util;


import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class LinhasZebradasRenderer extends DefaultTableCellRenderer {
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		final Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		c.setBackground(row % 2 == 0 ? Color.LIGHT_GRAY : Color.WHITE);
		return c;
	}
}
