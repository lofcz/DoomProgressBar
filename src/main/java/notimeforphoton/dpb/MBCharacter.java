package notimeforphoton.dpb;

import javax.swing.*;

public enum MBCharacter {
    DOOM_GUY(Icons.DOOM_GUY);

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