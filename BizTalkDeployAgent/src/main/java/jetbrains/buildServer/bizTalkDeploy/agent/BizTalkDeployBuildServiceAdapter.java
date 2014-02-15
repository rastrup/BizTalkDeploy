package jetbrains.buildServer.bizTalkDeploy.agent;

import jetbrains.buildServer.RunBuildException;
import jetbrains.buildServer.agent.runner.BuildServiceAdapter;
import jetbrains.buildServer.agent.runner.ProgramCommandLine;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Administrator on 08-01-14.
 */
public class BizTalkDeployBuildServiceAdapter extends BuildServiceAdapter {


    public BizTalkDeployBuildServiceAdapter() {
    }

    @NotNull
    @Override
    public ProgramCommandLine makeProgramCommandLine() throws RunBuildException {
        return null;
    }
}
