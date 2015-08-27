package com.softarea.tetris.menu;

import com.softarea.tetris.menu.items.ControlMenu;
import com.softarea.tetris.menu.items.GameMenu;
import com.softarea.tetris.menu.items.HelpMenu;
import com.softarea.tetris.menu.items.ViewMenu;

import javax.swing.*;

public class MainMenuBar extends JMenuBar {

    public MainMenuBar() {
        super();
        initItems();
    }

    private void initItems() {
        add(new GameMenu());
        add(new ViewMenu());
        add(new ControlMenu());
        add(new HelpMenu());
    }
}
