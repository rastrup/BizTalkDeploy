package jetbrains.buildServer.bizTalkDeploy.agent;

import com.intellij.openapi.diagnostic.Logger;
import jetbrains.buildServer.RunBuildException;
import jetbrains.buildServer.bizTalkDeploy.common.BizTalkDeployConstants;
import jetbrains.buildServer.util.FileUtil;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.Map;

/**
 * Created by Kristian on 16-02-14.
 */
public class ScriptGenerator {
    private static final Logger LOG = Logger.getInstance(ScriptGenerator.class.getName());

    @NotNull
    private File getScript(@NotNull final Map<String, String> runnerParameters,
                           @NotNull final File bizTalkInstallDir,
                           @NotNull final File buildCheckoutDir,
                           @NotNull final File buildTempDir) throws RunBuildException {
        String sourceScript = getBizTalkAssembliesScript(runnerParameters);
        File scriptFile = writeToTempFile(buildTempDir, sourceScript);
        return scriptFile;
    }

    @NotNull
    private File writeToTempFile(@NotNull final File buildTempDir, @NotNull final String text) throws RunBuildException {
        Closeable handle = null;
        File file;
        try {
            file = FileUtil.createTempFile(buildTempDir, "biztalk", ".cmd", true);
            OutputStreamWriter w = new OutputStreamWriter(new FileOutputStream(file), "utf-8");
            handle = w;
            w.write(text);
            return file;
        } catch (IOException e) {
            LOG.error("Error occured while processing file for powershell script", e);
            throw new RunBuildException("Failed to generate temporary resulting powershell script due to exception", e);
        } finally {
            FileUtil.close(handle);
        }
    }

    private String getBizTalkAssembliesScript(@NotNull final Map<String, String> runnerParameters){
        String assemblies = runnerParameters.get(BizTalkDeployConstants.RUNNER_BIZTALK_ASSEMBLIES);

        String script = "";
        return script;
    }
}
