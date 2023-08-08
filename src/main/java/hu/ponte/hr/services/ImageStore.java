package hu.ponte.hr.services;

import hu.ponte.hr.controller.ImageMeta;
import hu.ponte.hr.repository.ImageMetaRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ImageStore {

    public final ImageMetaRepository imageMetaRepository;
    public final SignService signService;

    public List<ImageMeta> findAll(){
       return imageMetaRepository.findAll();
    }

    public void saveImage(String id, String name, String mimeType,long size,byte[] imageData){
        String base64Signature = null;
        try {
            base64Signature = signService.getSignature(name);
        }catch (Exception er){
            er.getMessage();
        }

        ImageMeta imageMeta = ImageMeta.builder()
                .id(id)
                .name(name)
                .mimeType(mimeType)
                .size(size)
                .digitalSign(base64Signature)
                .imageData(imageData)
                .build();

        imageMetaRepository.save(imageMeta);

        log.info("Image has been saved");
    }


    public ImageMeta findImageById(String id) throws FileNotFoundException {
        return imageMetaRepository.findById(id).orElseThrow(()->new FileNotFoundException("file not found"));

    }
}
