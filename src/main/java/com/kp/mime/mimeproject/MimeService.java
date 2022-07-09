package com.kp.mime.mimeproject;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kp.mime.mimeproject.models.MimeDTO;
import com.kp.mime.mimeproject.models.entities.Mime;
import com.kp.mime.mimeproject.models.entities.MimeDetails;
import com.kp.mime.mimeproject.repositories.EventRepository;
import com.kp.mime.mimeproject.repositories.IssueRepository;
import com.kp.mime.mimeproject.repositories.MimeDetailsRepository;
import com.kp.mime.mimeproject.repositories.MimeRepository;
import com.kp.mime.mimeproject.repositories.OrganizationRepository;
import com.kp.mime.mimeproject.repositories.RoleRepository;

@Service
public class MimeService {

    @Autowired
    MimeRepository mimeRepository;

    @Autowired
    MimeDetailsRepository mimeDetailsRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    EventRepository eventRepository;

    @Autowired
    OrganizationRepository organizationRepository;

    @Autowired
    IssueRepository issueRepository;
    
    @Transactional
    public void saveMime(MimeDTO mimeDTO) {
        Mime mime = mimeRepository.findByLastName(mimeDTO.getLastName())
        .stream().findFirst().orElseGet(() -> {
            Mime newMime = new Mime();
            MimeDetails newMimeDetails = new MimeDetails();
            newMime.setMimeDetails(newMimeDetails);
            newMimeDetails.setMime(newMime);
            return newMime;
        });

        mime.setFirstName(mimeDTO.getFirstName());
        mime.setLastName(mimeDTO.getLastName());
        mime.setJobTitle(mimeDTO.getJobTitle());
        mime.setCompany(mimeDTO.getCompany());
        mime.setAddress(mimeDTO.getAddress());
        mime.setCity(mimeDTO.getCity());
        mime.setProvince(mimeDTO.getProvince());
        mime.setPostalCode(mimeDTO.getPostalCode());
        mime.setCountry(mimeDTO.getCountry());
        mime.setArea(mimeDTO.getArea());
        mime.setPhoneType(mimeDTO.getPhone().getType());
        mime.setPhone(mimeDTO.getPhone().getValue());
        mime.setEmail(mimeDTO.getEmail());
        mime.setUrl(mimeDTO.getUrl());
        mime.setNotes(mimeDTO.getNotes());

        MimeDetails mimeDetails = mime.getMimeDetails();
        mimeDetails.setMember(mimeDTO.isMember());
        mimeDetails.setJoinDate(mimeDTO.getJoin());
        mimeDetails.setLeaveDate(mimeDTO.getLeave());
        mimeDetails.setInfoWanted(mimeDTO.getInfoWanted());
        mimeDetails.setCommunicate(mimeDTO.getCommunicate());
        mimeDetails.setTraineeLevels(mimeDTO.getTraineeLevels());
        mimeDetails.setAssociations(mimeDTO.getAssociations());
        
        mimeDetails.setRoles(roleRepository.findByIdIn(mimeDTO.getRoles()));
        mimeDetails.setOrgs(organizationRepository.findByIdIn(mimeDTO.getOrgs()));
        mimeDetails.setEvents(eventRepository.findByIdIn(mimeDTO.getEvents()));
        mimeDetails.setIssues(issueRepository.findByIdIn(mimeDTO.getIssues()));
        mimeDetails.setTflOrganizer(mimeDTO.isTflOrganizer());
        mimeDetails.setContractDate(mimeDTO.getContractDate());
        mimeDetails.setTflDates(mimeDTO.getTflDates());
        mimeDetails.setTflFocus(mimeDTO.getTflFocus());
        mimeDetails.setTflFee(mimeDTO.getTflFee());
        mimeDetails.setFacilitator(mimeDTO.getFacilitator());
        mimeDetails.setAccomodation(mimeDTO.getAccomodation());
        mimeDetails.setCounsellor(mimeDTO.isCounsellor());
        mimeDetails.setStatus(mimeDTO.getStatus());

        mimeRepository.save(mime);
    }

    public Mime getMime(String lastName) {
        Mime mime = mimeRepository.findByLastName(lastName)
        .stream().findFirst().orElse(new Mime());
        return mime;
    }

}
