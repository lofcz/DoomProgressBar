package notimeforphoton.dpb.config;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.util.xmlb.XmlSerializerUtil;
import notimeforphoton.dpb.MBCharacter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@State(
        name = "notimeforphoton.dpb.config.DoomProgressBarSettingsState",
        storages = @Storage("DoomProgressBarPluginSettings.xml")
)
public class DoomProgressBarSettingsState implements PersistentStateComponent<DoomProgressBarSettingsState> {

  public MBCharacter selectedCharacter = MBCharacter.DOOM_GUY;

  public static DoomProgressBarSettingsState getInstance() {
    return ApplicationManager.getApplication().getService(DoomProgressBarSettingsState.class);
  }

  @Nullable
  @Override
  public DoomProgressBarSettingsState getState() {
    return this;
  }

  @Override
  public void loadState(@NotNull DoomProgressBarSettingsState state) {
    XmlSerializerUtil.copyBean(state, this);
  }

}