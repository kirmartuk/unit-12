package com.github.siberianintegrationsystems.restApp;

import com.github.siberianintegrationsystems.restApp.controller.dto.QuestionsNewItemDTO;
import com.github.siberianintegrationsystems.restApp.data.JournalRepository;
import com.github.siberianintegrationsystems.restApp.entity.Journal;
import com.github.siberianintegrationsystems.restApp.service.JournalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.annotation.PostConstruct;


@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.github.siberianintegrationsystems.restApp.data")
public class RestAppApplication {

	@Autowired
	private JournalRepository journalRepository;

	public static void main(String[] args) {
		SpringApplication.run(RestAppApplication.class, args);
	}

	@PostConstruct
	private void initData() {
		Journal journal = new Journal();
		journal.setId(JournalServiceImpl.QUESTIONS_JOURNAL_ID);
		journal.setName("Вопросы");
		journal.setDefaultPageSize(15L);
		journalRepository.save(journal);

		Journal journal1 = new Journal();
		journal1.setId(JournalServiceImpl.SESSIONS_JOURNAL_ID);
		journal1.setName("Сессии");
		journal1.setDefaultPageSize(15L);
		journalRepository.save(journal1);

	}
}
