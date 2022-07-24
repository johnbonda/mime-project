package com.kp.mime.mimeproject.repositories.impls;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kp.mime.mimeproject.models.Filter;
import com.kp.mime.mimeproject.models.MimeShort;
import com.kp.mime.mimeproject.models.entities.Mime;
import com.kp.mime.mimeproject.models.entities.Role;
import com.kp.mime.mimeproject.repositories.MimeRepositoryCustom;
import com.kp.mime.mimeproject.repositories.RoleRepository;

@Service
public class MimeRepositoryCustomImpl implements MimeRepositoryCustom {

    @Autowired
    RoleRepository roleRepository;

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<MimeShort> getMimesMatching(Filter filter) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<MimeShort> cq = cb.createQuery(MimeShort.class);
        Root<Mime> mime = cq.from(Mime.class);
        Path<List<Role>> rolesPath = mime.join("mimeDetails").get("roles");
        
        List<Role> roles = roleRepository.findByIdIn(filter.getRoles());

        Map<String, String> queries = filter.getQueries();
        List<Predicate> conditions = queries.entrySet().stream()
            .map(query -> cb.like(mime.get(query.getKey()), query.getValue()))
            .collect(Collectors.toList());
        conditions.addAll(
            roles.stream()
            .map(role -> cb.isMember(cb.literal(role), rolesPath))
            .collect(Collectors.toList())
        );

        cq.multiselect(
            mime.get("id"),
            mime.get("lastName")
        ).where(conditions.toArray(new Predicate[0]));
        return em.createQuery(cq).getResultList();
    }

}
