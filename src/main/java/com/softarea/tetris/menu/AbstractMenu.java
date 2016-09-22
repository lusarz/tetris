package com.softarea.tetris.menu;

import com.softarea.tetris.ApplicationContext;

import javax.swing.*;
import java.awt.event.ActionListener;

public abstract class AbstractMenu extends JMenu {

  public AbstractMenu(String titleCode, String descriptionCode) {
    super();
    String title = translate(titleCode);
    String description = translate(descriptionCode);

    init(title, null);
    getAccessibleContext().setAccessibleDescription(description);
    initItems();
  }

  protected String translate(String key) {
    return ApplicationContext.getInstance().getTranslation().translate(key);
  }

  protected void addMenuItem(String titleCode, KeyStroke keyStroke) {
    addMenuItem(titleCode, keyStroke, null);
  }

  protected void addMenuItem(String titleCode, KeyStroke keyStroke, ActionListener listener) {
    JMenuItem menuItem = new JMenuItem(translate(titleCode));
    if (keyStroke != null) {
      menuItem.setAccelerator(keyStroke);
    }

    if (listener != null) {
      menuItem.addActionListener(listener);
    }
    add(menuItem);
  }


  protected abstract void initItems();

}
