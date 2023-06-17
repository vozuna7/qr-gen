package com.vozuna.qrgen.service.impl;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.vozuna.qrgen.model.enums.Colors;
import com.vozuna.qrgen.service.IQRService;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.Base64;

@Service
public class QRService implements IQRService {
    private BitMatrix generateBitmatrix(final String content, final int width, final int height) throws WriterException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        return qrCodeWriter.encode(content, BarcodeFormat.QR_CODE, width, height);
    }
    @Override
    @SneakyThrows
    public String getQRString(final String content,final int width,final int height, final Colors color){
        return Base64.getEncoder().encodeToString(getQRBytes(content,width,height,color));
    }
    @Override
    @SneakyThrows
    public byte[] getQRBytes(final String content,final int width,final int height, final Colors color){
        ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
        MatrixToImageConfig configuration = new MatrixToImageConfig( 0xFF000002 , color.getArgb());
        MatrixToImageWriter.writeToStream(generateBitmatrix(content,width,height), "PNG", pngOutputStream,configuration);
        return pngOutputStream.toByteArray();
    }
    @SneakyThrows
    @Override
    public BufferedImage getQRImage(final String content,final int width,final int height){
        return MatrixToImageWriter.toBufferedImage(generateBitmatrix(content,width,height));
    }

}
