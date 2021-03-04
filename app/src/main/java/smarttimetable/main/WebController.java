package smarttimetable.main;


import android.os.Environment;
import android.util.Log;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;



//https://drive.google.com/u/0/uc?id=1qrXFAzRtvdpXvuUhzSy9d065MbVkA55q&export=download

public class WebController {

    private void onDownloadComplete(boolean success) {
        // файл скачался, можно как-то реагировать
        Log.i("***", "************** " + success);
    }

    private class LoadFile extends Thread {
        private final String src;
        private final File dest;

        LoadFile(String src, File dest) {
            this.src = src;
            this.dest = dest;
        }

        @Override
        public void run() {
            try {
                FileUtils.copyURLToFile(new URL(src), dest);
                onDownloadComplete(true);
            } catch (IOException e) {
                e.printStackTrace();
                onDownloadComplete(false);
            }
        }
    }

    public void DownloadFile(String url)
    {
        String src = url;
        String destFileName = "img.jpg";

        File dest = new File(Environment.getExternalStorageDirectory() + "/Download/" + destFileName);
        new LoadFile(src, dest).start();
    }
}
