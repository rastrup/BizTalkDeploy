package jetbrains.buildServer.bizTalkDeploy.common;

/**
 * Created by Kristian Rastrup
 * User: Kristian Rastrup
 * Date: 08.01.2014
 * Time: 19:46
 */
public class ArtifactsUtil {
  public static String getInternalArtifactPath(final String relativePath){
    return String.format("%s/%s/%s", ".teamcity", BizTalkDeployConstants.RUNNER_TYPE, relativePath);
  }
}
