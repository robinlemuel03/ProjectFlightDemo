

package Robin.com.utils;

import Robin.com.report.exceptions.FrameworkException;
import Robin.com.report.exceptions.InvalidPathForExtentReportFileException;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static Robin.com.constants.FrameworkConstants.*;

public final class ReportUtils {

    private ReportUtils() {
    }

    public static String createExtentReportPath() {
        String link = "";
        if (OVERRIDE_REPORTS.trim().equals(NO)) {
            System.out.println("OVERRIDE_REPORTS = " + OVERRIDE_REPORTS);
            link = EXTENT_REPORT_FOLDER_PATH + "/" + DateUtils.getCurrentDate() + "_"
                    + EXTENT_REPORT_FILE_NAME;
            System.out.println("Created link report: " + link);
            return link;
        } else {
            link = EXTENT_REPORT_FOLDER_PATH + "/" + EXTENT_REPORT_FILE_NAME;
            System.out.println("Created link report: " + link);
            return link;
        }
    }

    public static void openReports(String linkReport) {
        if (open_reports_after_execution.trim().equalsIgnoreCase(YES)) {
            try {
                Desktop.getDesktop().browse(new File(linkReport).toURI());
            } catch (FileNotFoundException fileNotFoundException) {
                throw new InvalidPathForExtentReportFileException("Extent Report file you are trying to reach is not found", fileNotFoundException.fillInStackTrace());
            } catch (IOException ioException) {
                throw new FrameworkException("Extent Report file you are trying to reach got IOException while reading the file", ioException.fillInStackTrace());
            }
        }
    }
}

