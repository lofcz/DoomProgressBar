package lofcz.dpb.config;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.util.xmlb.XmlSerializerUtil;

import lofcz.dpb.MBCharacter;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@State(
        name = "lofcz.dpb.config.TerryProgressBarSettingsState",
        storages = @Storage("TerryProgressBarPluginSettings.xml")
)
public class TerryProgressBarSettingsState implements PersistentStateComponent<TerryProgressBarSettingsState> {

  public MBCharacter selectedCharacter = MBCharacter.TERRY;

  public static TerryProgressBarSettingsState getInstance() {
    return ApplicationManager.getApplication().getService(TerryProgressBarSettingsState.class);
  }

  @Nullable
  @Override
  public TerryProgressBarSettingsState getState() {
    return this;
  }

  @Override
  public void loadState(@NotNull TerryProgressBarSettingsState state) {
    XmlSerializerUtil.copyBean(state, this);
  }

}