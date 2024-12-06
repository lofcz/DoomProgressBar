package lofcz.dpb;

import javax.swing.*;

public enum MBCharacter {
    TERRY(Icons.TERRY_ICON);

    private final ImageIcon icon;

    MBCharacter(ImageIcon icon) {
        this.icon = icon;
    }

    public String getDisplayName() {
        return icon.getDescription();
    }
    public ImageIcon getIcon() {
        return icon;
    }

}