package com.kp.mime.mimeproject.repositories;

import java.util.List;

import com.kp.mime.mimeproject.models.Filter;
import com.kp.mime.mimeproject.models.MimeShort;

public interface MimeRepositoryCustom {
    List<MimeShort> getMimesMatching(Filter filter);
}
