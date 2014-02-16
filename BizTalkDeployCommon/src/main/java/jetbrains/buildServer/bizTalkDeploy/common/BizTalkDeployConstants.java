package jetbrains.buildServer.bizTalkDeploy.common;

/**
 * Created by Kristian Rastrup
 * User: Kristian Rastrup
 * Date: 08.01.2014
 * Time: 19:46
 */
public interface BizTalkDeployConstants {
    String RUNNER_TYPE = "biztalk";
    String RUNNER_DISPLAY_NAME = "BizTalk Deploy";
    String RUNNER_DESCRIPTION = "BizTalk Deploy Tool";
    String RUNNER_BIZTALK_ASSEMBLIES = "jetbrains_biztalk_assemblies";
    String RUNNER_BIZTALK_ASSEMBLIES_OVERWRITE = "biztalk_biztalk_assemblies_overwrite";
    String RUNNER_BIZTALK_ASSEMBLIES_GACONADD = "biztalk_biztalk_assemblies_gaconadd";
    String RUNNER_BIZTALK_ASSEMBLIES_GACONINSTALL = "biztalk_biztalk_assemblies_gaconinstall";
    String RUNNER_BIZTALK_ASSEMBLIES_GACONIMPORT = "biztalk_biztalk_assemblies_gaconimport";
    String RUNNER_APPLICATION_NAME = "biztalk_application_name";
    String RUNNER_SERVER_NAME = "biztalk_server_name";
    String RUNNER_DATABASE_NAME = "biztalk_database_name";
}
