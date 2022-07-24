package com.kp.mime.mimeproject.repositories;

import java.util.List;

import com.kp.mime.mimeproject.models.Filter;
import com.kp.mime.mimeproject.models.entities.Mime;

public interface MimeRepositoryCustom {
    List<Mime> getMimesMatching(Filter filter);
}
