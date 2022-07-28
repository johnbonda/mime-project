package com.kp.mime.mimeproject;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.kp.mime.mimeproject.models.entities.Event;
import com.kp.mime.mimeproject.models.entities.Issue;
import com.kp.mime.mimeproject.models.entities.Organization;
import com.kp.mime.mimeproject.models.entities.Role;
import com.kp.mime.mimeproject.repositories.EventRepository;
import com.kp.mime.mimeproject.repositories.IssueRepository;
import com.kp.mime.mimeproject.repositories.OrganizationRepository;
import com.kp.mime.mimeproject.repositories.RoleRepository;

@SpringBootApplication
@EnableJpaRepositories
public class MimeProjectApplication {

	Logger log = LoggerFactory.getLogger(MimeProjectApplication.class);

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private OrganizationRepository organizationRepository;

	@Autowired
	private EventRepository eventRepository;

	@Autowired
	private IssueRepository issueRepository;

	public static void main(String[] args) {
		SpringApplication.run(MimeProjectApplication.class, args);
	}


	@PostConstruct
	public void init() {
		if(roleRepository.count() == 0) {
			log.info("Adding roles");
			List<Role> roles = Arrays.asList(
				new Role("Elder"),
				new Role("Donor"),
				new Role("Funder"),
				new Role("Counsellor"),
				new Role("Participant"),
				new Role("Politician-Federal"),
				new Role("Politician-Provincial"),
				new Role("Politician-Municipal"),
				new Role("Volunteer"),
				new Role("Researcher"),
				new Role("Musician"),
				new Role("Actor"),
				new Role("Supplier"),
				new Role("Other")
			);
			roleRepository.saveAll(roles);
		}

		if(organizationRepository.count() == 0) {
			log.info("Adding orgs");
			List<Organization> organizations = Arrays.asList(
				new Organization("Church"),
				new Organization("Culture"),
				new Organization("Education"),
				new Organization("First Nations"),
				new Organization("Health"),
				new Organization("Media-TV"),
				new Organization("Media-Newspaper"),
				new Organization("Media-Magazine"),
				new Organization("Media-Radio"),
				new Organization("Media-Other"),
				new Organization("Media-Web"),
				new Organization("NGO"),
				new Organization("Government"),
				new Organization("Theatre"),
				new Organization("Union"),
				new Organization("Community"),
				new Organization("Environment"),
				new Organization("PRESS RELEASE"),
				new Organization("NFP"),
				new Organization("Charity"),
				new Organization("Festival"),
				new Organization("Other")
			);
			organizationRepository.saveAll(organizations);
		}

		if(eventRepository.count() == 0) {
			log.info("Adding events");
			List<Event> events = Arrays.asList(
				new Event("2º"),
				new Event("ARRANGED"),
				new Event("LENS"),
				new Event("Corps I/O Heads"),
				new Event("CU"),
				new Event("CIH(BC)"),
				new Event("DSW"),
				new Event("FIRE"),
				new Event("GENDER"),
				new Event("GENERATIONS"),
				new Event("HERE & NOW"),
				new Event("HOMELESSNESS"),
				new Event("MAMU"),
				new Event("METH"),
				new Event("MALADJUSTED"),
				new Event("MALADJUSTED TOUR"),
				new Event("SHATTERING (meth)"),
				new Event("No `Xya`"),
				new Event("OOTS"),
				new Event("PD"),
				new Event("REACH"),
				new Event("Rec. Hope"),
				new Event("ROS"),
				new Event("SAFER"),
				new Event("SQEEGEE"),
				new Event("$x*?amat"),
				new Event("$x*? TOUR"),
				new Event("TDG"),
				new Event("THIR$TY"),
				new Event("US & THEM")
			);
			eventRepository.saveAll(events);
		}

		if(issueRepository.count() == 0) {
			log.info("Adding issues");
			List<Issue> issues = Arrays.asList(
				new Issue("Addiction"),
				new Issue("Anti-Racism"),
				new Issue("Conflict-Res"),
				new Issue("Environment"),
				new Issue("First Nations"),
				new Issue("Gender Roles"),
				new Issue("Globalization"),
				new Issue("Health"),
				new Issue("Intergenerational"),
				new Issue("Multiculturalism"),
				new Issue("Poverty"),
				new Issue("Violence-Schools"),
				new Issue("Violence-Family"),
				new Issue("Wellness"),
				new Issue("Youth")
			);
			issueRepository.saveAll(issues);
		}
	}

}
