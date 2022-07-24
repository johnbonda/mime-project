package com.kp.mime.mimeproject.repositories;

import java.util.List;
import java.util.Map;

import com.kp.mime.mimeproject.models.entities.Mime;

public interface MimeRepositoryCustom {
    List<Mime> getMimesMatching(Map<String, String> queries);
}
