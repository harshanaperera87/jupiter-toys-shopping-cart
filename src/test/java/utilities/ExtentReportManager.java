package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportManager implements ITestListener {
    public ExtentSparkReporter sparkReporter;  // UI of the report
    public ExtentReports extent;  //populate common info on the report
    public ExtentTest test; // creating test case entries in the report and update status of the test methods

    String repName;
    public void onStart(ITestContext context) {

        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());// time stamp
        repName = "Test-Report-" + timeStamp + ".html";
        sparkReporter = new ExtentSparkReporter(".\\reports\\" + repName);// specify location of the report

        sparkReporter.config().setDocumentTitle("Automation Report"); // TiTle of report
        sparkReporter.config().setReportName("Functional Testing"); // name of the report
        sparkReporter.config().setTheme(Theme.STANDARD);

        extent=new ExtentReports();
        extent.attachReporter(sparkReporter);

        extent.setSystemInfo("Computer Name","localhost");
        extent.setSystemInfo("Environment","QA");
        extent.setSystemInfo("Tester Name","Harshana");
        extent.setSystemInfo("os","Windows11");
        extent.setSystemInfo("Browser name","Chrome");

    }


    public void onTestSuccess(ITestResult result) {

        test = extent.createTest(result.getName()); // create a new enty in the report
        test.log(Status.PASS, "Test case PASSED is:" + result.getName()); // update status p/f/s

    }

    public void onTestFailure(ITestResult result) {

        test = extent.createTest(result.getName());
        test.log(Status.FAIL, "Test case FAILED is:" + result.getName());
        test.log(Status.FAIL, "Test Case FAILED cause is: " + result.getThrowable());

    }

    public void onTestSkipped(ITestResult result) {

        test = extent.createTest(result.getName());
        test.log(Status.SKIP, "Test case SKIPPED is:" + result.getName());

    }


    public void onFinish(ITestContext context) {

        extent.flush();
    }
}
