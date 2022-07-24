package com.kp.mime.mimeproject.repositories.impls;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Service;

import com.kp.mime.mimeproject.models.entities.Mime;
import com.kp.mime.mimeproject.repositories.MimeRepositoryCustom;

@Service
public class MimeRepositoryCustomImpl implements MimeRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Mime> getMimesMatching(Map<String, String> queries) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Mime> cq = cb.createQuery(Mime.class);
        Root<Mime> mime = cq.from(Mime.class);

        List<Predicate> conditions = queries.entrySet().stream()
            .map(query -> cb.like(mime.get(query.getKey()), query.getValue()))
            .collect(Collectors.toList());
        cq.where(conditions.toArray(new Predicate[0]));
        return em.createQuery(cq).getResultList();
    }

}
