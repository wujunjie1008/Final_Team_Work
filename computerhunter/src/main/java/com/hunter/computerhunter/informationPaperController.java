package com.hunter.computerhunter;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author dell
 */
@Controller
@RequestMapping(value = "/image")
public class informationPaperController {
    @RequestMapping(value = "/get/{no}",produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public byte[] getImage(@PathVariable("no") int no) throws IOException {
        String paperPath = "F:/";
        String paperName = no + ".jpg";
        paperPath += paperName;
        File file = new File(paperPath);
        FileInputStream inputStream = new FileInputStream(file);
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes, 0, inputStream.available());
        return bytes;
    }
}
