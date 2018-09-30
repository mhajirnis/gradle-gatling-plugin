package helper

import org.junit.Rule
import org.junit.rules.TemporaryFolder
import spock.lang.Specification

import static org.apache.commons.io.FileUtils.copyDirectory

abstract class GatlingSpec extends Specification {
    @Rule
    public final TemporaryFolder testProjectDir = new TemporaryFolder()

    File testProjectBuildDir

    def createBuildFolder(boolean copyFiles = true) {
        if (copyFiles) {
            copyDirectory(new File(this.class.getResource("/gradle-layout").file), testProjectDir.root)
        }
        testProjectBuildDir = new File(testProjectDir.root, "build")
    }
}