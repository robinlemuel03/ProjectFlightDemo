

package Robin.com.utils;

import org.zeroturnaround.zip.ZipUtil;
import Robin.com.constants.FrameworkConstants;

import java.io.File;

public class ZipUtils {

    /* Make Zip file of Extent Reports in Project Root folder */
    public static void zip() {
        if (FrameworkConstants.ZIP_FOLDER.toLowerCase().trim().equals(FrameworkConstants.YES)) {
            if ((FrameworkConstants.ZIP_FOLDER_PATH != null || !FrameworkConstants.ZIP_FOLDER_PATH.isEmpty()) && (FrameworkConstants.ZIP_FOLDER_NAME != null || !FrameworkConstants.ZIP_FOLDER_NAME.isEmpty())) {
                ZipUtil.pack(new File(FrameworkConstants.ZIP_FOLDER_PATH), new File(FrameworkConstants.ZIP_FOLDER_NAME));
                Log.info("Zipped " + FrameworkConstants.Zipped_ExtentReports_Folder_Name + " folder successfully !!");
            } else {
                ZipUtil.pack(new File(FrameworkConstants.EXTENT_REPORT_FOLDER_PATH), new File(FrameworkConstants.Zipped_ExtentReports_Folder_Name));
                Log.info("Zipped " + FrameworkConstants.Zipped_ExtentReports_Folder_Name + " folder successfully !!");
            }
        }
    }

}
