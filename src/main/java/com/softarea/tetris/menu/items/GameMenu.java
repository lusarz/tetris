package com.softarea.tetris.menu.items;

import com.softarea.tetris.menu.AbstractMenu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class GameMenu extends AbstractMenu {

    public GameMenu() {
        super("menu.game.title", "menu.game.description");
    }

    @Override
    protected void initItems() {
        addMenuItem("menu.newGame.title", KeyStroke.getKeyStroke(
                KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        addMenuItem("menu.statistics.title", null);
    }
}
