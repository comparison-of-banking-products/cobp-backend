package ru.cobp.backend.service.storage;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import ru.cobp.backend.exception.ExceptionUtil;

import java.net.MalformedURLException;
import java.nio.file.Path;

@Service
@RequiredArgsConstructor
public class LogoStorageServiceImpl implements StorageService {

    @Value("${storage.logo-path}")
    private final Path logoStoragePath;

    @Override
    public Resource getFileAsResource(String fileName) {
        try {
            Path logoPath = logoStoragePath.resolve(fileName).normalize();
            Resource resource = new UrlResource(logoPath.toUri());
            if (resource.exists()) {
                return resource;
            } else {
                throw ExceptionUtil.getLogoFileNotFoundException(fileName);
            }

        } catch (MalformedURLException ex) {
            throw ExceptionUtil.getLogoFileNotFoundException(fileName);
        }
    }

}
