package reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;   // preferred for Extent 5.x
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class ExtentManager {

	private static ExtentReports extent;

    // directory where reports will be stored
    private static final String REPORT_DIR = "target/ExtentReports";
    private static final String REPORT_FILE = "extent-report.html";

    public static synchronized ExtentReports getInstance() {
        if (extent == null) {
            createInstance(REPORT_DIR + "/" + REPORT_FILE);
        }
        return extent;
    }

    private static void createInstance(String filePath) {
        try {
            Path reportDir = Paths.get(REPORT_DIR);
            if (!Files.exists(reportDir)) Files.createDirectories(reportDir);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Use ExtentSparkReporter (recommended)
        ExtentSparkReporter spark = new ExtentSparkReporter(filePath);
        spark.config().setDocumentTitle("Automation Test Report");
        spark.config().setReportName("Regression Suite");
        spark.config().setTheme(Theme.STANDARD);

        extent = new ExtentReports();
        extent.attachReporter(spark);

        // system info (optional)
        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("Java Version", System.getProperty("java.version"));
        extent.setSystemInfo("User", System.getProperty("user.name"));
    }

	
}
