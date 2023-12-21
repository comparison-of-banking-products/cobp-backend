package ru.cobp.backend.service.storage;

import org.springframework.core.io.Resource;

public interface StorageService {

    Resource getFileAsResource(String fileName);

}
