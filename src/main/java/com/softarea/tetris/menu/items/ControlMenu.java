package com.softarea.tetris.menu.items;

import com.softarea.tetris.menu.AbstractMenu;

public class ControlMenu extends AbstractMenu {

    public ControlMenu() {
        super("menu.control.title", "menu.control.description");
    }

    @Override
    protected void initItems() {
        addMenuItem("menu.control.sound", null);
    }
}
