package com.nguyenchungtu.onthicuoiki.util;

import android.app.Activity;
import android.widget.Toast;
import java.io.*;

public class CopyDatabase {
  public static void processCopyDatabase(Activity context, String DB_PATH_SUFFIX, String DATABASE_NAME) {
    File dbFile = context.getDatabasePath(DATABASE_NAME);

    if (!dbFile.exists()) {
      try {
        CopyDataBaseFromAsset(context, DB_PATH_SUFFIX, DATABASE_NAME);
        Toast.makeText(context, "Đã chép CSDL xong", Toast.LENGTH_LONG).show();
      } catch (Exception e) {
        Toast.makeText(context, e.toString(), Toast.LENGTH_LONG).show();
      }
    }
  }

  public static String getDatabaseFullPath(Activity context, String DB_PATH_SUFFIX, String DATABASE_NAME) {
    return context.getApplicationInfo().dataDir + DB_PATH_SUFFIX + DATABASE_NAME;
  }

  public static void CopyDataBaseFromAsset(Activity context, String DB_PATH_SUFFIX, String DATABASE_NAME) {
    try {
      InputStream myInput;
      myInput = context.getAssets().open(DATABASE_NAME);
      String outFileName = getDatabaseFullPath(context, DB_PATH_SUFFIX, DATABASE_NAME);
      // Tạo thư mục chứa CSDL nếu chưa có
      File f = new File(context.getApplicationInfo().dataDir + DB_PATH_SUFFIX);
      if (!f.exists())
        f.mkdir();
      // Tạo file mới
      OutputStream myOutput = new FileOutputStream(outFileName);
      // Chép nội dung từ file CSDL trong assets vào thư mục CSDL
      byte[] buffer = new byte[1024];
      int length;
      while ((length = myInput.read(buffer)) > 0) {
        myOutput.write(buffer, 0, length);
      }
      myOutput.flush();
      myOutput.close();
      myInput.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
