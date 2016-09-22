package com.softarea.tetris.menu.items;

import com.softarea.tetris.menu.AbstractMenu;
import com.softarea.tetris.menu.listeners.FullScreenListener;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class ViewMenu extends AbstractMenu {

  public ViewMenu() {
    super("menu.view.title", "menu.view.description");
  }

  @Override
  protected void initItems() {
    addMenuItem("menu.view.fullScreen.title", KeyStroke.getKeyStroke(
        KeyEvent.VK_F11, 0), new FullScreenListener());
    addMenuItem("menu.view.toolbar.title", null);
    addMenuItem("menu.view.statebar.title", null);
  }


}
