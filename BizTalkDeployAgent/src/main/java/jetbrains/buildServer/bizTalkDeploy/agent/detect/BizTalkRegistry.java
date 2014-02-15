package jetbrains.buildServer.bizTalkDeploy.agent.detect;

import jetbrains.buildServer.bizTalkDeploy.common.BizTalkVersion;
import jetbrains.buildServer.util.FileUtil;
import jetbrains.buildServer.util.Win32RegistryAccessor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.util.Set;

import static jetbrains.buildServer.util.Win32RegistryAccessor.Hive.LOCAL_MACHINE;
import static jetbrains.buildServer.util.Bitness.BIT32;

/**
 * Created by Kristian on 15-02-14.
 */
public class BizTalkRegistry {
    private static String bizTalkRegistryKey = "SOFTWARE\\Microsoft\\BizTalk Server\\3.0";
    private static String uninstallRegistryKey = "SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Uninstall";
    private final Win32RegistryAccessor registryAccessor;
    private final VersionedBizTalk detector = new VersionedBizTalk();


    public BizTalkRegistry(@NotNull Win32RegistryAccessor registryAccessor) {
        this.registryAccessor = registryAccessor;
    }

    public boolean IsBizTalkInstalled(){
        return false;
    }

    @Nullable
    public BizTalkVersion GetInstalledVersion(){
        return detector.GetInstalledVersion();
    }

    @Nullable
    public File GetBizTalkInstallPath(){
        return detector.GetBizTalkInstallPath();
    }

    private class VersionedBizTalk {
        @Nullable
        public BizTalkVersion GetInstalledVersion() {
            final String version = registryAccessor.readRegistryText(
                    LOCAL_MACHINE,
                    BIT32,
                    bizTalkRegistryKey,
                    "ProductVersion"
            );
            if(version.equals(BizTalkVersion.v2006_R2.getProductVersion()))
            {
                Set<String> uninstall = registryAccessor.listSubKeys(
                        LOCAL_MACHINE,
                        BIT32,
                        uninstallRegistryKey
                );
                return uninstall.contains("Microsoft Biztalk Server 2006 R2 Service Pack 1 [KB 974563]") ?
                    BizTalkVersion.v2006_R2_SP1 : BizTalkVersion.v2006_R2;

            }
            return BizTalkVersion.fromString(version);
        }

        @Nullable
        public File GetBizTalkInstallPath() {
            final String home = registryAccessor.readRegistryText(
                    LOCAL_MACHINE,
                    BIT32,
                    bizTalkRegistryKey,
                    "InstallPath");

            if (home == null) return null;
            final File path = FileUtil.getCanonicalFile(new File(home));
            return path.isDirectory() ? path : null;
        }
    }
}
