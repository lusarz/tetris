package com.softarea.tetris.menu;

import com.softarea.tetris.ApplicationContext;

import javax.swing.*;

public abstract class AbstractMenu extends JMenu {

    public AbstractMenu(String titleCode, String descriptionCode) {
        super();
        String title = translate(titleCode);
        System.out.println(title);
        String description = translate(descriptionCode);

        init(title, null);
        getAccessibleContext().setAccessibleDescription(description);
        initItems();
    }

    protected String translate(String key) {
        return ApplicationContext.getInstance().getTranslation().translate(key);
    }

    protected void addMenuItem(String titleCode, KeyStroke keyStroke) {
        JMenuItem menuItem = new JMenuItem(translate(titleCode));
        if (keyStroke != null) {
            menuItem.setAccelerator(keyStroke);
        }
        add(menuItem);
    }

    protected abstract void initItems();

}
