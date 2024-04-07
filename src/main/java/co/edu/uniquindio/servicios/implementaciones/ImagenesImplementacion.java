package co.edu.uniquindio.servicios.implementaciones;

import co.edu.uniquindio.servicios.interfaces.ImagenesServicio;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

@Service
public class ImagenesImplementacion implements ImagenesServicio {
    private final Cloudinary cloudinary;
    public ImagenesImplementacion(){
        Map<String, String> config = new HashMap<>();
        config.put("cloud_name", "UniLocal");
        config.put("api_key", "753578928969621");
        config.put("api_secret", "689TeE4ynbNCOToB8j0ti98GLAA");
        cloudinary = new Cloudinary(config);
    }

    @Override
    public Map subirImagen(MultipartFile imagen) throws Exception {
        File file = convertir(imagen);
            return cloudinary.uploader().upload(file, ObjectUtils.asMap("folder", "unilocal"));
    }

    @Override
    public Map eliminarImagen(String idImagen) throws Exception {
        return cloudinary.uploader().destroy(idImagen, ObjectUtils.asMap());
    }

    private File convertir(MultipartFile imagen) throws IOException {
        File file = File.createTempFile(imagen.getOriginalFilename(), null);
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(imagen.getBytes());
        fos.close();
        return file;
    }
}
