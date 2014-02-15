package jetbrains.buildServer.bizTalkDeploy.common;

import jetbrains.buildServer.requirements.Requirement;
import jetbrains.buildServer.requirements.RequirementType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Kristian Rastrup
 * User: Kristian Rastrup
 * Date: 08.01.2014
 * Time: 19:46
 */
public enum BizTalkVersion {
    v2004("3.0.4902.0", "BizTalk Server 2004", 1),
    v2004_SP1("3.0.6070.0", "BizTalk Server 2004 SP1", 2),
    v2004_SP2("3.0.7405.0", "BizTalk Server 2004 SP2", 3),
    v2006("3.5.1602.0", "BizTalk Server 2006", 4),
    v2006_R2("3.6.1404.0", "BizTalk Server 2006 R2", 5),
    v2006_R2_SP1("3.6.1404.0", "BizTalk Server 2006 R2 SP1", 6),
    v2009("3.8.368.0", "BizTalk Server 2009", 7),
    v2010("3.9.469.0", "BizTalk Server 2010", 8),
    v2013("3.10.229.0", "BizTalk Server 2013", 9),
    v2013_R2("3.10.229.1", "BizTalk Server 2013 R2", 10);

    private final String _productVersion;
    private final String _productName;
    private final int _order;

    BizTalkVersion(final String technicalVersionPrefix, final String displayName, int order) {
        _productVersion = technicalVersionPrefix;
        _productName = displayName;
        _order = order;
    }

    @NotNull
    public String getProductVersion() {
        return _productVersion;
    }

    @NotNull
    public String getProductName() {
        return _productName;
    }

    @Nullable
    public Requirement CreateRequirement(){
        return new Requirement(BizTalkDeployConstants.BIZTALK_VERSION_PROPERTY, getProductVersion(), RequirementType.STARTS_WITH);
    }

    public static Collection<BizTalkVersion> GetThisOrNewer(@NotNull final BizTalkVersion targetVersion){
        final List<BizTalkVersion> result = new ArrayList<BizTalkVersion>();

        for(BizTalkVersion version : values()){
            if(version._order >= targetVersion._order) result.add(version);
        }

        return result;
    }


    @Nullable
    public static BizTalkVersion fromString(@Nullable String version) {
        if (version == null) return null;

        version = version.trim();
        if (version.length() == 0) return null;

        for (BizTalkVersion ver : values()) {
            if (ver.getProductVersion().equals(version)) {
                return ver;
            }
        }
        return null;
    }
}
