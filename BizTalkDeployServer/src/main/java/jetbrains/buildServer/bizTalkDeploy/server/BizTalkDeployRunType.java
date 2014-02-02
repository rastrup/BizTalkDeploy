package jetbrains.buildServer.bizTalkDeploy.server;

import jetbrains.buildServer.bizTalkDeploy.common.BizTalkDeployConstants;
import jetbrains.buildServer.serverSide.PropertiesProcessor;
import jetbrains.buildServer.serverSide.RunType;
import jetbrains.buildServer.serverSide.RunTypeRegistry;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.omg.DynamicAny._DynAnyFactoryStub;

import java.util.Map;

/**
 * Created by Administrator on 08-01-14.
 */
public class BizTalkDeployRunType extends RunType {

    public BizTalkDeployRunType(final RunTypeRegistry runTypeRegistry){
        runTypeRegistry.registerRunType(this);
    }

    @NotNull
    @Override
    public String getType() {
        return BizTalkDeployConstants.RUNNER_TYPE;
    }

    @NotNull
    @Override
    public String getDisplayName() {
        return null;
    }

    @NotNull
    @Override
    public String getDescription() {
        return null;
    }

    @Nullable
    @Override
    public PropertiesProcessor getRunnerPropertiesProcessor() {
        return null;
    }

    @Nullable
    @Override
    public String getEditRunnerParamsJspFilePath() {
        return null;
    }

    @Nullable
    @Override
    public String getViewRunnerParamsJspFilePath() {
        return null;
    }

    @Nullable
    @Override
    public Map<String, String> getDefaultRunnerProperties() {
        return null;
    }
}
