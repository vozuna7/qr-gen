package com.vozuna.qrgen.controller;

import com.vozuna.qrgen.model.enums.Colors;
import com.vozuna.qrgen.service.IQRService;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@Validated
public class QRController {
    private final IQRService qrService;
    @GetMapping
    public String index(){
        return "index";
    }
    @GetMapping("/qr")
    public String createQRCode(@RequestParam("content") @Size(min = 4, max = 2038) final String content,
                               @RequestParam(value = "width",defaultValue = "400") @Max(1000) @Min(0) final int width,
                               @RequestParam(value = "height", defaultValue = "400") @Max(1000) @Min(0) final int height,
                               @RequestParam(value = "color", defaultValue = "WHITE") final Colors color,
                                 Model model){
        model.addAttribute("imageUrl",qrService.getQRString(content,width,height,color));
        return "index";
    }
}
