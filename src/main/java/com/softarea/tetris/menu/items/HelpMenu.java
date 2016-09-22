package com.softarea.tetris.menu.items;

import com.softarea.tetris.menu.AbstractMenu;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class HelpMenu extends AbstractMenu {

  public HelpMenu() {
    super("menu.help.title", "menu.help.description");
  }

  @Override
  protected void initItems() {
    addMenuItem("menu.help.tableOfContents", KeyStroke.getKeyStroke(
        KeyEvent.VK_F1, 0));
    addMenuItem("menu.help.about", null);
  }
}
