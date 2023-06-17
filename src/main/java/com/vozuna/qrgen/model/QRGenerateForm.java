package com.vozuna.qrgen.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class QRGenerateForm implements Serializable {
    private String content;
    private Integer width;
    private Integer height;
}
