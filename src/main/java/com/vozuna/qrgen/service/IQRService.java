package com.vozuna.qrgen.service;

import com.vozuna.qrgen.model.enums.Colors;
import lombok.SneakyThrows;

import java.awt.image.BufferedImage;

public interface IQRService {

    @SneakyThrows
    String getQRString(String content, int width, int height, Colors color);

    @SneakyThrows
    byte[] getQRBytes(String content, int width, int height, Colors color);

    @SneakyThrows
    BufferedImage getQRImage(String content, int width, int height);
}
